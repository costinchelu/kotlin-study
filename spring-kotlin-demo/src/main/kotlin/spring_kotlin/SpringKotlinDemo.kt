package spring_kotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
open class SpringBootKotlinApp

fun main(args: Array<String>) {
    runApplication<SpringBootKotlinApp>(*args)
}

@RestController
class GreetingController {

    @GetMapping
    fun index(): List<Greeting> = listOf(
        Greeting(1, "Hello!"),
        Greeting(2, "Bonjour!"),
        Greeting(3, "Buon giorno!"),
        Greeting(4, "Guten Tag")
    )
}

data class Greeting(val id: Int, val text: String)