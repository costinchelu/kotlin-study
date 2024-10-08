package ch02.WhenEnums


enum class Color(
    val r: Int,
    val g: Int,
    val b: Int
) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b
}


fun getMnemonic(color: Color) =
    when (color) {
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }


fun measureColor() = Color.ORANGE
// as a stand-in for more complex measurement logic


fun getWarmthFromSensor(): String {
    val getTheColor: Color = measureColor()
    return when (getTheColor) {
        Color.RED,
        Color.ORANGE,
        Color.YELLOW -> "warm (red = ${getTheColor.r})"
        Color.GREEN -> "neutral (green = ${getTheColor.g})"
        Color.BLUE,
        Color.INDIGO,
        Color.VIOLET -> "cold (blue = ${getTheColor.b})"
    }
}

fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
        setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
        else -> throw Exception("Dirty color")
    }

fun mixOptimized(c1: Color, c2: Color) =
    when {
        (c1 == Color.RED && c2 == Color.YELLOW) || (c1 == Color.YELLOW && c2 == Color.RED) -> Color.ORANGE
        (c1 == Color.YELLOW && c2 == Color.BLUE) || (c1 == Color.BLUE && c2 == Color.YELLOW) -> Color.GREEN
        (c1 == Color.BLUE && c2 == Color.VIOLET) || (c1 == Color.VIOLET && c2 == Color.BLUE) -> Color.INDIGO
        else -> throw Exception("Dirty color")
    }

fun main() {
    println(getMnemonic(Color.BLUE))
    println(getWarmthFromSensor())
    println("${mixOptimized(Color.BLUE, Color.YELLOW)} - red value = ${mixOptimized(Color.BLUE, Color.YELLOW).r}")
}
