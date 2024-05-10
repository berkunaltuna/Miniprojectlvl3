public class Helper extends Character
{
    private String treasure_location_quadrant;

    //The constructor of the subclass Helper.
    //Helper knows the quadrant where the treasure is.
    //To get this information the player has to engage (ReceiveAdvice from) the helper.
    public Helper(Location location, String q)
    {
        super(location);
        this.treasure_location_quadrant = q;
    }

    //The getter method for the treasure location quadrant.
    public String getTreasureLocationQuadrant() {
        return treasure_location_quadrant;
    }

    //This is the method to print the name and properties of the helper character.
    public void printCharacter() {
        System.out.println("Hello my name is " + super.getName()+ " and I am a helper.");
        System.out.println("I know the quadrant of the treasure. You can buy this information at a price.");
    }
}
