package com.fundamentos.springboot.fundamentos.bean;

/*esta clase se crea toda la logica que estamos desarrollando*/

/*en esta clase dependencia inyectamos otra dependencia, para cuando se ejecute esta dependencia se ejecute la dependencia inyectada*/
public class MyBeanWithDempendencyImplement implements  MyBeanWithDependency
{
    /*para la injection de dependencia se implementa un constructor donde hare la instancia de la dependencia a injectar*/
   private MyOperation myOperation;
    /*esta clase se crea toda la logica que estamos desarrollando*/
    public MyBeanWithDempendencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        /*en esta parte hacemos el llamado del metodo MyOperation de la dependencia injectada y nuestro prnt de esta dependencia*/
        System.out.println(myOperation.sum(10));
        System.out.println("hola desde la implemetacion de un bean con dependencia");
    }
}
