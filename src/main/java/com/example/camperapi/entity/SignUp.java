package com.example.camperapi.entity;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data

 public class SignUp {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @ManyToOne
   @JoinColumn(name = "camper_id")
   private Camper camper;

   @ManyToOne
   @JoinColumn(name = "activity_id")
   private Activity activity;

   private Integer time;


   public SignUp() {
   }
   public SignUp(Long id, Camper camper, Activity activity, Integer time) {
      this.id = id;
      this.camper = camper;
      this.activity = activity;
      this.time = time;

   }
}


