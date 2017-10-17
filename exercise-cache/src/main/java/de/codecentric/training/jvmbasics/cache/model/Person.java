package de.codecentric.training.jvmbasics.cache.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Person{
    private Long id;
    private String name;
    private String surName;
    private byte[] profilePhoto = new byte[10000];

    public Person(Long id, String name, String surName) {
        this.id = id;
        this.name = name;
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @JsonIgnore
    public byte[] getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(byte[] profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
