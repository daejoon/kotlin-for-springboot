package d2

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.Banner
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.info.BuildProperties
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * ________       .___________
 * \______ \    __| _/\_____  \
 *  |    |  \  / __ |  /  ____/
 *  |    `   \/ /_/ | /       \
 * /_______  /\____ | \_______ \
 *         \/      \/         \/
 * :: ddoong2 ::
 *
 * @Author kdj
 * @Date 2017. 12. 19.
 */
@RestController
@SpringBootApplication
class Application {
    private val log = LoggerFactory.getLogger(Application::class.java)

    @Autowired
    lateinit var env: Environment

    @Autowired
    lateinit var buildInfo: BuildProperties

    fun init() = CommandLineRunner {
        log.info("Profile: '{}'", env.activeProfiles)
        log.info("Version: '{}'", buildInfo.version)
    }

    @GetMapping(value = arrayOf("", "/"))
    fun hello() = "Kotlin for Spring boot"
}

fun main(args: Array<String>) {
    SpringApplicationBuilder(Application::class.java)
            .sources(Application::class.java)
            .bannerMode(Banner.Mode.LOG)
            .run(*args)
}
