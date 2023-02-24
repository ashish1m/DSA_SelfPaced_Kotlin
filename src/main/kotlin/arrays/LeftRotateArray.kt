package arrays

fun main() {
    val inp = intArrayOf(2, 0, 4, 0, 1, 3, 4, 5, 7)
    leftRotate(inp, 2)
}

fun leftRotate(array: IntArray, d: Int = 1) {
    val effectiveRotation = d % array.size
    if (effectiveRotation != 0) {
        reverseArray(array, 0, effectiveRotation - 1)
        reverseArray(array, effectiveRotation, array.lastIndex)
        reverseArray(array, 0, array.lastIndex)
    }
    println(array.contentToString())
}

fun reverseArray(array: IntArray, low: Int, high: Int) {
    var start = low
    var end = high
    while (start < end) {
        //swap
        val temp = array[start]
        array[start] = array[end]
        array[end] = temp
        start++
        end--
    }
}