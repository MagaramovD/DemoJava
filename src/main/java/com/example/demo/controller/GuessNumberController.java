package com.example.demo.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/guess-number")
public class GuessNumberController {

    private int secretNumber;
    private boolean gameStarted;

    @PostMapping("/start")
    public String startGame() {
        Random random = new Random();
        secretNumber = random.nextInt(100) + 1;
        gameStarted = true;
        return "New game started. Try to guess the number between 1 and 100.";
    }

    @GetMapping("/info")
    public String getInfo() {
        if (!gameStarted) {
            return "Welcome to Guess the Number Game! To start a new game, send a POST request to /api/guess-number/start.";
        }
        return "Game in progress. Guess the number between 1 and 100.";
    }

    @GetMapping("/guess")
    public String guessNumber(@RequestParam int number) {
        if (!gameStarted) {
            return "Game has not started yet. Send a POST request to /api/guess-number/start to begin.";
        }
        if (number < secretNumber) {
            return "The hidden number is greater than " + number;
        } else if (number > secretNumber) {
            return "The hidden number is smaller than " + number;
        } else {
            gameStarted = false;
            return "Congratulations! You guessed the number " + secretNumber + ". Game over.";
        }
    }
}