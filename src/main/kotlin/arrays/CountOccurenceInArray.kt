package arrays

fun main() {
    val array = intArrayOf(1, 2, 3, 1, 4, 5, 3, 4, 1)

    printFrequency(array, 2)
}

fun printFrequency(array: IntArray, kOcc: Int) {
    val countMap = mutableMapOf<Int, Int>()
    for (i in array) {
        if (countMap[i] == null) {
            countMap[i] = 1
        } else {
            countMap[i] = countMap[i]?.plus(1) ?: 1
        }
    }
    val filteredMap = countMap.filter { it.value == 1 }.map { it.key }

    println(filteredMap)
}