package Classes

class Seller (
    id : Int,
    login : String,
    email : String,
    date : String,
    wallet : Double
) : User(id,login,email,date, wallet), paymentMethods {

    override fun showAccount() {
        println("konto sprzedajacego")
        println("nr uzytkownika: $id | login: $login | email: $email | data zalozenia konta: $date | stan konta: $wallet")
    }

    fun newOffer(name : String, price : Double, quantity : Int, description : String) {
        val offer = Product(name, price, quantity, description, this.id)
        println("Dodano: $name")
        Offers.offers.add(offer)
    }

    override fun payBlik(amount: Double, blikCode: Int) { // w prawdziwej aplikacji mozna by dodaj sprawdzanie poprawnosci kodu
        if (this.wallet >= amount) {
            this.wallet = this.wallet - amount
            println("Wyplacono blikiem $amount, teraz masz ${this.wallet}")
        }
        else {
            println("nie masz tylu pieniedzy na koncie")
        }
    }

    override fun payCard(amount: Double, cardNumber: Int, CVV : Int) { // w prawdziwej aplikacji mozna by dodaj sprawdzanie poprawnosci kodu
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