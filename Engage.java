
public class Engage
{
    private Character character1;
    private Character character2;

    //Engage or Engagement is where 2 characters exchange something.
    //There are 3 types of Engagements: Fight, Trade, ReceiveAdvice.
    public Engage(Character c1, Character c2)
    {
        this.character1 = c1;
        this.character2 = c2;
    }
    
    //In the game, character1 is always the player, i.e. player engages with some other character such as a fighter.
    public String makeEngagement(Character c1, Character c2) {
        this.character1 = c1;
        this.character2 = c2;
        
        if (character1 instanceof Player) {
            return "Engagement can be done.";
        }
        else {
            return "Engagement cannot be done. You need more money to engage. Go search more to find a fighter you can defeat.";
        }
    }
}
