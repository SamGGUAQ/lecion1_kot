package edu.example.lib
class CashRegister(cashIn: Int = 500) {
    var cashOnHand = if (cashIn >= 0) cashIn else 500 // ddefault o no negativos?

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
    var numberOfItems: Int = if (setNoOfItems >= 0) setNoOfItems else 50
    var cost: Int = if (setCost >= 0) setCost else 50

    fun getCount(): Int = numberOfItems
    fun getProductCost(): Int = cost
    fun makeSale() {
            numberOfItems--
    }
}
fun showSelection() {
    println("\nwelcome to shelly´s candy bar")
    println("to select an item enter")
    println("1 for candy")
    println("2 for chips")
    println("3 for gum")
    println("4 for cookies")
    println("9 to exit")
    print("select: ")
}
fun sellProduct(product: Dispenser, cRegister: CashRegister) {
    if (product.getCount() > 0) {
        val price = product.getProductCost()
        var coinsInserted = 0

        while (coinsInserted < price) {
            val mising = price - coinsInserted
            print("Please deposit  $mising cents ")

            val deposit = readln().toIntOrNull() ?: 0
            coinsInserted += deposit
        }
        cRegister.acceptAmount(coinsInserted)
        product.makeSale()
        println("collect your item at the bottom and enjoy")
    } else {
        println("sorry this item is sold out")
    }
}

fun main() {
    val cashRegister = CashRegister()
    val candy = Dispenser(100, 50)
    val chips = Dispenser(100, 65)
    val gum = Dispenser(75, 45)
    val cookies = Dispenser(100, 85)
    var choice = 0
    while (choice != 9) {
        showSelection()

        val input = readln()
        choice = input.toIntOrNull() ?: 0

        when (choice) {
            1 -> sellProduct(candy, cashRegister)
            2 -> sellProduct(chips, cashRegister)
            3 -> sellProduct(gum, cashRegister)
            4 -> sellProduct(cookies, cashRegister)
            9 -> println("BYE")
            else -> println("invalid selection")
        }
    }
}