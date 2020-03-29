package edu.niit.mvcdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WU, Homer
 * @version 1.0
 * @date 2020/3/24
 * @description
 */
@RestController
@RequestMapping("/api")
public class MyRestController {
    @RequestMapping("/hello")
    public String get() {
        return "Hello Spring Boot";
    }
}
