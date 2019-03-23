import java.awt.Color;
/**
 * This class creates Line objects with parameters
 * such as x and y locations, and color.
 *
 * @author Ashley Hughes, Justyn McHarg, Devante Saenger, 
 * Collin Adams, Dylan Lane 
 * 
 * @version Spring 2018
 */
public class Line
{
    public int sX;
    public int sY;
    public int eX;
    public int eY;
    public Color col;
    /**
     * Constructor for Line.
     * @param int x1(start x location), int y1(start y location), 
     * int x2(end x location), int y2(end y location), and Color-c(Color).
     */
    public Line(int x1, int y1, int x2, int y2, Color c)
    {
        sX = x1;
        sY = y1;
        eX = x2;
        eY = y2;
        col = c;
    }
    }

