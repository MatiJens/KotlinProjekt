package Classes

interface paymentMethods {
    fun payBlik(amount : Double, blikCode : Int) : Result<String>
    fun payCard(amount : Double, cardNumber : Int, CVV : Int) : Result<String>
    fun payCash(amount : Double) : Result<String>
}