package org.duku.mall.framework.starter.common.mybatis.mybatisplus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"org.duku.mall.framework.starter.common.modules.*.*.mapper", "org.duku.mall.framework.starter.common.modules.*.mapper"})
public class MybatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;

        //阻断解析器，测试环境使用
//       PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
//
//       List<ISqlParser> sqlParserList = new ArrayList<>();
//       //攻击 SQL 阻断解析器、加入解析链
//       sqlParserList.add(new BlockAttackSqlParser());
//       paginationInterceptor.setSqlParserList(sqlParserList);
//       return paginationInterceptor;
    }
}
