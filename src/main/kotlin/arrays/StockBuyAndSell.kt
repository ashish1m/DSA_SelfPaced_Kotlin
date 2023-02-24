package arrays

import kotlin.math.max

fun main() {
    val inp = intArrayOf(1, 5, 3, 8, 12)
    println("Max profit: ${maxProfit1(inp, 0, inp.lastIndex)}")
    println("Max profit: ${maxProfit2(inp)}")
}

fun maxProfit1(price: IntArray, start: Int, end: Int): Int {
    if (end <= start) {
        return 0
    }
    var profit = 0

    for (i in start until end) {
        for (j in i + 1..end) {
            if (price[j] > price[i]) {
                val curr_profit = price[j] - price[i] + maxProfit1(price, start, i - 1) + maxProfit1(price, j + 1, end)
                profit = max(profit, curr_profit)
            }
        }
    }

    return profit
}

fun maxProfit2(price: IntArray): Int {
    var profit = 0
    for (i in 1..price.lastIndex) {
        if (price[i] > price[i - 1]) {
            profit += price[i] - price[i - 1]
        }
    }

    return profit
}