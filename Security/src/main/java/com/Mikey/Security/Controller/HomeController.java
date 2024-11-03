package com.Mikey.Security.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("home")
    public String Title(HttpServletRequest req){

        return "Welcome Home Page"+req.getSession().getId();
    }
}
