package Classes

object createUser { // Obiekt odpowiedzialny za tworzenie nowych użytkowników (kupujących i sprzedających)
    private var userIdCounter = 0 // Licznik ID użytkowników — inkrementuje się przy każdym nowym użytkowniku

    fun createBuyer(username: String, email: String, date : String): Buyer {
        val id = userIdCounter++ // Nadaje nowy unikalny ID i zwiększa licznik
        val newBuyer = Buyer(id, username, email, date, 0.0) // Tworzy nowy obiekt Buyer z pustym portfelem
        Users.users.add(id,newBuyer) // Dodaje użytkownika do globalnej listy użytkowników
        return newBuyer // Zwraca obiekt klasy Buyer

    }

    fun createSeller(username: String, email: String, date : String): Seller {
        val id = userIdCounter++ // Nadaje nowy unikalny ID i zwiększa licznik
        val newSeller = Seller(id, username, email, date, 0.0) // Tworzy nowy obiekt Seller z pustym portfelem
        Users.users.add(id,newSeller) // Dodaje użytkownika do globalnej listy użytkowników
        return newSeller // Zwraca obiekt klasy Seller
    }
    }

