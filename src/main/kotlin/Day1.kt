import java.io.File
import java.io.InputStream

fun main(args: Array<String>) {
    //put code to run here
    questionTwo()
}
private fun questionOne() : MutableList<Long> {
    //elf calories
    val caloriesIn = readInput("Day1.txt")
    val elfCalorie = mutableListOf<Long>()

    var cals = 0L
    caloriesIn.forEach{ cal ->
        if(cal == "") {
            elfCalorie.add(cals)
            cals = 0L
            return@forEach
        }
        cals += cal.toLong()
    }
    elfCalorie.sortDescending()
    println("Question 1: ${elfCalorie[0]}")
    return elfCalorie
}

private fun questionTwo() {
    val elfCalorie = questionOne()
    var result = 0L
    for (i in 0..2) {
        result += elfCalorie[i]
    }
    println("Question 2: $result")
}