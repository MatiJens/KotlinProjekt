package Classes

class Buyer (
    id : Int,
    login : String,
    email : String,
    date : String
) : User(id,login,email,date),paymentMethods {

    fun showOffers() {
        if(Offers.offers.isEmpty()) { // sprawdza czy lista nie jest pusta
            println("Nie ma żadnych ofert")
        }
        else {
            println("Oferty na rynku:")
                    Offers.offers.forEachIndexed { index, product -> // dla kazdego elementu w liscie printuj index i kazde pole klasy produkt
                        print("${index+1} |")
                        print("nazwa: ${product.name} |")
                        print("cena: ${product.price} |")
                        print("ilosc: ${product.quantity} |")
                        print("opis: ${product.description} |")
                        print("sprzedawca: ${product.seller} |")
                    }
        }
    }
    override fun payBlik(amount: Double, blikCode: Int): Result<String> {
        return when {
            blikCode != blikCode -> Result.failure(Exception("Błędny Blik!"))
            amount <= 0 -> Result.failure(Exception("Kwota musi być większa od 0!"))
            else -> Result.success("Płatność $amount zł zakończona sukcesem!")
        }
    }

    override fun payCard(amount: Double, cardNumber: Int, CVV: Int): Result<String> {
        return when {
            CVV != CVV -> Result.failure(Exception("Bład!"))
            cardNumber != cardNumber -> Result.failure(Exception("Zły numer karty"))
            amount <= 0 -> Result.failure(Exception("Kwota musi być większa od 0!"))
            else -> Result.success("Płatność $amount zł zakończona sukcesem!")
        }
    }

    override fun payCash(amount: Double): Result<String> {
        return when {
            amount <= 0 -> Result.failure(Exception("Kwota musi być większa od 0!"))
            else -> Result.success("Zapłaciłeś $amount zł.")
        }
    }





}