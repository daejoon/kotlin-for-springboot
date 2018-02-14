package d2

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.info.BuildProperties
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

/**
 * @Author kdj
 * @Date 2017. 12. 19.
 */
@RestController
@SpringBootApplication
class Application: CommandLineRunner {
    private val log = LoggerFactory.getLogger(Application::class.java)

    val counter = AtomicLong()

    @Autowired
    lateinit var env: Environment

    @Autowired(required = false)
    var buildInfo: BuildProperties? = null

    override fun run(vararg args: String?) {
        log.info("Profile: '{}'", env.activeProfiles)
        log.info("Version: '{}'", buildInfo?.version ?: "Faild to load.")
    }

    @GetMapping(value = arrayOf("", "/"))
    fun hello() = "Kotlin for Spring boot"

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String)
            = Greeting(counter.incrementAndGet(), "Hello $name")
}

fun main(args: Array<String>) {
    SpringApplicationBuilder(Application::class.java)
            .sources(Application::class.java)
            .run(*args)
}
