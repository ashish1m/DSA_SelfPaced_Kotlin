package interview

val listOFProducts = arrayListOf("Apple", "Orange", "Banana", "Guava", "Watermelon").toList()

fun acronym(list: List<String>) {
    val listT = list.map { item ->
        if (item.length < 3) {
            item.uppercase()
        } else {
            val mid = if (item.length % 2 == 0) {
                (item.length - 1) / 2
            } else {
                item.length / 2
            }
            item[0].plus(item[mid].toString()).plus(item[item.length - 2]).uppercase()
        }
    }.sorted()

    println(listT)
}

fun main() {
    acronym(listOFProducts)
}