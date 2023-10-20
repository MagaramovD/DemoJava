package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/api/guess-number")
public class GuessNumberController {

    private final int secretNumber;

    public GuessNumberController() {
        Random random = new Random();
        secretNumber = random.nextInt(100) + 1;
    }

    @GetMapping("/info")
    public String getInfo() {
        return "Guess the number";
    }

    @GetMapping("/guess")
    public String guessNumber(@RequestParam int number) {
        if (number < secretNumber) {
            return "The hidden number is greater " + number;
        } else if (number > secretNumber) {
            return "The hidden number is smaller" + number;
        } else {
            return "Congrats, the number was " + secretNumber;
        }
    }
}