package org.duku.mall.framework.starter.common.modules.member.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.duku.mall.framework.starter.cache.SingletonCache;
import org.duku.mall.framework.starter.common.common.properties.RocketmqCustomProperties;
import org.duku.mall.framework.starter.common.common.security.token.Token;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.connect.entity.dto.ConnectAuthUser;
import org.duku.mall.framework.starter.common.modules.connect.service.ConnectService;
import org.duku.mall.framework.starter.common.modules.member.entity.dto.ManagerMemberEditDTO;
import org.duku.mall.framework.starter.common.modules.member.entity.dto.MemberAddDTO;
import org.duku.mall.framework.starter.common.modules.member.entity.dto.MemberEditDTO;
import org.duku.mall.framework.starter.common.modules.member.mapper.MemberMapper;
import org.duku.mall.framework.starter.common.modules.member.service.MemberService;
import org.duku.mall.framework.starter.common.modules.member.token.MemberTokenGenerate;
import org.duku.mall.framework.starter.common.modules.member.token.StoreTokenGenerate;
import org.duku.mall.framework.starter.common.modules.member.entity.vo.MemberSearchVO;
import org.duku.mall.framework.starter.common.modules.member.entity.vo.MemberVO;
import org.duku.mall.framework.starter.common.modules.member.entity.vo.QRCodeLoginSessionVo;
import org.duku.mall.framework.starter.common.modules.member.entity.vo.QRLoginResultVo;
import org.duku.mall.framework.starter.common.modules.store.service.StoreService;
import org.duku.mall.framework.starter.user.core.enums.UserEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.Member;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    /**
     * 会员token
     */
    @Autowired
    private MemberTokenGenerate memberTokenGenerate;
    /**
     * 商家token
     */
    @Autowired
    private StoreTokenGenerate storeTokenGenerate;
    /**
     * 联合登录
     */
    @Autowired
    private ConnectService connectService;
    /**
     * 店铺
     */
    @Autowired
    private StoreService storeService;
    /**
     * RocketMQ 配置
     */
    @Autowired
    private RocketmqCustomProperties rocketmqCustomProperties;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    /**
     * 缓存
     */
    @Autowired
    private SingletonCache cache;

    @Override
    public Member getUserInfo() {
        return null;
    }

    @Override
    public Member findByMobile(String mobile) {
        return null;
    }

    @Override
    public boolean findByMobile(String uuid, String mobile) {
        return false;
    }

    @Override
    public Member findByUsername(String username) {
        return null;
    }

    @Override
    public Token usernameLogin(String username, String password) {
        return null;
    }

    @Override
    public Token usernameStoreLogin(String username, String password) {
        return null;
    }

    @Override
    public Token mobilePhoneStoreLogin(String mobilePhone) {
        return null;
    }

    @Override
    public Token mobilePhoneLogin(String mobilePhone) {
        return null;
    }

    @Override
    public Member editOwn(MemberEditDTO memberEditDTO) {
        return null;
    }

    @Override
    public Member modifyPass(String oldPassword, String newPassword) {
        return null;
    }

    @Override
    public Token register(String userName, String password, String mobilePhone) {
        return null;
    }

    @Override
    public boolean canInitPass() {
        return false;
    }

    @Override
    public void initPass(String password) {

    }

    @Override
    public void cancellation() {

    }

    @Override
    public boolean changeMobile(String mobile) {
        return false;
    }

    @Override
    public boolean changeMobile(String memberId, String mobile) {
        return false;
    }

    @Override
    public boolean resetByMobile(String mobile, String password) {
        return false;
    }

    @Override
    public Member addMember(MemberAddDTO memberAddDTO) {
        return null;
    }

    @Override
    public Member updateMember(ManagerMemberEditDTO managerMemberEditDTO) {
        return null;
    }

    @Override
    public IPage<MemberVO> getMemberPage(MemberSearchVO memberSearchVO, PageVO page) {
        return null;
    }

    @Override
    public Member autoRegister(ConnectAuthUser authUser) {
        return null;
    }

    @Override
    public Token refreshToken(String refreshToken) {
        return null;
    }

    @Override
    public Token refreshStoreToken(String refreshToken) {
        return null;
    }

    @Override
    public Boolean updateMemberPoint(Long point, String type, String memberId, String content) {
        return null;
    }

    @Override
    public Boolean updateMemberStatus(List<String> memberIds, Boolean status) {
        return null;
    }

    @Override
    public long getMemberNum(MemberSearchVO memberSearchVO) {
        return 0;
    }

    @Override
    public List<Map<String, Object>> listFieldsByMemberIds(String columns, List<String> memberIds) {
        return List.of();
    }

    @Override
    public void logout(UserEnums userEnums) {

    }

    @Override
    public void logout(String userId) {

    }

    @Override
    public void updateHaveShop(Boolean haveStore, String storeId, List<String> memberIds) {

    }

    @Override
    public void resetPassword(List<String> ids) {

    }

    @Override
    public List<String> getAllMemberMobile() {
        return List.of();
    }

    @Override
    public boolean updateMemberLoginTime(String memberId) {
        return false;
    }

    @Override
    public MemberVO getMember(String id) {
        return null;
    }

    @Override
    public QRCodeLoginSessionVo createPcSession() {
        return null;
    }

    @Override
    public Object appScanner(String token) {
        return null;
    }

    @Override
    public boolean appSConfirm(String token, Integer code) {
        return false;
    }

    @Override
    public QRLoginResultVo loginWithSession(String token) {
        return null;
    }
}
