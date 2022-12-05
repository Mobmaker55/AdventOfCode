import java.util.*

fun main(args: Array<String>) {
    //questionOne()
    println("============")
    questionTwo()
}

private val crates = listOf(
    ArrayDeque(listOf("W", "M", "L", "F")),
    ArrayDeque(listOf("B", "Z", "V", "M", "F")),
    ArrayDeque(listOf("H", "L", "R", "S", "L", "Q")),
    ArrayDeque(listOf("F", "S", "V", "Q", "P", "M", "T", "J")),
    ArrayDeque(listOf("L", "S", "W")),
    ArrayDeque(listOf("F", "V", "P", "M", "R", "J", "W")),
    ArrayDeque(listOf("J", "Q", "C", "P", "N", "R", "F")),
    ArrayDeque(listOf("V", "H", "P", "S", "Z", "W", "R", "B")),
    ArrayDeque(listOf("B", "M", "J", "C", "G", "H", "Z", "W"))
)

private fun questionOne() {
    val input = readInput("Day5.txt")
    var coolCrates = crates
    for (i in 0 until input.size) {
        val cmd = input[i].split(" ")
        val amount = cmd[1].toInt()
        val from = cmd[3].toInt() - 1
        val to = cmd[5].toInt() - 1
        for (i in 0 until amount) {
            coolCrates[to].add(coolCrates[from].last())
            coolCrates[from].removeLast()
        }
    }
    for (i in coolCrates.indices) {
        println(coolCrates[i].last)
    }
}

private fun questionTwo() {
    val input = readInput("Day5.txt")
    var coolCrates = crates
    for (i in 0 until input.size) {
        val cmd = input[i].split(" ")
        val amount = cmd[1].toInt()
        val from = cmd[3].toInt() - 1
        val to = cmd[5].toInt() - 1
        var temp = mutableListOf<String>()
        for (i in 0 until amount) {
            print("${coolCrates[from].last} ")
            temp.add(coolCrates[from].last)
            coolCrates[from].removeLast()
        }
        temp.reverse()
        coolCrates[to].addAll(temp)
        println("$temp : ${coolCrates[to]}")
    }
    for (i in coolCrates.indices) {
        println(coolCrates[i].last)
    }
}