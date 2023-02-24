package arrays

fun main() {
    val inp = mutableListOf(2, 3, 4, 9, 1, 3, 4, 5, 7, 6)
    reverseArray(inp)
    println(inp.size)
}

fun reverseArray(arr: MutableList<Int>) {
    val itr = if (arr.size % 2 == 0) (arr.size - 1) / 2 else arr.size / 2
    for (i in 0..itr) {
        arr[i] = arr[i] + arr[arr.lastIndex - i]
        arr[arr.lastIndex - i] = arr[i] - arr[arr.lastIndex - i]
        arr[i] = arr[i] - arr[arr.lastIndex - i]
    }

    println(arr)
}