package com.fundamentos.springboot.fundamentos.configuration;

import com.fundamentos.springboot.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean
{
    @Bean
    public MyBean myBean()
    {
        return new MyBean2Implement();
    }

    @Bean
    public MyOperation beanOperation()
    {
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency myBeanWithDependency(MyOperation myOperation)
    {
        return new MyBeanWithDempendencyImplement(myOperation);
    }

}
