package net.alexandermora.demotwosources.controller

import net.alexandermora.demotwosources.dto.MovieDto
import net.alexandermora.demotwosources.dto.UserDto
import net.alexandermora.demotwosources.service.MovieService
import net.alexandermora.demotwosources.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/movie")
class MovieController (private val userService: MovieService) {

    @GetMapping("/")
    fun getAll(): List<MovieDto> = userService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: String): MovieDto = userService.getById(id)

    @PostMapping("/")
    fun save(@RequestBody body: MovieDto): String
    {
        var id = userService.save(body)
        return "The register $id was created success"
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: String, @RequestBody body: MovieDto): MovieDto = userService.update(id, body);

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: String): String
    {
        if (userService.delete(id))
        {
            return "OK"
        }
        return "Fail"
    }
}