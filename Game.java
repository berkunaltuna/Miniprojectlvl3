import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

//import Java.util.Random;
public class Game
{
    //private static GUI gui = new GUI();
    //private ChoiceHandler cHandler = new ChoiceHandler(this);
    //The method to input a string with after a question
    public static String inputString(String message)
    {
        Scanner scanner = new Scanner(System.in);
        String answer;
    
        System.out.println(message);
        answer = scanner.nextLine();
       
        return answer;
    }
    
    //engageCharacters() is where the player engages a fighter, treasure guardian, helper or a villager.
    //The engagement can be of type: "fight", or "trade", or "receiveAdvice".
    //Polymorphism occurs where each character has its own type of engagement.
    //This method returns true if the treasure is found (the Treasure Guardian is engaged with.).
    public static boolean engageCharacters(Player pl, TreasureGuardian tg, ArrayList <Character> character, String treasurequadrant) {
            if(pl.getLocationX() == tg.getLocationX() & pl.getLocationY() == tg.getLocationY()) {
                Engage ef = new Fight(pl,tg);
                ef.makeEngagement(pl,tg);
                return true;
            }
            else {
                for(int i = 1; i<character.size(); i++) {
                    Character c = character.get(i);
                    if(c instanceof Fighter && pl.getLocationX() == c.getLocationX() && pl.getLocationY() == c.getLocationY()) {
                        System.out.println("Engaging " + c.getName());
                        Fighter f1 = (Fighter)c;
                        Engage ef = new Fight(pl,f1);
                        ef.makeEngagement(pl,f1);
                        return false;
                    }
                    else if(c instanceof Helper && pl.getLocationX() == c.getLocationX() && pl.getLocationY() == c.getLocationY()) {
                        System.out.println("Engaging " + c.getName());
                        Helper hl = (Helper)c;
                        Engage eh = new ReceiveAdvice(pl,hl);
                        ReceiveAdvice rc = (ReceiveAdvice)eh; 
                        treasurequadrant = rc.makeEngagement(pl, hl);
                        System.out.println("The treasure is in: " + treasurequadrant);
                        return false;
                    }
                    else if(c instanceof Villager && pl.getLocationX() == c.getLocationX() && pl.getLocationY() == c.getLocationY()) {
                        System.out.println("Engaging " + c.getName());
                        Villager v = (Villager)c;
                        Engage ev = new Trade(pl,v);
                        Trade t =  (Trade)ev;
                        int p = t.getPriceTrade();
                        int sm = v.getStrengthModifierVillager();
                        t.makeEngagement(pl,v,p,sm);
                        return false;
                    }
                }
            }
            return false;
    }
    
    public static void main(String [] args) {
        
        //Initialization of objects and sizing constants SIZEX and SIZEY.
        boolean endofprogram = false;
        String treasurequadrant = "";
        String line = "";
        String sizeXstring = "";
        String sizeYstring = "";
        String [] inputs = {};
        String user_input = "";
        
        //Start the GUI interface.
        GameGUI gamegui = new GameGUI();
        
        //Read from file.        
        try {
            BufferedReader br = new BufferedReader(new FileReader("ArgumentsForGame.txt"));
            line = br.readLine();
            inputs = line.split(",");
            sizeXstring = inputs[0];
            sizeYstring = inputs[1];
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
            sizeXstring = inputString("Please enter the size X of the location grid: ");
            sizeYstring = inputString("Please enter the size Y of the location grid: ");
        }
        catch (IOException e) {
            System.out.println("IO exception. Exiting program.");
            sizeXstring = inputString("Please enter the size X of the location grid: ");
            sizeYstring = inputString("Please enter the size Y of the location grid: ");
        }
        
        try {
            int sizex = Integer.parseInt(sizeXstring);
            int sizey = Integer.parseInt(sizeYstring);
        }
        catch (Exception e) {
            System.out.println("Sizes not integer. Exiting program.");
            System.exit(0);
        }
        
        final int SIZEX = Integer.parseInt(sizeXstring);
        final int SIZEY = Integer.parseInt(sizeYstring);
        Location [][] location = new Location[SIZEX][SIZEY];
        
        // Create location grid.
        for (int i = 0; i<SIZEX; i++) {
            for(int j = 0; j<SIZEY; j++) {
                location[i][j] = new Location();
                location[i][j].setCoordinates(i,j);
            }
        }
        
        //Set number of characters for each character with respect to SIZEX*SIZEY.
        double noofhelpers = SIZEX*SIZEY*0.04;
        int numberofhelpers = (int)noofhelpers;
        int numberofcharacters = 3*numberofhelpers+2;
        int numberofwarriorswithsword = numberofhelpers/2;
        int numberofwarriorswithaxe = numberofhelpers-numberofwarriorswithsword;
        int numberofvillagers = numberofhelpers;
        
        // Create game characters.
        //Character [] character = new Character[numberofcharacters];
        ArrayList <Character> characters = new ArrayList<Character>();
        for (int i = 0;i<numberofcharacters; i++) {
            boolean taken = true;
            int x = 0;
            int y = 0;
            while(taken) { // Only one character is allowed to occupy one location.
                x = (int)(Math.random()*SIZEX);
                y = (int)(Math.random()*SIZEY);
                taken = location[x][y].getTaken();
            }    
            if (i == 0) { // Character 0 is the Player.
                characters.add(i, new Player(location[x][y], 100, 250, "Long sword"));
                //character[i]=new Player(location[x][y], 100, 250, "Long sword");
                String plname = inputString("What is your name?");
                characters.get(i).setName(plname);
                //character[i].setName(plname);
            }
            else if(i == 1) { // Character 1 is the Treasure Guardian.
                characters.add(i, new TreasureGuardian(location[x][y], 100000,100, "Long Sword"));
                //character[i]=new TreasureGuardian(location[x][y], 100000,100, "Long Sword");
                treasurequadrant = location[x][y].getQuadrant(x,y, SIZEX, SIZEY);  
                characters.get(i).setName("Ivan the terrible");
                //character[i].setName("Ivan the terrible");
            }
            else if (i<(2+numberofwarriorswithsword)) { // Characters 2 and 3 are warriors with swords.
                characters.add(i, new Fighter(location[x][y], 100, 100, "Sword"));
                //character[i]=new Fighter(location[x][y], 100, 100, "Sword");
                characters.get(i).setName("Fighter" + i);
                //character[i].setName("Fighter" + i);
            }
            else if(i<(2+numberofwarriorswithsword+numberofwarriorswithaxe)) { // Characters 4 and 5 are warriors with axes.
                characters.add(i, new Fighter(location[x][y], 100, 100, "Axe"));
                //character[i]=new Fighter(location[x][y], 100, 100, "Axe");
                characters.get(i).setName("Fighter" + i);
                //character[i].setName("Fighter" + i);
            }
            else if (i<2+numberofwarriorswithsword+numberofwarriorswithaxe+numberofhelpers) { // Characters 6 through 9 are helpers.
                characters.add(i, new Helper(location[x][y], treasurequadrant));
                //character[i]=new Helper(location[x][y], treasurequadrant);
                characters.get(i).setName("Helper" + i);
                //character[i].setName("Helper" + i);
            }
            else { // Characters 10 through 13 are villagers.
                characters.add(i, new Villager(location[x][y]));
                //character[i]=new Villager(location[x][y]);
                characters.get(i).setName("Villager" + i);
                //character[i].setName("Villager" + i);
            }
            location[x][y].setTaken();
        }
        
        //This loop prints names and properties of the characters.
        //Each character knows its own properties. Thus, the printed properties are distinct.
        //This is where dynamic binding occurs.
        for (int i = 0; i<numberofcharacters; i++) { 
            characters.get(i).printCharacter();
        }
        
        //This is the main game loop.
        //After randomly initialising the locations of the characters above, the player starts moving one cell at a time in the location grid 
        //and engaging the characters he encounters.
        //This continues until the treasure is found or the player is dead because he doesn't have any strength left.
        //When the treasure is found. The player has to fight with the treasure guardian until one of them is dead.
        endofprogram = false;
        //Player pl = (Player)character[0];
        Player pl = (Player)characters.get(0);
        //TreasureGuardian tg = (TreasureGuardian)character[1];
        TreasureGuardian tg = (TreasureGuardian)characters.get(1);
        System.out.println("");
        System.out.println("=================================================================================================================");
        System.out.println("Game is starting. You have to find and kill the treasure guardian to get the treasure and win.");
        System.out.println("In order to find the treasure location you can engage with an Helper to learn the treasure location quadrant.");
        System.out.println("The below diagram shows how the quadrants are defined with respect to the x and y axes of the grid.");
        System.out.println("=================================================================================================================");
        System.out.println("");
        System.out.println("                   X}            ") ;                 
        System.out.println("");
        System.out.println("       0  1  2  3  4  5  6   7  8  9"   );
        System.out.println("       __ __ __ __ __ __ __ __ __ __  ");
        System.out.println("    0 |               |              |");
        System.out.println("    1 |               |              |");
        System.out.println("    2 |       Q1      |      Q2      |");    
        System.out.println("Y}  3 |               |              |");
        System.out.println("    4 |__ __ __ __ __ |__ __ __ __ __|");
        System.out.println("    5 |               |              |");
        System.out.println("    6 |               |              |");
        System.out.println("    7 |       Q3      |      Q4      |");
        System.out.println("    8 |               |              |");
        System.out.println("    9 |__ __ __ __ __ |__ __ __ __ __|");
        System.out.println("");
        System.out.println("");
        
        while(!endofprogram) {
            String status1 = pl.getStatus();
            while(!engageCharacters(pl, tg, characters, treasurequadrant) && status1.equals("alive")) { //While treasure not found or the player is alive this loop will execute.
                pl.printAll(); //Print the strength, balance, and location of the player helps the user make a decision to move in a direction.
                System.out.println("Please use the GUI to select the direction you want to move towards.");
                while(!gamegui.clicked()) { //Wait until the user clicks on a direction button on the GUI displayed.
                    try {TimeUnit.SECONDS.sleep(1);}
                    catch (java.lang.InterruptedException ie){System.out.println("You clicked too fast.");}
                }
                user_input = gamegui.getAction();
                System.out.println("Trying to move: " + user_input);
                while (!pl.move(user_input, location)) {
                    pl.printAll(); //Print the strength, balance, and location of the player helps the user make a decision to move in a direction.
                    System.out.println("Please use the GUI to select the direction you want to move towards.");
                    while(!gamegui.clicked()) { //Wait until the user clicks on a direction button on the GUI displayed.
                        try {TimeUnit.SECONDS.sleep(1);}
                        catch (java.lang.InterruptedException ie){System.out.println("You clicked too fast.");}
                    }
                    user_input = gamegui.getAction();
                    }
                System.out.println("The new location: " + pl.getLocationX() + "," + pl.getLocationY());
            }
            status1 = pl.getStatus();
            String status2 = tg.getStatus();
            //System.out.println(status1 + "," + status2); For debugging.
            while(status1.equals("alive") && status2.equals("alive")) {
                System.out.println("Engaging the treasure guardian.");
                Engage ef = new Fight(pl,tg);
                ef.makeEngagement(pl,tg);
                status1 = pl.getStatus();
                status2 = tg.getStatus();
                System.out.println("Status of the player: " + status1 + ", The status of the treasure guardian: " + status2);
                System.out.println("The strength of the Player: "+ pl.getStrength()); 
                System.out.println("The strength of the treasure guardian: "+ tg.getStrength()); 
            }
            if(status1.equals("alive")) {
                System.out.println("");
                System.out.println("=============================================================================================");
                System.out.println("Congratulations! You won the game by defeating the treasure guardian!");
                pl.increaseMoney(tg.getMoney());
                tg.decreaseMoney(tg.getMoney());
                System.out.println("Now you have " + pl.getMoney() + " units of money!");
                System.out.println("=============================================================================================");
                System.out.println("");
            }
            else {
                System.out.println("");
                System.out.println("=============================================================================================");
                System.out.println("Unfortunately you have lost the game.");
                System.out.println("=============================================================================================");
                System.out.println("");
            }
            endofprogram = true;
        }
    }// main method
}// class game
