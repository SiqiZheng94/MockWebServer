package com.example.mockwebserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;

@Service
public class CharacterService {
    private final WebClient webClient;

    public CharacterService(@Value("${basic.url}") String basicUrl) {

        this.webClient = WebClient.create(basicUrl);
    }

    public RickAndMortyCharacter getCharacter() {
        RickAndMortyCharacter character = Objects.requireNonNull(
                webClient
                        .get()
                        .uri("/character/2")
                        .retrieve()
                        .toEntity(RickAndMortyCharacter.class)
                        .block()
        ).getBody();

        return character;
    }
}


