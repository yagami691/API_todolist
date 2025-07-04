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
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Todolist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Todolist() {
      
    }

    public Todolist(String title, String description, Status status){
        this.title = title;
        this.description = description;
        this.status = status;
    }


}
