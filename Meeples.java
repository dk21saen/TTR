/**
 * Creates each meeple object and places each meeple into an 
 * array of meeples(or "bag") with assigned color and picture.
 * 
 * 
 * @author Ashley Hughes, Justyn McHarg, Devante Saenger, 
 * Collin Adams, Dylan Lane
 * 
 * @version Spring 2018
 */
public class Meeples
{
    private Meeple[] bagofMeeples;
    private int meeple;
    /**
     * Constructor for Meeples. Places each created
     * meeple into an array of meeples.
     */
    public Meeples()
    {
        bagofMeeples = new Meeple[60];
        for (int i = 0; i< bagofMeeples.length; i++)
        {
            if (i<10)
            {
                bagofMeeples[i] = new Meeple("Red", "RedMeeple.jpg");
            }
            else if (i<20)
            {
                bagofMeeples[i] = new Meeple("Black", "BlackMeeple.jpg");
            }
            else if(i<30)
            {
                bagofMeeples[i] = new Meeple("Green", "GreenMeeple.jpg");
            }
            else if (i<40)
            {
                bagofMeeples[i] = new Meeple("Yellow", "YellowMeeple.jpg");
            }
            else if(i<50)
            {
                bagofMeeples[i] = new Meeple("Blue", "BlueMeeple.jpg");
            }
            else 
            {
                bagofMeeples[i] = new Meeple("White", "WhiteMeeple.jpg");
            }
        }
        meeple = 60;
    }
    /**
     * Prints the array of all the meeples with its' 
     * correspnding color or "Meeple Drawn" if that 
     * meeple has been drawn from the array("bag").
     */
    public void returnMeeples()
    {
        for (int i = 0; i<bagofMeeples.length; i++)
        {
            if (bagofMeeples[i] == null)
            {
                System.out.println("Meeple Drawn");
            }
            else
            {
                System.out.println(bagofMeeples[i].getColor());
            }

        }
    }
    /**
     * Shuffles the array of meeples.
     */
    public void shuffle()
    {
        int n = 3;
        int shuffle = n*10;
        for (int i = 0; i<n; i++)
        {
            for (int index = 0; index <shuffle; index++)
            {
                int num1 = (int) (60 * Math.random());
                int num2 = (int) (60 * Math.random());
                Meeple tmp = bagofMeeples[num1];
                bagofMeeples[num1] = bagofMeeples[num2];
                bagofMeeples[num2] = tmp;
            }
        }
    }
    /**
     * Selects a meeple out of the array of meeples.
     * Informs if the array of meeples is empty.
     * Sets the chosen meeple in the array to null.
     * @return Meeple- chosen meeple or empty
     * if no meeples are left
     */
    public Meeple chooseMeeple()
    {
        int num1 = (int) (meeple * Math.random());

        if (meeple == 0)
        {
            Meeple meep = new Meeple("No meeples left to be drawn", null);
            return meep;
        }
        else
        {
            Meeple m = bagofMeeples[num1];
            bagofMeeples[num1] = null;
            meeple--;
            shiftMeeples(bagofMeeples);
            return m;
        }

    }
    /**
     * Shifts the meeples in the bag when one meeple
     * was previously drawm. Adss the null meeple to the back of the array
     * @param Meeple[] - meeples
     */
    public void shiftMeeples(Meeple[] m)
    {
        for (int i = 0; i<bagofMeeples.length - 1; i++)
        {
            if(bagofMeeples[i] == null)
            {
                Meeple tmp = bagofMeeples[i+1];
                bagofMeeples[i + 1] = bagofMeeples[i];
                bagofMeeples[i] = tmp;
            }

        }
    }
    /**
     * Returns the image of the meeple.
     * @param String - pic(picture)
     * @returns String - image of the meeple
     */
    public String returnImage(String pic)
    {
        if (pic.toUpperCase() == "REDMEEPLE")
        {
            return "RedMeeple.jpg";
        }
        else if (pic.toUpperCase() == "BLACKMEEPLE")
        {
            return "BlackMeeple.jpg";
        }
        else if (pic.toUpperCase() == "GREENMEEPLE")
        {
            return "GreenMeeple.jpg";
        }
        else if (pic.toUpperCase() == "YELLOWMEEPLE")
        {
            return "YellowMeeple.jpg";
        }
        else if (pic.toUpperCase() == "BLUEMEEPLE")
        {
            return "BlueMeeple.jpg";
        }
        else if (pic.toUpperCase() == "WHITEMEEPLE")
        {
            return "WhiteMeeple.jpg";
        }
        else {
            return "Not correct input";
        }
    }
}
