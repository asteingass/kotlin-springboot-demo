package com.asteingass.springboot.controller

import com.asteingass.springboot.model.Customer
import com.asteingass.springboot.repository.CustomerRepository
import io.swagger.annotations.Api
import io.swagger.annotations.ApiImplicitParam
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers")
@Api(description = "Everything about customers", produces = "application/json", tags = ["customers"], position = 1)
class CustomerController(val repository: CustomerRepository) {
    @GetMapping
    @ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header", defaultValue = "Bearer X")
    fun findAll() = repository.findAll()

    @PostMapping
    @ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header", defaultValue = "Bearer X")
    fun addCustomer(@RequestBody customer: Customer) = repository.save(customer)

    @PutMapping("/{id}")
    @ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header", defaultValue = "Bearer X")
    fun updateCustomer(@PathVariable id: Long, @RequestBody customer: Customer) {
        assert(customer.id == id)
        repository.save(customer)
    }

    @DeleteMapping("/{id}")
    @ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header", defaultValue = "Bearer X")
    fun removeCustomer(@PathVariable id: Long) = repository.deleteById(id)

    @GetMapping("/{id}")
    @ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header", defaultValue = "Bearer X")
    fun getById(@PathVariable id: Long) = repository.findById(id)
}