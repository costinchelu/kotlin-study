package demo

import java.io.DataInputStream
import java.io.EOFException
import java.io.File
import java.io.FileInputStream


const val file1 = "test-file-1.txt"
const val file2 = "testfile.bin"
const val currentDir = "."

fun main() {
    // reader is an extension function (should not be used with big files)
    val lines = File(file1).reader().readLines()
    lines.forEach { println(it) }

    File(file1).reader().forEachLine { println(it) }

    // in Java:
//    new InputStreamReader(new FileInputStreamReader(new File(file1)), "UTF-8")

    // read the whole file
    val wholeFile = File(file1).bufferedReader().use { it.readText() }
    println(wholeFile)


    val wholeFile2 = File(file1).readText()
    println(wholeFile2)


    // use a java.io class to read binary file
    val dis = DataInputStream(FileInputStream(file2))
    var si: String
    try {
        while (true) {
            si = dis.readUTF()
            println(si)
        }
    } catch (e: EOFException) {
        println("End of file exception")
    }


    // walking the file tree
    // print only kotlin files
    File(currentDir)
        .walkTopDown()
        .filter { it.name.endsWith(".kt") }
        .forEach { println(it) }

}