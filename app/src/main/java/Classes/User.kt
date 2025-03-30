package Classes

abstract class User (
    val id: Int,
    val login: String,
    val email: String,
    val date: String
) : opinion {
    override fun giveOpinion(login : String, review: String, rating: opinions) {
        val user = Users.users.find { it.login == login }
        if (user == null) {
            println("nie ma takiego uzytkownika")
        }
        else {

        }
    }

    override fun watchOpinion(login: String) {
        TODO("Not yet implemented")
    }
}