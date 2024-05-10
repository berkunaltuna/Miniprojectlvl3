public class Food
{
    private String energy_level;
    private int price;
    
    //The constructor of the generic object Food.
    public Food() {
        this.energy_level = "";
        this.price = 0;
    }
    
    //This is the constructor which overloads the generic constructor above.
    //A type of food has an energy level and a price which is set
    public Food(String el, int p) {
        this.energy_level= el;
        this.price= p;
    }
    
    //This is the getter method for the strength modifier of the food.
    public int getStrengthModifier(String el) {
        if(el.equals("none")) {
            return 0;
        }
        else if(el.equals("low")) {
            return 10;        
        }
        else if(el.equals("moderate")) {
            return 20;
        }
        else if(el.equals("high")) {
            return 30;
        }
        else {
            return 0;
        }
    }
    
    //This is the getter method for the price of the food.
    public int getPrice(String el) {
        if(el.equals("none")) {
            return 0;
        }
        else if(el.equals("low")) {
            return 10;        
        }
        else if(el.equals("moderate")) {
            return 20;
        } 
        else if(el.equals("high")) {
            return 30;
        }
        else {
            return 0;
        }
    }
    
    //This is the getter method for the energy level of the food.
    public String getEnergyLevel() {
        return energy_level;
    }
}

