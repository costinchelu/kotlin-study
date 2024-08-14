package ch09.ex1_2_MoreOperators


data class Point(val x: Int, val y: Int)

// we can create an operator with an extension function
operator fun Point.plus(other: Point) = Point(x + other.x, y + other.y)

operator fun Point.times(scale: Double): Point {
    return Point((x * scale).toInt(), (y * scale).toInt())
}

operator fun Char.times(times: Int): String {
    return toString().repeat(times)
}

fun main() {
    val p1 = Point(30, 40)
    val p2 = Point(30, 40)
    val p3 = p1 + p2
    println(p3)

    val p = Point(10, 20)
    println(p * 1.5)
    // Point(x=15, y=30)


    println('a' * 3)
    // aaa


    // bitwise
    println(0x0F and 0xF0)
    // 0
    println(0x0F or 0xF0)
    // 255
    println(0x1 shl 4)
    // 16
}
