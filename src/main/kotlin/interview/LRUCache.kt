package interview

import java.util.*

class LRUCache(cacheSize: Int) {
    private val queue: Deque<Int> = LinkedList()
    private val CACHE_SIZE: Int

    init {
        CACHE_SIZE = cacheSize
    }

    fun refer(page: Int) {
        if (queue.contains(page)) {
            queue.remove(page)
            queue.addFirst(page)
        } else if (queue.size == CACHE_SIZE) {
            queue.removeLast()
            queue.addFirst(page)
        } else {
            queue.addFirst(page)
        }
        display()
    }

    private fun display() {
        println(queue)
    }
}

fun main() {
    val lruCache = LRUCache(3)
    lruCache.refer(3)
    lruCache.refer(4)
    lruCache.refer(1)
    lruCache.refer(4)
    lruCache.refer(2)
    lruCache.refer(1)
}