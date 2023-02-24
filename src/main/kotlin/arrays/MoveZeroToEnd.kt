package arrays

fun main() {
    val inp = intArrayOf(2, 0, 4, 0, 1, 3, 4, 5, 7)
//    arrays.naiveMoveZeroToEnd(inp)
    effMoveZeroToEnd(inp)
}

fun naiveMoveZeroToEnd(array: IntArray) {
    for (i in array.indices) {
        if (array[i] == 0) {
            for (j in i until array.size) {
                if (array[j] != 0){
                    array[i] = array[j]
                    array[j] = 0
                    break
                }
            }
        }
    }

    println(array.contentToString())
}

fun effMoveZeroToEnd(array: IntArray) {
    var count = 0
    for (i in array.indices){
        if (array[i] != 0) {
            //swap
            val temp = array[i]
            array[i] = array[count]
            array[count] = temp
            count++
        }
    }

    println(array.contentToString())
}
