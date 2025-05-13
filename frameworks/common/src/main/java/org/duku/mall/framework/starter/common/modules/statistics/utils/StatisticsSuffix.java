package org.duku.mall.framework.starter.common.modules.statistics.utils;

import java.util.Calendar;

public class StatisticsSuffix {


    /**
     * 平台统计后缀
     *
     * @return
     */
    public static String suffix() {  //取得系统当前时间
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        return year + "-" + month + "-" + day;
    }

    /**
     * 平台统计后缀（制定日期）
     *
     * @return
     */
    public static String suffix(Calendar calendar) {  //取得系统当前时间
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        return year + "-" + month + "-" + day;
    }


    /**
     * 获取商家统计后缀
     *
     * @param storeId
     * @return
     */
    public static String suffix(String storeId) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        return year + "-" + month + "-" + day + "-" + storeId;
    }

    /**
     * 获取商家统计后缀(指定日)
     *
     * @param storeId
     * @return
     */
    public static String suffix(Calendar calendar, String storeId) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        return year + "-" + month + "-" + day + "-" + storeId;
    }
}
