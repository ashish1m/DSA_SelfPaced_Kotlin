package interview

fun isPalindrome(word: String): Boolean {
    val len = word.length
    for (i in 0 until len / 2) {
        if (word[i] != word[len - i - 1]) {
            return false
        }
    }
    return true
}

fun main() {
    val str = "malayalam"
    println(isPalindrome(str))
}