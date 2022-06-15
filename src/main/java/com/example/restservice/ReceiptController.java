package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiptController {

    private static final String template = "OK!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/receipt")
    public Receipt receipt(String name) {
        return new Receipt(counter.incrementAndGet(), String.format(template, name));
    }
}