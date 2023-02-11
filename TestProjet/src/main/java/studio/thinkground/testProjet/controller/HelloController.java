package studio.thinkground.testProjet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//    @RequestMapping(value = "/hello", method = RequestMethod.GET) // = GetMapping("hello")
    @GetMapping("hello")
    public String hello() {
        return "Hello World!";
    }
}