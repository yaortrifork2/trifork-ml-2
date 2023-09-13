package com.trifork.nedgia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("majors")
@RequiredArgsConstructor
public class GasConsumptionController {

    @GetMapping
    public ResponseEntity<String> getAll() {
        return ok().body("Hello World");
    }

}
