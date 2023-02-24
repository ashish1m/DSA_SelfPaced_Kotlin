package linked_list

data class Node<T>(var value: T, var next: Node<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }
}

class LinkedListImpl<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    private var size = 0

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun nodeAt(index: Int): Node<T>? {
        var currentNode = head
        var currentIndex = 0

        if (index >= size) {
            throw IndexOutOfBoundsException("Index out of range. The current size is $size")
        }
        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }

        return currentNode
    }

    fun push(value: T): LinkedListImpl<T> {
        head = Node(value = value, next = head)
        if (isEmpty()) {
            tail = head
        }
        size++
        return this
    }

    fun insertAfter(value: T, afterNode: Node<T>): Node<T> {
        if (tail == afterNode) {
            append(value)
            return tail!!
        }

        val newNode = Node(value = value, next = afterNode.next)
        afterNode.next = newNode

        return newNode
    }

    fun insertBefore(value: T, beforeNode: Node<T>): Node<T> {
        if (head == beforeNode) {
            return push(value).head!!
        }

        var currentNode = head
        while (currentNode?.next != beforeNode) {
            currentNode = currentNode?.next
        }

        val newNode = Node(value = value, next = beforeNode)
        currentNode.next = newNode

        return newNode
    }

    fun append(value: T) {
        if (isEmpty()) {
            push(value)
            return
        }
        tail?.next = Node(value)
        tail = tail?.next
        size++
    }

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty list"
        } else {
            head.toString()
        }
    }
}

fun main() {
    val list = LinkedListImpl<Int>()
    list.append(3)
    list.push(2)
    list.push(1)
    list.append(4)
    println(list)
    list.nodeAt(10)
}