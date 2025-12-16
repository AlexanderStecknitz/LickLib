package de.licklib.kotlinbackend

import de.licklib.kotlinbackend.properties.BucketProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(
	BucketProperties::class
)
class KotlinBackendApplication

fun main(args: Array<String>) {
	runApplication<KotlinBackendApplication>(*args)
}
