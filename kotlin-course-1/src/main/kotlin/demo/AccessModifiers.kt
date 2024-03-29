package demo


fun main() {

    // even though AMEmployee class is private, it is still visible within its own kt file
    val obj1 = SomePrivateClass()
    println(obj1)
}



// in Kotlin a class can be private, and it is visible within the file
// a Kotlin file can have multiple classes/methods/variables
private class SomePrivateClass { }

class AMEmployee {

}


/*
in Kotlin, we can have the "internal" access modifier
the internal class will be visible within its kotlin module
if we use Java in the same project, internal is compiled as public


there is no protected top level item access modifier
 */