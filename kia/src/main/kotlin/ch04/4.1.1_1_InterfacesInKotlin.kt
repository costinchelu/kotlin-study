package ch04.ex1_1_1_InterfacesInKotlin

interface Clickable {

    // definitions of abstract methods
    fun click()

    // can contain implementations of non-abstract methods (however they can't contain any state
    fun showOff() = println("I'm clickable")

    // can contain property declarations (final and public by default)
}

class Button : Clickable {
    override fun click() = println("I was clicked")
}

fun main() {
    Button().click()
    Button().showOff()
}
