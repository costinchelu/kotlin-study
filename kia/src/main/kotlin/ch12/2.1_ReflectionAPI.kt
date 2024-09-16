package ch12.ReflectionAPI

import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.memberProperties

var counter = 0

class Person(val name: String, val age: Int)

annotation class JsonName(val jsonName: String)

class AnnotatedPerson(
    @JsonName("alias") val firstName: String,
    val age: Int)

fun foo(x: Int) = println(x)

fun sum(x: Int, y: Int) = x + y

// access elements at runtime
fun main() {
    // using reflection for objects
    val person = Person("Alice", 29)
    val kClass = person::class
    val memberProperty = Person::age

    println(kClass.simpleName)                                  // Person
    println(kClass.qualifiedName)                               // ch12.ReflectionAPI.Person
    println(memberProperty.get(person))                         // 29
    kClass.memberProperties.forEach { println(it.name) }
                                                                // age
                                                                // name

    // --------------------------------------------------------------------------------------------------------

    // calling a function
    // call(), calls the getter of the function
    val kFunction = ::foo
    kFunction.call(42)                                          // 42

    // using invoke prevents accidental passing of incorrect number of arguments to the function
    // it is the preferred way of calling it
    val kFunction2 = ::sum
    println(kFunction2.invoke(1, 2) + kFunction2(3, 4))         // 10

    // --------------------------------------------------------------------------------------------------------

    // manipulating a property
    val kProperty = ::counter
    kProperty.setter.call(21)
    println(kProperty.get())                                    // 21

    // we can use reflection to access properties defined at the top level or in a class,
    // but not local variables of a function

    // ---------------------------------------------------------------------------------------------------------

    val annotatedPerson = AnnotatedPerson("Alice", 29)
    val kClass2 = annotatedPerson::class
    val filteredProperties = kClass2.memberProperties.filter { it.findAnnotation<JsonName>() == null }
    filteredProperties.forEach { println(it) }
}
