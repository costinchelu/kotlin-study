package ch05.ex4_2_1_UsingApply


// receiverObject.apply { lambda }    : returns the (processed) receiver object

// sometimes you want the call to return the receiver object, not the result of executing the lambda
// the object we are calling apply on, becomes the receiver of the lambda
// apply can work as a builder. Initialize a StringBuilder with some state.
fun alphabet() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
}

// standard library function that will initialize a StringBuilder and then it will call toString on it
fun alphabet2() = buildString {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
}


fun main() {
    println(alphabet().toString())
    println(alphabet2())

    val shouldAdd = true

    // collection builder functions from the Kotlin Standard Library:
    val fibonacci: List<Int> = buildList {
        addAll(listOf(1, 1, 2))
        add(3)
        add(index = 0, element = 0)
    }

    val fruits: Set<String> = buildSet {
        add("Apple")
        if(shouldAdd) {
            addAll(listOf("Apple", "Banana", "Cherry"))
        }
    }

    val medals: Map<String, Int> = buildMap {
        put("Gold", 1)
        putAll(listOf("Silver" to 2, "Bronze" to 3))
    }
}
