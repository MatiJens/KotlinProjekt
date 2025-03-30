package Classes

abstract class User (
    val id: Int,
    val login: String,
    val email: String,
    val date: String
) : opinion {
    override fun giveOpinion(login : String, review: String, rating: opinions)  {
        val user = Users.users.any { it.login == login }
        if (user == null) {

        }
    }

    override fun watchOpinion(login: String) {
        TODO("Not yet implemented")
    }
}