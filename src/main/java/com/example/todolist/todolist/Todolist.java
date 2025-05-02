//package com.example.todolist.todolist;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Entity
//@Table
//@Getter
//@Setter
//@NoArgsConstructor
//
//public class Todolist {
//    @Id
//    @SequenceGenerator(
//            name  = "todolist_sequence",
//            sequenceName = "todolist_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "todolist_sequence"
//    )
//     private Long id;
//     private String title;
//     private String description;
//     private String status;
//
//
//     public Todolist(String title, String description, String status){
//         this.title= title;
//         this.description= description;
//         this.status = status;
//     }
//
//
//}
//

package com.example.todolist.todolist;

import jakarta.persistence.*;


@Entity
@Table
public class Todolist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Todolist() {
      
    }

    public Todolist(String titre, String description, Status status){
        this.titre = titre;
        this.description = description;
        this.status = status;
    }

    public Todolist(Long id, String titre, String description, Status status) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.status = status;
    }

    // Getters et setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
