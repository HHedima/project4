package edu.guilford;

import java.util.Random;

public abstract class Creature {
    private double size = 1.0;
    private double growthRate = 0.1;
    private boolean alive = true;
    private int age = 0;
    private int lifeSpan = 100;
    private Random rand = new Random();

    // constructor
    public Creature(double size, double growthRate) {
        this.size = size;
        this.growthRate = growthRate;
    }

    /**
     * Changes the size of the Creature 
     * if size is less than or equal to 0, call the die method
     * @return
     */
    public void changeSize(double amount) {
        size += amount;
        if (size <= 0) {
            die();
        }
    }

    /**
     * Simulates a day in the life of a creature
     * @return
     */
    public void simulateDay() {
        age++;
        if (age > lifeSpan) {
            if (rand.nextDouble() < 0.1) {
                die();
            }
        }
        changeSize(growthRate);
    }

    /**
     * Kills the creature
     * @return
     */
    public void die() {
        alive = false;
        size = 0;
        growthRate = 0;
    }


    // getters
    public double getSize() {
        return size;
    }

    public double getGrowthRate() {
        return growthRate;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getAge() {
        return age;
    }

    public int getLifeSpan() {
        return lifeSpan;
    }

    // setters
    public void setGrowthRate(double newGrowthRate) {
        this.growthRate = newGrowthRate;
    }

    public void setSize(double newSize) {
        this.size = newSize;
    }

    public void setLifeSpan(int newLifeSpan) {
        this.lifeSpan = newLifeSpan;
    }

        // toString
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Plant{");
            sb.append("size=").append(getSize());
            sb.append(", growthRate=").append(getGrowthRate());
            sb.append(", age=").append(getAge());
            sb.append(", alive=").append(isAlive());
            sb.append('}');
            return sb.toString();
        }

}
