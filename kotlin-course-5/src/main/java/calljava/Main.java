package calljava;

//import callkotlin.MainKt;
import callkotlin.KCar;
import callkotlin.SingletonObj;
import callkotlin.StaticKt;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

//        MainKt.topLevelFunction();      // in the background, Java is creating a static class with the kt filename
        StaticKt.topLevelFunction();

        StaticKt.print("This is Java");

        KCar kcar = new KCar("blue", "Mazda", 2024, true, "always white");
        kcar.setFixedColor(".");
        System.out.println(kcar.getColor());
        System.out.println(kcar.getFixedColor());
        System.out.println(kcar.getAutomatic());
        System.out.println(kcar.model);

        KCar.carComp();
        System.out.println("isAuto = " + KCar.IS_AUTO);

        kcar.printMe(null);

        try {
            StaticKt.doIO();
        } catch (IOException e) {
            System.out.println("Caught: IOException");
        }

        StaticKt.defaultArgs("The number is: ");

        SingletonObj.doSomething();
    }
}
