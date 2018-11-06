package com.company;

public class Resident extends Man {
    private String address;
    private District district;

    public Resident(String name, String surname) {
        super(name, surname);
    }

    public void makeApplication(String message) {
        System.out.println(String.format("Application to %s %s from %s district:\n%s.",
                district.getInspector().getName(), district.getInspector().getSurname(),
                district.getInspector().getDistrict().getName(), message));
    }

    public String toString() {
        if (address != null) {
            return (String.format("Resident. Name: %s, Surname: %s, Address: %s, District: %s",
                    name, surname, address, district.getName()));
        }
        else {
            return (String.format("Resident. Name: %s, Surname: %s, Address: undefined",
                    name, surname));
        }
    }

    public String getAddress() {
        return (address);
    }
    public District getDistrict() {
        return (district);
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void setDistrict(District district) {
        this.district = district;
    }

}
