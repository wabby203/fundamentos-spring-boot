package com.fundamentos.springboot.fundamentos.configuration;

import com.fundamentos.springboot.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*en esta clase la creamos para tener un orden de las dependencias creadas
* se hace llamando la interfaz como MyBean y se hace un retun de su clase donde esta la logica de programacion*/

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

    /*este metodo es es la dependencia que se le injecto otra dependencia por eso se agrega como parametro la clase de la dependencia */
    @Bean
    public MyBeanWithDependency myBeanWithDependency(MyOperation myOperation)
    {
        return new MyBeanWithDempendencyImplement(myOperation);
    }

}
