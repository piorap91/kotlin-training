fun main() {
    //declaring variable
    var x: Int = 0;
    x++;

    //declaring value with type inferring
    val y: Int = 1

    //y is final
    //y++

    println(x + y + z)

    //declaring val but no initialization
    val t: Int

    //t not initialized
    //println(x + y + z + t)
}

//constant - non-local variable - gets inlined
const val z: Int = 2