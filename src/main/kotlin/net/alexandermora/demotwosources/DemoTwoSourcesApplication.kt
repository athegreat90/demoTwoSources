package net.alexandermora.demotwosources

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories(basePackages = ["net.alexandermora.demotwosources.reposql"])
@SpringBootApplication
class DemoTwoSourcesApplication

fun main(args: Array<String>) {
    runApplication<DemoTwoSourcesApplication>(*args)
}
