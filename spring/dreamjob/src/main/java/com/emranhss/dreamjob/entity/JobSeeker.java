package com.emranhss.dreamjob.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class JobSeeker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String gender;
    private String address;
    private Date dateOfBirth;
    private String photo;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Education> educations;


    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Refference> refferences;

    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Experience> experiences;

    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Hobby> hobbies;


    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Extracurricular> extracurriculars;

    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Language> languages;

    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Skill> skills;


    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Training> trainings;

    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Summery> summery;






    public JobSeeker() {

    }

    public JobSeeker(Long id, String name, String email, String phone, String gender, String address, Date dateOfBirth, String photo, User user) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.photo = photo;
        this.user = user;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }


    public List<Refference> getRefferences() {
        return refferences;
    }

    public void setRefferences(List<Refference> refferences) {
        this.refferences = refferences;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public List<Extracurricular> getExtracurriculars() {
        return extracurriculars;
    }

    public void setExtracurriculars(List<Extracurricular> extracurriculars) {
        this.extracurriculars = extracurriculars;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }

    public List<Summery> getSummery() {
        return summery;
    }

    public void setSummery(List<Summery> summery) {
        this.summery = summery;
    }
}
