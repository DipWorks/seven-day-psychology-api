package com.bhandari.sevendaypsychology.counsellor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Counsellor {
    @Id
    @SequenceGenerator(
            name="counsellor_sequence",
            sequenceName="counsellor_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "counsellor_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;
    private String education;

    public Counsellor() {
    }

    public Counsellor(Long id,
                      String name,
                      String email,
                      LocalDate dob,
                      String education) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.education = education;
    }

    public Counsellor(String name,
                      String email,
                      LocalDate dob,
                      String education) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.education = education;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {

        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Councellor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                ", education='" + education + '\'' +
                '}';
    }
}
