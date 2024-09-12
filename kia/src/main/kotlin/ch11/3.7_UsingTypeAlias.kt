package ch11.UsingTypeAlias

/*
from the perspective of the compiler, type aliases don’t introduce any new constraints or changes—
during compilation, aliases are expanded entirely to their underlying type.
So, while they provide a useful shorthand, type aliases do not provide any additional type safety.
 */
typealias NameCombiner = (String, String, String, String) -> String

val authorsCombiner: NameCombiner = { a, b, c, d -> "$a et al." }
val bandCombiner: NameCombiner = { a, b, c, d -> "$a, $b & The Gang" }

fun combineAuthors(combiner: NameCombiner) {
    println(combiner("Sveta", "Seb", "Dima", "Roman"))
}

fun main() {
    combineAuthors(bandCombiner)                            // Sveta, Seb & The Gang
    combineAuthors(authorsCombiner)                         // Sveta et al.
    combineAuthors { a, b, c, d -> "$d, $c & Co."}          // Roman, Dima & Co.
}

