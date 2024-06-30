package stud;

public class C4112Interfaces implements Clickable, Focusable {

    // because we have 2 default methods with the same signature in both implemented
    // interfaces, we need to override that method. Normally we wouldn't need to override it.
    @Override
    public void showOff() {
        Clickable.super.showOff();
        Focusable.super.showOff();
    }
}


interface Clickable {

    default void showOff() {
        System.out.println("ShowOff in Clickable");
    }
}

interface Focusable {

    default void showOff() {
        System.out.println("ShowOff in Focusable");
    }
}

class Demo {
    public static void main(String[] args) {
        C4112Interfaces cls = new C4112Interfaces();
        cls.showOff();
    }
}

class JavaButton implements ch04.main.Clickable {

    // even though showOff has an implementation in Kotlin, the way the language is
    // creating that default method, prevents us to automatically call that kotlin
    // default method (showOff). We need to override it in this case.
    @Override
    public void showOff() {
        ch04.main.Clickable.super.showOff();
    }

    @Override
    public void click() {

    }
}