package com.example.personneproject;

import com.example.personneproject.entities.Personne;
import com.example.personneproject.services.PersonneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PersonneProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonneProjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(PersonneService personneService) {
        return args -> {
            // Ajouter des personnes
            Personne p1 = new Personne(null, "Talbi", "Jawher", 25);
            Personne p2 = new Personne(null, "Doe", "John", 30);
            Personne p3 = new Personne(null, "Smith", "Anna", 28);

            personneService.createPersonne(p1);
            personneService.createPersonne(p2);
            personneService.createPersonne(p3);
            System.out.println("ajout effectuée");
             System.out.println("ajout effectuée2");
            

            // Afficher toutes les personnes
            System.out.println("Liste des personnes après ajout :");
            personneService.getAllPersonnes().forEach(p ->
                    System.out.println(p.getId() + " - " + p.getNom() + " " + p.getPrenom() + ", Age: " + p.getAge())
            );
        };
    }

}
