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
@RequestMapping("/sign-up")
@Api(description = "Register / Sign-Up", produces = "application/json", tags = ["sign-up"])
class SignUpController(val applicationUserRepository: ApplicationUserRepository, val bCryptPasswordEncoder: BCryptPasswordEncoder) {

    @PostMapping
    fun register(@RequestBody applicationUser: ApplicationUser) {
        applicationUser.password = bCryptPasswordEncoder.encode(applicationUser.password)
        if (applicationUserRepository.findByUsername(applicationUser.username) != null)
            throw UserAlreadyExistsException()
        else
            applicationUserRepository.save(applicationUser)
    }
}