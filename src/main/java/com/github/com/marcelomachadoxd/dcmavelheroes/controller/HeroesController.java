package com.github.com.marcelomachadoxd.dcmavelheroes.controller;

import  com.github.com.marcelomachadoxd.dcmavelheroes.document.Heroes;
import  com.github.com.marcelomachadoxd.dcmavelheroes.repository.HeroesRepository;
import  com.github.com.marcelomachadoxd.dcmavelheroes.service.HeroesService;
//import  lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import  org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.github.com.marcelomachadoxd.dcmavelheroes.constants.HeroesConstat.HEROES_ENDPOINT_LOCAL;

@RestController
//@Slf4j
public class HeroesController {

    HeroesService heroesService;
    HeroesRepository heroesRepository;


    private static final Logger log =
        LoggerFactory.getLogger(HeroesController.class);

    public HeroesController (HeroesService heroesService, HeroesRepository heroesRepository){
        this.heroesRepository = heroesRepository;
        this.heroesService = heroesService;
    }

    @GetMapping(HEROES_ENDPOINT_LOCAL)
    public Flux<Heroes> getAllItems(){
        log.info("Requesting list of all heroes");
        return heroesService.findAll();
    }

    @GetMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
    public Mono<ResponseEntity<Heroes>> findByIdHero(@PathVariable String id){
        log.info("requesting a hero with id {}", id);
        return heroesService.findById(id)
            .map((item)-> new ResponseEntity<>(item,HttpStatus.OK))
            .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(code=HttpStatus.CREATED)
    public Mono<Heroes> createHero(@RequestBody Heroes heroes){
        log.info("Creating a hero {}", heroes);

        return heroesService.save(heroes);
    }

    @DeleteMapping(HEROES_ENDPOINT_LOCAL+"/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Mono<HttpStatus> deleteHeroById(@PathVariable String id){
        heroesService.deleteByIdHero(id);
        log.info("Deleting a hero with id {}", id);
        return Mono.just(HttpStatus.ACCEPTED);
    }


}
