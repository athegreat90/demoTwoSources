package net.alexandermora.demotwosources.controller

import net.alexandermora.demotwosources.dto.UserDto
import net.alexandermora.demotwosources.service.UserService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/user")
class UserController (private val userService: UserService) {

    @GetMapping("/")
    fun getAll(): List<UserDto> = userService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Long): UserDto = userService.getById(id.toInt())

    @PostMapping("/")
    fun save(@RequestBody body: UserDto): String
    {
        var id = userService.save(body)
        return "The register $id was created success"
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Long, @RequestBody body: UserDto): UserDto = userService.update(id.toInt(), body);

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long): String
    {
        if (userService.delete(id.toInt()))
        {
            return "OK"
        }
        return "Fail"
    }
}