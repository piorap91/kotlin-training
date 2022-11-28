import kotlin.system.measureTimeMillis

fun main() {
    val myService = MyService(
        repository = MySuperRepositoryDelegate(MyRepository())
    )
    myService.doSth(MyDomainId("1")).run {
        println("concatenation ${concatenate()}")
        if (this is MySuperDomain) {
            printSth()
        }
    }

}

//constructor is internal - not allowed to be instantiated outside of module
internal class MyService internal constructor(
    private val repository: Repository
) {
    fun doSth(id: MyDomainId) =
        repository.findById(id)
}

//interface
interface Repository {
    fun save(domain: MyDomain)
    fun findById(id: MyDomainId): MyDomain
}

//non-final classes are open
open class MyRepository : Repository {
    override fun save(domain: MyDomain) {
    }

    override fun findById(id: MyDomainId) =
        MySuperDomain(id, "fromDb")

}


//delegation with by
class MySuperRepositoryDelegate(private val repo: Repository) : Repository by repo {
    override fun findById(id: MyDomainId): MyDomain {
        println("Delegated")
        return repo.findById(id)
    }
}

//Is not type of repository, doest not have method save - delegate above allows to override some of the methods
class MySuperRepository(private val repo: Repository) {
    fun findById(id: MyDomainId) {
        println(measureTimeMillis {
            repo.findById(id)
        })
    }
}

//class that we inherit from
//can't be data class - you cannot inherit from data class
//doesn't have to be open - its abstract
abstract class MyDomain(
    //is used in childs
    protected open val id: MyDomainId,
    private val value: String,
) {
    open fun concatenate() = id.value + value
}

class MySuperDomain(
    //used in parent and in this class, is protected from parent
    override val id: MyDomainId,
    //used only in parent constructor
    value: String,
    private val superValue: String = "2",
) : MyDomain(id, value) {

    override fun concatenate(): String {
        return super.concatenate() + superValue
    }

    fun printSth() {
        println("id is $id")
    }
}

@JvmInline
value class MyDomainId(val value: String)