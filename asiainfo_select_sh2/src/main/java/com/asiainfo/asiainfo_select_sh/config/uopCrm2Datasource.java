package com.asiainfo.asiainfo_select_sh.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.asiainfo.asiainfo_select_sh.mapper.uopcrm2", sqlSessionTemplateRef  = "uopCrm2SqlSessionTemplate")
public class uopCrm2Datasource {

    @Bean(name = "uopCrm2DataSource")
    @ConfigurationProperties(prefix = "uopcrm2.datasource")
    public DataSource uopCrm2DataSource() {
        return DataSourceBuilder.create().build();
    }

/*
    @Value("${uopcrm2.datasource.jdbc-url}")
    private String url;

    @Value("${uopcrm2.datasource.username}")
    private String user;

    @Value("${uopcrm2.datasource.password}")
    private String password;

    @Value("${uopcrm2.datasource.driver-class-name}")
    private String driverClass;

    @Bean(name = "uopCrm2DataSource")
    public DataSource clusterDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }
*/

    @Bean(name = "uopCrm2SqlSessionFactory")
    public SqlSessionFactory uopCrm2SqlSessionFactory(@Qualifier("uopCrm2DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/uopcrm2/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "uopCrm2TransactionManager")
    public DataSourceTransactionManager uopCrm2TransactionManager(@Qualifier("uopCrm2DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "uopCrm2SqlSessionTemplate")
    public SqlSessionTemplate uopCrm2SqlSessionTemplate(@Qualifier("uopCrm2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}

