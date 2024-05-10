public class Character
{
    private Location location;
    private String status;
    private String name;
    
    //The constructor of the generic class character which initializes the location and the status of the character.
    public Character(Location location) {
        // initialise instance variables
        this.location = location;
        this.status = "alive";
        this.name = "Some Character";
    }
    
    //Setter method to set the name of a character.
    public void setName(String nm) {
        this.name = nm;
    }
    
    //Getter method to return the name of a character.
    public String getName() {
        return this.name;
    }
    
    //Sets the location of the character to coordinates (x,y).
    //If x or y are out of bounds the method returns false.
    public boolean setLocation(int x, int y, Location [][] loc ) {
        try {
            Location testlocation = loc[x][y];
            location.setCoordinates(x, y);
            return true;
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("No such location.");
            return false;
        }        
    }
    
    //This is the method to get the x coordinates of the location of the character.
    public int getLocationX() {
        return location.getCoordinateX();
    }
    
    //This is the method to get the y coordinates of the location of the character.
     public int getLocationY() {
        return location.getCoordinateY();
    }
    
    //This is the generic method for move. Only the player can move. Thus, this method is overriden in the player subclass.
    public boolean move(String s, int x, int y) {
        return false;
    }
    
    //these are the setter and getter methods for the Character class.
    public void setStatus(String st) {
        this.status = st;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    //This is the generic method to print character name and character properties. 
    //It will be overidden in the subclasses to achieve dynamic binding at runtime.
    public void printCharacter() {
    }
}
