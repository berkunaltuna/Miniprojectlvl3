public class Fight extends Engage
{
    private Fighter fighter1;
    private Fighter fighter2;
    
    //Constructor of the subclass Fight.
    public Fight(Fighter f1,Fighter f2)
    {
        super(f1,f2);
        this.fighter1 = f1;
        this.fighter2 = f2;
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
        
        if(!(c1_is_player & c2 instanceof Fighter)) {
            return "Engagement cannot be done.";
        }
        else { //This is the main fight code.
            this.fighter1 = (Fighter)c1;  
            this.fighter2 = (Fighter)c2; 
            String status1 = fighter1.getStatus();
            String status2 = fighter2.getStatus();
            
            //If one of them is dead, there cannot be any fight.
            if(status1.equals("dead") | status2.equals("dead")) {
                return "Engagement cannot be done";
            }
            
            //Get the strengths, balances and  weapon types of the two fighters.
            int strength1 = fighter1.getStrength();
            int strength2 = fighter2.getStrength();
            int money1 = fighter1.getMoney();
            int money2 = fighter2.getMoney();
            String weapon1 = fighter1.getWeaponType();
            String weapon2 = fighter2.getWeaponType();
            int totalstrength1 = 0;
            int totalstrength2 = 0;
            
            //totalstrength1 is proportional to strength1 multiplied by  a factor for the  weapon type.
            if (weapon1.equals("Long Sword")) {
                totalstrength1 = strength1*3;
            }
            else if (weapon1.equals("Sword")) {
                totalstrength1 = strength1*2;
            }
            else {
                totalstrength1 = strength1;
            }
            
            //totalstrength2 is proportional to strength2 multiplied by  a factor for the  weapon type.
            if (weapon2.equals("Long Sword")) {
                totalstrength2 = strength2*3;
            }
            else if (weapon2.equals("Sword")) {
                totalstrength2 = strength2*2;
            }
            else {
                totalstrength2 = strength2;
            }
            
            //strength1ratio is the probability(times 100) that fighter1 will win the fight.
            int strength1ratio = 100*totalstrength1/(totalstrength1+totalstrength2);
            //strength2ratio is the probability(times 100) that fighter2 will win the fight.
            int strength2ratio = 100*totalstrength2/(totalstrength1+totalstrength2);
            
            //This is where the fight occurs. The winner gets 10 units of money from the loser and his strength decreases by 10.
            //The loser loses 10 units of money and his strength decreases by 50.
            int randomnumber = (int)(Math.random()*100);
            if (randomnumber<= strength1ratio) {
                if(money2<10) {
                    fighter1.increaseMoney(money2);
                    fighter2.decreaseMoney(money2);
                }
                else {
                    fighter1.increaseMoney(10);
                    fighter2.decreaseMoney(10);
                }
                if (strength1<10) {
                    fighter1.decreaseStrength(strength1);
                }
                else {
                    fighter1.decreaseStrength(10);
                }                
                if (strength2<50) {
                    fighter2.decreaseStrength(strength2);
                }
                else {
                    fighter2.decreaseStrength(50);
                }
                System.out.println("You won the fight.");
            }
            else {
                if(money1<10) {
                    fighter2.increaseMoney(money1);
                    fighter1.decreaseMoney(money1);
                }
                else {
                    fighter2.increaseMoney(10);
                    fighter1.decreaseMoney(10);
                }                
                if (strength2<10) {
                    fighter2.decreaseStrength(strength2);
                }
                else {
                    fighter2.decreaseStrength(10);
                }                
                if (strength1<50) {
                    fighter1.decreaseStrength(strength1);
                }
                else {
                    fighter1.decreaseStrength(50);
                }
                System.out.println("You lost the fight.");
            }
        }
        return "Engagement can be done.";
    }
}
