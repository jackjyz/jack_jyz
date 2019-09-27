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
@MapperScan(basePackages = "com.asiainfo.asiainfo_select_sh.mapper.uopcrm1", sqlSessionTemplateRef  = "uopCrm1SqlSessionTemplate")
public class uopCrm1Datasource {
    @Bean(name = "uopCrm1DataSource")
    @ConfigurationProperties(prefix = "uopcrm6.datasource")
    public DataSource uopCrm1DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "uopCrm1SqlSessionFactory")
    public SqlSessionFactory uopCrm1SqlSessionFactory(@Qualifier("uopCrm1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/uopcrm1/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "uopCrm1TransactionManager")
    public DataSourceTransactionManager uopCrm1TransactionManager(@Qualifier("uopCrm1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "uopCrm1SqlSessionTemplate")
    public SqlSessionTemplate uopCrm1SqlSessionTemplate(@Qualifier("uopCrm1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {

        return new SqlSessionTemplate(sqlSessionFactory);
    }

}

