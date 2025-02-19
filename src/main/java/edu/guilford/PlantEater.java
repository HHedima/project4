package edu.guilford;

import java.util.ArrayList;
import java.util.Random;

public class PlantEater extends Critter {
    private Random rand = new Random();
    private ArrayList<Plant> food;

    // constructor
    public PlantEater(double size, double growthRate, double foodNeed) {
        super(size, growthRate, foodNeed);
    }

    /*
     * Eats a plant
     * Cannot eat more than half the size of the plant
     * Cannot eat more than the amount of food still needed
     */
    public void chew(Plant plant) {
        // the maximum amount of food that can be eaten is half the size of the plant
        double maxChewAmount = plant.getSize() / 2;
        // the maximum amount of food that can be eaten is the amount of food still needed
        if (maxChewAmount > stillNeed()) {
            maxChewAmount = stillNeed();
        }
        // the minimum amount of food that can be eaten is 10% of the food needed
        double minChewAmount = getFoodNeed() * 0.1;
        if (minChewAmount > maxChewAmount) {
            return;
        }

        // cant eat nothing
        if (maxChewAmount <= 0) {
            return;
        }
        double eating = rand.nextDouble(minChewAmount, maxChewAmount);
        eat(eating);
        plant.chewedOn(eating);
    }

    // Simulates a day in the life of a plant eater
    @Override
    public void SimulateDay() {
        
    }

    // getters and setters
    public ArrayList<Plant> getFood() {
        return food;
    }

    public void setFood(ArrayList<Plant> food) {
        this.food = food;
    }

    // toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Critter{");
        sb.append("size=").append(getSize());
        sb.append(", growthRate=").append(getGrowthRate());
        sb.append(", age=").append(getAge());
        sb.append(", alive=").append(isAlive());
        sb.append(", foodNeed=").append(getFoodNeed());
        sb.append(", foodEaten=").append(getFoodEaten());
        sb.append(", food=").append(food);
        sb.append('}');
        return sb.toString();
    }

}
