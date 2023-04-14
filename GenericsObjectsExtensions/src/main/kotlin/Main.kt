interface ProgressPrintable {
    val progressText: String

    fun printProgressBar()
}


class Quiz : ProgressPrintable{
    override val progressText: String
        get() = "${answered * 100/ total}%"

    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
        repeat(Quiz.total - Quiz.answered) { print("▒") }
        println()
        println(progressText)
    }

    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }

    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    companion object StudentProgress {
        var total: Int = 100
        var answered: Int = 10
    }
}


class FillInTheBlankQuestion(
    val questionText: String,
    val answer: String,
    val difficulty: Difficulty
)


class TrueOrFalseQuestion(
    val questionText: String,
    val answer: Boolean,
    val difficulty: Difficulty
)


data class NumericQuestion(
    val questionText: String,
    val answer: Int,
    val difficulty: Difficulty
)


class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)


enum class Difficulty {
    EASY, MEDIUM, HARD
}


enum class Daypart{
    MORNING, AFTERNOON, EVENING
}


data class Event<T>(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationOfEvent: T
)


fun main(args: Array<String>) {

    val event1 = Event<Int>(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationOfEvent = 0)
    val event2 = Event<Int>(title = "Eat breakfast", daypart = Daypart.MORNING, durationOfEvent = 15)
    val event3 = Event<Int>(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationOfEvent = 30)
    val event4 = Event<Int>(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationOfEvent = 60)
    val event5 = Event<Int>(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationOfEvent = 10)
    val event6 = Event<Int>(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationOfEvent = 45)
    val events = mutableListOf(event1, event2, event3, event4, event5, event6)
    val shortEvents = events.filter {  it.durationOfEvent < 60 }
    println("You have ${shortEvents.size} short events.")

    val daypartEvents = events.groupBy { it.daypart }
    daypartEvents.forEach { (daypart, events) ->
        println("$daypart: ${events.size} events")
    }
    println(events)
    println("Last event of the day: ${events.last().title}")
    val durationOfEvent = if (events[0].durationOfEvent < 60) {
        "short"
    } else {
        "long"
    }
    println("Duration of first event of the day: $durationOfEvent")
    println("Duration of first event of the day: ${events[0].durationOfEvent}")
//    Quiz().apply {
//        printQuiz()
//    }
//
//    val q1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
//    val q2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
//    val q3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
//    val q4 = FillInTheBlankQuestion("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
//    val q5 = TrueOrFalseQuestion("The sky is green. True or false", false, Difficulty.EASY)
//    val q6 = NumericQuestion("How many days are there between full moons?", 28, Difficulty.HARD)
//
//    println(q5)
//    println(q6)
//    println("${Quiz.answered} of ${Quiz.total} answered.")
//    Quiz().printProgressBar()
}