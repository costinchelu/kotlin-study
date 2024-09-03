package ch10.ReducingDuplicationWithLambdas



data class SiteVisit(
    val path: String,
    val duration: Double,
    val os: OS,
)

enum class OS { WINDOWS, LINUX, MAC, IOS, ANDROID }

val siteLogger = listOf(
    SiteVisit("/", 34.0, OS.WINDOWS),
    SiteVisit("/", 22.0, OS.MAC),
    SiteVisit("/login", 12.0, OS.WINDOWS),
    SiteVisit("/signup", 8.0, OS.IOS),
    SiteVisit("/", 16.3, OS.ANDROID)
)

// hardcoded filter (need multiple filters for multiple OS)
val averageDurationForWindows = siteLogger
    .filter { it.os == OS.WINDOWS }
    .map(SiteVisit::duration)
    .average()

// we can create an extension function that will use an OS type
fun List<SiteVisit>.averageDurationFor(os: OS) =
    filter { it.os == os }.map(SiteVisit::duration).average()

// or a higher order function that accepts a predicate like a query
fun List<SiteVisit>.averageDurationFor(predicate: (SiteVisit) -> Boolean) =
    filter(predicate).map(SiteVisit::duration).average()


fun main() {
    println(averageDurationForWindows)     // 23.0


    println(siteLogger.averageDurationFor(OS.WINDOWS))     // 23.0
    println(siteLogger.averageDurationFor(OS.MAC))         // 22.0


    val averageMobileDuration = siteLogger
        .filter { it.os in setOf(OS.IOS, OS.ANDROID) }
        .map(SiteVisit::duration)
        .average()
    println(averageMobileDuration)        // 12.15

    // the higher order function can be used to create a result for one or more OS and even for certain paths6
    println(siteLogger.averageDurationFor { it.os in setOf(OS.ANDROID, OS.IOS) })            // 12.15
    println(siteLogger.averageDurationFor { it.os == OS.IOS && it.path == "/signup" })       // 8.0
}