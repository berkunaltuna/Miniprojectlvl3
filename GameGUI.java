import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameGUI implements ActionListener
{
    private String direction;
    private boolean actionperformed = false;
    JFrame frame;
    JTextField textfield;
    JButton westButton,northButton,eastButton,southButton;
    JPanel panel;
    Font myFont = new Font("Times New Roman",Font.BOLD,23);
    
    //The constructor of the class GameGUI. It sets up a panel of direction buttons for the user to click on. 
    public GameGUI() {
        this.direction = "";
        frame = new JFrame("Adventure Game");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(420, 550);
    frame.setLayout(null);
    frame.setAlwaysOnTop(true);
        
    textfield = new JTextField();
    textfield.setBounds(50, 25, 300, 50);
    textfield.setFont(myFont);
    textfield.setEditable(false);
        
    westButton = new JButton("West");
    westButton.addActionListener(this);
    westButton.setFont(myFont);
    westButton.setFocusable(false);
    northButton = new JButton("North");
    northButton.addActionListener(this);
    northButton.setFont(myFont);
    northButton.setFocusable(false);
    eastButton = new JButton("East");
    eastButton.addActionListener(this);
    eastButton.setFont(myFont);
    eastButton.setFocusable(false);
    southButton = new JButton("South");
    southButton.addActionListener(this);
    southButton.setFont(myFont);
    southButton.setFocusable(false);
    westButton.setEnabled(true);
    northButton.setEnabled(true);
    southButton.setEnabled(true);
    eastButton.setEnabled(true);
    
    
    westButton.setBounds(50,100,100,50);
    northButton.setBounds(200,100,100,50);
    eastButton.setBounds(50,200,100,50);
    southButton.setBounds(200,200,100,50);

    panel = new JPanel();
    panel.setBounds(50, 400, 500, 500);
    panel.setLayout(new GridLayout(2,2,10,10));

    panel.add(westButton);
    panel.add(northButton);
    panel.add(eastButton);
    panel.add(southButton);
    
    frame.add(panel);
    frame.add(westButton);
    frame.add(northButton);
    frame.add(eastButton);
    frame.add(southButton);
    frame.add(textfield);
    frame.setVisible(true);
    }
    
    //The action listener listens to the click of the button created.
    //This method overrides actionPerformed method in the ActionListener interface.
    //When the user clicks a button, the variable direction is set accordingly and the corresponding button is temporarily disabled.
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==westButton) {
        textfield.setText("West");
        this.direction = "w";
        this.actionperformed = true;
        westButton.setEnabled(false);
    }
    if(e.getSource()==northButton) {
        textfield.setText("North");
        this.direction = "n";
        this.actionperformed = true;
        northButton.setEnabled(false);
    }
    if(e.getSource()==eastButton) {
        textfield.setText("East");
        this.direction = "e";
        this.actionperformed = true;
        eastButton.setEnabled(false);
    }
    if(e.getSource()==southButton) {
        textfield.setText("South");
        this.direction = "s";
        this.actionperformed = true;
        southButton.setEnabled(false);
    }
    }
    
    //This method returns the direction the user has selected to the main program.
    //Before doing this, the buttons on the panel are re-enabled.
    public String getAction() {
        if(actionperformed) {
            actionperformed = false;
            westButton.setEnabled(true);
            northButton.setEnabled(true);
            southButton.setEnabled(true);
            eastButton.setEnabled(true);
            return this.direction;
        }
        else {
            return "action not performed.";
        }
    }
    
    //This method returns whether any button is clicked on the GUI interface to the main program.
    public boolean clicked() {
        return actionperformed;
    }
}
