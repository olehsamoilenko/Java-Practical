package com.company;

public class Resident extends Man {
    private String address;
    private District district;

    public Resident(String name, String surname) {
        super(name, surname);
    }



    public String toString() {
        if (address != null) {
            return (String.format("Resident. Name: %s, Surname: %s, Address: %s, District: %s",
                    name, surname, address, district.getName()));
        }
        else {
            return (String.format("Resident. Name: %s, Surname: %s, Address: undefined, District: undefined",
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
