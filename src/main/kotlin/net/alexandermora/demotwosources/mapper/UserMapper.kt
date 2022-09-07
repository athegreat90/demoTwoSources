package net.alexandermora.demotwosources.mapper


import net.alexandermora.demotwosources.domain.User
import net.alexandermora.demotwosources.dto.UserDto
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface UserMapper {

    @Mapping(source = "id", target = "id")
    fun getDtoList(list: List<User>): List<UserDto>

    fun getDto(entity: User): UserDto

    @InheritInverseConfiguration
    fun getEntity(dto: UserDto): User
}