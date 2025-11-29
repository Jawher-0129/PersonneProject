package com.example.personneproject.controllers;
import com.example.personneproject.entities.Personne;
import com.example.personneproject.services.PersonneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personnes")
public class PersonneController {

    private final PersonneService personneService;

    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @GetMapping
    public List<Personne> getAllPersonnes() {
        return personneService.getAllPersonnes();
    }

    @GetMapping("/{id}")
    public Personne getPersonneById(@PathVariable Long id) {
        return personneService.getPersonneById(id);
    }

    @PostMapping
    public ResponseEntity<Personne> createPersonne(@RequestBody Personne personne) {
        return new ResponseEntity<>(personneService.createPersonne(personne), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Personne updatePersonne(@PathVariable Long id, @RequestBody Personne personne) {
        return personneService.updatePersonne(id, personne);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonne(@PathVariable Long id) {
        personneService.deletePersonne(id);
        return ResponseEntity.noContent().build();
    }
}
