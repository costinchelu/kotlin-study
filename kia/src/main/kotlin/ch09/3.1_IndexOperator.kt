package ch09.ex3_1_IndexOperator


data class Point(val x: Int, val y: Int)

operator fun Point.get(index: Int): Int {
    return when (index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

data class MutablePoint(var x: Int, var y: Int)

operator fun MutablePoint.get(index: Int): Int {
    return when (index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

operator fun MutablePoint.set(index: Int, value: Int) {
    when (index) {
        0 -> x = value
        1 -> y = value
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

fun main() {
    val p = Point(10, 20)
    println(p[1])
    // 20


    val m = MutablePoint(10, 20)
    m[1] = 42
    println(m[1])
    // 42
    println(m)
    // MutablePoint(x=10, y=42)
}
