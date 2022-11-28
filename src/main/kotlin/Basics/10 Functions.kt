import java.util.*
import kotlin.system.measureTimeMillis

fun main() {

    //optional to nullable extended function
    val opt = find().toNullable()
    //talk about visibility
    //talk about usability

    //infix example
    val oldData = Data()
    val newData = Data()
    val diffLog = DiffLog()
    diffLog.insert(oldData diffWith newData)
    diffLog.insert(oldData.diffWith(newData))

    //inline example
    println("time: " + measureTimeMillis {
        someLongFunction()
    })

    //higher order functions
    logResult {
        find().toNullable()
    }

    val noDifference = noDifference(oldData, newData) {
        "No Diff For: $it"
    }

    val noDifferenceWithReceiver = noDifferenceWithReceiver(oldData, newData) {
        "No Diff for $this"
    }

    //@ example
    measureTimeMillis {
        noDifference(oldData, newData) {
            return@noDifference "noDifference"
        }
    }

    //reference vs lambda
    listOf("1", "2", "3").map { it.toInt() }.forEach { println(it) }
    listOf("1", "2", "3").map(String::toInt).forEach(::println)

    //talk about Java Functional Interface
}


class Data {
    infix fun diffWith(data: Data) = DataDifference()
}

class DiffLog {
    private val history: MutableList<DataDifference> = mutableListOf()

    fun insert(dataDifference: DataDifference) {
        history.add(dataDifference)
    }
}

class DataDifference {
    fun hasChanges() = false
}

fun find(): Optional<String> {
    return Optional.of("1")
}

fun <T> Optional<T>.toNullable(): T? = this.orElse(null)

fun someLongFunction() {
    var x = 0
    for (i in 1..100_000_000) {
        x += i
    }
    println("sum: $x")
}

fun <T> logResult(function: () -> T) =
    function.invoke().also { println("log: $it") }

fun <T> noDifference(data1: Data, data2: Data, function: (DataDifference) -> T) {
    val dataDifference = data1 diffWith data2
    if (!dataDifference.hasChanges()) {
        logResult { function.invoke(dataDifference) }
    }
}

fun <T> noDifferenceWithReceiver(data1: Data, data2: Data, function: DataDifference.() -> T) {
    val dataDifference = data1 diffWith data2
    if (!dataDifference.hasChanges()) {
        logResult { function.invoke(dataDifference) }
    }
}

