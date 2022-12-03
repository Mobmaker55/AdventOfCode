fun main(args: Array<String>) {
    questionOne()
    println("============")
    questionTwo()
}

private fun questionOne() {
    var iter = 0L
    var score = 0L
    val rucksacksIn = readInput("Day3.txt")
    rucksacksIn.forEach { sack ->
        iter++
        var diffFound = false
        val compartments = sack.length / 2
        val compartmentI = sack.substring(0, compartments).toCharArray()
        val compartmentII = sack.substring(compartments, sack.length).toCharArray()
        compartmentI.forEach {
            if (!diffFound) {
                if (compartmentII.contains(it)) {
                    diffFound = true
                    var scoreAdd = 0L
                    if (it.code in 97..122) scoreAdd += it.code - 96
                    if (it.code in 65..90) scoreAdd += it.code - 38
                    score += scoreAdd
                    //println("> ${sack.substring(0, compartments)} : ${sack.substring(compartments, sack.length)}")
                }
            }
        }
    }
    println(score)
}

private fun questionTwo() {
    var score = 0L
    val rucksacksIn = readInput("Day3.txt")
    for (i in 0 until rucksacksIn.size step 3) {
        val elf1 = rucksacksIn[i].toCharArray()
        val elf2 = rucksacksIn[i + 1].toCharArray()
        val elf3 = rucksacksIn[i + 2].toCharArray()
        var charFound = false
        elf1.forEach {
            if (charFound) return@forEach
            var scoreAdd = 0L
            if (!elf2.contains(it)) return@forEach
            if (!elf3.contains(it)) return@forEach
            charFound = true
            if (it.code in 97..122) scoreAdd += it.code - 96
            if (it.code in 65..90) scoreAdd += it.code - 38
            score += scoreAdd
        }
    }
    println(score)
}