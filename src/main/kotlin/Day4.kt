fun main(args: Array<String>) {
    questionOne()
    println("============")
    questionTwo()
}

private fun questionOne() {
    val input = readInput("Day4.txt")
    var score = 0L
    for (i in 0 until input.size) {
        var elf1Contained = true
        var elf2Contained = true
        val elf1in = input[i].split(",")[0]
        val elf2in = input[i].split(",")[1]
        val elf1Range = elf1in.split("-")[0].toInt().rangeTo(elf1in.split("-")[1].toInt())
        val elf2Range = elf2in.split("-")[0].toInt().rangeTo(elf2in.split("-")[1].toInt())
        elf1Range.forEach {
            if (!elf2Range.contains(it)) elf1Contained = false
        }
        elf2Range.forEach {
            if (!elf1Range.contains(it)) elf2Contained = false
        }
        if (elf1Contained or elf2Contained) score += 1
    }
    println(score)
}

private fun questionTwo() {
    val input = readInput("Day4.txt")
    var score = 0L
    for (i in 0 until input.size) {
        var elf1Contained = false
        var elf2Contained = false
        val elf1in = input[i].split(",")[0]
        val elf2in = input[i].split(",")[1]
        val elf1Range = elf1in.split("-")[0].toInt().rangeTo(elf1in.split("-")[1].toInt())
        val elf2Range = elf2in.split("-")[0].toInt().rangeTo(elf2in.split("-")[1].toInt())
        elf1Range.forEach {
            if (elf2Range.contains(it)) elf1Contained = true
        }
        elf2Range.forEach {
            if (elf1Range.contains(it)) elf2Contained = true
        }
        if (elf1Contained or elf2Contained) score += 1
    }
    println(score)
}