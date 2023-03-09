package esperer.hexakonal

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class HexakonalApplication

fun main(args: Array<String>) {
	runApplication<HexakonalApplication>(*args)
}
