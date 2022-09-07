package net.alexandermora.demotwosources.service

import net.alexandermora.demotwosources.domain.Movie
import net.alexandermora.demotwosources.dto.MovieDto
import net.alexandermora.demotwosources.mapper.MovieMapper
import net.alexandermora.demotwosources.reponosql.MovieRepo
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class MovieServiceImpl(private val movieRepo: MovieRepo, private val movieMapper: MovieMapper) : MovieService {
    override fun getAll(): List<MovieDto> {
        val listEntity = movieRepo.findAll()
        return movieMapper.getDtoList(listEntity)
    }

    override fun getById(id: String): MovieDto {
        return movieMapper.getDto(getUser(id))
    }

    override fun save(body: MovieDto): String {
        val entity = movieMapper.getEntity(body)
        val savedEntity = movieRepo.save(entity)
        return savedEntity.id!!
    }

    override fun update(id: String, body: MovieDto): MovieDto {
        return body
    }

    override fun delete(id: String): Boolean {
        getUser(id)
        movieRepo.deleteById(id)
        return true
    }

    private fun getUser(id: String): Movie {
        val entity = movieRepo.findById(id)
        if (entity.isEmpty) {
            throw RuntimeException("Id not found")
        }
        return entity.get()
    }
}