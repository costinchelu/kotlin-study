package ro.ccar.demo.app

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SimpleRunner(private val demo: DemoKt): CommandLineRunner {

    override fun run(vararg args: String) {
        demo.processBranches()
    }
}