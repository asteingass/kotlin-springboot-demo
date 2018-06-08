package com.asteingass.springboot.controller

import com.asteingass.springboot.exceptions.UserAlreadyExistsException
import com.asteingass.springboot.model.ApplicationUser
import com.asteingass.springboot.repository.ApplicationUserRepository
import io.swagger.annotations.Api
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/register")
@Api(description = "Register", produces = "application/json", tags = ["register"])
class RegisterController(val applicationUserRepository: ApplicationUserRepository, val bCryptPasswordEncoder: BCryptPasswordEncoder) {

    @PostMapping
    fun addNewApplicationUser(@RequestBody applicationUser: ApplicationUser) {
        applicationUser.password = bCryptPasswordEncoder.encode(applicationUser.password)
        if (applicationUserRepository.findByUsername(applicationUser.username) != null)
            throw UserAlreadyExistsException()
        else
            applicationUserRepository.save(applicationUser)
    }
}