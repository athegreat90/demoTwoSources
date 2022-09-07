package net.alexandermora.demotwosources.service

import net.alexandermora.demotwosources.dto.MovieDto

interface MovieService
{
    fun getAll(): List<MovieDto>
    fun getById(id: String): MovieDto
    fun save(body: MovieDto): String
    fun update(id: String, body: MovieDto): MovieDto
    fun delete(id: String): Boolean

}