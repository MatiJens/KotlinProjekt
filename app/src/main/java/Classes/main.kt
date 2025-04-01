package Classes

fun main() {
    var Kuba = createUser.createBuyer("Kuba", "kuba.pl", "01.04")
    var Tomek = createUser.createSeller("Tomek", "tomek.pl", "07.03")
    Tomek.newOffer("jablko", 5.5, 1, "dobre i swieze")
    Tomek.newOffer("ananas", 10.5, 4, "z hawajow")
    Kuba.showOffers()
    Kuba.payCash(12.0)
    Kuba.buyProduct(0)
    Kuba.showOffers()
    Kuba.showAccount()
    Tomek.showAccount()
    Kuba.buyProduct(1)
    Kuba.buyProduct(0)
    Tomek.payCash(3.0)
    Kuba.giveOpinion(1, "Chujowe", opinions.TRAGEDIA)
    Kuba.watchOpinions(1)
    Tomek.watchOpinions(1)
    Tomek.watchOpinions(0)
}