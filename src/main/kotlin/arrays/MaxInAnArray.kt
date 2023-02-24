package arrays

fun main() {
    val inp = intArrayOf(2, 3, 4, 9, 1, 3, 4, 5, 7)
    println("Max: " + maxInArray(inp))
    println("SecondMax: " + secondLargest(inp))
}

fun maxInArray(arr: IntArray): Int {
    var max = Int.MIN_VALUE
    for (i in arr) {
        if (max < i) {
            max = i
        }
    }

    return max
}

fun secondLargest(arr: IntArray):Int {
    var max = Int.MIN_VALUE
    var sec = max
    for (i in arr) {
        if (max < i) {
            sec = max
            max = i
        } else if (sec < i) {
            sec = i
        }
    }

    return sec
}