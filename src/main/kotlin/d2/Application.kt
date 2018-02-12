package d2

import org.slf4j.LoggerFactory
import org.springframework.boot.Banner
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.io.PrintStream
import java.util.concurrent.atomic.AtomicLong

/**
 * @Author kdj
 * @Date 2017. 12. 19.
 */
@RestController
@SpringBootApplication
class Application : CommandLineRunner {
    private val log = LoggerFactory.getLogger(Application::class.java)

    val counter = AtomicLong()

    override fun run(vararg args: String?) {
        log.info("Hello Kotlin")
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
            .bannerMode(Banner.Mode.LOG)
            .banner(Banner { environment, sourceClass, out -> getBanner(environment, sourceClass, out) })
            .run(*args)
}

fun getBanner(env: Environment, clazz: Class<*>, out: PrintStream) {
    val banner =  """
________       .___________
\______ \    __| _/\_____  \
 |    |  \  / __ |  /  ____/
 |    `   \/ /_/ | /       \
/_______  /\____ | \_______ \
        \/      \/         \/
                     [ddoong2]
"""
    out.print(banner)
}
