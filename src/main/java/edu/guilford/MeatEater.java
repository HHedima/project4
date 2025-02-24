package edu.guilford;

import java.util.ArrayList;
import java.util.Random;

public class MeatEater extends Critter {
    private Random rand = new Random();
    private ArrayList<PlantEater> food = new ArrayList<>();

    // constructor
    public MeatEater(double size, double growthRate, double foodNeed, ArrayList<PlantEater> food) {
        super(size, growthRate, foodNeed);
        this.food = food;
    }


    /*
     * Eats a plantEater
     * Cannot eat more than the amount of food still needed
     */
    public void chew(PlantEater plantEater) {
        double ChewAmount = (plantEater.getSize());
        double eating = 0;

        // if already full, dont eat
        if (stillNeed() <= 0) {
            return;
        }
        
        // cant eat more than needed
        ChewAmount = stillNeed();

        // exit if eating nothing
        if (ChewAmount <= 0) {
            return;
        }
        
        eating = ChewAmount;

        // cant eat if full
        if (eating > stillNeed()) {
            eating = stillNeed();
        }

        eat(eating);
        plantEater.chewedOn(eating);
    }

    // Simulates a day in the life of a meat eater
    @Override
    public void simulateDay() {

        // chase n plantEaters
        if (food.size() != 0) {
            for (int n = 0; n < 2; n++) {
                PlantEater plantEater = food.get(rand.nextInt(food.size()));
                // chance to catch a plantEater
                if (rand.nextDouble() < 0.50) {
                    chew(plantEater);
                    plantEater.die();
                }
            }
        }



        super.simulateDay();

        // update the amount of food still needed
        setFoodNeed(getSize() * 0.01);

    }

     // getters and setters
     public ArrayList<PlantEater> getFood() {
        return food;
    }

    public void setFood(ArrayList<PlantEater> food) {
        this.food = food;
    }

    @Override   
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PlantEater{");
        sb.append("size=").append(getSize());
        sb.append(", growthRate=").append(getGrowthRate());
        sb.append(", age=").append(getAge());
        sb.append(", alive=").append(isAlive());
        sb.append(", foodNeed=").append(getFoodNeed());
        sb.append("}");
        return sb.toString();
    }

}
