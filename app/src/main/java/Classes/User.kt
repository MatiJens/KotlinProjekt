package Classes

abstract class User (
    val id: Int,
    val login: String,
    val email: String,
    val date: String,
    var wallet : Double
) : opinion {

    private val opinions = mutableListOf<opinionData>()

    open fun showAccount() {
        println("nr uzytkownika: $id")
        println("login: $login")
        println("email: $email")
        println("data zalozenia konta: $date")
    }

    override fun giveOpinion(targetID: Int, review: String, rating: opinions) {
        val user = Users.users.find { it.id == targetID }
        if (user != null) {
            user.opinions.add(opinionData(review, rating, this.login))
            println("Opinia dodana dla uzytkownika ${Users.users[targetID].login}")
        } else {
            println("Uzytkownik o loginie ${Users.users[targetID].login} nie istnieje")
        }
    }

    override fun watchOpinions(targetID: Int): List<opinionData> {
        val user = Users.users.find { it.id == targetID }
        return if (user != null) {
            if (user.opinions.isEmpty()) {
                println("Brak opinii dla uzytkownika ${Users.users[targetID].login}")
            } else {
                println("Opinie dla uzytkownika ${Users.users[targetID].login}:")
                user.opinions.forEach { println("Ocena: ${it.rating} Opis: ${it.review} Dodajacy: ${it.user}") }
            }
            user.opinions
        } else {
            println("Uzytkownik o loginie ${Users.users[targetID].login} nie istnieje")
            emptyList()
        }
    }
}