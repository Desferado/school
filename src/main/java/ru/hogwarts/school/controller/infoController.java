package ru.hogwarts.school.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class infoController {
    @Value("${server.port}")
    private int port;

@GetMapping("/getPort")
    public int getPort(){
    return port;
}
}
