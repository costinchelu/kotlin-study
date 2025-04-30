package ro.ccar.kt

interface GenericsExample<out T> {
    fun next(): T
}

interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}

fun copy(from: Array<out Any>, to: Array<Any>) {
    assert(from.size == to.size)
    for (i in from.indices)
        to[i] = from[i]
}


class IntGenerator : GenericsExample<Int> {
    private var current = 0

    override fun next(): Int {
        return current++
    }
}

fun main() {
    val intGenerator = IntGenerator()
    println(intGenerator.next())
    println(intGenerator.next())
}