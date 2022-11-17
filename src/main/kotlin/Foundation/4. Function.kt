fun main() {
    globalPrint()
    globalPrint2()

    println(sum1(1, 2))
    println(sum2(1, 2))
    println(sum3(1, 2))

    printWithPrefix("1")
    printWithPrefix("1", "Result: ")
}

//global function returning nothing
fun globalPrint(): Unit {
    println("Hello")
}

//Unit type dont have to be explicit
fun globalPrint2() {
    println("World")
}

//Returnint sth else
fun sum1(x: Int, y: Int): Int {
    return x + y
}

//ExpressionBody example
fun sum2(x: Int, y: Int): Int = x + y
fun sum3(x: Int, y: Int) = x + y

//Default parameter value
fun printWithPrefix(s: String, prefix: String = "pre: ") {
    println(prefix + s)
}