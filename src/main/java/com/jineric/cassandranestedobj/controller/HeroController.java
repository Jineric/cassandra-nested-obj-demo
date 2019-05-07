package com.jineric.cassandranestedobj.controller;

import com.jineric.cassandranestedobj.model.Hero;
import com.jineric.cassandranestedobj.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class HeroController {

    @Autowired
    HeroRepository heroRepository;

    @GetMapping(value = "/healthcheck", produces = "application/json; charset=utf-8")
    public String getHealthCheck() {
        return "{ \"isWorking\" : true }";
    }

    @GetMapping("/heroes")
    public List<Hero> getHeroes() {
        Iterable<Hero> result = heroRepository.findAll();
        List<Hero> heroList = new ArrayList<Hero>();
        result.forEach(heroList::add);
        return heroList;
    }

    @GetMapping("/heroes/{id}")
    public Optional<Hero> getHero(@PathVariable String id) {
        Optional<Hero> emp = heroRepository.findById(id);
        return emp;
    }

    @DeleteMapping(value = "/heroes/{id}", produces = "application/json; charset=utf-8")
    public String deleteEmployee(@PathVariable String id) {
        Boolean result = heroRepository.existsById(id);
        heroRepository.deleteById(id);
        return "{ \"success\" : "+ (result ? "true" : "false") +" }";
    }

        @PostMapping("/heroes")
    public Hero addHero(@RequestBody Hero newHero)
    {
        Hero emp = new Hero(newHero.getName(), newHero.getStats());
        heroRepository.save(emp);
        return emp;
    }
}
