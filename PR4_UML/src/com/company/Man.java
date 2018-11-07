package com.company;

public abstract class Man {
    protected String name;
    protected String surname;
    protected Container applications = new Container("applications");

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



    public void makeApplication(Man to, String message) {
        to.addApplication(new Application(message, this));
    }
    public void addApplication(Application application) {
        applications.add(application);
    }
    public void showApplications() {
        applications.show();
    }


}
