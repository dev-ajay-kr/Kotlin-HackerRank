package com.devajaykr.`Dev-Ajay-Kr`.HackerRank

fun receivedText(S: String): String {
    // WRITE DOWN YOUR CODE HERE
    // Initialize variables
    var output = ""
    var numericLockOn = true
    var cursor = 0

    // Iterate through the input string
    for (c in S) {
        when (c) {
            '<' -> cursor = 0
            '>' -> cursor = output.length
            '*' -> {
                if (cursor > 0) {
                    output = output.substring(0, cursor - 1) + output.substring(cursor)
                    cursor--
                }
            }
            '#' -> numericLockOn = !numericLockOn
            else -> {
                if (numericLockOn || !c.isDigit()) {
                    output = output.substring(0, cursor) + c + output.substring(cursor)
                    cursor++
                }
            }
        }
    }

    return output

}

fun main(args: Array<String>) {
    val S = readLine()!!

    val result = receivedText(S)

    println(result)
}
