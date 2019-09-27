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
@MapperScan(basePackages = "com.asiainfo.asiainfo_select_sh.mapper.uopcrm3", sqlSessionTemplateRef  = "uopCrm3SqlSessionTemplate")
public class uopCrm3Datasource {
    @Bean(name = "uopCrm3DataSource")
    @ConfigurationProperties(prefix = "uopcrm3.datasource")
    public DataSource DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "uopCrm3SqlSessionFactory")
    public SqlSessionFactory uopCrm3SqlSessionFactory(@Qualifier("uopCrm3DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/uopcrm3/uopcrm3*.xml"));
        return bean.getObject();
    }

    @Bean(name = "uopCrm3TransactionManager")
    public DataSourceTransactionManager uopCrm3TransactionManager(@Qualifier("uopCrm3DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "uopCrm3SqlSessionTemplate")
    public SqlSessionTemplate uopCrm3SqlSessionTemplate(@Qualifier("uopCrm3SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}

