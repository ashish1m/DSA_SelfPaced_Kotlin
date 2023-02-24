package misc

interface Base {
    fun print()
}

class BaseImpl(private val num: Int) : Base {
    override fun print() {
        print(num)
    }
}

class BaseImpl2() : Base {
    override fun print() {
        print("ABC")
    }
}

class Derived(b: Base) : Base by b

fun main() {
    val b = BaseImpl2()
    Derived(b).print()
}