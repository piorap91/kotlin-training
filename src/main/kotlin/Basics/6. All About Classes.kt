import Error.ServerError
import Error.UserError
import NotificationType.*

fun main() {

    //New Empty Instance
    Empty()

    //Shows Bar object reference
    println(Bar(1,2))

    //Use of companion object
    println(Bar.NAME)

    //Use of Object
    println(BarObject.x)

    //Preety print of data class
    val barData = BarButData(1,2)
    println(barData)
    //equals - the same values
    println(barData == BarButData(1,2))
    //not equals - different references
    println(barData === BarButData(1,2))

    //copies object and change non mutable data
    println(barData.copy(x = 5))
    //does not change original
    println(barData)

    //Normal Enum
    println(EMAIL)
    //Enum with values
    println(IntConstants.ONE.i)


    //When with Email
    val notificationType = SMS
    when(notificationType){
        SMS -> "asd"
        EMAIL -> "asd"
    }

    val error: Error = UserError("Result")
    //I dont know why intelij shows that as error, but it's not
    when(error){
        is UserError -> println("user")
        is ServerError -> println("server")
    }

    //value class
    val person = Person(PersonId("123"), "Ann")
    //comparison not allowed
    //person.personId == person.name

    //talk about encapsulation


}

class Empty

class Bar(
    val x: Int,
    var y: Int?,
) {
    //like static
    companion object {
        const val NAME = "Harold"
    }
}

//Singleton
object BarObject{
    const val x = 5;
}

//overrides Hash and Equals, toString, componentN, copy
data class BarButData(
    val x: Int,
    var y: Int?
)

//maybe since kotlin 1.9
//data object BarObjectButData()

enum class NotificationType {
    EMAIL,
    SMS
}

//Enum with some value
enum class IntConstants(val i: Int) {
    ONE(1),
    TWO(2)
}

//Knows all implementations
sealed class Error {
    data class UserError(val validationResult: String) : Error()
    class ServerError(errorCode: Int) : Error()
}

//Object while coding, String after compilation
//Only one field
@JvmInline
value class PersonId(val id: String)

data class Person(
    val personId: PersonId,
    val name: String,
)