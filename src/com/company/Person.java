package com.company;

public abstract class Person {

    private String name;
    private Roles role;
    private int pin;

    public Person(String name, Roles role, int pin) {
        this.name = name;
        this.role = role;
        this.pin = pin;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", role=" + role +
                ", pin=" + pin +
                '}';
    }
}
