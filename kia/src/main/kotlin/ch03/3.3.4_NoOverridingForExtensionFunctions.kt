package ch03.NoOverridingForExtensionFunctions


/*
“Even though you can define extension functions with the same name and parameter types for a base class and its subclass,
the function that’s called depends on the declared static type of the variable, determined at compile time,
not the run-time type of the value stored in that variable.”
 */
open class View {
    open fun click() = println("View clicked")
}

class Button: View() {
    override fun click() = println("Button clicked")
}

fun View.showOff() = println("I'm a view!")
fun Button.showOff() = println("I'm a button!")

// extension functions aren't part of a class, they're declared externally to it
fun main() {
    val view: View = Button()
    view.click()  // Button clicked

    // in JVM this will be a static method for View class (not the one for Button class)
    view.showOff()  // I'm a view!
}

/*  /Java

class Demo {
    public static void main(String[] args) {
        View view = new Button();
        ExtensionsKt.showOff(view);
        // I'm a view!
    }
}

 */