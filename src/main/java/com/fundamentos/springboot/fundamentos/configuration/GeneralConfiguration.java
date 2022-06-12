package com.fundamentos.springboot.fundamentos.configuration;

import com.fundamentos.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithPropertiesImplement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import pojo.UserPojo;

import javax.sql.DataSource;

@EnableConfigurationProperties(UserPojo.class)
/*se llama el archivo properties creado */
@PropertySource("classpath:conection.properties")
@Configuration
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.apellido}")
    private String apellido;

    @Value("${value.random}")
    private String random;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${driver}")
    private String driver;

    @Value("${username}")
    private String usrName;

    @Value("${password}")
    private String pwd;
    @Bean
    public MyBeanWithProperties function ()
    {
        return  new MyBeanWithPropertiesImplement(name, apellido);
    }

    /*este metododo es para manejar una bd desde myConfiguraciones */
    @Bean
    public DataSource dataSource ()
    {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driver);
        dataSourceBuilder.url(jdbcUrl);
        dataSourceBuilder.username(usrName);
        dataSourceBuilder.password(pwd);
        return dataSourceBuilder.build();
    }
}
