package net.alexandermora.demotwosources.service

import net.alexandermora.demotwosources.dto.UserDto

interface UserService
{
    fun getAll(): List<UserDto>
    fun getById(id: Int): UserDto
    fun save(body: UserDto): Int
    fun update(id: Int, body: UserDto): UserDto
    fun delete(id: Int): Boolean

}