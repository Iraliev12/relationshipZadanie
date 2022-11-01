package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "schools")
@Getter
@Setter
@NoArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String schoolName;
    private int schoolnumber;
    @ManyToMany(
            fetch = FetchType.EAGER)
    @JoinTable(name = "schools_students",
            joinColumns = @JoinColumn(name = "school_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id",referencedColumnName = "id"))
    private List<Student> schools = new ArrayList();

    public School(String schoolName, int schoolnumber) {
        this.schoolName = schoolName;
        this.schoolnumber = schoolnumber;
    }
    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", schoolName='" + schoolName + '\'' +
                ", schoolnumber=" + schoolnumber +
                '}';
    }
}
