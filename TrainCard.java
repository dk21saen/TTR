/**
 * This class creates a train card ticket with parameters 
 * color and picture.
 * 
 * @author Ashley Hughes, Justyn McHarg, Devante Saenger, 
 * Collin Adams, Dylan Lane
 * 
 * @version Spring 2018
 */
public class TrainCard
{
    public String color;
    public String pic;
    /**
     * TrainCard Constructor.
     * @param String - c(color), String - p(picture). 
     */
    public TrainCard(String c, String p)
    {
        color = c;
        pic = p;
    }
    /** 
     * Returns the color of the train card.
     * @return String - color
     */
    public String getColor()
    {
        return color;
    }
     /** 
     * Returns the picture of the train card.
     * @return String - picture
     */
    public String getPic()
    {
        return pic;
    }
}
