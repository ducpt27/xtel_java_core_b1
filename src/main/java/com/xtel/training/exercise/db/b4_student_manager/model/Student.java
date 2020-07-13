package com.xtel.training.exercise.db.b4_student_manager.model;

public class Student {

    private Integer id;

    private String fullName;

    private Integer age;

    private Boolean gender;

    private String homeTown;

    public Student(Integer id, String fullName, Integer age, Boolean gender, String homeTown) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.homeTown = homeTown;
    }

    public Student(Integer id) {
        this.id = id;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }
}
