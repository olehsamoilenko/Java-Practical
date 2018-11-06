package com.company;

public abstract class Man {
    protected String name;
    protected String surname;

    public Man(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return (name);
    }
    public String getSurname() {
        return (surname);
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }


}
