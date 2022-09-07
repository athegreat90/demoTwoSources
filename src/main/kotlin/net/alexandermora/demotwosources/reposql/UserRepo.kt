package net.alexandermora.demotwosources.reposql

import net.alexandermora.demotwosources.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepo : JpaRepository<User, Int> {
}