package Classes

interface paymentMethods {
    fun payBlik(amount : Double, blikCode : Int)
    fun payCard(amount : Double, cardNumber : Int, CVV : Int)
    fun payCash(amount : Double)
}