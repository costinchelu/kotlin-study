package ch11.CopyDataAny


fun <T : R, R> copyDataV1(
    source: MutableList<T>,
    destination: MutableList<R>,
) {
    for (item in source) {
        destination.add(item)
    }
}

fun <T> copyDataV2(
    source: MutableList<out T>,
    destination: MutableList<T>,
) {
    for (item in source) {
        destination.add(item)
    }
}

fun <T> copyDataV3(
    source: MutableList<T>,
    destination: MutableList<in T>,
) {
    for (item in source) {
        destination.add(item)
    }
}

fun main() {
    val ints = mutableListOf(1, 2, 3)
    val anyItems = mutableListOf<Any>()
    copyDataV1(ints, anyItems)
    println(anyItems)                               // [1, 2, 3]
}
