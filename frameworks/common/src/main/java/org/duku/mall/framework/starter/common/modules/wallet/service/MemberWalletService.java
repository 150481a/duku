package org.duku.mall.framework.starter.common.modules.wallet.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.Member;
import org.duku.mall.framework.starter.common.modules.wallet.entity.dos.MemberWallet;
import org.duku.mall.framework.starter.common.modules.wallet.entity.dto.MemberWalletUpdateDTO;
import org.duku.mall.framework.starter.common.modules.wallet.entity.vo.MemberWalletVO;

public interface MemberWalletService extends IService<MemberWallet> {

    /**
     * 查询会员的预存款
     *
     * @param memberId 会员id
     * @return 会员预存款VO
     */
    MemberWalletVO getMemberWallet(String memberId);

    /**
     * 增加用户预存款余额
     *
     * @param memberWalletUpdateDTO 变动模型
     * @return 返回增加结果    true:成功    false:失败
     */
    Boolean increase(MemberWalletUpdateDTO memberWalletUpdateDTO);

    /**
     * 从冻结金额到余额
     *
     * @param memberWalletUpdateDTO 变动模型
     * @return 返回冻结结果    true:成功    false:失败
     */
    Boolean increaseWithdrawal(MemberWalletUpdateDTO memberWalletUpdateDTO);

    /**
     * 扣减用户预存款余额
     *
     * @param memberWalletUpdateDTO 变动模型
     * @return 操作状态 true:成功    false:失败
     */
    Boolean reduce(MemberWalletUpdateDTO memberWalletUpdateDTO);

    /**
     * 提现扣减余额到冻结金额
     *
     * @param memberWalletUpdateDTO 变动模型
     * @return 操作状态 true:成功    false:失败
     */
    Boolean reduceWithdrawal(MemberWalletUpdateDTO memberWalletUpdateDTO);

    /**
     * 提现扣减冻结金额
     *
     * @param memberWalletUpdateDTO 变动模型
     * @return 操作状态
     */
    Boolean reduceFrozen(MemberWalletUpdateDTO memberWalletUpdateDTO);

    /**
     * 设置支付密码
     *
     * @param member   会员id
     * @param password 支付密码
     */
    void setMemberWalletPassword(Member member, String password);

    /**
     * 检查当前会员是否设置过预存款密码
     *
     * @return 操作状态
     */
    Boolean checkPassword();

    /**
     * 会员注册添加会员余额钱包
     *
     * @param memberId   会员id
     * @param memberName 会员名称
     * @return 操作结果
     */
    MemberWallet save(String memberId, String memberName);

    /**
     * 用户提现
     *
     * @param price 提现金额
     * @param realName 真实姓名
     * @param connectNumber 第三方账号
     * @return 是否提现成功
     */
    Boolean applyWithdrawal(Double price, String realName, String connectNumber);

    /**
     * 提现公共方法
     *
     * @param withdrawApplyId 会员零钱提现Id
     */
    void withdrawal(String withdrawApplyId);
}
