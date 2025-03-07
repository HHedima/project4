package edu.guilford;

import java.util.ArrayList;
import java.util.Random;


public class Test {
    public static void main(String[] args) {
        Random rand = new Random();

        // create 2000 plants
        ArrayList<Plant> plants = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            Double size = 300 + rand.nextDouble(-50, 50);
            plants.add(new Plant(size, 5));
        }

        // create 300 PlantEaters
        ArrayList<PlantEater> plantEaters = new ArrayList<>();
        for (int i = 0; i < 300; i++) {
            Double size = 1000 + rand.nextDouble(-100, 100);
            plantEaters.add(new PlantEater(size, 3, 50, plants));
        }

        // create 30 MeatEaters
        ArrayList<MeatEater> meatEaters = new ArrayList<>();    
        for (int i = 0; i < 30; i++) {
            Double size = 1000 + rand.nextDouble(-100, 100);
            meatEaters.add(new MeatEater(size, 3, 50, plantEaters));
        }

        // chance to add Plants
        double plantChance = 0.1;
        // chance to add PlantEaters
        double plantEaterChance = 0.7;
        // chance to add MeatEaters
        double meatEaterChance = 0.7;


        
        int day = 0;
        while (day < 1000 && stillAlive(meatEaters) && stillAlive(plantEaters))  {
            
            System.out.println("Day: " + day);

            // simulate a day for each PlantEater
            for (PlantEater eater : plantEaters) {
            if (eater.isAlive()) {
                eater.simulateDay();
            }
            }

            // simulate a day for each MeatEater
            for (MeatEater eater : meatEaters) {
            if (eater.isAlive()) {
                eater.simulateDay();
            }
            }

            // simulate a day for each Plant
            for (Plant plant : plants) {
            plant.simulateDay();
            }

            // chance to add a new Plant
            if (rand.nextDouble() < plantChance) {
            Double size = 300 + rand.nextDouble(-50, 50);
            plants.add(new Plant(size, 5));
            }

            // chance to add a new PlantEater
            if (rand.nextDouble() < plantEaterChance) {
            Double size = 1000 + rand.nextDouble(-100, 100);
            plantEaters.add(new PlantEater(size, 3, 50, plants));
            }

            // chance to add a new MeatEater
            if (rand.nextDouble() < meatEaterChance) {
            Double size = 1000 + rand.nextDouble(-100, 100);
            meatEaters.add(new MeatEater(size, 3, 50, plantEaters));
            }

            
            // remove dead PlantEaters
            int i = 0;
            while (i < plantEaters.size()) {
            if (!plantEaters.get(i).isAlive()) {
                plantEaters.remove(i);
            } else {
                i++;
            }
            }

            // remove dead MeatEaters
            i = 0;
            while (i < meatEaters.size()) {
            if (!meatEaters.get(i).isAlive()) {
                meatEaters.remove(i);
            } else {
                i++;
            }
            }

            day++;

            System.out.println("plants" + plants.size());
            System.out.println("plantEaters alive: " + plantEaters.size());
            System.out.println("meatEaters alive: " + meatEaters.size());
        }

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
