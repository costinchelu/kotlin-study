package demo

fun main() {

    val strings = listOf("spring", "summer", "autumn", "winter")
    println(strings.javaClass) // immutable

    val arrayList = arrayListOf(1, 2, 4)
    println(arrayList.javaClass) // mutable

    val mutableList = mutableListOf(1, 2 ,3)
    println(mutableList.javaClass)

    val array = arrayOf("black", "white", "green")
    val listFromArray = array.toList()
    println(listFromArray)

    val ints = intArrayOf(1, 2 ,3)
    println(ints.toList())

    val emptyList = emptyList<String>()
    println(emptyList.javaClass)

    val notNullList = listOfNotNull("hello", null, "goodbye")
    println(notNullList)

    val mergedLists = arrayList + mutableList
    println(mergedLists)


    val immutableMap = mapOf<Int, Car>(
        1 to Car("green", "Toyota", 2015),
        2 to Car("red", "Ford", 2016),
        3 to Car("silver", "Honda", 2014),
        3 to Car("red", "BMW", 2015),
        3 to Car("white", "Ford", 2010),
    )
    println(immutableMap.javaClass)
    println(immutableMap)

    val mutableMap = mutableMapOf(
        "John's car" to Car("red", "Range Rover", 2010),
        "Jane's car" to Car("blue", "Mazda", 2013)
    )
    println(mutableMap.javaClass)
    println(mutableMap)

    for ((k, v) in mutableMap) {
        println("$k, $v")
    }

    // deconstruct a class (using operator) (data classes don't need operator)
    val (c, m, y) = immutableMap.getValue(1)
    println("$c, $m, $y")

    val setInts = setOf(10, 15, 19, 5 ,2, -22)
    println(setInts.plus(20))
    println(setInts.plus(10))
    println(setInts.filter { it % 2 != 0 })
    println(setInts.javaClass)

    val add10List = setInts.map { it + 10 }
    println(add10List)

    println(immutableMap.map { it.value.year })

    println(immutableMap.filter { it.value.model == "Ford" }.map { it.value.color })

    println(immutableMap.all { it.value.year > 2014 })
    println(immutableMap.any { it.value.year > 2014 })
    println(immutableMap.values.find { it.year > 2014 })
    println(immutableMap.values.groupBy { it.color })
    println(immutableMap.values.sortedBy { it.year })
}

class Car(val color: String, val model: String, val year: Int) {

    operator fun component1() = color
    operator fun component2() = model
    operator fun component3() = year

    override fun toString(): String {
        return "Car(color='$color', model='$model', year=$year)"
    }


}