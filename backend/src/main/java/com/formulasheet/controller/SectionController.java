package com.formulasheet.controller;

import com.formulasheet.model.Item;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/sections")
public class SectionController {
    private final List<Item> sections = new ArrayList<>();

    @PostMapping(consumes = "application/json", produces = "application/json")
public Item addSection(@RequestBody Item item) {
    sections.add(item);
    return item;
}

    @GetMapping
    public List<Item> getSections() {
        return sections;
    }
}