package app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleServiceToServiceFeignCommunicationDemoApplication

fun main(args: Array<String>) {
	runApplication<SimpleServiceToServiceFeignCommunicationDemoApplication>(*args)
}
