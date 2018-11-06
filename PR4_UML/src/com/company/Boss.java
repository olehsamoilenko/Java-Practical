package com.company;

import java.util.Scanner;

public class Boss extends Man {

    private Container districts = new Container("approved districts");

    public Boss(String name, String surname) {
        super(name, surname);
    }

    public void approveDistrict(District district) {
        districts.add(district);
        district.approve();
    }

    public void distributeDistrict(District district, Inspector inspector) {
        if (district.getApproved()) {
            inspector.setDistrict(district);
            district.setInspector(inspector);
            System.out.println("District distributing done");
        }
        else {
            System.out.println("District is not distributed. It's not approved");
        }

    }

    public String toString() {
        String dist = "";
        int i = -1;
        while (++i < districts.length()) {
            if (i != 0) {
                dist += ", ";
            }
            dist += ((Boss)districts.get(i)).getName();

        }
        if (dist == "") {
            dist = "undefined";
        }
        return(String.format("Boss. Name: %s, Surname: %s, Districts: %s",
                name, surname, dist));
    }

    public Container getDistricts() {
        return (districts);
    }
}
