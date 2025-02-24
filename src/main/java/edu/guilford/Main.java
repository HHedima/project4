package edu.guilford;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        // Test 1
        System.out.println("Test 1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // create 2000 plants
        ArrayList<Plant> plants = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            Double size = 300 + rand.nextDouble(-50, 50);
            plants.add(new Plant(size, 5));

            //  make plants live longer
            plants.get(i).setLifeSpan(10000);
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

        // Test 2
        System.out.println("Test 2");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // create 300 PlantEaters
        ArrayList<PlantEater> plantEaters = new ArrayList<>();
        for (int i = 0; i < 300; i++) {
            Double size = 1000 + rand.nextDouble(-100, 100);
            plantEaters.add(new PlantEater(size, 3, 50, plants));

            //  make plantEaters live longer
            plantEaters.get(i).setLifeSpan(10000);
        }

        // runs as long as there are still PlantEaters alive
        int day = 0;
        while (stillAlive(plantEaters) && day < 1000) {

            // simulate a day for each PlantEater
            for (PlantEater eater : plantEaters) {
            if (eater.isAlive()) {
                eater.simulateDay();
            }
            }

            // simulate a day for each Plant
            for (Plant plant : plants) {
                plant.simulateDay();
            }

            // 5% chance to add a new Plant
            if (rand.nextDouble() < 0.05) {
            Double size = 300 + rand.nextDouble(-50, 50);
            plants.add(new Plant(size, 5));
            }

            // 30% chance to add a new PlantEater
            if (rand.nextDouble() < 0.3) {
            Double size = 1000 + rand.nextDouble(-100, 100);
            plantEaters.add(new PlantEater(size, 3, 50, plants));
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

            // remove dead Plants
            i = 0;
            while (i < plants.size()) {
                if (!plants.get(i).isAlive()) {
                    plants.remove(i);
                } else {
                    i++;
                }
            }

            day++;
            System.out.println("Day " + day);
            System.out.println("Total mass of plants: " + totalMass(plants));
            long plantAliveCount = plants.stream().filter(Plant::isAlive).count();
            System.out.println("Total number of plants: " + plantAliveCount);
            System.out.println("Total mass of PlantEaters: " + totalMass(plantEaters));
            long plantEaterAliveCount = plantEaters.stream().filter(PlantEater::isAlive).count();
            System.out.println("Total number of PlantEaters alive: " + plantEaterAliveCount);

            
        }

        // Test 3
        System.out.println("Test 3");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // create 2000 plants
        ArrayList<Plant> plants2 = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            Double size = 300 + rand.nextDouble(-50, 50);
            plants2.add(new Plant(size, 5));

            // plants lifeSpan
            plants2.get(i).setLifeSpan(10000);
        }

        // create 300 PlantEaters
        ArrayList<PlantEater> plantEaters2 = new ArrayList<>();
        for (int i = 0; i < 300; i++) {
            Double size = 1000 + rand.nextDouble(-100, 100);
            plantEaters2.add(new PlantEater(size, 3, 50, plants2));

            // plantEaters lifeSpan
            plantEaters2.get(i).setLifeSpan(10000);
        }

        // create 10 MeatEaters
        ArrayList<MeatEater> meatEaters = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Double size = 1000 + rand.nextDouble(-100, 100);
            meatEaters.add(new MeatEater(size, 3, 50, plantEaters2));

            // meatEaters lifeSpan
            meatEaters.get(i).setLifeSpan(10000);
        }

        // runs as long as there are still PlantEaters or MeatEaters alive
        int day2 = 0;

        while (day2 < 1000 && stillAlive(meatEaters) && stillAlive(plantEaters2))  {
            
            // simulate a day for each PlantEater
            for (PlantEater eater : plantEaters2) {
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
            for (Plant plant : plants2) {
            plant.simulateDay();
            }

            // 5% chance to add a new Plant
            if (rand.nextDouble() < 0.05) {
            Double size = 300 + rand.nextDouble(-50, 50);
            plants2.add(new Plant(size, 5));
            }

            // 30% chance to add a new PlantEater
            if (rand.nextDouble() < 0.4) {
            Double size = 1000 + rand.nextDouble(-100, 100);
            plantEaters2.add(new PlantEater(size, 3, 50, plants2));
            }

            // 70% chance to add a new MeatEater
            if (rand.nextDouble() < 0.7) {
            Double size = 1000 + rand.nextDouble(-100, 100);
            meatEaters.add(new MeatEater(size, 3, 50, plantEaters2));
            }

            // remove dead PlantEaters
            int i = 0;
            while (i < plantEaters2.size()) {
            if (!plantEaters2.get(i).isAlive()) {
                plantEaters2.remove(i);
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

            // remove dead Plants
            i = 0;
            while (i < plants2.size()) {
            if (!plants2.get(i).isAlive()) {
                plants2.remove(i);
            } else {
                i++;
            }
            }

            day2++;
            System.out.println("Day " + day2);
            System.out.println("Total mass of plants: " + totalMass(plants2));
            long plantAliveCount = plants2.stream().filter(Plant::isAlive).count();
            System.out.println("Total number of plants: " + plantAliveCount);
            System.out.println("Total mass of PlantEaters: " + totalMass(plantEaters2));
            long plantEaterAliveCount = plantEaters2.stream().filter(PlantEater::isAlive).count();
            System.out.println("Total number of PlantEaters alive: " + plantEaterAliveCount);
            System.out.println("Total mass of MeatEaters: " + totalMass(meatEaters));
            long meatEaterAliveCount = meatEaters.stream().filter(MeatEater::isAlive).count();
            System.out.println("Total number of MeatEaters alive: " + meatEaterAliveCount);


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