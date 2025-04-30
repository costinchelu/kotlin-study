package ro.ccar.java;

import ro.ccar.kt.ClassWithObjectK;

public class ClassStaticVsObjectJ {

    public static String STATIC_STRING = "staticField";

    public static void staticMethod() {
        System.out.println("Static method called");
    }
}


class TestStatic {
    public static void main(String[] args) {
        System.out.println( ClassStaticVsObjectJ.STATIC_STRING);
        ClassStaticVsObjectJ.staticMethod();

        // because it is annotated as @JvmStatic we can access it without calling the companion object
        ClassWithObjectK.foo();

        // but we can access any member of the Companion as well
        ClassWithObjectK.Companion.foo();
        ClassWithObjectK.Companion.bar();
        System.out.println(ClassWithObjectK.SOME_VALUE);
    }
}
