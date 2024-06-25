package ait.cars.model;

import java.util.Comparator;

public class Car {
    private String regNumber;
    private String model;
    private String company;
    private double eingine;
    private String color;

    public Car(String regNumber, String model, String company, double eingine, String color) {
        this.regNumber = regNumber;
        this.model = model;
        this.company = company;
        this.eingine = eingine;
        this.color = color;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getModel() {
        return model;
    }

    public String getCompany() {
        return company;
    }

    public double getEingine() {
        return eingine;
    }

    public String getColor() {
        return color;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("regNumber='").append(regNumber).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", company='").append(company).append('\'');
        sb.append(", eingine=").append(eingine);
        sb.append(", color='").append(color).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public final boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Car car)) return false;

        return regNumber.equals(car.regNumber);
    }

    @Override
    public int hashCode() {
        return regNumber.hashCode();
    }

}
