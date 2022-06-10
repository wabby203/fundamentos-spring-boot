package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanWithDempendencyImplement implements  MyBeanWithDependency
{
   private MyOperation myOperation;

    public MyBeanWithDempendencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        System.out.println(myOperation.sum(10));
        System.out.println("hola desde la implemetacion de un bean con dependencia");
    }
}
