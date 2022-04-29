fun main() {

    val users: List<Account> = listOf(
        Account("Damian", 1324),
        Account("Pawel", 1337, 9972137.77),
        Account("Jan", 2580, 100000.00)
    )

    print(
        """
        [Select user:]
        [1] Damian
        [2] Pawel
        [3] Jan
        User input: 
    """.trimIndent()
    )

    lateinit var selectedUser: Account

    val inputtedId = readln()

    if (inputtedId.toIntOrNull() == null) {
        // wrong input, show message
    } else {
        // try with id = 4
        selectedUser = users.get(inputtedId.toInt()+1)
    }

    print("Enter your PIN: ")
    selectedUser.pinCheck(readln().toShort())

    selectedUser.hello()

    while (true) {
        selectedUser.showMenu()
        selectedUser.action(readln().toInt())
    }
}

class Account {
    constructor(n: String, p: Short, b: Double) {
        name = n
        pin = p
        balance = b
    }

    constructor(n: String, p: Short) {
        name = n
        pin = p
        balance = 0.0
    }

    val name: String
    val pin: Short
    var balance: Double

    fun printWhole() {
        println("Name: $name, PIN: $pin, Balance: $balance")
    }

    fun printName() {
        println(name)
    }

    fun getGreetingForName(name: String): String {
        return "Hello $name!"
    }

    fun String.withOneAtTheEnd(): String { //this is extension function
        return this+"1"
        //sample usage: "test".withOneAtTheEnd() --> effect "test1"
    }

    fun pinCheck(p: Short) {
        val checkPin = p
        if (checkPin == pin) {
            println("------------------------")
            println("Logged successfully!")
        } else {
            println("------------------------")
            println("Incorrect PIN! Try again later.")
            System.exit(0)
        }
    }

    fun hello() {
        println("------------------------")
        println("Hello $name! What would you like to do? Choose from the menu below")
    }

    fun showMenu() {
        println(
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
            System.exit(0)
        } else if (decision == 3) {
            println("Under construction.")
            System.exit(0)
        } else if (decision == 4) {
            println("------------------------")
            println("Bye")
            System.exit(0)
        } else {
            println("Incorrect input. Bye")
            System.exit(0)
        }
    }
}