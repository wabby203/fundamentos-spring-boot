package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanWithPropertiesImplement implements  MyBeanWithProperties {

    private  String name;
    private  String apellido;

    public MyBeanWithPropertiesImplement(String name, String apellido) {
        this.name = name;
        this.apellido = apellido;
    }

    @Override
    public String function() {
        return name + "-" + apellido;
    }
}
