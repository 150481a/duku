package org.duku.mall.framework.starter.common.modules.im.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.cache.SingletonCache;
import org.duku.mall.framework.starter.common.common.security.token.Token;
import org.duku.mall.framework.starter.common.modules.im.entity.dos.Seat;
import org.duku.mall.framework.starter.common.modules.im.entity.vo.SeatVO;
import org.duku.mall.framework.starter.common.modules.im.mapper.SeatMapper;
import org.duku.mall.framework.starter.common.modules.im.service.SeatService;
import org.duku.mall.framework.starter.common.modules.im.token.SeatTokenGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class SeatServiceImpl extends ServiceImpl<SeatMapper, Seat> implements SeatService {


    @Autowired
    private SeatTokenGenerate seatTokenGenerate;

    @Autowired
    private SingletonCache<String> cache;

    /**
     * 快捷登录缓存前缀
     */
    private static String prefix = "{quick_login}_";

    @Override
    public List<SeatVO> seatVoList(String storeId) {
        return List.of();
    }

    @Override
    public Token usernameLogin(String username, String password) {
        return null;
    }

    @Override
    public String createQuickLoginCode(String username) {
        return "";
    }

    @Override
    public Token quickLogin(String code) {
        return null;
    }

    @Override
    public Seat findByUsername(String username) {
        return null;
    }
}
