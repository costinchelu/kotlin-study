package ch04.ex1_2_1_OpenFinalAbstractModifiers

// abstract members are always open
interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

open class RichButton : Clickable {

    fun disable() {}

    open fun animate() {}

    override fun click() {}

    final override fun showOff() {}
}

// if we override a member of a base class or interface, then that member will be opened by default
class ThemedButton: RichButton() {

    override fun click() {} // not marked as final in RichButton, and so we can still override it from Clickable

    override fun animate() {}

//    override fun showOff() {} // showOff is marked as final in the superclass

//    fun disable() {} can't override disable, and we also can't hide the disable method in superclass
}

/*
by default all Kotlin classes are final, so you can't inherit them
in Java is the other way around

if you need to allow the creation of subclasses, you need the open modifier

not enough to open the class, but we need to open the properties and methods too
 */