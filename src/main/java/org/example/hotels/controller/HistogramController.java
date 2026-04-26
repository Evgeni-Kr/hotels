package org.example.hotels.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/histogram")
public class HistogramController {

    @GetMapping("/{param}")
    public Map<String, Long> histogram(@PathVariable String param) {
        return null;
    }
}
