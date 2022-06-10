package com.fundamentos.springboot.fundamentos.bean;
/*esta clase se crea toda la logica que estamos desarrollando*/
/*esta clase es la logica de la dependencia que injectaremos en la dependencia MyBeanWithDependency
* como no sera una depedencia propia no se le crea una interfaz*/
public abstract class MyOperation
{
    int sum(int num) {
        return num;
    }
}