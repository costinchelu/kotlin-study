package ch04.ex3_3_ClassDelegationUsingTheByKeyword


// we can delegate the MutableCollection implementation to innerSet variable using operator by
class CountingSet<T>(
        private val innerSet: MutableCollection<T> = HashSet()
) : MutableCollection<T> by innerSet {

    var objectsAdded = 0

    override fun add(element: T): Boolean {
        // decoration:
        objectsAdded++
        // normal MutableCollection method call:
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdded += elements.size
        return innerSet.addAll(elements)
    }
}

fun main() {
    val cset = CountingSet<Int>()
    cset.add(5)
    cset.addAll(listOf(1, 1, 2))
    println("Tried to add ${cset.objectsAdded} objects, and ${cset.size} are uniques.")
    // all other methods specific to MutableCollection are still available and untouched
    // only add and addAll are overridden by a custom implementation (are decorated)
}
