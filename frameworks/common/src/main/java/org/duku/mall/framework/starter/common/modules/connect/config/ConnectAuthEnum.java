package org.duku.mall.framework.starter.common.modules.connect.config;

/**
 * 用户信息 枚举
 */
public enum ConnectAuthEnum implements ConnectAuth {
    /**
     * 微信公众号登录
     */
    WECHAT {
        @Override
        public String authorize() {
            return "https://open.weixin.qq.com/connect/oauth2/authorize";
        }

        @Override
        public String accessToken() {
            return "https://api.weixin.qq.com/sns/oauth2/access_token";
        }

        @Override
        public String userInfo() {
            return "https://api.weixin.qq.com/sns/userinfo";
        }
    },

    /**
     * 微信开放平台
     * 微信PC登录
     */
    WECHAT_PC {
        @Override
        public String authorize() {
            return "https://open.weixin.qq.com/connect/qrconnect";
        }

        @Override
        public String accessToken() {
            return "https://api.weixin.qq.com/sns/oauth2/access_token";
        }

        @Override
        public String userInfo() {
            return "https://api.weixin.qq.com/sns/userinfo";
        }

    },

    /**
     * QQ
     */
    QQ {
        @Override
        public String authorize() {
            return "https://graph.qq.com/oauth2.0/authorize";
        }

        @Override
        public String accessToken() {
            return "https://graph.qq.com/oauth2.0/token";
        }

        @Override
        public String userInfo() {
            return "https://graph.qq.com/user/get_user_info";
        }

    },

    /**
     * 支付宝
     */
    ALIPAY {
        @Override
        public String authorize() {
            return "https://openauth.alipay.com/oauth2/publicAppAuthorize.htm";
        }

        @Override
        public String accessToken() {
            return "https://openapi.alipay.com/gateway.do";
        }

        @Override
        public String userInfo() {
            return "https://openapi.alipay.com/gateway.do";
        }

    },

    /**
     * 新浪微博
     */
    WEIBO {
        @Override
        public String authorize() {
            return "https://api.weibo.com/oauth2/authorize";
        }

        @Override
        public String accessToken() {
            return "https://api.weibo.com/oauth2/access_token";
        }

        @Override
        public String userInfo() {
            return "https://api.weibo.com/2/users/show.json";
        }

    }
}
