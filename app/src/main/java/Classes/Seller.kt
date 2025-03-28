package Classes

class Seller (
    id : Int,
    login : String,
    email : String,
    date : String
) : User(id,login,email,date) {

    fun newOffer(name : String, price : Double, quantity : Int, description : String) {
        val offer = Product(name, price, quantity, description, this.login)
        println("Dodano: $name")
        Offers.offers.add(offer)
    }
}