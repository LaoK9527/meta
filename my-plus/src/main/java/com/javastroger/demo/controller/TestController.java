package com.javastroger.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.InputStream;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public File getFile() {
        File file = new File("D://USER.xlsx");
        return file;
    }

}
