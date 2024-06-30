package ch04.ex1_2_1_OpenFinalAbstractModifiers

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

open class RichButton : Clickable {

    fun disable() {}

    open fun animate() {}

    override fun click() {}
}

/*
by default all Kotlin classes are final, so you can't inherit them
in Java is the other way around

if you need to allow the creation of subclasses, you need the open modifier
 */