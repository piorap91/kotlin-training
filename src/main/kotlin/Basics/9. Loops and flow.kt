package Basics

import java.lang.RuntimeException

fun main() {

    //run example
    Service().run {
        //also example
        val data = getData(2).also { println("getData(2): $it") }
        val nullData = getData(-2).also { println("getData(2): $it") }

        //elvis example
        val default = (nullData ?: Data("default")).also { println("?: $it") }

        //smartcast non null - example
        //println(nullData.value) //compile error
        if (nullData != null) {
            println(nullData.value)
        }

        //non null assertion
        println("asserted:" + data!!.value)
        //smartcast of above assertion
        println("smartcasted:" + data.value)

        //let example
        nullData?.let {
            //nullData.value //compile error
            println(it)
        }

        //apply example
        val vector = MutableVector().apply {
            x = 1
            y = 2
        }

        val mutableMap = mutableSetOf<String>().apply {
            add("1")
            add("2")
            if (vector.x > 1) {
                add("3")
            }
        }

        //smartcast with if & when
        val result: Result = saveData(data)
        if (result is Success) {
            Success.printSuccess()
        }
        when (result) {
            is Success -> Success.printSuccess()
            is Error -> Error.printError()
            else -> println("Other Type")

        }
    }


    //casting
    val x: Int? = 10
    //val y1 : String = x as String //throws error
    val y2: String? = x as? String


    //loops
    val list = listOf(1, 2, 3)
    for (i in list) {
        //do sth
    }
    val iterator1 = list.iterator()
    while (iterator1.hasNext()) {
        println("while: ${iterator1.next()}")
    }

    var s = ""
    do {
        s += "a"
    } while (s.length < 3)
    println("do: $s")

    //ranges
    for (i in 1..3) {
        println("range: $i")
    }
    for (i in 1 until 3) {
        println("until: $i")
    }

    for (i in 1..7 step 2) {      // 3
        println("step: $i")
    }

    for (i in 3 downTo 0) {      // 4
        println("downTo: $i")
    }

    //Errors
    try {
        throw RuntimeException()
    } catch (e: RuntimeException) {
        println("catch")
    } finally {
        println("finally")
    }

    //try with resources
    Resource().use {
        println("using")
    }

    //Result Class
    runCatching {
        throw RuntimeException()
    }.recoverCatching {
        "1"
    }.mapCatching {
        it + "2"
    }.getOrNull().run {
        println("runCatching: $this")
    }

    //talk about optional

}

class Service {
    fun getData(id: Int): Data? =
        id.takeIf { id > 0 }?.let {
            Data(id.toString())
        }

    fun saveData(data: Data): Result =
        if (data.value.length == 1) {
            Success
        } else {
            Error
        }
}

data class Data(
    val value: String
)

interface Result
object Success : Result {
    fun printSuccess() {
        println("SUCCESS")
    }
}

object Error : Result {
    fun printError() {
        println("ERROR")
    }
}

class MutableVector {
    var x: Int = 0
    var y: Int = 0
}

class Resource : AutoCloseable {
    override fun close() {
        println("close")
    }

}