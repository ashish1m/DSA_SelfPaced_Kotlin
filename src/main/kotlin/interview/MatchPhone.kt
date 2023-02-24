package interview

fun main() {
    val name = arrayOf("Ashish", "Mathur", "Shana", "Sanpreet")
    val phone = arrayOf("121223343", "34546323", "3464756746", "64743255")
    println(solution(name, phone, "4546"))
}

fun solution(A: Array<String>, B: Array<String>, P: String): String {
    // Implement your interview.solution here
    val sortedSet = sortedSetOf<String>()

    for (i in B.indices) {
        if (B[i].contains(P)) {
            sortedSet.add(A[i])
        }
    }

    return if (sortedSet.isEmpty()) {
        "NO CONTACT"
    } else {
        sortedSet.first()
    }
}