package spring_kotlin

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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

    @GetMapping("/get/{key}")
    fun mapFromConfig(@PathVariable key: String): String = KeyVal.kvDataMap[key].toString()
}


data class Greeting(val id: Int, val text: String)


@Component
@PropertySource("classpath:props/keyval.properties")
class KeyVal(
    @Value("#{\${key.val}}")
    keyValues: Map<String, String>) {

    init {
        kvDataMap = keyValues.map { it.key to KVData(it.key, it.value) }.toMap()
    }

    companion object {
        lateinit var kvDataMap: Map<String, KVData>
    }

    data class KVData(val key: String, val value: String)
}