package ro.ccar.kt

class ClassWithObjectK {

    companion object {
        @JvmStatic
        fun foo() {
            println("directly accessible in Java")
        }

        fun bar() {
            println("only accessible in Java through Companion")
        }

        const val SOME_VALUE = 100
    }
}

fun main() {
    ClassWithObjectK.foo()
    ClassWithObjectK.bar()
    println(ClassWithObjectK.SOME_VALUE)
}