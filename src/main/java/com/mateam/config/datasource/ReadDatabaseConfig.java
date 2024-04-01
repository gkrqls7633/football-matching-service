package com.mateam.config.datasource;

import javax.sql.DataSource;
import com.mateam.config.annotation.ReadDatabase;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/*
Advanced scanning
The MyBatis-Spring-Boot-Starter will search, by default, for mappers marked with the @Mapper annotation.
You may want to specify a custom annotation or a marker interface for scanning.
If so, you must use the @MapperScan annotation. See more about it in the MyBatis-Spring reference page.
The MyBatis-Spring-Boot-Starter will not start the scanning process if it finds at least one MapperFactoryBean in the Spring's context so if you want to stop the scanning at all you should register your mappers explicitly with @Bean methods.
*/

@MapperScan(value = "com.mateam.application.adapter.out.persistence",
        annotationClass = ReadDatabase.class, sqlSessionFactoryRef = "readSqlSessionFactory")
@EnableTransactionManagement
@Configuration
public class ReadDatabaseConfig {

    @Bean(name = "testReadDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource testReadDataSource() {
        return DataSourceBuilder.create().
                 type(HikariDataSource.class)
                .build();
    }

    @Bean(name = "readSqlSessionFactory")
    public SqlSessionFactory readSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setDataSource(testReadDataSource());
        sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
        sqlSessionFactoryBean
                .setMapperLocations(resolver.getResources("classpath:mapper/read/Read*Repository.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "readSqlSessionTemplate")
    public SqlSessionTemplate readSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(readSqlSessionFactory());
    }

    @Bean(name = "readTransactionManager")
    public DataSourceTransactionManager readTransactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(testReadDataSource());
        transactionManager.setGlobalRollbackOnParticipationFailure(false);
        return transactionManager;
    }
}
