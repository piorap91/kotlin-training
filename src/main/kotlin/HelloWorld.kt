fun main() {
    println("Hello")
    HelloWorld().run()
}

class HelloWorld {
    fun run() {
        logger().info("World")
    }
}