package Classes

abstract class User ( // Abstrakcyjna klasa reprezentująca użytkownika
    val id: Int,
    val login: String,
    val email: String,
    val date: String,
    var wallet : Double
) : opinion {

    private val opinions = mutableListOf<opinionData>() // Lista opinii otrzymanych przez użytkownika

    open fun showAccount() { // Funkcja wyświetlająca dane konta
        println("nr uzytkownika: $id")
        println("login: $login")
        println("email: $email")
        println("data zalozenia konta: $date")
    }

    override fun giveOpinion(targetID: Int, review: String, rating: opinions) { // Funkcja pozwalająca dodać opinię innemu użytkownikowi
        val user = Users.users.find { it.id == targetID } // Szuka użytkownika o podanym ID
        if (user != null) {
            user.opinions.add(opinionData(review, rating, this.login)) // Dodaje opinię do listy
            println("Opinia dodana dla uzytkownika ${Users.users[targetID].login}")
        } else {
            println("Uzytkownik o loginie ${Users.users[targetID].login} nie istnieje")  // Jeśli użytkownik nie istnieje, wyświetla komunikat
        }
    }

    override fun watchOpinions(targetID: Int): List<opinionData> { // Funkcja zwracająca opinie danego użytkownika
        val user = Users.users.find { it.id == targetID } // Szuka użytkownika o podanym ID
        return if (user != null) {
            if (user.opinions.isEmpty()) {
                println("Brak opinii dla uzytkownika ${Users.users[targetID].login}")
            } else {
                println("Opinie dla uzytkownika ${Users.users[targetID].login}:")
                user.opinions.forEach { println("Ocena: ${it.rating} Opis: ${it.review} Dodajacy: ${it.user}") }
            }
            user.opinions // Zwraca listę opinii
        } else {
            println("Uzytkownik o loginie ${Users.users[targetID].login} nie istnieje")
            emptyList() // Zwraca pustą listę jeśli użytkownik nie istnieje
        }
    }
}