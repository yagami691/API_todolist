package com.example.todolist.todolist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TodolistConfig {
    @Bean
    CommandLineRunner commandLineRunner(TodolistRepository todolistRepository){
        return args -> {
              Todolist achat = new Todolist(
                      "Acheter des courses",
                      "Aller au supermarché pour acheter des fruits, " +
                              "du lait, du pain et du riz.",
                      Status.A_FAIRE
              );
            Todolist rapportMensuel = new Todolist(
                    "Finaliser le rapport mensuel",
                    "Compiler les statistiques de vente d’avril " +
                            "et envoyer le rapport à la direction.",
                    Status.EN_COURS
            );
            Todolist nettoyerCuisine = new Todolist(
                    "Nettoyer la cuisine",
                    " Vider le lave-vaisselle, nettoyer les plans de travail " +
                            "et sortir les poubelles.",
                    Status.TERMINE
            );
            Todolist reviser = new Todolist(
                    "Réviser le cours de Java",
                    " Refaire les exercices sur les classes, " +
                            "les interfaces et les collections.",
                    Status.A_FAIRE
            );
            Todolist appelMedecin = new Todolist(
                    "Réviser le cours de Java",
                    " Prendre rendez-vous pour un bilan de santé annuel.",
                    Status.EN_COURS
            );
            Todolist deployer = new Todolist(
                    "Déployer la version 1.2 de l’application",
                    "Vérifier les tests, mettre à jour les dépendances, " +
                            "puis faire le déploiement en production.",
                    Status.TERMINE
            );
            todolistRepository.saveAll(List.of(achat, rapportMensuel,nettoyerCuisine,
                    reviser,appelMedecin, deployer));
        };
    }
}
