package com.asteingass.springboot.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@ApiModel
data class Customer(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        @ApiModelProperty(position = 0, allowEmptyValue = true)
        var id: Long = 0,

        @ApiModelProperty(required = true, position = 1)
        var firstName: String = "",

        @ApiModelProperty(required = true, position = 2)
        var lastName: String = ""
)