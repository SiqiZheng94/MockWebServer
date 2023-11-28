package com.example.mockwebserver;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rick-and-morty")
@RequiredArgsConstructor
public class RickAndMortyController {
    private final CharacterService service;
    @GetMapping
    public RickAndMortyCharacter getCharacter(){
        return service.getCharacter();
    }
}
