package edu.example.lib
class CashRegister(cashIn: Int = 500) {
    var cashOnHand = if (cashIn >= 0) cashIn else 500 // para defaul? o no se puede tener numeros negativos?

    fun getBalance(): Int {
        return cashOnHand
    }
    fun currentBalance(): Int {
        return cashOnHand
    }
    fun acceptAmount(amountIn: Int) {
        cashOnHand += amountIn
    }
}
class Dispenser(setNoOfItems: Int = 50, setCost: Int = 50) {
    var numberOfItems: Int = if (setNoOfItems >= 0) setNoOfItems else 50 // supongo que no negativos igual
    var cost: Int = if (setCost >= 0) setCost else 50

    fun getCount(): Int = numberOfItems
    fun getProductCost(): Int = cost
    fun makeSale() {
            numberOfItems-- // [cite: 192]
    }
}

fun main() {
    val cashRegister = CashRegister()
    val candy = Dispenser(100, 50)
    val chips = Dispenser(100, 65)
    val gum = Dispenser(75, 45)
    val cookies = Dispenser(100, 85)
    var choice: Int = 0
    while (choice != 9) {
        showSelection()

        // Leemos la entrada del usuario dentro del bucle
        val input = readln()
        choice = input.toIntOrNull() ?: 0 // Si no es un número, ponemos 0

        when (choice) {
            1 -> sellProduct(candy, cashRegister)
            2 -> sellProduct(chips, cashRegister)
            3 -> sellProduct(gum, cashRegister)
            4 -> sellProduct(cookies, cashRegister)
            9 -> println("------------------")
            else -> println("Invalid selection")
        }
    }
}
fun showSelection() {
    println("\n*** Welcome to Shelly´s Candy Bar ***")
    println("to select an item, enter")
    println("1 for Candy")
    println("2 for Chips")
    println("3 for Gum")
    println("4 for Cookies")
    println("9 to exit")
    print("select: ")
}
fun sellProduct(product: Dispenser, cRegister: CashRegister) {
    if (product.getCount() > 0) {
        val price = product.getProductCost()
        var coinsInserted = 0

        while (coinsInserted < price) {
            val missing = price - coinsInserted
            print("Please deposit  $missing cents ")

            val deposit = readln().toIntOrNull() ?: 0
            coinsInserted += deposit
        }
        cRegister.acceptAmount(coinsInserted)
        product.makeSale()
        println("Collect your item at the bottom and enjoy")
    } else {
        println("Sorry this item is sold out")
    }
}