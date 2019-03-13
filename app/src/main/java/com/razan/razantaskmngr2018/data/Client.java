package com.razan.razantaskmngr2018.data;

public class Client {
    private int number;
    private int visa;
    private String name;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getVisa() {
        return visa;
    }

    public void setVisa(int visa) {
        this.visa = visa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "number=" + number +
                ", visa=" + visa +
                ", name='" + name + '\'' +
                '}';
    }
}
