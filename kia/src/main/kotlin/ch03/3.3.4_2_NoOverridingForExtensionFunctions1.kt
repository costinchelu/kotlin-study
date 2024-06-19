package ch03.ex3_4_2_NoOverridingForExtensionFunctions1

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
