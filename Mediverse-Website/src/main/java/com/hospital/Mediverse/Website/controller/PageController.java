package com.hospital.Mediverse.Website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/services")
    public String services() {
        return "services";
    }

    @GetMapping("/doctors")
    public String doctors() {
        return "doctors";
    }

    @GetMapping("/branches")
    public String branches() {
        return "branches";
    }

    @GetMapping("/departments")
    public String departments() {
        return "departments";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/appointment")
    public String appointment() {
        return "appointment";
    }


}
