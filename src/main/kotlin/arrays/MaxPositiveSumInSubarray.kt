package arrays

fun main() {
    val intArr = intArrayOf(-3, 4, -2, 6, -2, -4, -1, -5)
    println(maxPositiveSum(intArr))
}

fun maxPositiveSum(arr: IntArray): Int {
    // Implement your interview.solution here
    var maxSoFar = Int.MIN_VALUE
    var maxEndingHere = 0
    for (i in arr) {
        maxEndingHere += i
        if (maxSoFar < maxEndingHere) {
            maxSoFar = maxEndingHere
        }
        if (maxEndingHere < 0) {
            maxEndingHere = 0
        }
    }

    return maxSoFar
}