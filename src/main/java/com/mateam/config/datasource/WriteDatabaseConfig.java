package com.mateam.config.datasource;

import com.mateam.config.annotation.WriteDatabase;
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

import javax.sql.DataSource;


/*
Advanced scanning
The MyBatis-Spring-Boot-Starter will search, by default, for mappers marked with the @Mapper annotation.
You may want to specify a custom annotation or a marker interface for scanning.
If so, you must use the @MapperScan annotation. See more about it in the MyBatis-Spring reference page.
The MyBatis-Spring-Boot-Starter will not start the scanning process if it finds at least one MapperFactoryBean in the Spring's context so if you want to stop the scanning at all you should register your mappers explicitly with @Bean methods.
*/

@MapperScan(value = "com.mateam.application.adapter.out.persistence",
        annotationClass = WriteDatabase.class, sqlSessionFactoryRef = "writeSqlSessionFactory")
@EnableTransactionManagement
@Configuration
public class WriteDatabaseConfig {

    @Bean(name = "testWriteDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource testWriteDataSource() {
        return DataSourceBuilder.create().
                 type(HikariDataSource.class)
                .build();
    }

    @Bean(name = "writeSqlSessionFactory")
    public SqlSessionFactory writeSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setDataSource(testWriteDataSource());
        sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
        sqlSessionFactoryBean
                .setMapperLocations(resolver.getResources("classpath:mapper/write/Write*Repository.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "writeSqlSessionTemplate")
    public SqlSessionTemplate writeSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(writeSqlSessionFactory());
    }

    @Bean(name = "writeTransactionManager")
    public DataSourceTransactionManager writeTransactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(testWriteDataSource());
        transactionManager.setGlobalRollbackOnParticipationFailure(false);
        return transactionManager;
    }
}
