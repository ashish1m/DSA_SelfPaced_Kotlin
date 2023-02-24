import kotlin.time.measureTime

fun main(args: Array<String>) {
    val string = "occurences"
    println(countOccurence(string))
}

fun countOccurence(s: String): String {
    var result = ""
    for (i in s) {
        if (!result.contains(i)) {
            val count = s.count { it == i }
            result = result.plus(i).plus(count)
        }
    }

    return result
}