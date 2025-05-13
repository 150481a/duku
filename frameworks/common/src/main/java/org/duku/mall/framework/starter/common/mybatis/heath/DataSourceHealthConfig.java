package org.duku.mall.framework.starter.common.mybatis.heath;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.actuate.autoconfigure.jdbc.DataSourceHealthContributorAutoConfiguration;
import org.springframework.boot.jdbc.metadata.DataSourcePoolMetadataProvider;
import org.springframework.context.annotation.Configuration;

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
