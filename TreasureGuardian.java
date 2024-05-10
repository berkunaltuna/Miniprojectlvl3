
public class TreasureGuardian extends Fighter
{
    private boolean is_at_treasure_location;

    //The constructor for the subclass TreasureGuardian.
    //The TreasureGuardian is always in the cell where the treasure is located.
    public TreasureGuardian(Location location, int m, int s, String wt)
    {
        super(location,m,s, wt);
        is_at_treasure_location = true;
    }
    
    //This is the method to print the name and properties of the treasure guardian character.
    public void printCharacter() {
        System.out.println("Hello my name is " + super.getName()+ " and I am the treasure guardian.");
        System.out.println("My weapon is: " + getWeaponType() + " My status is: " + super.getStatus());
        System.out.println("My strength is: " + getStrength() + " and I guard the treasure.");
    }
}
