package ch04

// abstract class -> can't create an instance of it
abstract class Animated {

    abstract val animationSpeed: Double     // subclasses need to override its value or accessor

    val keyframe: Int = 20                  // non-abstract properties in abstract classes aren't open by default

    open val frames: Int = 60               // but can be marked as open

    abstract fun animate()                  // this must be implemented in a subclass

    open fun stopAnimating() {}             // non-abstract methods aren't open by default

    fun animateTwice() {}                   // this can't be overridden
}



class AnimatedBall(override val animationSpeed: Double) : Animated() {

    override fun animate() {}           // this abstract method must be overridden

    override fun stopAnimating() {}     // we are allowed to override this method
}

fun main() {
    val a: Animated = AnimatedBall(22.5)
    println(a.frames)
    println(a.keyframe)
    println(a.animationSpeed)
    a.animate()
    a.stopAnimating()
    a.animateTwice()
}