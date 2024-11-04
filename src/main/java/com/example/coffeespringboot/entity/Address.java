package com.example.coffeespringboot.entity;

import java.io.Serializable;

public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

    private String streetName;

    public Address() {

    }

    public Address(int id, String streetName) {
        this.id = id;
        this.streetName = streetName;
    }

    public int getId() {
        return id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
}
