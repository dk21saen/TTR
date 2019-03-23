import java.awt.Color;
/**
 * This class creates a route with parameters location(start city),
 * destination(end city), length, color, and type(single, double, triple).
 *
 * @author Ashley Hughes, Justyn McHarg, Devante Saenger, 
 * Collin Adams, Dylan Lane
 * 
 * @version Spring 2018
 */
public class Route
{
    public String location;
    public String destination;
    public int length;
    public Color color;
    public int routeType;
    public int claimedBy;
    /**
     * Constructor for route. Creates a new route.
     * @param String -loc(start city), String-des(end city), 
     * int- l(length), Color- c(color), and 
     * int- type(single, double, triple).
     */
    public Route(String loc, String d, int l, Color c, int type)
    {
        location = loc;
        destination = d;
        length = l;
        color = c;
        routeType = type;
        claimedBy = 0;
    }
    /**
     * Gets the beginning location of the route.
     * @return String- location
     */
    public String getLocation()
    {
        return location;
    }
    /**
     * Gets the ending destination of the route.
     * @return String- destination
     */
    public String getDestination()
    {
        return destination;
    }
    /**
     * Gets the length of the route.
     * @return int- length
     */
    public int getLength()
    {
        return length;
    }
    /**
     * Gets the color of the route.
     * @return Color- color.
     */
    public Color getColor()
    {
        return color;
    }
    /**
     * Sets the color of the route.
     * @param Color - c 
     */
    public void setColor(Color c)
    {
        color = c;
    }
    /**
     * Gets route type.
     * @return int- route type
     */
    public int getRouteType()
    {
        return routeType;
    }
    /**
     * Sets the route to a single route depending 
     * on the number of players plating the game.
     */
    public void setSingleRoute()
    {
        routeType = 1;
    }
    /**
     * Sets the route to a double route depending 
     * on the number of players plating the game.
     */
    public void setDoubleRoute()
    {
         routeType = 2;
    }
    /**
     * Sets the route to a triple route depending 
     * on the number of players plating the game.
     */
    public void setTripleRoute()
    {
        routeType = 3;
    }
}
