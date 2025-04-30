package ro.ccar.kt

fun String.concatenatedLengthK(str: String): Int {
    return (this.length + str.length)
}

fun main() {
    val len = "one string".concatenatedLengthK("another string")
    println(len)
}