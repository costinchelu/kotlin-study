package demo

/*
TOP LEVEL VISIBILITY:

public (default in Kotlin)
    - default access in Kotlin is public (in Java is package private)

private (everything in the same kt file can access it but invisible to other files/classes)
    - in Java there are no private classes but here there might be
    - it will be compiled to package private for the JVM

protected (there is no protected top level item access modifier, but also not in Java too)

internal (the internal class will be visible within its kotlin module)
    - if we use Java in the same project, internal is compiled as public

In Kotlin there is no matching between class names and file names. We can have as many public classes in the same kt file

CLASS MEMBER VISIBILITY:
Kotlin classes can only have properties. They don't have fields.
public, protected and private is the same as in Java
internal would be useful only in the case the class is visible outside the module
in Kotlin, classes can't see the inner member of its inner classes

In Kotlin getters and setters have the same visibility as the property. So if we have a private property, then there will be
no way for us to accessor modify that property. BUT, in Kotlin we can safely have public properties because all access
to the properties from outside the class is done automatically through getters and setters. So there is no point to declare
a private property (only in case we need it inside that class).

In case we need to write our own getters and setters, then we need to declare that property inside the class.
 */
fun classBasics() {
    val ke1 = KotlinEmployee("Test")
    println(ke1.firstName)

    val ke2 = KotlinEmployee("Test2", false)
    println(ke2.fullTime)

    val ke3 = KotlinEmployeeV2("Test3")
    ke3.fullTime = false
    println(ke3.fullTime)

    val ke4 = KotlinEmployeeV3("Test4", false)
    println(ke4.fullTimed)
    ke4.fullTimed = true
    println(ke4.fullTimed)

    val d1 = Demo("dummy1")
    println(d1.dummy)

    // private classes are visible in their own kt file
    val obj1 = SomePrivateClass()
}


/*
All classes in Kotlin are public final by default
In a kt file we can have multiple public classes unlike in Java

we can declare fields directly [primary constructor] - like in a Record
these fields can be var or val (default is val)
if we need another access modifier for the constructor, then we need to explicitly include the keyword:
class KotlinEmployee protected constructor (val firstName: String) {}

we can declare fields:

   val firstName: String

we can init fields in an init block (this is not a constructor)
because primary constructor is auto generated, we can use init fields to add initialisation logic

   init {
       firstName = "John"
   }

we can declare other constructors (like in Java). They are called secondary constructors.
Classes create the primary constructor (all arg) and getters/setters (of course, val will only have getter)
*/
class KotlinEmployee (val firstName: String) {

    var fullTime: Boolean = true

    // secondary constructor must call primary constructor, and this is specified after the colon
    constructor(firstName: String, fullTime: Boolean): this(firstName) {
        this.fullTime = fullTime
    }
}

// more simple would be to specify fullTime as having a default value in the primary constructor:
class KotlinEmployeeV2 (val firstName: String, var fullTime: Boolean = true)

/*
without var/val, fullTime is no longer a property, but a parameter
for explicit getter/setter -> get()/set() should be placed directly after the field */
class KotlinEmployeeV3 (val firstName: String, fullTime: Boolean = true) {

    var fullTimed = fullTime

        get() {
            println("Custom getter for $field")
            return field
        }

        set(value) {
            println("Custom setter for $field")
            field = value
        }
}

// in Kotlin a class can be private, and it is visible within the file
// a Kotlin file can have multiple classes/methods/variables
private class SomePrivateClass


// example class with no primary constructor
class Demo {

    val dummy: String

    constructor(dummy: String) {
        this.dummy = dummy
    }
}