import kotlin.system.exitProcess

fun main() {

    val users = listOf<Account>(        //jest jakaś różnica pomiedzy tym sposobem deklaracji typu a wcześniejszym?
        Account("Damian", 1324),
        Account("Michał", 1337, 9972137.77),
        Account("Jan", 2580, 100000.00),
        Account("Przemek", 1111, 1234.00)
    )

    println("[Select user:]")

    for (i in 0 until users.size) {
        println("[${i+1}] ${users[i].name}")
    }

    print("User input: ")

    lateinit var selectedUser: Account

    val inputtedId = readln()

    when (inputtedId.toIntOrNull()) {
        null -> {
            println("Invalid input! Try again later.")
            exitProcess(0)
        }
        in 1..users.size -> selectedUser = users.get(inputtedId.toInt()-1)
        else -> {
            println("Value out of range! Try again later.")
            exitProcess(0)
        }
    }

    print("Enter your PIN: ")
    selectedUser.pinCheck(readln().toInt())

    selectedUser.hello()

    while (true) {
        selectedUser.showMenu()
        selectedUser.action(readln().toInt())
    }
}

class Account {
    constructor(n: String, p: Int, b: Double) {
        name = n
        pin = p
        balance = b
    }

    constructor(n: String, p: Int) {
        name = n
        pin = p
        balance = 0.0
    }

    val name: String
    val pin: Int
    var balance: Double

    fun String.withOneAtTheEnd(): String { //this is extension function
        return this+"1"
        //sample usage: "test".withOneAtTheEnd() --> effect "test1"
    }

    fun pinCheck(p: Int) {
        if (p == pin) {
            println("------------------------")
            println("Logged successfully!")
        } else {
            println("------------------------")
            println("Incorrect PIN! Try again later.")
            exitProcess(0)
        }
    }

    fun hello() {
        println("------------------------")
        println("Hello $name! What would you like to do? Choose from the menu below")
    }

    fun showMenu() {
        print(
            """
        ------------------------
        [1] Check the balance
        [2] Withdraw money
        [3] Deposit money
        [4] Exit
        User input: 
    """.trimIndent()
        )
    }

    fun action(decision: Int) {
        if (decision == 1) {
            println("------------------------")
            println("Total account balance: " + this.balance)
        } else if (decision == 2) {
            println("Under construction.")
            exitProcess(0)
        } else if (decision == 3) {
            println("Under construction.")
            exitProcess(0)
        } else if (decision == 4) {
            println("------------------------")
            println("Bye")
            exitProcess(0)
        } else {
            println("Incorrect input. Bye")
            exitProcess(0)
        }
    }
}