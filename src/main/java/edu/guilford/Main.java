package edu.guilford;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        // Test 1

        // create 2000 plants
        ArrayList<Plant> plants = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            Double size = 300 + rand.nextDouble(-50, 50);
            plants.add(new Plant(size, 5));
        }
        
        // create one plantEater
        PlantEater plantEater = new PlantEater(1000 + rand.nextDouble(-100, 100), 3, 50, plants);

        // testing simulateDay
        // if the chew method is working, the plantEater should be full after the first day and plant mass should reduce by the same amount
        // The total mass of plants should be reduced by the amount eaten by the plantEater (50)
        // simulateDay also has all the other methods from PlantEater and its parent classes
        System.out.println(plantEater);
        double before = totalMass(plants);
        System.out.println("Total mass of plants: " + totalMass(plants));
        plantEater.simulateDay();
        System.out.println(plantEater);
        System.out.println("Total mass of plants: " + totalMass(plants));
        System.out.println("Total mass of plants reduced by " + (before - totalMass(plants)));


    }

    /**
     * Checks if there are any creatures in the list that are still alive.
     *
     * @param creatures an ArrayList of objects that extend the Creature class
     * @return true if at least one creature in the list is alive, false otherwise
     */
    public static boolean stillAlive(ArrayList<? extends Creature> creatures) {
        for (Creature creature : creatures) {
            if (creature.isAlive()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Calculates the total mass of a list of creatures.
     *
     * @param creatures an ArrayList of objects that extend the Creature class
     * @return the total mass of all the creatures in the list
     */
    public static double totalMass(ArrayList<? extends Creature> creatures) {
        double totalMass = 0;
        for (Creature creature : creatures) {
            totalMass += creature.getSize();
        }
        return totalMass;

    }
}