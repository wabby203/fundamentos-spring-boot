package com.fundamentos.springboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplement implements  ComponentDependency{

    @Override
    public void saludadar()
    {
        System.out.println("Hola desde mi componente numero 2");
    }
}
