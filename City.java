import java.awt.*;
/**
 * This class creates a new city with parameters such as its' name, 
 * xy-coordinates and number of meeples that are allowed to be 
 * placed and assigned to the particular city.
 *
 * @author Ashley Hughes, Justyn McHarg, Devante Saenger, 
 * Collin Adams, Dylan Lane
 * @version Spring 2018
 */
public class City
{
    public String name;
    public int numMeeples;
    public Meeple[] meeples;
    private int xLocation;
    private int yLocation;
    public int startX;
    public int endX;
    public int startY;
    public int endY;
    /**
     * City constructor. Creates city
     * @param String n - name of city, int sx - start x, 
     * int ex - end x, int sy - start y, int  ey - end y, 
     * int num - number of meeples
     * 
     */
    public City(String n, int sx, int ex, int sy, int ey, int num) {
        name = n;
        startX = sx;
        endX = ex;
        startY = sy;
        endY = ey;
        numMeeples = num;
        // declares an array the size of the meeples allowed
        // in the city
        meeples = new Meeple[numMeeples]; 
    }
    /**
     * Adds the meeples from the the city's array of meeples 
     * to the gameBoard city.
     * 
     */
    public void addMeeples() {
        for (int i = 0; i < numMeeples; i++) {
            meeples[i] = GameBoard.meeples.chooseMeeple();
        }
    }

}
