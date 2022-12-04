import java.io.File
import java.io.InputStream

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}

fun readInput(fileName: String) : MutableList<String> {
    val dataIn = mutableListOf<String>()
    val inputStream: InputStream = File("src/main/resources/$fileName").inputStream()
    inputStream.bufferedReader().useLines { lines -> lines.forEach { dataIn.add(it)} }
    return dataIn
}