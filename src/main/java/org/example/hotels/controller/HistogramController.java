package org.example.hotels.controller;

import org.example.hotels.service.HistogramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/histogram")
public class HistogramController {

    private final HistogramService histogramService;
    @Autowired
    public HistogramController(HistogramService histogramService) {
        this.histogramService = histogramService;
    }
    @GetMapping("/{param}")
    public Map<String, Long> histogram(@PathVariable String param) {
        return histogramService.createHistogram(param);
    }
}
