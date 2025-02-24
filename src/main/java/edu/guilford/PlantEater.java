package edu.guilford;

import java.util.ArrayList;
import java.util.Random;

public class PlantEater extends Critter {
    private Random rand = new Random();
    private ArrayList<Plant> food = new ArrayList<>();

    // constructor
    public PlantEater(double size, double growthRate, double foodNeed, ArrayList<Plant> food) {
        super(size, growthRate, foodNeed);
        this.food = food;
    }

    /*
     * Eats a plant
     * Cannot eat more than half the size of the plant
     * Cannot eat more than the amount of food still needed
     */
    public void chew(Plant plant) {
        double minChewAmount = (stillNeed() * 0.1);
        double maxChewAmount = (plant.getSize() * 0.5);
        double eating = 0;

        // if already full, dont eat
        if (stillNeed() <= 0) {
            return;
        }

        // min cant be greater than max
        if (minChewAmount > maxChewAmount) {
            minChewAmount = maxChewAmount;
        }

        // cant eat more than needed
        if (minChewAmount > stillNeed() || maxChewAmount > stillNeed()) {
            minChewAmount = stillNeed();
        }

        // exit if eating nothing
        if (maxChewAmount <= 0) {
            return;
        }
        eating = rand.nextDouble(minChewAmount, maxChewAmount);

        // cant eat if full
        if (eating > stillNeed()) {
            eating = stillNeed();
        }

        eat(eating);
        plant.chewedOn(eating);
    }

    // Simulates a day in the life of a plant eater
    
    /**
     * Simulates a day in the life of a PlantEater.
     * The PlantEater will chew a random amount of food within a specified range.
     * The range is determined by the size of the food list.
     * After chewing, it prints out the amount of food still needed.
     * Finally, it calls the simulateDay method from the superclass.
     */
    public void simulateDay() {
            double minChewAmount = food.size() * 0.005;
            double maxChewAmount = food.size() * 0.02;
            double chewAmount = (int) rand.nextDouble(minChewAmount, maxChewAmount);
            for (int i = 0; i < chewAmount; i++) {
                chew(food.get(rand.nextInt(food.size())));
            }
            System.out.println("Still need: " + stillNeed());
        super.simulateDay();
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
        sb.append("}");
        return sb.toString();
    }

}
