import kotlin.system.exitProcess

fun main() {

    val users = listOf<Account>(
        Account("Adrian", "Paweł", "Wielki" , 1234),
        Account("Michał", null, "Kowalski", 1337, 9972137.77),
        Account("Jan", null, "Testowy", 2580, 100000.00)
    )

    println("[Select user:]")

    for (i in 0 until users.size) {
        println("[${i+1}] ${users[i].firstName}")
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
    selectedUser.printSeparator()
    println(selectedUser.hello())

    while (true) {
        selectedUser.printSeparator()
        selectedUser.showMenu()
        selectedUser.action(readln().toInt())
    }
}

class Account (
    val firstName: String,
    val secondName: String?,
    val lastName: String,
    val pin: Int,
    var balance: Double = 0.0
) {

    fun Int.checkStrength(): String {
        return when (this) {
            1111, 2222, 3333, 4444, 5555, 6666, 7777, 8888, 9999 -> "low"
            1234, 2345, 3456, 4567, 5678, 6789, 7890 -> "low"
            else -> "OK"
        }
    }

    fun pinCheck(pin: Int) {
        if (pin == this.pin) {
            println("Logged successfully!")
        } else {
            println("Incorrect PIN! Try again later.")
            exitProcess(0)
        }
    }

    fun hello(): String {
        return "Hello $firstName! What would you like to do? Choose from the menu below"
    }

    fun printSeparator() {
        println("------------------------")
    }

    fun showMenu() {
        print(
            """
        [1] Check the balance
        [2] Withdraw money
        [3] Deposit money
        [4] User data
        [5] Exit
        User input: 
    """.trimIndent()
        )
    }

    fun action(decision: Int) {
        printSeparator()
        if (decision == 1) {
            println("Total account balance: " + balance)
        } else if (decision == 2) {
            println("Under construction.")
            exitProcess(0)
        } else if (decision == 3) {
            println("Under construction.")
            exitProcess(0)
        } else if (decision == 4) {
            println("First name: " + firstName)
            println("Second name: " + (secondName?.let {it} ?: "-"))
            println("Last name: " + lastName)
            println("PIN strength: " + pin.checkStrength())
        } else if (decision == 5) {
            println("Bye")
            exitProcess(0)
        } else {
            println("Incorrect input. Bye")
            exitProcess(0)
        }
    }
}