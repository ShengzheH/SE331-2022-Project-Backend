package se331.rest.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String name;
    String sur_name;
    String age;
    String hometown;
    @ElementCollection
    List<String> imageUrl;

    @OneToMany
    List<Patient> patients = new ArrayList<>();

    @OneToMany
    List<Comment> comments = new ArrayList<>();

}