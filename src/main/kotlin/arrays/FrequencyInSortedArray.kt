package arrays

fun main() {
    val arr = intArrayOf(10, 10, 10, 20, 20, 30, 40)
    frequencyInSortedArray(arr)
}

fun frequencyInSortedArray(array: IntArray) {
    var freq = 1
    var i = 1
    while (i < array.size) {
        while (i < array.size && array[i] == array[i - 1]) {
            i++
            freq++
        }
        println("${array[i - 1]}:: $freq")
        i++
        freq = 1
    }

    if (array.size == 1 || array.last() != array[array.lastIndex - 1]){
        println("${array[i - 1]}:: $freq")
    }
}