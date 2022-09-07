package net.alexandermora.demotwosources.service

import net.alexandermora.demotwosources.domain.User
import net.alexandermora.demotwosources.dto.UserDto
import net.alexandermora.demotwosources.mapper.UserMapper
import net.alexandermora.demotwosources.reposql.UserRepo
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class UserServiceImpl(private val userRepo: UserRepo, private val userMapper: UserMapper) : UserService {
    override fun getAll(): List<UserDto> {
        val listEntity = userRepo.findAll()
        return userMapper.getDtoList(listEntity)
    }

    override fun getById(id: Int): UserDto {
        return userMapper.getDto(getUser(id))
    }

    override fun save(body: UserDto): Int {
        val entity = userMapper.getEntity(body)
        val savedEntity = userRepo.saveAndFlush(entity)
        return savedEntity.id!!
    }

    override fun update(id: Int, body: UserDto): UserDto {
        return body
    }

    override fun delete(id: Int): Boolean {
        getUser(id)
        userRepo.deleteById(id)
        return true
    }

    private fun getUser(id: Int): User {
        val entity = userRepo.findById(id)
        if (entity.isEmpty) {
            throw RuntimeException("Id not found")
        }
        return entity.get()
    }
}