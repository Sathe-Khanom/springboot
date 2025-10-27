package com.emranhss.dreamjob.dto;

import com.emranhss.dreamjob.entity.*;

import java.util.Date;
import java.util.List;

public class JobSeekerFullDTO {


    private Long id;
    private String name;
    private String email;
    private String phone;
    private String gender;
    private String address;
    private Date dateOfBirth;
    private String photo;

    private List<Education> educations;
    private List<Experience> experiences;
    private List<Skill> skills;
    private List<Training> trainings;
    private List<Extracurricular> extracurriculars;
    private List<Language> languages;
    private List<Hobby> hobbies;
    private List<Refference> references;
    private List<Summery> summeries;

    // constructor from JobSeeker entity
    public JobSeekerFullDTO(JobSeeker js) {
        this.id = js.getId();
        this.name = js.getName();
        this.email = js.getEmail();
        this.phone = js.getPhone();
        this.gender = js.getGender();
        this.address = js.getAddress();
        this.dateOfBirth = js.getDateOfBirth();
        this.photo = js.getPhoto();

        this.educations = js.getEducations();
        this.experiences = js.getExperiences();
        this.hobbies = js.getHobbies();
        this.skills = js.getSkills();
        this.trainings = js.getTrainings();
        this.extracurriculars = js.getExtracurriculars();
        this.languages = js.getLanguages();
        this.references = js.getRefferences();
        this.summeries = js.getSummery();


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

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
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

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public List<Refference> getReferences() {
        return references;
    }

    public void setReferences(List<Refference> references) {
        this.references = references;
    }

    public List<Summery> getSummeries() {
        return summeries;
    }

    public void setSummeries(List<Summery> summeries) {
        this.summeries = summeries;
    }
}
