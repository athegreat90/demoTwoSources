package net.alexandermora.demotwosources.domain

import javax.persistence.*

@Entity
class User
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    var id: Int? = null

    @Column(name = "login")
    var login: String? = null

    @Column(name = "firstname")
    var firstname: String? = null

    @Column(name = "lastname")
    var lastname: String? = null

    @Column(name = "description")
    var description: String? = null
}