package org.duku.mall.framework.starter.common.modules.member.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.common.security.token.Token;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.connect.entity.dto.ConnectAuthUser;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.Member;
import org.duku.mall.framework.starter.common.modules.member.entity.dto.ManagerMemberEditDTO;
import org.duku.mall.framework.starter.common.modules.member.entity.dto.MemberAddDTO;
import org.duku.mall.framework.starter.common.modules.member.entity.dto.MemberEditDTO;
import org.duku.mall.framework.starter.common.modules.member.entity.vo.MemberSearchVO;
import org.duku.mall.framework.starter.common.modules.member.entity.vo.MemberVO;
import org.duku.mall.framework.starter.common.modules.member.entity.vo.QRCodeLoginSessionVo;
import org.duku.mall.framework.starter.common.modules.member.entity.vo.QRLoginResultVo;
import org.duku.mall.framework.starter.user.core.enums.UserEnums;

import java.util.List;
import java.util.Map;

public interface MemberService extends IService<Member> {
    /**
     * 默认密码
     */
    static String DEFAULT_PASSWORD = "111111";

    /**
     * 获取当前登录的用户信息
     *
     * @return 会员信息
     */
    Member getUserInfo();

    /**
     * 通过手机获取用户
     *
     * @param mobile 手机号
     * @return 操作状态
     */
    Member findByMobile(String mobile);

    boolean findByMobile(String uuid, String mobile);

    /**
     * 通过用户名获取用户
     *
     * @param username 用户名
     * @return 会员信息
     */
    Member findByUsername(String username);

    /**
     * 登录：用户名、密码登录
     *
     * @param username 用户名
     * @param password 密码
     * @return token
     */
    Token usernameLogin(String username, String password);

    /**
     * 商家登录：用户名、密码登录
     *
     * @param username 用户名
     * @param password 密码
     * @return token
     */
    Token usernameStoreLogin(String username, String password);

    /**
     * 商家登录：用户名、密码登录
     *
     * @param mobilePhone 用户名
     * @return token
     */
    Token mobilePhoneStoreLogin(String mobilePhone);

    /**
     * 注册：手机号、验证码登录
     *
     * @param mobilePhone 手机号
     * @return token
     */
    Token mobilePhoneLogin(String mobilePhone);

    /**
     * 修改会员信息
     *
     * @param memberEditDTO 会员修改信息
     * @return 修改后的会员
     */
    Member editOwn(MemberEditDTO memberEditDTO);

    /**
     * 修改用户密码
     *
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return 操作结果
     */
    Member modifyPass(String oldPassword, String newPassword);

    /**
     * 注册会员
     *
     * @param userName    会员
     * @param password    密码
     * @param mobilePhone mobilePhone
     * @return 处理结果
     */
    Token register(String userName, String password, String mobilePhone);

    /**
     * 是否可以初始化密码
     *
     * @return
     */
    boolean canInitPass();

    /**
     * 初始化密码
     *
     * @param password 密码
     * @return 操作结果
     */
    void initPass(String password);

    /**
     * 注销账号
     *
     * @return 操作结果
     */
    void cancellation();
    /**
     * 修改当前会员的手机号
     *
     * @param mobile 手机号
     * @return 操作结果
     */
    boolean changeMobile(String mobile);

    /**
     * 修改用户手机号
     * @param memberId 会员ID
     * @param mobile 手机号
     * @return
     */
    boolean changeMobile(String memberId,String mobile);


    /**
     * 通过手机号修改密码
     *
     * @param mobile   手机号
     * @param password 密码
     * @return
     */
    boolean resetByMobile(String mobile, String password);

    /**
     * 后台-添加会员
     *
     * @param memberAddDTO 会员
     * @return 会员
     */
    Member addMember(MemberAddDTO memberAddDTO);

    /**
     * 后台-修改会员
     *
     * @param managerMemberEditDTO 后台修改会员参数
     * @return 会员
     */
    Member updateMember(ManagerMemberEditDTO managerMemberEditDTO);

    /**
     * 获取会员分页
     *
     * @param memberSearchVO 会员搜索VO
     * @param page           分页
     * @return 会员分页
     */
    IPage<MemberVO> getMemberPage(MemberSearchVO memberSearchVO, PageVO page);


//    /**
//     * 一键注册会员
//     *
//     * @return
//     */
//    Token autoRegister();

    /**
     * 一键注册会员
     *
     * @param authUser 联合登录用户
     * @return Token
     */
    Member autoRegister(ConnectAuthUser authUser);

    /**
     * 刷新token
     *
     * @param refreshToken
     * @return Token
     */
    Token refreshToken(String refreshToken);

    /**
     * 刷新token
     *
     * @param refreshToken
     * @return Token
     */
    Token refreshStoreToken(String refreshToken);

    /**
     * 会员积分变动
     *
     * @param point    变动积分
     * @param type     是否增加积分 INCREASE 增加  REDUCE 扣减
     * @param memberId 会员id
     * @param content  变动日志
     * @return 操作结果
     */
    Boolean updateMemberPoint(Long point, String type, String memberId, String content);


    /**
     * 修改会员状态
     *
     * @param memberIds 会员id集合
     * @param status    状态
     * @return 修改结果
     */
    Boolean updateMemberStatus(List<String> memberIds, Boolean status);

    /**
     * 根据条件查询会员总数
     *
     * @param memberSearchVO
     * @return 会员总数
     */
    long getMemberNum(MemberSearchVO memberSearchVO);

    /**
     * 获取指定会员数据
     *
     * @param columns   指定获取的列
     * @param memberIds 会员ids
     * @return 指定会员数据
     */
    List<Map<String, Object>> listFieldsByMemberIds(String columns, List<String> memberIds);

    /**
     * 登出
     *
     * @param userEnums token角色类型
     */
    void logout(UserEnums userEnums);

    /**
     * 登出
     *
     * @param userId 用户id
     */
    void logout(String userId);

    /**
     * 修改会员是否拥有店铺
     *
     * @param haveStore 是否拥有店铺
     * @param storeId   店铺id
     * @param memberIds 会员id
     * @return
     */
    void updateHaveShop(Boolean haveStore, String storeId, List<String> memberIds);

    /**
     * 重置会员密码为123456
     *
     * @param ids 会员id
     */
    void resetPassword(List<String> ids);

    /**
     * 获取所有会员的手机号
     *
     * @return 所有会员的手机号
     */
    List<String> getAllMemberMobile();

    /**
     * 更新会员登录时间为最新时间
     *
     * @param memberId 会员id
     * @return 是否更新成功
     */
    boolean updateMemberLoginTime(String memberId);

    /**
     * 获取用户VO
     * @param id 会员id
     * @return 用户VO
     */
    MemberVO getMember(String id);

    QRCodeLoginSessionVo createPcSession();

    Object appScanner(String token);

    boolean appSConfirm(String token, Integer code);

    QRLoginResultVo loginWithSession(String token);
}
