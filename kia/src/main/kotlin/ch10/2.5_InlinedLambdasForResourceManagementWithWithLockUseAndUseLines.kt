package ch10.InlinedLambdasForResourceManagementWithWithLockUseAndUseLines

import java.io.BufferedReader
import java.io.FileReader
import kotlin.io.path.Path
import kotlin.io.path.useLines

// use function is an inlined extension fun called on a closable resource
// the function calls the lambda (given as a parameter) and ensures the resource is closed
// being inlined it doesn't incur any performance overhead
fun readFirstLineFromFile(fileName: String): String {
    BufferedReader(FileReader(fileName)).use { bufferedReader -> return bufferedReader.readLine() }
}

/* Java

static String readFirstLineFromFile(String fileName) throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        return br.readLine();
    }
}
*/


// useLines is a more specialized inlined extension function (kotlin.io)
fun readFirstLineFromFileV2(fileName: String): String {
    Path(fileName).useLines { return it.first() }
}