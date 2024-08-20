package ch09.OverloadingUnaryOperators


import java.math.BigDecimal


data class Point(val x: Int, val y: Int)

operator fun Point.unaryMinus(): Point {
    return Point(-x, -y)
}

operator fun BigDecimal.inc() = this + BigDecimal.ONE


fun main() {
    val p = Point(10, 20)
    println(-p)
    // Point(x=-10, y=-20)


    var bd = BigDecimal.ZERO
    println(bd++)
    // 0
    println(bd)
    // 1
    println(++bd)
    // 2
}
