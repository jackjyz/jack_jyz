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
@MapperScan(basePackages = "com.asiainfo.asiainfo_select_sh.mapper.tact5", sqlSessionTemplateRef  = "tact5SqlSessionTemplate")
public class Tact5Datasource {
    @Bean(name = "tact5DataSource")
    @ConfigurationProperties(prefix = "tact5.datasource")
    @Primary
    public DataSource tact5DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "tact5SqlSessionFactory")
    @Primary
    public SqlSessionFactory tact5SqlSessionFactory(@Qualifier("tact5DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/tact5/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "tact5TransactionManager")
    @Primary
    public DataSourceTransactionManager tact5TransactionManager(@Qualifier("tact5DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "tact5SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate tact5SqlSessionTemplate(@Qualifier("tact5SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}

