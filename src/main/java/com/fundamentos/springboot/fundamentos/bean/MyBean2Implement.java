package com.fundamentos.springboot.fundamentos.bean;
/*esta clase se crea toda la logica que estamos desarrollando*/
public class MyBean2Implement implements  MyBean
{
    @Override
    public void print() {
        System.out.println("Hola desde mi implementacion2 propia del Bean 2");
    }
}
