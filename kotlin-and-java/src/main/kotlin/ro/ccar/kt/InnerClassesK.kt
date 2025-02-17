package ro.ccar.kt

open class FooK {

    open val x: Int = 0

    open fun f() {}
}

class BarK : FooK() {

    override val x: Int get() = 0

    override fun f() {}

    inner class BazK {

        fun g() {
            super@BarK.f()              // Calls Foo's implementation of f()
            println(super@BarK.x)       // Uses Foo's implementation of x's getter
        }
    }
}


class InnerClassesK {
}