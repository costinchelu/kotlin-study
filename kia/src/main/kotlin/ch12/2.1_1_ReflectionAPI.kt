package ch12.ex1_1_ReflectionAPI

import kotlin.reflect.full.memberProperties

var counter = 0

class Person(val name: String, val age: Int)

fun foo(x: Int) = println(x)

fun main() {
    val person = Person("Alice", 29)
    val kClass = person::class
    val memberProperty = Person::age
    println(kClass.simpleName)                                  // Person
    println(memberProperty.get(person))                         // 29
    kClass.memberProperties.forEach { println(it.name) }
                                                                // age
                                                                // name

    // --------------------------

    val kFunction = ::foo
    kFunction.call(42)                                          // 42

    // --------------------------

    val kProperty = ::counter
    kProperty.setter.call(21)
    println(kProperty.get())                                    // 21
}
