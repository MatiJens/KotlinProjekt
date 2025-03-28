package Classes

object createUser {
    private var userIdCounter = 1 //

    fun createUser(type: String, username: String, email: String, date : String): User? {
        val id = userIdCounter++
        return when (type.lowercase()) {
            "buyer" -> Buyer(id, username, email, date)
            "seller" -> Seller(id, username, email, date)
            else -> {
                println("Nieznany typ użytkownika: $type")
                null
            }
        }
    }
}
