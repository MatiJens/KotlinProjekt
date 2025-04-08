package Classes

class Buyer ( // Klasa reprezentująca kupującego, dziedziczy po klasie User i implementuje metody z interfejsu paymentMethods
    id : Int,
    login : String,
    email : String,
    date : String,
    wallet : Double
) : User(id,login,email,date,wallet),paymentMethods {

    override fun showAccount() { // Nadpisana metoda pokazująca informacje o koncie kupującego
        println("konto kupujacego")
        println("nr uzytkownika: $id | login: $login | email: $email | data zalozenia konta: $date | stan konta: $wallet")
    }

    fun showOffers() { // Metoda wyświetlająca wszystkie dostępne oferty z rynku
        if(Offers.offers.isEmpty()) { // Sprawdza czy lista nie jest pusta
            println("Nie ma żadnych ofert")
        }
        else {
            println("Oferty na rynku:")
                    Offers.offers.forEachIndexed { index, product -> // Dla każdego elementu w liscie wypisuje index i każde pole klasy produkt
                        print("${index} | ")
                        print("nazwa: ${product.name} | ")
                        print("cena: ${product.price} | ")
                        print("ilosc: ${product.quantity} | ")
                        print("opis: ${product.description} | ")
                        println("sprzedawca: ${product.idSeller} | ")
                    }
        }
    }
    override fun payBlik(amount: Double, blikCode: Int) { // W prawdziwej aplikacji można dodać sprawdzanie poprawności płatności
        this.wallet = this.wallet + amount
        println("Doladowano blikiem $amount, teraz masz ${this.wallet}")
    }

    override fun payCard(amount: Double, cardNumber: Int, CVV : Int) { // W prawdziwej aplikacji można dodać sprawdzanie poprawności płatności
        this.wallet = this.wallet + amount
        println("Doladowano karta $amount, teraz masz ${this.wallet}")
    }

    override fun payCash(amount: Double) {
        this.wallet = this.wallet + amount
        println("Doladowano gotowka $amount, teraz masz ${this.wallet}")
    }

    fun buyProduct(index : Int) { // Metoda do zakupu produktu z listy ofert
        if(this.wallet >= Offers.offers[index].price && Offers.offers[index].quantity > 0) { // Sprawdza, czy użytkownik ma wystarczająco pieniędzy i czy produkt jest dostępny
            Offers.offers[index].quantity -= 1 // Zmniejsza ilość produktu o 1
            this.wallet -= Offers.offers[index].price // Odejmuje kwotę z portfela kupującego
            val seller = Users.users[(Offers.offers[index].idSeller)] // Znajduje sprzedawcę
            seller.wallet += Offers.offers[index].price // Dodaje pieniądze sprzedawcy
            println("Kupiono ${Offers.offers[index].name} pozostalo ci na koncie ${this.wallet}")
        }
        else if(this.wallet < Offers.offers[index].price)  {
            println("Masz za malo pieniedzy") // Jeśli nie ma wystarczających środków
        }
        else {
            println("ten produkt nie jest aktualnie dostepny") // Jeśli produkt jest niedostępny
        }
    }
}