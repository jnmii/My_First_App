package com.example.myfirstapp

fun main() {
    println("Enter card information")
    val cardNumber = readLine().toString()

    val list = listOf("1121-0000-0000-0312", "1111-0000-0000-0312", "3796-0000-0000-0312")

    val cardCompany = when (cardNumber){
        "1121-0000-0000-0312" -> "ACME"
        "1111-0000-0000-0312" -> "ALFA"
        "3796-0000-0000-0312" -> "AMEX"
        else -> "Enter valid number"
    }
   println("$cardCompany is welcomed please continue")
    if (cardNumber in list) {

        var expirationDate: String?
        do {
            println("Enter expiration date in format MMYY")
            expirationDate = readLine().toString()
        } while (expirationDate != "0312")

        println("Expiration date accepted.")
        // Continue with further processing if needed
    } else {
        println("Invalid card number. Aborting transaction.")
    }
}
