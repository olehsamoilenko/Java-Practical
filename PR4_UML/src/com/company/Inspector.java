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
            System.out.println("Registration is not completed. There is a problem with the ispector's district");
        }
    }

    public void removeRegistration(Resident resident) {
        resident.setAddress(null);
        district.removeResident(resident);
    }

    public void showResidents() {
        Container residents = district.getResidents();
        int i = -1;
        while (++i < residents.length()) {
            System.out.println(residents.get(i).toString());
        }
    }

    public void makeQuery(Resident resident, String message) {
        System.out.println(String.format("Query to %s %s from %s %s:\n%s",
                resident.getName(), resident.getSurname(),
                name, surname, message));
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
