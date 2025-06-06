package org.duku.mall.framework.starter.common.modules.verification.service.impl;

import cn.hutool.core.text.CharSequenceUtil;
import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.cache.CachePrefix;
import org.duku.mall.framework.starter.cache.SingletonCache;
import org.duku.mall.framework.starter.common.common.properties.VerificationCodeProperties;
import org.duku.mall.framework.starter.common.common.vo.SerializableStream;
import org.duku.mall.framework.starter.common.modules.verification.entity.dos.VerificationSource;
import org.duku.mall.framework.starter.common.modules.verification.entity.dto.VerificationDTO;
import org.duku.mall.framework.starter.common.modules.verification.entity.enums.VerificationEnums;
import org.duku.mall.framework.starter.common.modules.verification.entity.enums.VerificationSourceEnum;
import org.duku.mall.framework.starter.common.modules.verification.service.VerificationService;
import org.duku.mall.framework.starter.common.modules.verification.service.VerificationSourceService;
import org.duku.mall.framework.starter.convention.enums.ResultCode;
import org.duku.mall.framework.starter.convention.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Slf4j
@Component
public class VerificationServiceImpl implements VerificationService {


    @Autowired
    private VerificationSourceService verificationSourceService;


    @Autowired
    private VerificationCodeProperties verificationCodeProperties;

    @Autowired
    private SingletonCache cache;

    /**
     * 创建校验
     *
     * @return 验证码参数
     */
    @Override
    public Map<String, Object> createVerification(VerificationEnums verificationEnums, String uuid) {

        if (uuid == null) {
            throw new ServiceException(ResultCode.ILLEGAL_REQUEST_ERROR);
        }

        //获取验证码配置
        VerificationDTO verificationDTO = verificationSourceService.getVerificationCache();

        List<VerificationSource> verificationResources = verificationDTO.getVerificationResources();
        List<VerificationSource> verificationSlider = verificationDTO.getVerificationSlider();


        Random random = new Random();
        //随机选择需要切的图下标
        int resourceNum = random.nextInt(verificationResources.size());
        //随机选择剪切模版下标
        int sliderNum = random.nextInt(verificationSlider.size());

        //随机选择需要切的图片地址
        String originalResource = verificationResources.get(resourceNum).getResource();
        //随机选择剪切模版图片地址
        String sliderResource = verificationSlider.get(sliderNum).getResource();
        // 干扰块
        String interfereResource = verificationSlider.get(sliderNum == verificationSlider.size() - 1 ?
                sliderNum - 1 : sliderNum + 1).getResource();

        try {
            //获取缓存中的资源
            SerializableStream originalFile = getInputStream(originalResource);
            SerializableStream sliderFile = getInputStream(sliderResource);
            SerializableStream interfereSliderFile = verificationCodeProperties.getInterfereNum() > 0 ? getInputStream(interfereResource) : null;
            //生成数据
            Map<String, Object> resultMap = SliderImageUtil.pictureTemplatesCut(
                    sliderFile, interfereSliderFile, originalFile,
                    verificationCodeProperties.getWatermark(), verificationCodeProperties.getInterfereNum());
            //生成验证参数 有效时间 默认600秒，可以自行配置
            cache.put(cacheKey(verificationEnums, uuid), resultMap.get("randomX"), verificationCodeProperties.getEffectiveTime());
            resultMap.put("key", cacheKey(verificationEnums, uuid));
            resultMap.put("effectiveTime", verificationCodeProperties.getEffectiveTime());
            //移除横坐标移动距离
            resultMap.remove("randomX");
            return resultMap;
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            log.error("生成验证码失败", e);
            throw new ServiceException(ResultCode.ERROR);
        }
    }

    /**
     * 根据网络地址，获取源文件
     * 这里简单说一下，这里是将不可序列化的inputstream序列化对象，存入redis缓存
     *
     * @param originalResource
     * @return
     */
    private SerializableStream getInputStream(String originalResource) throws Exception {

        Object object = cache.get(CachePrefix.VERIFICATION_IMAGE.getPrefix() + originalResource);
        if (object != null) {
            return (SerializableStream) object;
        }
        if (StringUtils.isNotEmpty(originalResource)) {
            URL url = new URL(originalResource);
            InputStream inputStream = url.openStream();
            SerializableStream serializableStream = new SerializableStream(inputStream);
            cache.put(CachePrefix.VERIFICATION_IMAGE.getPrefix() + originalResource, serializableStream);
            return serializableStream;
        }
        return null;
    }

    /**
     * 预校验图片 用于前端回显
     *
     * @param xPos              X轴移动距离
     * @param verificationEnums 验证key
     * @return 验证是否成功
     */
    @Override
    public boolean preCheck(Integer xPos, String uuid, VerificationEnums verificationEnums) {
        Integer randomX = (Integer) cache.get(cacheKey(verificationEnums, uuid));
        if (randomX == null) {
            throw new ServiceException(ResultCode.VERIFICATION_CODE_INVALID);
        }
        log.debug("{}{}", randomX, xPos);
        //验证结果正确 && 删除标记成功
        if (Math.abs(randomX - xPos) < verificationCodeProperties.getFaultTolerant() && cache.remove(cacheKey(verificationEnums, uuid))) {
            //验证成功，则记录验证结果 验证有效时间与验证码创建有效时间一致
            cache.put(cacheResult(verificationEnums, uuid), true, verificationCodeProperties.getEffectiveTime());
            return true;
        }
        throw new ServiceException(ResultCode.VERIFICATION_ERROR);
    }

    /**
     * 验证码校验
     *
     * @param uuid              用户标识
     * @param verificationEnums 验证key
     * @return 验证是否成功
     */
    @Override
    public boolean check(String uuid, VerificationEnums verificationEnums) {
        //如果有校验标记，则返回校验结果
        if (Boolean.TRUE.equals(cache.remove(cacheResult(verificationEnums, uuid)))) {
            return true;
        }
        throw new ServiceException(ResultCode.VERIFICATION_CODE_INVALID);
    }

    /**
     * 生成缓存key 记录缓存需要验证的内容
     *
     * @param verificationEnums 验证码枚举
     * @param uuid              用户uuid
     * @return 缓存key
     */
    public static String cacheKey(VerificationEnums verificationEnums, String uuid) {
        return CachePrefix.VERIFICATION_KEY.getPrefix() + verificationEnums.name() + uuid;
    }

    /**
     * 生成缓存key 记录缓存验证的结果
     *
     * @param verificationEnums 验证码枚举
     * @param uuid              用户uuid
     * @return 缓存key
     */
    public static String cacheResult(VerificationEnums verificationEnums, String uuid) {
        return CachePrefix.VERIFICATION_RESULT.getPrefix() + verificationEnums.name() + uuid;
    }


    @Override
    public Boolean checkCreateVerification(String type, String filePath) {
        if (CharSequenceUtil.isBlank(type) || CharSequenceUtil.isBlank(filePath)) {
            throw new ServiceException(ResultCode.ILLEGAL_REQUEST_ERROR);
        }

        //获取验证码配置
        VerificationDTO verificationDTO = verificationSourceService.getVerificationCache();

        List<VerificationSource> verificationResources = verificationDTO.getVerificationResources();

        List<VerificationSource> verificationSlider = verificationDTO.getVerificationSlider();

        //随机选择需要切的图片地址
        String originalResource = verificationResources.get(0).getResource();
        //随机选择剪切模版图片地址
        String sliderResource = verificationSlider.get(0).getResource();


        if (VerificationSourceEnum.RESOURCE.name().equals(type)) {
            originalResource = filePath;
        } else if (VerificationSourceEnum.SLIDER.name().equals(type)) {
            sliderResource = filePath;
        }

        try {
            //获取缓存中的资源
            SerializableStream originalFile = getInputStream(originalResource);
            SerializableStream sliderFile = getInputStream(sliderResource);
            //生成数据
            SliderImageUtil.pictureTemplatesCut(
                    sliderFile, sliderFile, originalFile,
                    verificationCodeProperties.getWatermark(),
                    verificationCodeProperties.getInterfereNum()
            );
        } catch (Exception e) {
            throw new ServiceException("当前图片不符合规则，请上传正确格式的图片！");
        }
        return true;
    }
}
