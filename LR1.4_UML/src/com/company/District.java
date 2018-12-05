package com.company;

public class District {
    private String name;
    private Inspector inspector;
    private Container residents = new Container("registrated residents");
    private boolean approved = false;

    public District(String name) {
        this.name = name;
    }

    public void addResident(Resident resident) {
        residents.add(resident);
    }

    public void removeResident(Resident resident) {
        residents.remove(resident);
    }

    public String getName() {
        return (name);
    }

    public String toString() {
        String res = String.format("District. Name: %s", name);

        if (approved) {
            res = String.format("%s, Approved: yes", res);
        }
        else {
            res = String.format("%s, Approved: no", res);
        }
        if (inspector != null) {
            res = String.format("%s, Inspector: %s %s",
                    res, inspector.getName(), inspector.getSurname());
        }
        else {
            res = String.format("%s, Inspector: undefined", res);
        }

        return (res);
    }

    public void approve() {
        approved = true;
    }

    public boolean getApproved() { return (approved); }
    public Inspector getInspector() {
        return (inspector);
    }
    public Container getResidents() { return (residents); }
    public void setName(String name) {
        this.name = name;
    }
    public void setInspector(Inspector inspector) {
        this.inspector = inspector;
    }
}
