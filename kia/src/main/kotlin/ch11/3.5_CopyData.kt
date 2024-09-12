package ch11.CopyDataAny

// in this case it is valid to copy a collection of strings into a collection with the generic type Any
fun <T> copyDataV1(
    source: MutableList<T>,
    destination: MutableList<in T>,
) {
    for (item in source) {
        destination.add(item)
    }
}

// to make it work with lists of different types we can write it like:
// (to be able to copy elements from one list to the other,
// the source element type should be a subtype of elements in the destination list, like Int is a subtype of Any)
fun <T : R, R> copyDataV2(
    source: MutableList<T>,
    destination: MutableList<R>,
) {
    for (item in source) {
        destination.add(item)
    }
}

// a more elegant way would be to use a variance modifier
fun <T> copyDataV3(
    source: MutableList<T>,
    destination: MutableList<in T>,
) {
    for (item in source) {
        destination.add(item)
    }
}

// source will be a covariant of T (a subtype of T can be used as source)
// also T can be used in out positions
fun <T> copyDataV4(
    source: MutableList<out T>,
    destination: MutableList<T>,
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
/*
Use-site variance declarations in Kotlin correspond directly to Java bounded wildcards.
MutableList<out T> in Kotlin means the same as MutableList<? extends T> in Java
MutableList<in T> in Kotlin corresponds to MutableList<? super T> in Java
 */