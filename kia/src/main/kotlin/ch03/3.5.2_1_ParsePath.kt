package ch03.ParsePath

fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")

    println("Dir path: $directory, file name: $fileName, file ext: $extension")
}

fun parsePathRegex(path: String) {
    val regex = """
        (.+)/(.+)\.(.+)
        """.trimIndent().toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured
        println("Dir path: $directory, file name: $filename, file ext: $extension")
    }
}

fun String.parsePathRegexExt() {
    val regex = """
        (.+)/(.+)\.(.+)
        """.trimIndent().toRegex()
    val matchResult = regex.matchEntire(this)
    if (matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured
        println("Dir path: $directory, file name: $filename, file ext: $extension")
    }
}

fun main() {
    parsePath("/Users/user/kotlin-book/chapter3.docx")
    println()
    parsePathRegex("/Users/user/kotlin-book/chapter3.docx")
    println()
    "/Users/user/kotlin-book/chapter3.docx".parsePathRegexExt()
}
