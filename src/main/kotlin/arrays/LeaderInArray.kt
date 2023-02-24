package arrays

fun main() {
    val inp = intArrayOf(2, 3, 9, 9, 1, 3, 4, 5, 7)
    leaderInArray(inp)
}

fun leaderInArray(array: IntArray) {
    val leaders = mutableListOf<Int>()
    var maxSoFar = Int.MIN_VALUE
    for (i in array.lastIndex downTo 0) {
        if (maxSoFar < array[i]) {
            maxSoFar = array[i]
            leaders.add(0, maxSoFar)
        }
    }

    println(leaders)
}