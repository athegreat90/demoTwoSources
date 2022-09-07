package net.alexandermora.demotwosources.dto



data class UserDto(
    var id: Int? = null,
    var login: String,
    var firstname: String,
    var lastname: String,
    var description: String? = null
) {}