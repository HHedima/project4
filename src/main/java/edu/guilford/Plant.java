package edu.guilford;

public class Plant extends Creature {

    /**
     * Constructs a new Plant object with the specified size and growth rate.
     *
     * @param size the size of the plant
     * @param growthRate the growth rate of the plant
     */
    public Plant(double size, double growthRate) {
        super(size, growthRate);
    }

    /**
     * The size of the plant is decreased by an ammount 
     */
    public void chewedOn(double ammount) {
        changeSize(-ammount);
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
