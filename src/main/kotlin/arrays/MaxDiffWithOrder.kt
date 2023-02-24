package arrays

fun main() {
    val arr = intArrayOf(2, 3, 10, 6, 4, 8, 1)
    naiveMaxDiff(arr)
    maxDiff(arr)
}

fun naiveMaxDiff(array: IntArray) {
    var maxDiff = Int.MIN_VALUE
    for (i in array.size - 1 downTo 1) {
        for (j in i - 1 downTo 0) {
            if (array[i] - array[j] > maxDiff) {
                maxDiff = array[i] - array[j]
            }
        }
    }

    println("Max Diff: $maxDiff")
}

fun maxDiff(array: IntArray) {
    var maxDiff = Int.MIN_VALUE
    var minSoFar = array[0]
    for (i in 1 until array.size) {
        if (array[i] - minSoFar > maxDiff) {
            maxDiff = array[i] - minSoFar
        }
        if (array[i] < minSoFar) {
            minSoFar = array[i]
        }
    }

    println("MinSoFar: $minSoFar")
    println("Max Diff: $maxDiff")
}