fun main() {
    val rowsCount: Int
    val colsCount: Int

    while (true) {
        print("Enter rows count >>> ")
        val input = readln().toIntOrNull()
        if (input == null || input <= 0) {
            println("Rows count must be a positive number")
        } else {
            rowsCount = input
            break
        }
    }

    while (true) {
        print("Enter columns count >>> ")
        val input = readln().toIntOrNull()
        if (input == null || input <= 0) {
            println("Columns count must be a positive number")
        } else {
            colsCount = input
            break
        }
    }

    val inputArr = Array(rowsCount) { Array(colsCount) { getNum() } }

    println()
    for (row in inputArr) {
        for (num in row) {
            print("$num \t")
        }
        println()
    }
    println()

    val result = mutableMapOf<Int, Int>()
    for (digit in 0..9) {
        result[digit] = inputArr.sumOf { row: Array<Int> ->
            row.sumOf { num: Int ->
                num.toString().count { c -> c == digit.toString()[0] }
            }
        }
    }

    println("В массиве использовано ${result.values.count { n -> n > 0 }} различных цифр")
}

fun getNum(): Int {
    while (true) {
        print("Enter num >>> ")
        val input = readln().toIntOrNull()
        if (input == null || input <= 99 || input > 999) {
            println("Columns count must be a positive number and less than 1000")
        } else {
            return input
        }
    }
}