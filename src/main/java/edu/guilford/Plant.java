package edu.guilford;

public class Plant extends Creature {

    // constructor
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
