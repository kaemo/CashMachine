import kotlin.system.exitProcess

fun main() {

    val users = listOf<Account>(
        Account("Adrian", "Paweł", "Wielki" , 1234),
        Account("Michał", null, "Kowalski", 1337, 9972137.77),
        Account("Jan", null, "Testowy", 2580, 100000.00)
    )

    println("[Select user:]")

    for (i in 0 until users.size) {
        println("[${i+1}] ${users[i].cFirstName}")
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

    constructor(firstName: String, secondName: String?, lastName: String, pin: Int, balance: Double) {
        cFirstName = firstName
        cSecondName = secondName
        cLastName = lastName
        cPin = pin
        cBalance = balance
    }

    constructor(firstName: String, secondName: String?, lastName: String, pin: Int) {
        cFirstName = firstName
        cSecondName = secondName
        cLastName = lastName
        cPin = pin
        cBalance = 0.0
    }

    val cFirstName: String
    val cSecondName: String?
    val cLastName: String
    val cPin: Int
    var cBalance: Double

    fun Int.checkStrength(): String {
        return when (this) {
            1111, 2222, 3333, 4444, 5555, 6666, 7777, 8888, 9999 -> "low"
            1234, 2345, 3456, 4567, 5678, 6789, 7890 -> "low"
            else -> "OK"
        }
    }

    fun pinCheck(pin: Int) {
        if (pin == cPin) {
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
        println("Hello $cFirstName! What would you like to do? Choose from the menu below")
    }

    fun showMenu() {
        print(
            """
        ------------------------
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
        if (decision == 1) {
            println("------------------------")
            println("Total account balance: " + cBalance)
        } else if (decision == 2) {
            println("Under construction.")
            exitProcess(0)
        } else if (decision == 3) {
            println("Under construction.")
            exitProcess(0)
        } else if (decision == 4) {
            println("------------------------")

            println("First name: " + cFirstName)

            cSecondName?.let {
                println("Second name: " + cSecondName)
            } ?: println("Second name: -")

            println("Last name: " + cLastName)

            println("PIN strength: " + cPin.checkStrength())

        } else if (decision == 5) {
            println("------------------------")
            println("Bye")
            exitProcess(0)
        } else {
            println("Incorrect input. Bye")
            exitProcess(0)
        }
    }
}