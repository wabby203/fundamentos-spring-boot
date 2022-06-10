package com.fundamentos.springboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class componentImplement implements ComponentDependency{
    @Override
    public void saludadar()
    {
        System.out.println("hola mundo desde mi componente");
    }
}
