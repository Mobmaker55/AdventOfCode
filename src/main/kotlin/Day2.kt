import kotlin.math.truncate

fun main(args: Array<String>) {
    //put code to run here
    questionOne()
    println("=============")
    questionTwo()
}

//paper, scissors, rock
val rps = listOf('B', 'C', 'A')
private fun questionOne() {
    val duelsIn = readInput("Day2.txt")
    var playerOneScore = 0L //A Rock, B Paper, C Scissors
    var playerTwoScore = 0L //X Rock, Y Paper, Z Scissors
    duelsIn.forEach {
        when (it[0]) {
            //score addition for p1
            'A' -> playerOneScore += 1
            'B' -> playerOneScore += 2
            'C' -> playerOneScore += 3
        }
        when (it[2]) {
            //score addition for p2
            'X' -> playerTwoScore += 1
            'Y' -> playerTwoScore += 2
            'Z' -> playerTwoScore += 3
        }
        val opponentI = rps.indexOf(it[0])
        val responseI = rps.indexOf(it[2] - 23)
        if (opponentI != responseI) {
            if (responseI == (opponentI + 1) % 3) playerTwoScore += 6
            else playerOneScore += 6
        } else {
            playerTwoScore += 3
            playerOneScore += 3
        }

    }
    println("Player 1: $playerOneScore")
    println("Player 2: $playerTwoScore")
}

private fun questionTwo() {
    val duelsIn = readInput("Day2.txt")
    var playerOneScore = 0L //A Rock, B Paper, C Scissors
    var playerTwoScore = 0L //X Lose, Y Tie, Z Win
    duelsIn.forEach {
        var ourMove = 'A'
        when (it[2]) {
            'X' -> {
                ourMove = it[0] - 1
                if (ourMove < Char(65)) ourMove = Char(67)
            }
            'Y' -> {
                ourMove = it[0]
                playerTwoScore += 3
            }
            'Z' -> {
                ourMove = it[0] + 1
                if (ourMove > Char(67)) ourMove = Char(65)
                playerTwoScore += 6
            }
        }
        playerTwoScore += ourMove.code - 64
    }
    println("$playerTwoScore")
}
