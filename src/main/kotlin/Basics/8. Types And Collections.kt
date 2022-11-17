import java.lang.RuntimeException

fun main() {

    //Numeric
    // +, -, *, /, %
    val int1: Int = 2
    val int2 = 2
    val byte: Byte = 2
    val short: Short = 2
    val long1: Long = 2
    val long2 = 2L
    val intHex = 0x0F
    val intBinary = 0b1001
    val intUnderscore = 2_000_000

    val double1 = 5.5
    val float1 = 5.5f
    val double2 = 5.5e10

    //Boolean
    // &&, ||, !
    val b1 = true
    val b2 = false

    //String and Chars
    val char = 'a'
    val escapedChar = '\''

    val str = "Hello World!"
    for (s in str) {
        println(s)
    }
    val concatenation = "prefix " + str
    val interpolation1 = "prefix $str"
    val interpolation2 = "prefix ${SomeObj.value}"

    val rawString = """
        object SomeObj {
            const val value = "value"
        }
    """.trimIndent()

    //Other
    //like void
    val u: Unit

    //Unit is an object -> All functions have return type even if it does not return anything, useful in functional programming
    fun doNothing(): Unit {
        //do sth but no return
    }

    //Should throw exception or be infinite loop
    fun returnNothing(): Nothing {
        throw RuntimeException()
    }

    fun notImplemented(): Nothing = TODO("This feature is not yet implemented")

    //example:
    val someData: Int? = null
    //val dataOrNothing: Int = someData ?: error("No Data is an error")

    //Takes place of Object
    fun returnAny(i: Int): Any {
        if (i > 3) {
            return 5
        }
        return "a"
    }

    val any: Any = returnAny(2)
    println("any: $any")

    //Collections
    val list: List<String> = listOf("1", "2", "3", "1")
    val set: Set<String> = setOf("1", "2", "3", "1")
    val map: Map<String, String> = mapOf("1" to "a", "2" to "b", "1" to "c")

    val mutableList: MutableList<String> = mutableListOf("1")
    val mutableSet: MutableSet<String> = mutableSetOf("1")
    val mutableMap: MutableMap<String, String> = mutableMapOf("1" to "a")

    //collection operations example
    list.map { it.toInt() }
        .filter { it > 1 }
        .flatMap { listOf(it, it * it) }
        .drop(1)
        .take(5)
        .distinct()
        .associate { it.toString() to it * it }
        .forEach {
            println(it)
        }

    val listInt = listOf(1, 2, 3, 1)

    println("all " + listInt.all { it > 1 })
    println("any " + listInt.any { it > 1 })
    println("none " + listInt.none { it > 1 })

    println("find " + listInt.find { it > 1 })
    println("firstOrNull " + listInt.firstOrNull() { it > 1 })
    println("count " + listInt.count { it > 1 })
    println("groupBy " + listInt.groupBy { it })
    println("partition " + listInt.partition { it > 1 })

    //talk about stream api

}

object SomeObj {
    const val value = "value"
}

