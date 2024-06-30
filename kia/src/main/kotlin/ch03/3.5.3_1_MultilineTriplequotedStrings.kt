package ch03.ex5_3_1_MultilineTriplequotedStrings

import org.intellij.lang.annotations.Language

val kotlinLogo =
    """
    | //
    |//
    |/ \
    """.trimIndent()

fun parseExpressions() {

    @Language("HTML")
    val expectedPage = """
<html lang="en">
    <head>
        <title>A page</title>
    </head>
    <body>
        <p>Hello, Kotlin!</p>
    </body>
</html>
    """

    @Language("JSON")
    val expectedObject = """
        {
            "name": "Sebastian",
            "age": 27,
            "homeTown": "Munich"
        }
    """.trimIndent()

    println()
    println(expectedPage)
    println()
    println(expectedObject)
}

fun main() {
    println(kotlinLogo)

    parseExpressions()
}
