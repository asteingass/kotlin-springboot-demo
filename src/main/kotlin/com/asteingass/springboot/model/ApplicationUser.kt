package com.asteingass.springboot.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@ApiModel
class ApplicationUser(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @ApiModelProperty(position = 0, allowEmptyValue = true)
        val id: Long = 0,

        @ApiModelProperty(required = true, position = 1)
        var username: String = "",

        @ApiModelProperty(required = true, position = 2)
        var password: String = ""
)