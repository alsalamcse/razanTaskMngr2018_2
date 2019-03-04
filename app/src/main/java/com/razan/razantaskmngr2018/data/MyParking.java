package com.razan.razantaskmngr2018.data;

public class MyParking {
    private String id;
    private String name;
    private String address;
    private double cost;
    private String code;



    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public double getCost() {
        return cost;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
