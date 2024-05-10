

public class Player extends Fighter
{
    private boolean change_location;
    
    //The constructor of the subclass Player which extends Fighter.
    //It initialize the super constructor and the other instance variables.
    public Player(Location location, int m, int s, String wt) {
        super(location,m,s,wt);
        this.change_location = true;
    }
    
    //This method overrides the move method of the superclass Character.
    //The player can move one cell at a time, i.e. player can move to the cell on the left(west), on the right(east), 
    //to the cell above (north) or to the cell below (south)
    //the move cannot be executed if the new x or y coordinate is out of bounds.
    public boolean move(String direction,Location [][] loc) {
        int coordinatex;
        int coordinatey;
        coordinatex = super.getLocationX();
        coordinatey = super.getLocationY();
        if (direction.equals("w")) {
            if (super.setLocation(coordinatex-1, coordinatey, loc)) {
                super.decreaseStrength(1);
                return true;
            }
            else {
                return false;
            }
        }
        else if(direction.equals("e")) {
            if (super.setLocation(coordinatex+1, coordinatey, loc)) {
                super.decreaseStrength(1);
                return true;
            }
            else {
                return false;
            }
        }
        else if(direction.equals("n")){
            if (super.setLocation(coordinatex, coordinatey-1, loc)) {
                super.decreaseStrength(1);
                return true;
            }
            else {
                return false;
            }
        }
        else if (direction.equals("s")) {
            if (super.setLocation(coordinatex, coordinatey+1, loc)) {
                super.decreaseStrength(1);
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    
    //This is the method to print the name and properties of the player character.
    public void printCharacter() {
        System.out.println("Hello my name is " + super.getName()+ " and I am the player.");
        System.out.println("My weapon is: " + getWeaponType() + " My status is: " + super.getStatus());
        System.out.println("My strength is: " + getStrength() + " I have " + getMoney() + " units of money.");
        System.out.println("My location is: " + super.getLocationX()+ "," + super.getLocationY());
    }
    
    public void printAll() {
        System.out.println("Strength: "+ super.getStrength() + " Balance: " + super.getMoney() + " (X,Y): " + super.getLocationX() + "," + super.getLocationY());
    }
}
