package Classes

class Buyer (
    id : Int,
    login : String,
    email : String,
    date : String,
    wallet : Double
) : User(id,login,email,date,wallet),paymentMethods {

    override fun showAccount() {
        println("konto kupujacego")
        println("nr uzytkownika: $id | login: $login | email: $email | data zalozenia konta: $date | stan konta: $wallet")
    }

    fun showOffers() {
        if(Offers.offers.isEmpty()) { // sprawdza czy lista nie jest pusta
            println("Nie ma żadnych ofert")
        }
        else {
            println("Oferty na rynku:")
                    Offers.offers.forEachIndexed { index, product -> // dla kazdego elementu w liscie printuj index i kazde pole klasy produkt
                        print("${index} | ")
                        print("nazwa: ${product.name} | ")
                        print("cena: ${product.price} | ")
                        print("ilosc: ${product.quantity} | ")
                        print("opis: ${product.description} | ")
                        println("sprzedawca: ${product.idSeller} | ")
                    }
        }
    }
    override fun payBlik(amount: Double, blikCode: Int) { // w prawdziwej aplikacji mozna by dodaj sprawdzanie poprawnosci kodu
        this.wallet = this.wallet + amount
        println("Doladowano blikiem $amount, teraz masz ${this.wallet}")
    }

    override fun payCard(amount: Double, cardNumber: Int, CVV : Int) { // w prawdziwej aplikacji mozna by dodaj sprawdzanie poprawnosci kodu
        this.wallet = this.wallet + amount
        println("Doladowano karta $amount, teraz masz ${this.wallet}")
    }

    override fun payCash(amount: Double) {
        this.wallet = this.wallet + amount
        println("Doladowano gotowka $amount, teraz masz ${this.wallet}")
    }

    fun buyProduct(index : Int) {
        if(this.wallet >= Offers.offers[index].price && Offers.offers[index].quantity > 0) {
            Offers.offers[index].quantity -= 1
            this.wallet -= Offers.offers[index].price
            val seller = Users.users[(Offers.offers[index].idSeller)]
            seller.wallet += Offers.offers[index].price
            println("Kupiono ${Offers.offers[index].name} pozostalo ci na koncie ${this.wallet}")
        }
        else if(this.wallet < Offers.offers[index].price)  {
            println("Masz za malo pieniedzy")
        }
        else {
            println("ten produkt nie jest aktualnie dostepny")
        }
    }
}