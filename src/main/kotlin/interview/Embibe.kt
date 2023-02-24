package interview

fun main() {
    val str = "Testt"
    reverseString(str)
    removeDup(str)
}

fun reverseString(str: String) {
    var revStr = ""
    for (i in str.lastIndex downTo 0) {
        revStr += str[i]
    }
    println(revStr)
}

fun removeDup(str: String) {
    val countOccurrence = mutableMapOf<String, Int>()
    for (i in str) {
        if (countOccurrence[i.lowercase()] == null) {
            countOccurrence[i.lowercase()] = 1
        } else {
            countOccurrence[i.lowercase()] = countOccurrence[i.lowercase()]?.plus(1) ?: 1
        }
    }

    var res = ""
    for ((key, value) in countOccurrence) {
        if (value == 1) {
            res += key
        }
    }

    println(res)
}