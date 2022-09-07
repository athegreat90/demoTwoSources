package net.alexandermora.demotwosources.reponosql

import net.alexandermora.demotwosources.domain.Movie
import org.socialsignin.spring.data.dynamodb.repository.EnableScan
import org.springframework.data.repository.CrudRepository

@EnableScan
interface MovieRepo : CrudRepository<Movie, String> {
}