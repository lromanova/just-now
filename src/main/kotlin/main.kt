fun main(){
    val seconds: Int = (1..300_000).random()

    val text_to_show = convertToText(seconds)

    println("Пользователь был в сети $text_to_show")
}

fun convertToText(seconds: Int): String {
    val level_just_now = 60
    val level_minutes = 3600
    val level_hours = 86400
    val level_today = level_hours * 2
    val level_yesterday = level_hours * 3

    return when {
        (seconds <= level_just_now) -> "только что"
        (seconds <=  level_minutes) -> convertToMinutes(seconds)
        (seconds <= level_hours) -> convertToHours(seconds)
        (seconds <= level_today) -> "сегодня"
        (seconds <= level_yesterday) -> "вчера"
        else -> "давно"
    }


}

fun convertToMinutes (seconds: Int): String {
    val minutes = seconds/60

    return when {
        (minutes in 5..20) -> "$minutes минут назад"
        (minutes.toString().endsWith("1")) -> "$minutes минуту назад"
        (minutes.toString().endsWith("2") || minutes.toString().endsWith("3") || minutes.toString().endsWith("4")) -> "$minutes минуты назад"
        else -> "$minutes минут назад"
    }

}

fun convertToHours (seconds: Int): String {
    val hours = seconds/3600

    return when {
        (hours in 5..20) -> "$hours часов назад"
        (hours.toString().endsWith("1")) -> "$hours час назад"
        (hours.toString().endsWith("2") || hours.toString().endsWith("3") || hours.toString().endsWith("4")) -> "$hours часа назад"
        else -> "$hours часов назад"
    }
}