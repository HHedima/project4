package edu.guilford;

public class Main {
    public static void main(String[] args) {
        Plant plant = new Plant(50, 0.1);
        PlantEater plantEater = new PlantEater(1, 0.1, 10);
        plantEater.chew(plant);
        System.out.println(plant);
    }
}