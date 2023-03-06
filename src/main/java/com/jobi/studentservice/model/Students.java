package com.jobi.studentservice.model;
import jakarta.persistence.*;
// We can avoid all the getter and setter methods by using 2 annotations @Data, @Getter and @Setter, which will replace almost 30 lines of code here.
@Entity
@Table(name="students_db")

public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;
    @Column
    private String email;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String course;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
