package ch02.ex5_2_TryAsAnExpression

import java.io.BufferedReader
import java.io.StringReader

fun readNumber(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        return
    } finally {
        reader.close()
    }

    println(number)
}

fun readNumberV2(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        null
    } finally {
        reader.close()
    }

    println(number)
}

fun main() {
    val reader = BufferedReader(StringReader("not a number"))
    readNumber(reader)

    val reader2 = BufferedReader(StringReader("not a number"))
    readNumberV2(reader2)
}
