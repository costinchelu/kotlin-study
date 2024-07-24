package ch06.ex1_6_TransformingCollectionsIntoMaps


data class Person(val name: String, val age: Int)

fun main() {
    val people = listOf(
        Person("Joe", 22),
        Person("Mary", 31),
        Person("Jamie", 22)
    )
	
	// !! keys for maps have to be unique - if the transformation function would result in the same key being added multiple times, the last result overwrites any previous assignments
    val nameToAge: Map<String, Int> = people.associate { it.name to it.age }
    println(nameToAge)          // {Joe=22, Mary=31, Jamie=22}
    println(nameToAge["Joe"])   // 22


    val personToAge: Map<Person, Int> = people.associateWith { it.age }
    println(personToAge)        // {Person(name=Joe, age=22)=22, Person(name=Mary, age=31)=31, Person(name=Jamie, age=22)=22}
    val ageToPerson: Map<Int, Person> = people.associateBy { it.age }
    println(ageToPerson)       // {22=Person(name=Jamie, age=22), 31=Person(name=Mary, age=31)} <3>
}
