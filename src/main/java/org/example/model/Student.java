package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "students")
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String First_name;
     private String Last_Name;
    @ManyToMany(
            fetch = FetchType.EAGER)
    @JoinTable(name = "schools_students",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "school_id",referencedColumnName = "id"))
    private List<School> schools = new ArrayList();
    public Student(String first_name, String last_Name) {
        First_name = first_name;
        Last_Name = last_Name;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", First_name='" + First_name + '\'' +
                ", Last_Name='" + Last_Name + '\'' +
                '}';
    }
}
