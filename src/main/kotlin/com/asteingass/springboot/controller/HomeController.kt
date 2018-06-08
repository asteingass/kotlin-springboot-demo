package com.asteingass.springboot.controller

import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.view.RedirectView

@RestController
@RequestMapping("/")
@Api(description = "Home Document", produces = "application/json", tags = ["home"], position = 0)
class HomeController {

    @GetMapping
    fun getHomeDocument(): RedirectView {
        return RedirectView("swagger-ui.html")
    }
}