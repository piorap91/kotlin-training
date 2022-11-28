fun main() {
    //Cannot be null
    //var x: Int = null;
    //val y: Int = null;

    //Can be null
    var x: Int? = null
    val y: Int? = null

    //Inferred null
    var z = null
    val t = null

    println(x)
    println(y)
    println(z)
    println(t)

    // elvis operator
    var c = 5
    var result = x ?: c
    println(result)

    //do if not null
    val x1 = x?.inc()
    println(x1)
}
