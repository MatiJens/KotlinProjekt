package Classes

class Buyer (
    id : Int,
    login : String,
    email : String,
    date : String
) : User(id,login,email,date) {

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

    override fun giveOpinion(review: String, rating: opinions) {
        super.giveOpinion(review, rating)
    }
}