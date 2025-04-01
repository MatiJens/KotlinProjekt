package Classes

interface opinion {
    fun giveOpinion(targetID: Int, review: String, rating: opinions)
    fun watchOpinions(targetID: Int): List<opinionData>
}