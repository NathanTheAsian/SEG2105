/*
    Generics, Objects and extensions using the fill in the blank question example
*/
class Question<T> (
    val questionText: String,
    val answer: T,
    val difficulty: String
)

/*
Enum classes contain fixed constants */
enum class Difficulty {
    EASY, MEDIUM, HARD 
    /*
    Comparable values
     */
}

/* 
Data class are used to hold data
*/
data class Question<T> (
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
) 

/*
Singleton classes only allow one instance of a class at a time
*/
object objectName {
    /*
    code here 
    */
}

/*
Companion object is a singleton that makes the object static. Called within class definitions
*/
class superClass {
    companion object companionObject {
        //constructor call
        fun method(): superClass = superClass() 
    }
}