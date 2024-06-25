package ait.cars.test;

import ait.cars.dao.Garage;
import ait.cars.dao.GarageCopyImpl;
import ait.cars.model.Car;

import static org.junit.jupiter.api.Assertions.*;

class GarageTest {
    Garage garage;
    Car[] cars;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        garage = new GarageCopyImpl(6);
        cars = new Car[5];
        cars[0] = new Car("AA777BB", "Touran", "Volkswagen", 2.0, "Black");
        cars[1] = new Car("CC888DD", "Passat", "Volkswagen", 1.8, "blue");
        cars[2] = new Car("EE555FF", "GLC", "Mercedes", 2.2, "white");
        cars[3] = new Car("GG222XX", "A4", "Audi", 2.0, "red");
        cars[4] = new Car("II333KK", "A3", "Audi", 1.8, "Black");
        for (int i = 0; i < cars.length; i++) {
            garage.addCar(cars[i]);
        }
    }

    @org.junit.jupiter.api.Test
    void addCar() {
        assertFalse(garage.addCar(cars[3]));
        assertFalse(garage.addCar(null));
        Car car = new Car("GG999XX", "A4", "Audi", 2.0, "red");
        assertTrue(garage.addCar(car));
        car = new Car("II000KK", "A3", "Audi", 1.8, "Black");
        assertFalse(garage.addCar(car));
    }

    @org.junit.jupiter.api.Test
    void removeCar() {
        Car car = garage.removeCar("CC888DD");
        assertEquals(cars[1], car);
        assertNull(garage.removeCar("CC888DD"));
        assertEquals(cars[2], garage.removeCar(new String("EE555FF")));
    }

    @org.junit.jupiter.api.Test
    void findCarsByRegNumber() {
        assertEquals(cars[4], garage.findCarByRegNumber("II333KK"));
        assertNull(garage.findCarByRegNumber("SS000SS"));
        assertEquals(cars[4], garage.findCarByRegNumber(new String("II333KK")));
    }

    @org.junit.jupiter.api.Test
    void findCarsByModel() {
        Car[] actual = garage.findCarsByModel("Passat");
        Car[] expected = {cars[1]};
        assertArrayEquals(expected, actual);
        Car[] actual1 = garage.findCarsByModel("Lanos");
        Car[] expected1 = new Car[0];
        assertArrayEquals(expected1, actual1);
    }

    @org.junit.jupiter.api.Test
    void findCarsByCompany() {
        Car[] actual = garage.findCarsByCompany("Volkswagen");
        Car[] expected = {cars[0], cars[1]};
        assertArrayEquals(expected, actual);
        Car[] actual1 = garage.findCarsByModel("Daewoo");
        Car[] expected1 = new Car[0];
        assertArrayEquals(expected1, actual1);
    }

    @org.junit.jupiter.api.Test
    void findCarsByEngine() {
        Car[] actual = garage.findCarsByEngine(1.8, 2.1);
        Car[] expected = {cars[0], cars[1], cars[3], cars[4]};
        assertArrayEquals(expected, actual);
        Car[] actual1 = garage.findCarsByEngine(1.0, 1.5);
        Car[] expected1 = new Car[0];
        assertArrayEquals(expected1, actual1);
    }

    @org.junit.jupiter.api.Test
    void findCarsByColor() {
        Car[] actual = garage.findCarsByColor("Black");
        Car[] expected = {cars[0], cars[4]};
        assertArrayEquals(expected, actual);
        Car[] actual1 = garage.findCarsByColor("Pink");
        Car[] expected1 = new Car[0];
        assertArrayEquals(expected1, actual1);
    }
}