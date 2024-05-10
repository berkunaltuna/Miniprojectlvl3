//import Java.util.Random;
public class Villager extends Character
{
    private Food food;
    private int randomnumber;
    
    //The constructor for the subclass Villager.
    //The purpose of the Villager class is to trade food for money with the player.
    //There are 3 types of food available; low energy food, moderate energy food, high energy food.
    //A villager can only have one type of food 
    public Villager(Location location)
    {
        super(location);
        randomnumber = (int)(Math.random()*10);
        this.food = new Food();
        
        if (randomnumber<2) {
            int p = food.getPrice("low");
            this.food = new Food("low", p);
        }
        else if(randomnumber<5) {
            int p = food.getPrice("moderate");
            this.food = new Food("moderate", p);
        }
        else {
            int p = food.getPrice("high");
            this.food = new Food("high", p);
        }
    }

    //The villager gets and returns the price for the types of food from the class Food.
    public int getPriceVillager() {
        return food.getPrice(food.getEnergyLevel());
    }
    
    //The villager gets and returns the strength modifier for the types of food from the class Food.
    public int getStrengthModifierVillager() {
        return food.getStrengthModifier(food.getEnergyLevel());
    }
    
    //This is the method to print the name and properties of the villager character.
    public void printCharacter() {
        System.out.println("Hello my name is " + super.getName()+ " and I am a villager.");
        System.out.println("You can buy food from me to replenish your strength to defeat enemies.");
        System.out.println("My food is a " + food.getEnergyLevel() + " energy food. You can buy it at the price of: " + getPriceVillager());
        System.out.println("This food will increase your strength by " + getStrengthModifierVillager());
    }
}
