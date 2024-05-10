
public class Location {
    private boolean taken;
    private int x_coordinate,y_coordinate;
    
    //The generic constructor for the class Location.
    //Location is a cell of the location grid. Thus, each location has an x and y coordinate and it can only be occupied by one character.
    public Location () {
        x_coordinate = 0;
        y_coordinate = 0;
        taken = false;
    }
    
    //This is the setter method to set x and y coordinates of a cell.
    //If the move method tries to set the coordinates out of bounds, then setCoordinates() fails.
    /*public boolean setCoordinates(int x, int y, int sizex, int sizey) {
        if(x<0 | x>=sizex) {
            return false;
        }
        else if(y<0 | y>=sizey) {
            return false;
        }
        else {
            this.x_coordinate = x;
            this.y_coordinate = y;
            return true;
        }
    }*/
    
    public boolean setCoordinates(int x, int y) {
        this.x_coordinate = x;
        this.y_coordinate = y;
        return true;
    }

    
    //Getter method to get the X coordinate of a cell.
    public int getCoordinateX() {
        return x_coordinate;
    }
    
    //Getter method to get the Y coordinate of a cell.
    public int getCoordinateY() {
        return y_coordinate;
    }
    
    //Setter method to set whether a cell is taken by a character or not.
    public void setTaken() {
        this.taken = true;
    }
    
    //Getter method to get the variable taken.
    public boolean getTaken() {
        return this.taken;
    }
    
    //Getter method to return the quadrant of a cell. This is used by the helper character to give advice to the player.
    public String getQuadrant(int x,int y,int sizex, int sizey) {
        if (x<(sizex/2)) {
            if(y<(sizey/2)) {
                String quadrant = "Quadrant 1. 0<x<" + (sizex/2)+ ","+" 0<y<" +(sizey/2) +".";
                return quadrant;
            }
            else {
                String quadrant = "Quadrant 3. 0<x<" + (sizex/2)+ "," + (sizey/2) +"<y<"+sizey +".";
                return quadrant;
            }
        }
        else if (y<(sizey/2)) {
            String quadrant = "Quadrant 2. "+(sizex/2) +"<x<" + (sizex)+ ", 0<y<"+sizey +".";
            return quadrant;
        }
        else {
            String quadrant = "Quadrant 4. "+(sizex/2) +"<x<" + (sizex)+ ","+ (sizey/2) +"<y<"+sizey +".";
            return quadrant;
        }
    }
}