public class ReceiveAdvice extends Engage
{
    private Player player;
    private Helper helper;
    
    //The constructor of the subclass ReceiveAdvice.
    public ReceiveAdvice(Player pl, Helper hl)
    {
        super(pl, hl);
        this.player = pl;
        this.helper = hl;
    }
    
    //The advice the player receives from the helper is the quadrant of the treasure. 
    public String getTreasureQuadrant() {
        return helper.getTreasureLocationQuadrant();
    }
    
    //makeEngagement() method here overrides method makeEngagement() in the super class Engage.
    public String makeEngagement(Character c1, Character c2) {
        boolean c1_is_player = false;
        String engagementstring = super.makeEngagement(c1,c2);
        
        if(engagementstring.equals("Engagement can be done.")) {
            c1_is_player = true;
        }
        else {
            c1_is_player = false;
        }
        
        //Returns the treasure quadrant after decreasing the balance of the player by 50.
        //If the player doesn't have enough money he cannot learn the treasure quadrant.
        if(c1_is_player & c2 instanceof Helper) {
            String tq = getTreasureQuadrant();
            if(this.player.getMoney() <50) {
                return "Engagement cannot be done. You need more money.";
            }
            else {
                this.player.decreaseMoney(50);
                return tq;
            }
        }
        else {
            return "Engagement cannot be done. You need more money.";
        }
    }
}
