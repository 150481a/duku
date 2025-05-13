package org.duku.mall.framework.starter.common.modules.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.member.entity.vo.StoreLogisticsVO;
import org.duku.mall.framework.starter.common.modules.store.entity.dos.StoreLogistics;
import org.duku.mall.framework.starter.common.modules.store.entity.dto.StoreLogisticsCustomerDTO;

import java.util.List;

public interface StoreLogisticsService extends IService<StoreLogistics> {

    /**
     * 获取当前店铺的物流公司列表
     *
     * @param storeId 店铺id
     * @return 物流公司列表
     */
    List<StoreLogisticsVO> getStoreLogistics(String storeId);

    /**
     * 获取当前店铺已选择的物流公司列表
     *
     * @param storeId 店铺id
     * @return 物流公司列表
     */
    List<StoreLogisticsVO> getStoreSelectedLogistics(String storeId);

    /**
     * 获取当前店铺已选择的物流公司名称列表
     *
     * @param storeId 店铺id
     * @return 物流公司列表
     */
    List<String> getStoreSelectedLogisticsName(String storeId);

    /**
     * 添加店铺-物流公司
     *
     * @param logisticsId 物流公司设置id
     * @param storeId 店铺id
     * @return 店铺物流公司
     */
    StoreLogistics add(String logisticsId, String storeId, StoreLogisticsCustomerDTO storeLogisticsCustomerDTO);

    /**
     * 获取当前店铺已选择的物流公司并使用电子面单列表
     *
     * @param storeId 店铺id
     * @return 物流公司列表
     */
    List<StoreLogisticsVO> getStoreSelectedLogisticsUseFaceSheet(String storeId);


    /**
     * 修改店铺-物流公司电子面单参数
     * @param logisticsId 物流公司设置id
     * @param storeId 店铺id
     * @return 店铺物流公司
     */
    StoreLogistics update(String logisticsId, String storeId, StoreLogisticsCustomerDTO storeLogisticsCustomerDTO);


    /**
     * 获取店铺物流信息回填
     * @param logisticsId 物流id
     * @return 店铺物流信息
     */
    StoreLogistics getStoreLogisticsInfo(String logisticsId);

    /**
     * 获取当前店铺已开启的物流公司列表
     *
     * @param storeId 店铺id
     * @return 物流公司列表
     */
    List<StoreLogisticsVO> getOpenStoreLogistics(String storeId);

    /**
     * 获取当前店铺未开启的物流公司列表
     *
     * @param storeId 店铺id
     * @return 物流公司列表
     */
    List<StoreLogisticsVO> getCloseStoreLogistics(String storeId);
}
