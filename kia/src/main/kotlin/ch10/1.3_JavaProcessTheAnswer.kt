@file:JvmName("ProcessTheAnswer")

package ch10.JavaProcessTheAnswer

/* Kotlin declaration */
fun processTheAnswer(f: (Int) -> Int) {
    println(f(42))
}

/* Java call */
// processTheAnswer(number -> number + 1
// prints 43


/* Java

import kotlin.collections.CollectionsKt;

// ...
public static void main(String[] args) {
    List<String> strings = new ArrayList();
    strings.add("42");
    CollectionsKt.forEach(strings, s -> {
        System.out.println(s);
        return Unit.INSTANCE;
    });
}

we can use a function from the Kotlin StdLib in Java, but we have to return a Unit type explicitly
Unit type has a value in Kotlin so we cannot return void

 */