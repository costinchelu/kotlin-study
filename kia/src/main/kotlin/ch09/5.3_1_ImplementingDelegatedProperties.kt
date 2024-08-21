package ch09.ImplementingDelegatedProperties

// Observer Design Pattern
fun interface Observer {
    fun onChange(name: String, oldValue: Any?, newValue: Any?)
}


open class Observable {

    val observers = mutableListOf<Observer>()

    fun notifyObservers(propName: String, oldValue: Any?, newValue: Any?) {
        for (obs in observers) {
            obs.onChange(propName, oldValue, newValue)
        }
    }
}


class Person(val name: String, age: Int, salary: Int) : Observable() {

    var age: Int = age
        set(newValue) {
            val oldValue = field
            field = newValue
            notifyObservers(
                "age", oldValue, newValue
            )
        }

    var salary: Int = salary
        set(newValue) {
            val oldValue = field
            field = newValue
            notifyObservers(
                "salary", oldValue, newValue
            )
        }
}


fun main() {
    val p1 = Person("Seb", 28, 1000)
    val p2 = Person("John", 35, 1200)

    // add observers
    p1.observers += Observer { propName, oldValue, newValue ->
        println("obs1 -> Property $propName for ${p1.name} changed from $oldValue to $newValue!")
    }

    p1.observers += Observer { propName, oldValue, newValue ->
        println("obs2 -> Property $propName for ${p1.name} changed from $oldValue to $newValue!")
    }

    p2.observers += Observer { propName, oldValue, newValue ->
        println("obs1 -> Property $propName for ${p2.name} changed from $oldValue to $newValue!")
    }

    // all observers will be notified
    p1.age = 29
    p2.age = 36
    p1.salary = 1500
}
