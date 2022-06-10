package com.fundamentos.springboot.fundamentos.bean;
/*esta clase se crea toda la logica que estamos desarrollando*/
public class MyBeanImplement implements  MyBean
{
    @Override
    public void print()
    {
        System.out.println("Hola desde mi implementacion propia del Bean");
    }
}
