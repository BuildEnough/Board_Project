package com.Board.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/hi")
    public String niceToMeetyou(Model model) {
        model.addAttribute("username", "사용자");
        return "greetings";
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model) {
        model.addAttribute("nickname", "사용자");
        return "goodbye";
    }
}
