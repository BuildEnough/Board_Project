package com.Board.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/hi")
    public String niceToMeetyou() {
        return "greetings";
    }
}
