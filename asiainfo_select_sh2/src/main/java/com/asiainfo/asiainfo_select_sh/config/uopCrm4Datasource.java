package com.asiainfo.asiainfo_select_sh.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.asiainfo.asiainfo_select_sh.mapper.uopcrm4", sqlSessionTemplateRef  = "uopCrm4SqlSessionTemplate")
public class uopCrm4Datasource {
    @Bean(name = "uopCrm4DataSource")
    @ConfigurationProperties(prefix = "uopcrm4.datasource")
    public DataSource uopCrm4DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "uopCrm4SqlSessionFactory")
    public SqlSessionFactory uopCrm4SqlSessionFactory(@Qualifier("uopCrm4DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/uopcrm4/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "uopCrm4TransactionManager")
    public DataSourceTransactionManager uopCrm4TransactionManager(@Qualifier("uopCrm4DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "uopCrm4SqlSessionTemplate")
    public SqlSessionTemplate uopCrm4SqlSessionTemplate(@Qualifier("uopCrm4SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}

