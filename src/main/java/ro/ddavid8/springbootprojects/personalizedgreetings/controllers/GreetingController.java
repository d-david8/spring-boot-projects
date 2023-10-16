package ro.ddavid8.springbootprojects.personalizedgreetings.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ro.ddavid8.springbootprojects.personalizedgreetings.services.GreetingService;

@RestController
public class GreetingController {
    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/api/personalizedGreetings/greet/{name}")
    public String greet(@PathVariable String name) {
        return greetingService.getGreeting(name);
    }
}
