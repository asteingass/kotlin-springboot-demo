package com.asteingass.springboot.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.FORBIDDEN, reason = "User already exists")
class UserAlreadyExistsException : RuntimeException()