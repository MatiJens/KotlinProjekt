package Classes

class Seller ( // Klasa reprezentująca sprzedawcę, dziedziczy po klasie User i implementuje metody płatności z interfejsu paymentMethods
    id : Int,
    login : String,
    email : String,
    date : String,
    wallet : Double
) : User(id,login,email,date, wallet), paymentMethods {

    override fun showAccount() { // Nadpisana metoda wyświetlająca dane konta sprzedawcy
        println("konto sprzedajacego")
        println("nr uzytkownika: $id | login: $login | email: $email | data zalozenia konta: $date | stan konta: $wallet")
    }

    fun newOffer(name : String, price : Double, quantity : Int, description : String) { // Funkcja pozwalająca sprzedawcy dodać nową ofertę (produkt)
        val offer = Product(name, price, quantity, description, this.id) // Tworzy nowy obiekt typu Product z ID sprzedawcy
        println("Dodano: $name")
        Offers.offers.add(offer) // Dodaje ofertę do listy globalnych ofert
    }

    override fun payBlik(amount: Double, blikCode: Int) { // W prawdziwej aplikacji można dodać sprawdzanie poprawności płatności
        if (this.wallet >= amount) {
            this.wallet = this.wallet - amount
            println("Wyplacono blikiem $amount, teraz masz ${this.wallet}")
        }
        else {
            println("nie masz tylu pieniedzy na koncie")
        }
    }

    override fun payCard(amount: Double, cardNumber: Int, CVV : Int) { // W prawdziwej aplikacji można dodać sprawdzanie poprawności płatności
        if (this.wallet >= amount) {
            this.wallet = this.wallet - amount
            println("Wyplacono karta $amount, teraz masz ${this.wallet}")
        }
        else {
            println("nie masz tylu pieniedzy na koncie")
        }
    }

    override fun payCash(amount: Double) {
        if (this.wallet >= amount) {
            this.wallet = this.wallet - amount
            println("Wyplacono gotowka $amount, teraz masz ${this.wallet}")
        }
        else {
            println("nie masz tylu pieniedzy na koncie")
        }
    }
}