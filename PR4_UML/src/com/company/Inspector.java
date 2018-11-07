package com.company;

public class Inspector extends Man {
    private District district;

    public Inspector(String name, String surname) {
        super(name, surname);
    }

    public void createRegistration(Resident resident, String address) {
        if (district != null) {
            resident.setAddress(address);
            district.addResident(resident);
            resident.setDistrict(district);
            System.out.println("Registration done");
        }
        else {
            System.out.println("Registration is not completed. There is a problem with the inspector's district");
        }
    }

    public void removeRegistration(Resident resident) {
        resident.setAddress(null);
        district.removeResident(resident);
        System.out.println("Registration removed");
    }





    public String toString() {
        if (district != null) {
            return (String.format("Inspector. Name: %s, Surname: %s, District: %s",
                    name, surname, district.getName()));
        }
        else {
            return (String.format("Inspector. Name: %s, Surname: %s, District: undefined",
                    name, surname));
        }
    }

    public District getDistrict() {
        return (district);
    }
    public void setDistrict(District district) {
        this.district = district;
    }
}
