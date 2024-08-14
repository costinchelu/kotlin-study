package ch08.ex2_2_ReadonlyAndMutableCollections

fun <T> copyElements(source: Collection<T>, target: MutableCollection<T>) {
    for (item in source) {
        target.add(item)
    }
}

fun main() {
    // read only collections aren't always thread safe
    val source: Collection<Int> = arrayListOf(3, 5, 7)

    // read and write
    val target: MutableCollection<Int> = arrayListOf(1, 2)

    // defensive copy (from a read-only Collection to a read-write one)
    copyElements(source, target)
    println(target)

    // read-only collections are not necessarily immutable
    val arrayList = arrayListOf(1, 3)
    val readOnly: Collection<Int> = arrayList
    val readAndWrite: MutableCollection<Int> = arrayList
    readAndWrite.add(5)
    println(readOnly)
}
