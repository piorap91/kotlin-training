package Basics

import Foo as FoundationFoo

fun main() {
    //typealias
    val foo = Foo.createFrom(FoundationFoo(1, 2))

    //destructuring declarations
    val (x, y) = foo
    println("x: $x, y:$y")

    val (_, y2) = foo
    println("y:$y2")

    val myMap = mapOf(1 to "a", 2 to "b")
    for ((key, value) in myMap) {
        println("key: $key, value: $value")
    }

    myMap.map { (_, value) -> value }.forEach { println(it) }


    //generics
    //List<out T> in Kotlin is List<? extends T> in Java
    //List<in T> in Kotlin is List<? super T> in Java

    class StackOut<out T>
    //Stack of Number allows subtypes of Number
    val stackOut1: StackOut<Number> = StackOut<Int>()
    val stackOut2: StackOut<Number> = StackOut<Double>()
    //val stackOut3: StackOut<Number> = StackOut<Any>() // must be at least a Number

    class StackIn<in T>
    val stackIn1: StackIn<Int> = StackIn<Number>()
    val stackIn2: StackIn<Double> = StackIn<Number>()
    //val stackIn3: StackIn<Number> = StackIn<Double>() // must be at most a Number

    class Stack<T>
    val stack1: Stack<out Number> = Stack<Int>()
    val stack2: Stack<in Double> = Stack<Number>()

    //limiting generics
    listOf(1, 2, 3).sorted()
    class StackLimited<T: Comparable<T>>

    //example of where
    class StackWhere<T> where
        T: Comparable<T>,
        T: Number

}


//talk about typeAlias
data class Foo(
    val x: Int,
    val y: Int
) {
    companion object {
        fun createFrom(existingFoo: FoundationFoo) =
            Foo(existingFoo.x, existingFoo.y ?: throw RuntimeException("No `y` value"))
    }
}