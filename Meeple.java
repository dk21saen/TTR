/**
 * This class creates meeples which are then used to play the game
 * with paramters color and picture.
 * 
 * @author Ashley Hughes, Justyn McHarg, Devante Saenger, 
 * Collin Adams, Dylan Lane
 * 
 * @version Spring 2018
 */
public class Meeple
{
    public String color;
    private String picture;
    /**
     * Contructor for Meeple.
     * @param String- c(color), String pic(picture).
     */
    public Meeple(String c, String pic)
    {
        color = c;
        picture = pic;
    }
    /**
     * Returns the color of the meeple.
     * @return String- color.
     */
    public String getColor()
    {
        return color;
    }
    /**
     * Returns the picture of the meeple.
     * @return String- pic.
     */
    public String getPicture()
    {
        return picture;
    }
}
