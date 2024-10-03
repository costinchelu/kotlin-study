package ch13.ex1_InvokeConvention

class Greeter(val greeting: String) {

    operator fun invoke(name: String) {
        println("$greeting, $name!\t[object called like a function]")
    }
}

// we can call the Greeter object as a function using the invoke function convention.
// Invoke can have different parameters and return types and can even be overloaded
fun main() {
    val bavarianGreeter = Greeter("Servus")
    bavarianGreeter("Dmitry")                       // Servus, Dmitry!	[object called like a function]
}
