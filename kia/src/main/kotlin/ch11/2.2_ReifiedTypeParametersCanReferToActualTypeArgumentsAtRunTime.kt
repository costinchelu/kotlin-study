package ch11.ReifiedTypeParametersCanReferToActualTypeArgumentsAtRunTime

// we can now check the value with is
// with reified, the type parameter will not be erased at runtime (reification works on inline functions)
// an inline function only has performance benefits when the function has function type parameters
// and the corresponding arguments (lambdas) are inlined together with the function
// but in this case we aren't marking it for performance reasons but only to enable the use of reified type parameters
inline fun <reified T> isA(value: Any) = value is T

// we can use reified with accessors
inline val <reified T> T.canonical: String
    get() = T::class.java.canonicalName

fun main() {
    // here T is a String
    println(isA<String>("abc"))                         // true
    println(isA<String>(123))                           // false

    println(isA<Int>(123))                              // true


    val items = listOf("one", 2, "three")

    // standard library - this method is already inline reified si we can use the is operator on the list
    println(items.filterIsInstance<String>())           // [one, three]


    println(listOf("one", "two", "three").toSet().canonical)    // java.util.Set
    println(4.canonical)                                        // java.lang.Integer
}
