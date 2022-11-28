fun main() {

    //Instantiate class without new
    Foo(5, 2)
    FooWithMethod().printSth()
    FooWithPrimaryConstructor(5, 2)
    FooWithSecondaryConstructor(5, 2)

    //Not Allowed
    //Foo()
    //FooWithPrimaryConstructor()
    //FooWithSecondaryConstructor()

    //equals
    println(Foo(1, 2) == Foo(1, 2))

    //references comparison
    println(Foo(1, 2) === Foo(1, 2))

}


class Foo(
    val x: Int,
    var y: Int?
)

class FooWithMethod {
    fun printSth() {
        print("STH")
    }
}

class FooWithPrimaryConstructor constructor(
    val x: Int,
    var y: Int?
)

class FooWithSecondaryConstructor {
    val x: Int
    var y: Int?

    constructor(x: Int, y: Int?) {
        this.x = x
        this.y = y
    }
}

//setter getter example
class FooWithSetterGetter {
    var y: Int = 0
        get() = field + 1
        set(value) { field = value - 1}
}