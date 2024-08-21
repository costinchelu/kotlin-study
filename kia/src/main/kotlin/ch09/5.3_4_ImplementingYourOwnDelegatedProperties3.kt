package ch09.ImplementingYourOwnDelegatedProperties3

import ch09.ImplementingDelegatedProperties.Observable
import ch09.ImplementingDelegatedProperties.Observer
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class Person(val name: String, age: Int, salary: Int) : Observable() {
    private val onChange = {
        property: KProperty<*>,
        oldValue: Any?,
        newValue: Any? ->
        notifyObservers(property.name, oldValue, newValue)
    }

    var age by Delegates.observable(age, onChange)

    var salary by Delegates.observable(salary, onChange)
}

fun main() {
    val p1 = Person("Alice", 29, 1200)
    p1.observers += Observer { propName, oldValue, newValue ->
            println("obs1 -> Property $propName for ${p1.name} changed from $oldValue to $newValue!")
    }

    p1.observers += Observer { propName, oldValue, newValue ->
            println("obs2 -> Property $propName for ${p1.name} changed from $oldValue to $newValue!")
    }

    p1.age = 30
    p1.salary = 1500
}