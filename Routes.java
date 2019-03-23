import static java.awt.Color.*;
import java.awt.Color;
/**
 * Creates route objects and adds them to an array of routes with
 * correct names of the location and destination, length, color, and
 * route type.
 *
 * @author Ashley Hughes, Justyn McHarg, Devante Saenger, 
 * Collin Adams, Dylan Lane
 * 
 * @version Spring 2018
 */
public class Routes
{
    public Route [] routes;
    static final Color PURPLE = new Color(150, 0, 150);
    
    /**
     * Routes contructor. Creates routes and adds them
     * to the array of routes.
     */
    public Routes()
    {
        routes = new Route[110];
        routes[0] = new Route("Danemach", "Kiel" , 2, GRAY, 1);
        routes[1] = new Route("Danemach", "Bremerhaven" , 5, GREEN, 1);
        routes[2] = new Route("Bremerhaven", "Kiel" , 3 , GRAY, 1);
        routes[3] = new Route("Bremerhaven", "Hamburg" , 3 , GRAY, 1);
        routes[4] = new Route("Bremerhaven", "Bremen" , 1 , WHITE, 1);
        routes[5] = new Route("Bremerhaven", "Emden" , 3, GRAY, 1);
        routes[6] = new Route("Bremen", "Emden" , 3 , BLUE, 1);
        routes[7] = new Route("Bremen", "Hamburg" , 3 , ORANGE, 1);
        routes[8] = new Route("Bremen", "Hannover", 3, YELLOW, 1);
        routes[9] = new Route("Bremen", "Munster" , 3, BLACK, 1);
        routes[10] = new Route("Emden", "Munster" , 4 , RED, 1);
        routes[11] = new Route("Emden", "Niederlande" ,2, WHITE, 1);
        routes[12] = new Route("Kiel", "Hamburg" , 2, BLACK, 2);
        routes[85] = new Route("Kiel", "Hamburg", 2, PURPLE, 2);
        routes[13] = new Route("Kiel", "Rostock" , 4 , ORANGE, 1);
        routes[14] = new Route("Kiel", "Schwerin" , 3 , YELLOW, 1);
        routes[15] = new Route("Hamburg", "Hannover", 4, RED, 2);
        routes[86] = new Route("Hamburg", "Hannover", 4, WHITE, 2);
        routes[16] = new Route("Hamburg", "Berlin", 7, BLUE, 2);
        routes[87] = new Route("Hamburg", "Berlin", 7, YELLOW, 2);
        routes[17] = new Route("Hamburg", "Schwerin", 2, GREEN, 1);
        routes[18] = new Route( "Hannover","Munster" ,  4, PURPLE, 1);
        routes[19] = new Route( "Hannover","Berlin" ,  7, BLACK, 1);
        routes[20] = new Route( "Hannover","Magdeburg" ,  4, BLUE, 1);
        routes[21] = new Route( "Hannover","Erfurt" ,  5, ORANGE, 2);
        routes[88] = new Route( "Hannover","Erfurt" ,  5, GREEN, 2);
        routes[22] = new Route( "Hannover","Kassel" ,  3, GRAY, 2);
        routes[89] = new Route( "Hannover","Kassel" ,  3, GRAY, 2);
        routes[23] = new Route( "Munster","Dortmund" ,  1, GRAY, 2);
        routes[90] = new Route( "Munster","Dortmund" ,  1, GRAY, 2);
        routes[24] = new Route( "Munster","Niederlande" ,  2, ORANGE, 1);
        routes[25] = new Route( "Niederlande", "Dusseldorf" ,  3, PURPLE, 1);
        routes[26] = new Route( "Rostock","Schwerin" ,  2, RED, 1);
        routes[27] = new Route( "Rostock","Berlin" ,  6, PURPLE, 1);
        routes[28] = new Route( "Schwerin","Berlin" ,  5, WHITE, 1);
        routes[29] = new Route( "Berlin","Magdeburg" ,  3, RED, 1);
        routes[30] = new Route( "Berlin","Leipzig" ,  4, ORANGE, 1);
        routes[31] = new Route( "Berlin", "Dresden" ,  5, GREEN, 1);
        routes[32] = new Route("Magdeburg", "Leipzig", 2, YELLOW, 1);
        routes[33] = new Route("Dusseldorf", "Dortmund", 1, GRAY, 3);
        routes[91] = new Route("Dusseldorf", "Dortmund", 1, GRAY, 3);
        routes[92] = new Route("Dusseldorf", "Dortmund", 1, GRAY, 3);
        routes[34] = new Route("Dusseldorf", "Koln", 1, GRAY, 3);
        routes[93] = new Route("Dusseldorf", "Koln", 1, GRAY, 3);
        routes[94] = new Route("Dusseldorf", "Koln", 1, GRAY, 3);
        routes[35] = new Route("Dortmund", "Kassel", 4, GREEN, 1);
        routes[36] = new Route("Kassel", "Frankfurt", 4, BLUE, 2);
        routes[95] = new Route("Kassel", "Frankfurt", 4, WHITE, 2);
        routes[37] = new Route("Kassel", "Erfurt", 3, GRAY, 1);
        routes[38] = new Route("Erfurt", "Leipzig", 3, RED, 1);
        routes[39] = new Route("Erfurt", "Chemnitz", 4, BLACK, 1); 
        routes[40] = new Route("Erfurt", "Regensburg", 7, WHITE, 1); 
        routes[41] = new Route("Erfurt", "Nurnberg", 4, YELLOW, 2);
        routes[96] = new Route("Erfurt", "Nurnberg", 4, PURPLE, 2);
        routes[42] = new Route("Leipzig", "Chemnitz", 2, BLUE, 1);
        routes[43] = new Route("Leipzig", "Dresden", 3, BLACK, 1);
        routes[44] = new Route("Dresden", "Chemnitz", 1, YELLOW, 1);
        routes[45] = new Route("Dresden", "Regensburg", 7, RED, 1);
        routes[46] = new Route("Chemnitz", "Regensburg", 6, PURPLE, 1);
        routes[47] = new Route("Koln", "Koblenz", 1, GRAY, 2);
        routes[97] = new Route("Koln", "Koblenz", 1, GRAY, 2);
        routes[48] = new Route("Koln", "Frankfurt", 4, GRAY, 2);
        routes[98] = new Route("Koln", "Frankfurt", 4, GRAY, 2);
        routes[49] = new Route("Koblenz" ,"Saarbrucken", 3, GRAY, 1);
        routes[50] = new Route("Koblenz" ,"Mainz", 2, GRAY, 2);
        routes[99] = new Route("Koblenz" ,"Mainz", 2, GRAY, 2);
        routes[51] = new Route("Frankfurt" ,"Mainz", 1, GRAY, 2);
        routes[100] = new Route("Frankfurt" ,"Mainz", 1, GRAY, 2);
        routes[52] = new Route("Frankfurt" ,"Wurzburg", 2, GRAY, 2);
        routes[101] = new Route("Frankfurt" ,"Wurzburg", 2, GRAY, 2);
        routes[53] = new Route("Frankfurt" ,"Mannheim", 2, GRAY, 2);
        routes[102] = new Route("Frankfurt" ,"Mannheim", 2, GRAY, 2);
        routes[54] = new Route("Mainz", "Mannheim", 1, GRAY, 2);
        routes[103] = new Route("Mainz", "Mannheim", 1, GRAY, 2);
        routes[55] = new Route("Mainz", "Saarbrucken", 3, GRAY, 1);
        routes[56] = new Route("Mannheim","Karlsruhe" , 1, BLUE, 1);
        routes[57] = new Route("Mannheim","Stuttgart" , 2, GRAY, 2);
        routes[104] = new Route("Mannheim","Stuttgart" , 2, GRAY, 2);
        routes[58] = new Route("Mannheim","Saarbrucken" , 3, GRAY, 1);
        routes[59] = new Route("Saarbrucken","Frankreich" , 1, GREEN, 1);
        routes[60] = new Route("Saarbrucken","Karlsruhe" , 3, GRAY, 1);
        routes[61] = new Route("Wurzburg","Nurnberg" , 2, GRAY, 2);
        routes[105] = new Route("Wurzburg","Nurnberg" , 2, GRAY, 2);
        routes[62] = new Route("Nurnberg","Augsburg" , 4, ORANGE, 1);
        routes[63] = new Route("Nurnberg","Munchen" , 5, BLUE, 2);
        routes[106] = new Route("Nurnberg","Munchen" , 5, BLACK, 2);
        routes[64] = new Route("Nurnberg","Regensburg" , 3, GREEN, 1);
        routes[65] = new Route("Regensburg","Munchen" , 3, ORANGE, 1);
        routes[66] = new Route("Regensburg","Osterreich", 4, YELLOW, 1);
        routes[67] = new Route("Karlsruhe","Frankreich", 2, BLACK, 1);
        routes[68] = new Route("Karlsruhe","Stuttgart", 1, PURPLE, 1);
        routes[69] = new Route("Karlsruhe","Freiburg", 3, WHITE, 1);
        routes[70] = new Route("Stuttgart","Freiburg", 3, GRAY, 1);
        routes[71] = new Route("Stuttgart","Konstanz", 3, GREEN, 1);
        routes[72] = new Route("Stuttgart","Ulm", 2, GRAY, 2);
        routes[107] = new Route("Stuttgart","Ulm", 2, GRAY, 2);
        routes[73] = new Route("Freiburg","Frankreich", 2 , YELLOW, 1);
        routes[74] = new Route("Freiburg","Schweiz", 2 , ORANGE, 1);
        routes[75] = new Route("Freiburg","Konstanz", 2 , BLACK, 1);
        routes[76] = new Route("Konstanz","Lindau", 1 , YELLOW, 1);
        routes[77] = new Route("Konstanz","Schweiz", 1, WHITE, 1);
        routes[78] = new Route("Ulm","Augsburg", 1 , GRAY, 2);
        routes[108] = new Route("Ulm","Augsburg", 1 , GRAY, 2);
        routes[79] = new Route("Ulm","Lindau", 2, RED, 1);
        routes[80] = new Route("Lindau","Schweiz", 2 , BLUE, 1);
        routes[81] = new Route("Lindau","Osterreich", 2 , PURPLE, 1);
        routes[82] = new Route("Lindau","Munchen", 5, GRAY, 1);
        routes[83] = new Route("Augsburg","Munchen", 2, GRAY, 2);
        routes[109] = new Route("Augsburg","Munchen", 2, GRAY, 2);
        routes[84] = new Route("Munchen","Osterreich", 3, RED, 1);
    }
    /**
     * Returns the length of the route.
     * @param String-loc, String-des
     * @return the length of the route
     * with the particlar start city and end city. 
     */
    public int getLength(String loc, String des)
    {
        int length = 0;
        for (int i = 0; i<routes.length; i++)
        {
            // if the inputed cities match up with the cities in 
            //one of the routes
            if ((loc == routes[i].getLocation() || 
            loc == routes[i].getDestination())
            && (des == routes[i].getLocation() || 
            des == routes[i].getDestination()))
            {
                length = routes[i].getLength(); 
            }
        }
        return length;
    }
    /**
     * Sets the route to a single route.
     */
    public void setToSingleRoute()
    {
        for(int i = 0; i<routes.length; i++)
        {
            routes[i].routeType = 1;
        }
    }
}
