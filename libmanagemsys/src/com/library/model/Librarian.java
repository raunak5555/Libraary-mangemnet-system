package com.library.model;

public class Librarian extends Person {

    public Librarian(int id, String name) {
        super(id, name);
    }

    @Override
    public void displayDetails() {
        System.out.println("Librarian ID: " + getId());
        System.out.println("Librarian Name: " + getName());
    }
}