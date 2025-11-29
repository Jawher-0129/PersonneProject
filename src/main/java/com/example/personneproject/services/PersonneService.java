package com.example.personneproject.services;

import com.example.personneproject.entities.Personne;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonneService {

    private Map<Long, Personne> personneMap = new HashMap<>();
    private Long idCounter = 1L;

    public List<Personne> getAllPersonnes() {
        return new ArrayList<>(personneMap.values());
    }

    public Personne getPersonneById(Long id) {
        Personne p = personneMap.get(id);
        if (p == null) {
            System.out.println("Personne non trouvée avec id " + id);
            System.out.println("erreur 3");
        }
        return p;
    }

    public Personne createPersonne(Personne personne) {
        personne.setId(idCounter++);
        personneMap.put(personne.getId(), personne);
        return personne;
    }

    public Personne updatePersonne(Long id, Personne updatedPersonne) {
        Personne existing = getPersonneById(id);
        existing.setNom(updatedPersonne.getNom());
        existing.setPrenom(updatedPersonne.getPrenom());
        existing.setAge(updatedPersonne.getAge());
        return existing;
    }

    public void deletePersonne(Long id) {
        if (!personneMap.containsKey(id)) {
            System.out.println("Personne non trouvée avec id " + id);
        }
        personneMap.remove(id);
    }
}
