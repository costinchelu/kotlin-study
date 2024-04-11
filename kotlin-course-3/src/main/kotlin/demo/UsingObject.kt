package demo

import java.time.Year


fun main() {
    println(CompanyCommunications.getTagLine())
    println(CompanyCommunications.getCopyrightLine())

    SomeClassKt.accessPrivateVar()

    val sc1 = SomeClassKt.justAssign("string as is")
    val sc2 = SomeClassKt.upperOrLowerCase("string to upper?", false)
    val sc3 = SomeClassKt.upperOrLowerCase("string to upper?", true)
    println(sc1.someString)
    println(sc2.someString)
    println(sc3.someString)

    // Object expressions (essentially anonymous objects)
    // even though we use the object keyword here, it is not a singleton.
    wantSomeInterface(object: SomeInterface {
        override fun mustImplement(num: Int): String = "This is from mustImplement: ${num * 100}."
    })
}


// we use the keyword object to create a Singleton class
// we can't have any constructors
// the single instance of the class is created lazily
object CompanyCommunications {

    private val currentYear = Year.now().value

    fun getTagLine() = "Our company rocks!"

    fun getCopyrightLine() = "Copyright\u00A9 $currentYear Our Company. All rights reserved."
}

// static keyword does not exist in Kotlin. Instead, we can use:
//      - top level functions and properties
//      - companion objects

// companion objects:
//      -   can have names
//      -   can access private constructors
//      -   can be used to implement Factory DP
class SomeClassKt private constructor(val someString: String) {

    companion object {

        private var privateVar = 3

        fun accessPrivateVar() = println("I'm accessing privateVar: $privateVar")

        fun justAssign(str: String) = SomeClassKt(str)

        fun upperOrLowerCase(str: String, lowercase: Boolean): SomeClassKt {
            return if (lowercase) {
                SomeClassKt(str.lowercase())
            } else {
                SomeClassKt(str.uppercase())
            }
        }
    }
}


interface SomeInterface {
    fun mustImplement(num: Int): String
}

fun wantSomeInterface(si: SomeInterface) {
    println("Printing from wantSomeInterface ${si.mustImplement(22)}.")
}
