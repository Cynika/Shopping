package com.tianmao.entity;

public class User {
    private String id;
    private String name;
    private String paassword;
    private String gender;
    private String Sbatch;

    public User(String id, String name, String paassword, String gender, String sbatch) {
        this.id = id;
        this.name = name;
        this.paassword = paassword;
        this.gender = gender;
        this.Sbatch = sbatch;
    }

    private String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPaassword() {
        return paassword;
    }

    public String getGender() {
        return gender;
    }

    public String getSbatch() {
        return Sbatch;
    }
}

