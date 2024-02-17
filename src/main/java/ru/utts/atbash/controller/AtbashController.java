package ru.utts.atbash.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.utts.atbash.model.Atbash;
import ru.utts.atbash.service.AtbashService;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class AtbashController {
    private final AtbashService atbashService;
    
    @GetMapping()
    public String index(@ModelAttribute("atbash") Atbash atbash) {
        return "index";
    }
    
    @PostMapping("/encrypt")
    public ResponseEntity<String> encrypt(@ModelAttribute("atbash") Atbash atbash) {
        return ResponseEntity.ok(atbashService.encrypt(atbash.getMessage()));
    }
}
