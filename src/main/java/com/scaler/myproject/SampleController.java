package com.scaler.myproject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {


    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @RequestMapping("/welcome/{name}")
    public String welcome(@PathVariable String name) {
        return "Welcome to Spring Boot! " + name;
    }

    @RequestMapping("/greet")
    public String greet() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/salute")
    public String salute() {
        return "Salutations from Spring Boot!";
    }

    @RequestMapping("/hail")
    public String hail() {
        return "Hail from Spring Boot!";
    }

    @RequestMapping("/cheers")
    public String cheers() {
        return "Cheers from Spring Boot!";
    }

    @RequestMapping("/goodbye")
    public String goodbye() {
        return "Goodbye from Spring Boot!";
    }

    @RequestMapping("/farewell")
    public String farewell() {
        return "Farewell from Spring Boot!";
    }

    @RequestMapping("/adios")
    public String adios() {
        return "Adios from Spring Boot!";
    }

    @RequestMapping("/ciao")
    public String ciao() {
        return "Ciao from Spring Boot!";
    }

    @RequestMapping("/sayonara")
    public String sayonara() {
        return "Sayonara from Spring Boot!";
    }

    @RequestMapping("/au-revoir")
    public String auRevoir() {
        return "Au revoir from Spring Boot!";
    }

    @RequestMapping("/auf-wiedersehen")
    public String aufWiedersehen() {
        return "Auf Wiedersehen from Spring Boot!";
    }

    @RequestMapping("/arrivederci")
    public String arrivederci() {
        return "Arrivederci from Spring Boot!";
    }

    @RequestMapping("/tata")
    public String tata() {
        return "Tata from Spring Boot!";
    }

    @RequestMapping("/bye")
    public String bye() {
        return "Bye from Spring Boot!";
    }

    @RequestMapping("/goodnight")
    public String goodnight() {
        return "Goodnight from Spring Boot!";
    }

    @RequestMapping("/night")
    public String night() {
        return "Night from Spring Boot!";
    }

    @RequestMapping("/sweetdreams")
    public String sweetdreams() {
        return "Sweet dreams from Spring Boot!";
    }

    @RequestMapping("/sleepwell")
    public String sleepwell() {
        return "Sleep well from Spring Boot!";
    }

}
