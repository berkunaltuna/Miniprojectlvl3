
public class Trade extends Engage
{
    private int price;
    private Villager villager;
    private Player player;
    
    //The constructor of the subclass Trade.
    public Trade(Player p, Villager v)
    {
        super(p,v);
        this.villager = v;
        this.player = p;
    }
    
    //Since there is only one type of trade (buy food), we get the price of the food from the villager who has it. 
    public int getPriceTrade() {
        return villager.getPriceVillager();    
    }

    //makeEngagement() method here overrides method makeEngagement() in the super class Engage. 
    public String makeEngagement(Character c1, Character c2, int m, int sm) {
        boolean c1_is_player = false;
        
        //This is where we check if the right characters are making the engagement.
        String engagementstring = super.makeEngagement(c1,c2);
        if(engagementstring.equals("Engagement can be done.")) {
            c1_is_player = true;
        }
        else {
            c1_is_player = false;
        }
        
        //Player buys food which increases his strength by sm (strength modifier) and pays for it by decreasing his balance.
        //If the player does not have enough money he cannot buy the food offered by the villager.
        if (c1_is_player & c2 instanceof Villager) {
            if (this.player.getMoney() < m) {
                return "Engagement cannot be done.";
            }
            else {
                player.decreaseMoney(m);
                player.increaseStrength(sm);
                return "Engagement can be done.";
            }
        }
        else {
            return "Engagement cannot be done.";
        }
    }
}
