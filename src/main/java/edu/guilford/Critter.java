package edu.guilford;

public abstract class Critter extends Creature {
    private double foodNeed = 1;
    private double foodEaten = 0;

    // constructor
    public Critter(double size, double growthRate, double foodNeed) {
        super(size, growthRate);
        this.foodNeed = foodNeed;
    }

    public Critter() {
        super(1, 0.1);
        foodNeed = 1;
    }

    /**
     * Critter dies if the amount of food eaten is less than the food needed
     * @return
     */
    @Override
    public void SimulateDay() {
        if (foodEaten < foodNeed) {
            die();
        } else {
            foodEaten = 0;
        }
    }

    /**
     * Allows the critter to eat food
     * @return
     */
    public void eat(double food) {
        foodEaten += food;
    }


    // getters and setters
    public double getFoodNeed() {
        return foodNeed;
    }

    public void setFoodNeed(double foodNeed) {
        this.foodNeed = foodNeed;
    }

    public double stillNeed() {
        return foodNeed - foodEaten;
    }

    public double getFoodEaten() {
        return foodEaten;
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
            sb.append('}');
            return sb.toString();
        }
}
