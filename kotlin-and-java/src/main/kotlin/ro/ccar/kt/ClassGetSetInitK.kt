package ro.ccar.kt

class UsingVarAndInitK(var name: String = "")

class UsingVarAndNoInitK(var name: String)

class UsingValAndInitK(val name: String = "")

class UsingValAndNoInitK(val name: String)


class PropertyWorkingOnExistingFieldK(var size: Int) {
    // This is just a property, not a field!
    var isEmpty: Boolean
        get() = size == 0
        set(value) {
            if (value) {
                size = 0
            }
        }
}

class AccessField() {
    var counter = 0
        set(value) {
            // Referencing the field here will make a field appear in the class (see in the demo)
            if (value >= 0) field = value
        }

    var counterWithoutField = 0
        set(value) {
            // Not referencing field, no field will be created in the class
            if (value >= 0) counter = value
        }
}

class FunctionAndPropertyK(var size: Int) {
    val isEmptyVal: Boolean
        get() = this.size == 0

    // The same thing can be done with a function
    fun isEmptyFun(): Boolean = this.size == 0
}





fun main() {
    val accessField = AccessField()

    // Setting counter
    accessField.counter = 5
    println("Counter: ${accessField.counter}") // Output: Counter: 5

    // Setting counterWithoutField
    accessField.counterWithoutField = 10
    println("CounterWithoutField: ${accessField.counterWithoutField}") // Output: CounterWithoutField: 0
    println("Counter after setting CounterWithoutField: ${accessField.counter}") // Output: Counter after setting CounterWithoutField: 10
}