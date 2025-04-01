package Classes

object createUser {
    private var userIdCounter = 0 //

    fun createBuyer(username: String, email: String, date : String): Buyer {
        val id = userIdCounter++
        val newBuyer = Buyer(id, username, email, date, 0.0)
        Users.users.add(id,newBuyer)
        return newBuyer
    }

    fun createSeller(username: String, email: String, date : String): Seller {
        val id = userIdCounter++
        val newSeller = Seller(id, username, email, date, 0.0)
        Users.users.add(id,newSeller)
        return newSeller
    }
    }

