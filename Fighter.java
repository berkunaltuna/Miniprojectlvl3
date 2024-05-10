public class Fighter extends Character
{
    private int money;
    private int strength;
    private String weapon_type;
    
    //The constructor of the subclass Fighter which extends Character.
    //It initialize the super constructor and the other instance variables.
    public Fighter(Location location, int m, int s, String wt) {
        super(location);
        this.money = m;
        this.strength = s;
        this.weapon_type = wt;
    }
    
    //The methods that decreases/increases a Fighters money/strength by amount m.
    //If the fighter doesn't have less than m units of money his balance is set to zero.
    public void decreaseMoney(int m) {
        if(this.money<m) {
            this.money = 0;
        }
        else {
            this.money -= m;
        }
    }

    public void increaseMoney(int m) {
        this.money += m;
    }
    
    //Strength cannot be decreased below 0 so if a Fighter reaches 0 strength the method sets its status as "dead". 
    public void decreaseStrength(int s) {
        if(this.strength<s) {
            this.strength = 0;
            super.setStatus("dead");
        }
        else {
            this.strength -= s;
        }
        if(this.strength <= 0) {
            super.setStatus("dead");
        }
    }
    
    public void increaseStrength(int s) {
        this.strength += s;
    }
    
    //The getter methods and print methods for the instance variables of the Fighter class.
    public String getWeaponType() {
        return this.weapon_type;
    }
    
    public int getMoney() {
        return money;
    }
    
    public int getStrength() {
        return strength;
    }
    
    public void setStrength(int s) {
        this.strength = s;
    }
    
    public void printStrength() {
        System.out.println("The strength = " + getStrength());
    }
    
    public void printMoney() {
        System.out.println("Your balance is " + getMoney());
    }
    
    public void printLocation() {
        System.out.println("Your x coordinate is " + getLocationX() + " Your y coordinate is " + getLocationY());
    }
    
    public void printAll() {
        System.out.println("Strength: "+ getStrength() + " Balance: " + getMoney());
    }
    
    //This is the method to print the name and properties of the fighter character.
    public void printCharacter() {
        System.out.println("Hello my name is " + super.getName()+ " and I am a fighter.");
        System.out.println("My weapon is: " + getWeaponType() + " My status is: " + super.getStatus());
        System.out.println("My strength is: " + getStrength() + " I have " + getMoney() + " units of money.");
    }
}
