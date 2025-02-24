# UML Diagram

## Creature

    - size: double
    - growthRate: double
    - alive: boolean
    - age: int
    - lifeSpan: int
    - rand: Random
    
    + Creature(size: double, growthRate: double)
    + changeSize(amount: double): void
    + simulateDay(): void
    + die(): void
    + getSize(): double
    + getGrowthRate(): double
    + isAlive(): boolean
    + getAge(): int
    + getLifeSpan(): int
    + setGrowthRate(newGrowthRate: double): void
    + setSize(newSize: double): void
    + setLifeSpan(newLifeSpan: int): void
    + toString(): String

## Critter

    - foodNeed: double
    - foodEaten: double
    
    + Critter(size: double, growthRate: double, foodNeed: double)
    + Critter()
    + simulateDay(): void
    + eat(food: double): void
    + getFoodNeed(): double
    + setFoodNeed(foodNeed: double): void
    + stillNeed(): double
    + getFoodEaten(): double
    + setFoodEaten(foodEaten: double): void
    + toString(): String

Critter extends Creature

## MeatEater 

    - rand: Random
    - food: ArrayList<PlantEater>
    
    + MeatEater(size: double, growthRate: double, foodNeed: double, food: ArrayList<PlantEater>)
    + chew(plantEater: PlantEater): void
    + simulateDay(): void
    + getFood(): ArrayList<PlantEater>
    + setFood(food: ArrayList<PlantEater>): void
    + toString(): String

MeatEater extends Critter

## Plant 

    + Plant(size: double, growthRate: double)
    + chewedOn(amount: double): void
    + toString(): String

Plant extends Creature

## PlantEater

    - rand: Random
    - food: ArrayList<Plant>
    
    + PlantEater(size: double, growthRate: double, foodNeed: double, food: ArrayList<Plant>)
    + chewedOn(amount: double): void
    + chew(plant: Plant): void
    + simulateDay(): void
    + getFood(): ArrayList<Plant>
    + setFood(food: ArrayList<Plant>): void
    + toString(): String

PlantEater extends Critter