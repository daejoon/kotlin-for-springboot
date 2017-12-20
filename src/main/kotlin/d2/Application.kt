package d2

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @Author kdj
 * @Date 2017. 12. 19.
 */
@RestController
@SpringBootApplication
class Application : CommandLineRunner {
    private val log = LoggerFactory.getLogger(Application::class.java)

    override fun run(vararg args: String?) {
        log.info("Hello Kotlin")
    }

    @RequestMapping(value = arrayOf("", "/"))
    fun hello() = "Kotlin for Spring boot"
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}