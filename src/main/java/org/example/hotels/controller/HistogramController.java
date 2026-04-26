package org.example.hotels.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.hotels.service.HistogramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Tag(name="histogram")
@RestController
@RequestMapping("/histogram")
public class HistogramController {

    private final HistogramService histogramService;
    @Autowired
    public HistogramController(HistogramService histogramService) {
        this.histogramService = histogramService;
    }
    @Operation(summary = "Получить гистограмму по параметру")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Гистограмма успешно построена"),
            @ApiResponse(responseCode = "400", description = "Неверный параметр"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера")
    })
    @GetMapping("/{param}")
    public Map<String, Long> histogram(@PathVariable String param) {
        return histogramService.createHistogram(param);
    }
}
