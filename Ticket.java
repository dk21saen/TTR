/**
 * This class creates a destination ticket with parameters length,
 * location, destination, color, and picture.
 * 
 * @author Ashley Hughes, Justyn McHarg, Devante Saenger, 
 * Collin Adams, Dylan Lane 
 * @version Spring 2018
 */
public class Ticket
{
    public int length;
    public String location;
    public String destination;
    public String color;
    public String pic;
    /**
     * Constructor for Ticket. Creates destination ticket.
     * @param int- l(length), String loc(location), 
     * String des(destination), String c(color), String p(picture).
     */
    public Ticket(int l, String loc, String des, String c, String p)
    {
        length = l;
        location = loc;
        destination = des;
        color = c;
        pic = p;
        
    }
    /**
     * Returns the length of the ticket.
     * @return int- length
     */
    public int getLength()
    {
        return length;
    }
    /**
     * Returns the location of the ticket.
     * @return String- location
     */
    public String getLocation()
    {
        return location;
    }
    /**
     * Returns the destination of the ticket.
     * @return String- destination
     */
    public String getDestination()
    {
        return destination;
    }
    /**
     * Returns the color of the ticket.
     * @return String- color
     */
    public String getColor()
    {
        return color;
    }
    /**
    * Returns the pic of the ticket.
    * @return String- pic
    */
    public String getPic()
    {
        return pic;
    }
    /**
    * Returns the info of the ticket.
    * @return String- information
    */
    public String getInfo()
    {
        String s = length + " " + location + " " + destination + 
        " " + color + " ";
        return s;
        
    }
}
