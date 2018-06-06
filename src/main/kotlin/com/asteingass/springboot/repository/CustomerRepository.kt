package com.asteingass.springboot.repository

import com.asteingass.springboot.model.Customer
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<Customer, Long>