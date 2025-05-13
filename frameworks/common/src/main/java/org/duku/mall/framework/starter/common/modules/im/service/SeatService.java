package org.duku.mall.framework.starter.common.modules.im.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.common.security.token.Token;
import org.duku.mall.framework.starter.common.modules.im.entity.dos.Seat;
import org.duku.mall.framework.starter.common.modules.im.entity.vo.SeatVO;

import java.util.List;

public interface SeatService extends IService<Seat> {


    /**
     * 获取坐席列表
     *
     * @param storeId 店铺id
     * @return
     */
    List<SeatVO> seatVoList(String storeId);

    /**
     * 坐席登录
     *
     * @param username
     * @param password
     * @return
     */
    Token usernameLogin(String username, String password);

    /**
     * 快捷登录code 生成
     *
     * @param username 用户名
     * @return
     */
    String createQuickLoginCode(String username);

    /**
     * 快捷登录
     *
     * @param code
     * @return
     */
    Token quickLogin(String code);

    /**
     * 查询坐席
     *
     * @param username
     * @return
     */
    Seat findByUsername(String username);
}
