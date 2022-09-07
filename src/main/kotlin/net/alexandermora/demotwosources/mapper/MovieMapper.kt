package net.alexandermora.demotwosources.mapper

import net.alexandermora.demotwosources.domain.Movie
import net.alexandermora.demotwosources.dto.MovieDto
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping


@Mapper(componentModel = "spring")
interface MovieMapper {
    @Mapping(source = "id", target = "id")
    fun getDtoList(list: MutableIterable<Movie>): List<MovieDto>

    fun getDto(entity: Movie): MovieDto

    @InheritInverseConfiguration
    fun getEntity(dto: MovieDto): Movie
}