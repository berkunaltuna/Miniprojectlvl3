README

DESCRIPTION OF THE PROGRAM:
This is an adventure game with 1 player character, 1 treasure guardian character, and several warrior, helper, villager characters. The purpose of the game is to find the treasure.
The numbers of warrior, helper, and villager characters are equal to one another. The size of the game grid determines these numbers. 
The program tries to read the size of the game grid from a file called "ArgumentsForGame.txt" which has to reside in the same directory as the program code. 
If the program fails to find this file, the execution continues by requesting the size of the game grid from the user. The game grid is usually selected as 
10 by 10, or 5 by 5 etc.
The locations of characters described above are randomly initialized to some cells on the grid. 
The location of the treasure is the same as the location of the treasure guardian character. The player can move one cell at a time to the north, south, east, or west.
With each move the player's strength decreases by one unit.
If the cell is occupied by a warrior a fight between the player and the warrior takes place. As the result of the fight the player either gains or loses strength.
If the player wins he/she takes the warrior's money. The winning probability is proportional to the strength difference between the player and the warrior. 
At the ame time this probability is also influenced by the weapon each character is carrying. 
If the cell is occupied by a villager character the player can buy food and increase his/her strength.
If the cell is occupied by a helper character the player can learn which quadrant the treasure is in (at a price).
The following diagram shows the definition of the quadrants for a 10x10 game grid.
                     X}

        0  1  2  3  4  5  6   7  8  9   
        __ __ __ __ __ __ __ __ __ __
    0 |               |              |
    1 |               |              | 
    2 |       Q1      |      Q2      |     
Y}  3 |               |              |
    4 |__ __ __ __ __ |__ __ __ __ __|
    5 |               |              |
    6 |               |              |
    7 |       Q3      |      Q4      |
    8 |               |              |
    9 |__ __ __ __ __ |__ __ __ __ __|

If the cell is occupied by the treasure guardian character the treasure has been found. However, the player has to defeat the treasure guardian to get the treasure and win the game.
A simple GUI is used to let the user select which direction the player wants to move. After each move, the location, strength, and balance is printed on the console.

Now complete the statements below for each level you wish to be marked. Replace all text in square brackets.

If your level 1/2 submission did not get full marks you MUST complete the second part of this template describing how and where your have improved your code so that it now meets the level 1 and 2 requirements. If your code still does not meet level 1 and 2 requirements then you will get 0 for level 3.

LEVEL THREE

GUI

[4 buttons and a text area are created in the GameGUI.java class where the buttons are equipped with action listeners. The buttons, when clicked, return the direction in which the player has chosen to move to. 
After clicking, the buttons are disabled so that the user can not abuse clicking the buttons and cause an unexpected error. The GameGUI.java class is the file that contains all the GUI code that are called from the main game class. 
Inside the game class, the getAction() method of the GameGUI class is called in lines 219 and 228 and the gamegui instance of GameGUI class is created in line 85.]

Exceptions

[Inside the Game class, FileNotFoundException on line 95, IOException on line 100, java.lang.InterruptedException at lines 217 and 226, and  Exception on line 110. Inside the Character class, ArrayIndexOutOfBoundsException at line 33. ]
[The code needs to handle exceptions in order to handle problems elegantly in case something goes wrong. 
In my code, there are several places where the usage of exceptions are appropriate as indicated above.
For example, when I try to read an input from a file to get the size of the game grid. The possible exceptions handled here are, FileNotFoundException in case the file is accidentally not in the same directory as the project.]

Collections

[Inside the game.java class an ArrayList of type Character is created on line 137. ]
[I used arraylist to handle varying number of characters where this number is proportional the size of the game grid selected by the user. The arraylist collection provides an uncertain amount of array index size; therefore, 
it can be used to keep the difficulty level of the game by adding new character objects if the user increases the grid size.
For example, if the game grid size is 15x15 or 10x10 or 5x5 the program always creates the appropriate number of characters proportional to this size.]

File I/O

[File input is used to read the grid size in a flexible and elegant way from a file ("ArgumentsForGame.txt"). 
Otherwise, the user would have to be prompted for the size or provide this size as an argument to the program when the program is called.]

'Something impressive'

[Explain in no more than six sentences how and where your code implements OOP/Java principles beyond those taught on the course.]


LEVELS 1 AND 2

(ONLY complete this if you did not get full marks for your level 1/2 submission.)

How I fixed my level 1 and 2: Actually, there was nothing wrong with it. The probable cause may be the person who was marked it was trying to start the game without any arguments. 
It was expecting the verticle and horizontal sizes of the grid as comma seperated arguments. For example, {"10","10"}. Now it is not necessary because
the program reads these from a file. Other than this and the level 3 requirements, I did not change anything in the code.
 

LEVEL ONE

My code demonstrates inheritance in the following way...

I have a superclass called [Character]

This superclass is extended into at least two subclasses called [Helper, Villager, Fighter, TreasureGuardian, Player]

For each of the named subclasses complete the following...

Subclass 1.

Subclass [Helper] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [treasure_location_quadrant]

These/this new properties/property are used by the subclass in the following way: [It was added for the character Helper to get and tell the location of the treasure that the player is trying to find. Line 11 and 16. ]

Subclass [Helper] extends the superclass by overriding the following methods (there must be at least one): [public void printCharacter() starting on line 20.]

These overridden methods are used in the working code in the following places: [The main program Game.java line 184.]

Subclass 2.

Subclass [Villager] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [A variable food of type Food]

These/this new properties/property are used by the subclass in the following way: [It was added to instantiate villager with a food that the player in the game can buy. Lines 15 to 27, and lines 33, 38, 45. ]

Subclass [Villager] extends the superclass by overriding the following methods (there must be at least one): [public void printCharacter() starting on line 42.]

These overridden methods are used in the working code in the following places: [The main program Game.java line 184.]

Subclass 3.

Subclass [Fighter] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [money, strength, weapon_type]

These/this new properties/property are used by the subclass in the following way: [The class was added to create characters that could fight with their strength and a specific weapon type. The characters also have money and the character that is defeated will exchange an amount of money.]

Subclass [Fighter] extends the superclass by overriding the following methods (there must be at least one): [public void printCharacter() starting on line 78.]

These overridden methods are used in the working code in the following places: [The main program Game.java line 184.]

Subclass 4.

Subclass [TreasureGuardian] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [is_at_treasure_location]

These/this new properties/property are used by the subclass in the following way: [To denote that the treasure guardians location is the treasure location. Line 11.]

Subclass [TreasureGuardian] extends the superclass by overriding the following methods (there must be at least one): [public void printCharacter() starting on line 15.]

These overridden methods are used in the working code in the following places: [The main program Game.java line 184.]

Subclass 5.

Subclass [Player] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [change_location]

These/this new properties/property are used by the subclass in the following way: [The class was added for the user to play as the player and be able to move around the map. Line 11.]

Subclass [Player] extends the superclass by overriding the following methods (there must be at least one): [public void printCharacter() starting on line 65.]

These overridden methods are used in the working code in the following places: [The main program Game.java line 184.]


I have a second superclass called [Engage]

This superclass is extended into at least two subclasses called [Trade, Fight, ReceiveAdvice]

For each of the named subclasses complete the following...

Subclass 1.

Subclass [Trade] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [int price, Villager villager, and Player player]

These/this new properties/property are used by the subclass in the following way: [The class was added to allow a trade to happen between a villager and a player to exchange money for the villager's food. ]

Subclass [Trade] extends the superclass by overriding the following methods (there must be at least one): [public String makeEngagement(...) starting on line 22.]

These overridden methods are used in the working code in the following places: [The main program Game.java lines 92, 101, 110, 119.]

Subclass 2.

Subclass [Fight] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [Fighter fighter1 and Fighter fighter2]

These/this new properties/property are used by the subclass in the following way: [The class was added to allow two characters being the player and another Fighter to fight and exchange money. Lines 10, 11 , and 30, 31.]

Subclass [Fight] extends the superclass by overriding the following methods (there must be at least one): [public String makeEngagement(...) starting on line 20.]

These overridden methods are used in the working code in the following places: [The main program Game.java lines 26, 33, 39, 45, 51, and 241.]

Subclass 3.

Subclass [ReceiveAdvice] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [Player player and Helper helper]

These/this new properties/property are used by the subclass in the following way: [The class was added to allow two characters being the Helper and the player to get the quadrant of the map where the treasure is located for a price of 50 units of money. Lines 10, 11, 16, 35, and 39.]

Subclass [ReceiveAdvice] extends the superclass by overriding the following methods (there must be at least one): [public String makeEngagement(...) starting on line 15.]

These overridden methods are used in the working code in the following places: [The main program Game.java lines 58, 66, 74, and 82.]

LEVEL TWO

Polymorphism consists of the use of the Substitution principle and Late Dynamic binding.

In my code, polymorphism is implemented in at least two places…

Example 1.

The substitution principle can be seen in use in [ class Game in lines 92, 101, 110, 119, 26, 33, 39, 45, 51, 241 58, 66, 74, 82  ]. The name of the superclass used in this example is [Engage] and the subclasses used are [Trade, Fight, ReceiveAdvice].

Late dynamic binding can be seen in [Trade and starting on line 22 (makeEngagement()), Fight starting on line 20 (makeEngagement()), ReceiveAdvice starting on line 15 (makeEngagement())].

[Subclasses share the characteristics of engaging one another. But each engagement differs on the characters involved. For example, player and fighter fight. Player receives advice from helper and player trades with villager.  ]

Example 2.

The substitution principle can be seen in use in [Game class in lines 152, 157, 162, 166, 170, 174.]. The name of the superclass used in this example is [Character] and the subclasses used are [Helper, Villager, Fighter, TreasureGuardian, Player].

Late dynamic binding can be seen in [Helper starting on line 20 (printCharacter()), Villager  starting on line 42 (printCharacter()), Fighter  starting on line 78 (printCharacter()), TreasureGuardian starting on line 15 (printCharacter()), Player starting on line 65 (printCharacter())].

[Subclasses share certain characteristics like having a name and having a location etc. But they have different properties like being able to fight and giving advice and trading food]
