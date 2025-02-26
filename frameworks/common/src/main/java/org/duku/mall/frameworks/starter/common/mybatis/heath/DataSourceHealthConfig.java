package org.duku.mall.frameworks.starter.common.mybatis.heath;
import jakarta.activation.DataSource;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.actuate.autoconfigure.jdbc.DataSourceHealthContributorAutoConfiguration;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.jdbc.DataSourceHealthIndicator;
import org.springframework.boot.jdbc.metadata.DataSourcePoolMetadataProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

@Configuration
public class DataSourceHealthConfig  extends DataSourceHealthContributorAutoConfiguration {
    public DataSourceHealthConfig(ObjectProvider<DataSourcePoolMetadataProvider> metadataProviders) {
        super(metadataProviders);
    }
//    @Value("${spring.datasource.dbcp2.validation-query:select 1}")
//    private String defaultQuery;
//
//
//    public DataSourceHealthConfig( ObjectProvider<DataSourcePoolMetadataProvider> metadataProviders) {
//        super( metadataProviders);
//    }
//
//    @Override
//    protected AbstractHealthIndicator createContributor(DataSource source) {
//        DataSourceHealthIndicator indicator = (DataSourceHealthIndicator) super.createContributor(source);
//        if (!StringUtils.hasText(indicator.getQuery())) {
//            indicator.setQuery(defaultQuery);
//        }
//        return indicator;
//    }
}
