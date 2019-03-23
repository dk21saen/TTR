/**
 * This class creates an array(deck) of short destination tickets with
 * correct locations, destinations, colors, lengths, and pictures. 
 * 
 * @author Ashley Hughes, Justyn McHarg, Devante Saenger, 
 * Collin Adams, Dylan Lane 
 * 
 * @version Spring 2018
 */
public class ShortTicketsDeck
{
    public Ticket [] deckofShortTickets;
    private int card;
    /**
     * Constructor for ShortTicketsDeck. Creates array of 
     * short destination tickets.
     */
    public ShortTicketsDeck()
    {
        deckofShortTickets = new Ticket[55];
        deckofShortTickets[0] = new Ticket(6, "Berlin", 
        "Chemnitz", "GREEN", "BerlChem.jpg");
        deckofShortTickets[1] = new Ticket(7, "Berlin", 
        "Erfurt", "GREEN", "BerlErfu.jpg");
        deckofShortTickets[2] = new Ticket(4, "Berlin", 
        "Leipzig", "GREEN", "BerlLeip.jpg");
        deckofShortTickets[3] = new Ticket(10, "Bremen" , 
        "Berlin", "GREEN", "BremBerl.jpg");
        deckofShortTickets[4] = new Ticket(5, "Bremen", 
        "Dusseldorf", "GREEN", "BremDuss.jpg");
        deckofShortTickets[5] = new Ticket(6, "Bremen", 
        "Kassel", "GREEN", "BremKass.jpg");
        deckofShortTickets[6] = new Ticket(7, "Bremerhaven", 
        "Koln", "GREEN", "BremKoln.jpg");
        deckofShortTickets[7] = new Ticket(10, "Danemack", 
        "Berlin", "GREEN", "DaneBerl.jpg");
        deckofShortTickets[8] = new Ticket(10, "Danemack", 
        "Niederlande", "GREEN", "DaneNied.jpg");
        deckofShortTickets[9] = new Ticket(7, "Dortmund", 
        "Erfurt", "GREEN", "DortErfu.jpg");
        deckofShortTickets[10] = new Ticket(9, "Dortmund", 
        "Magdeburg", "GREEN", "DortMagd.jpg");
        deckofShortTickets[11] = new Ticket(6, "Dortmund", 
        "Mannheim", "GREEN", "DortMann.jpg");
        deckofShortTickets[12] = new Ticket(10, "Dusseldorf", 
        "Konstanz", "GREEN", "DussKons.jpg");
        deckofShortTickets[13] = new Ticket(6, "Emden", 
        "Hamburg", "GREEN", "EmdeHamb.jpg");
        deckofShortTickets[14] = new Ticket(6, "Erfurt", 
        "Wurzburg", "GREEN", "ErfuWurz.jpg");
        deckofShortTickets[15] = new Ticket(9, "Frankfurt", 
        "Munchen", "GREEN", "FrankfMunc.jpg");
        deckofShortTickets[16] = new Ticket(8, "Frankreich", 
        "Munchen", "GREEN", "FrankrMunc.jpg");
        deckofShortTickets[17] = new Ticket(8, "Frankfurt", 
        "Lindau", "GREEN", "FranLind.jpg");
        deckofShortTickets[18] = new Ticket(10, "Frankfurt", 
        "Osterreich", "GREEN", "FranOste.jpg");
        deckofShortTickets[19] = new Ticket(4, "Frankfurt", 
        "Stuttgart", "GREEN", "FranStut.jpg");
        deckofShortTickets[20] = new Ticket(7, "Hamburg", 
        "Berlin", "GREEN", "HambBerl.jpg");
        deckofShortTickets[21] = new Ticket(11, "Hamburg", 
        "Frankfurt", "GREEN", "HambFran.jpg");
        deckofShortTickets[22] = new Ticket(7, "Hamburg", 
        "Kassel", "GREEN", "HambKass.jpg");
        deckofShortTickets[23] = new Ticket(10, "Hamburg", 
        "Koblenz", "GREEN", "HambKobl.jpg");
        deckofShortTickets[24] = new Ticket(9, "Hamburg", 
        "Koln", "GREEN", "HambKoln.jpg");
        deckofShortTickets[25] = new Ticket(10, "Hamburg", 
        "Leipzig", "GREEN", "HambLeip.jpg");
        deckofShortTickets[26] = new Ticket(4, "Hamburg", 
        "Rostock", "GREEN", "HambRost.jpg");
        deckofShortTickets[27] = new Ticket(7, "Hannover", 
        "Franfurt", "GREEN", "HannFran.jpg");
        deckofShortTickets[28] = new Ticket(6, "Hannover", 
        "Leipzig", "GREEN", "HannLeip.jpg");
        deckofShortTickets[29] = new Ticket(11, "Hannover", 
        "Saarbrucken", "GREEN", "HannSaar.jpg");
        deckofShortTickets[30] = new Ticket(4, "Karlsruhe", 
        "Augsburg", "GREEN", "KarlAugs.jpg");
        deckofShortTickets[31] = new Ticket(9, "Karlsruhe", 
        "Regensburg", "GREEN", "KarlRege.jpg");
        deckofShortTickets[32] = new Ticket(10, "Kassel", 
        "Freiburg", "GREEN", "KassFrei.jpg");
        deckofShortTickets[33] = new Ticket(7, "Koblenz", 
        "Ulm", "GREEN", "KoblUlm.jpg");
        deckofShortTickets[34] = new Ticket(4, "Koln", 
        "Frankfurt", "GREEN", "KolnFran.jpg");
        deckofShortTickets[35] = new Ticket(11, "Koln", 
        "Munchen", "GREEN","KolnMunc.jpg");
        deckofShortTickets[36] = new Ticket(8, "Koln", 
        "Nurnberg", "GREEN", "KolnNurn.jpg");
        deckofShortTickets[37] = new Ticket(11, "Koln", 
        "Regensburg", "GREEN", "KolnRege.jpg");
        deckofShortTickets[38] = new Ticket(4, "Koln", 
        "Saarbrucken", "GREEN", "KolnSaar.jpg");
        deckofShortTickets[39] = new Ticket(10, "Koln", 
        "Schweiz", "GREEN", "KolnSchw.jpg");
        deckofShortTickets[40] = new Ticket(11, "Leipzig", 
        "Munchen", "GREEN", "LeipMunc.jpg");
        deckofShortTickets[41] = new Ticket(10, "Leipzig", 
        "Frankfurt", "GREEN", "LiepFran.jpg");
        deckofShortTickets[42] = new Ticket(7, "Leipzig", 
        "Nurnberg", "GREEN", "LiepNurn.jpg");
        deckofShortTickets[43] = new Ticket(11, "Magdeburg", 
        "Koln", "GREEN", "MagdKoln.jpg");
        deckofShortTickets[44] = new Ticket(3, "Mainz", 
        "Stuttgart", "GREEN", "MainStut.jpg");
        deckofShortTickets[45] = new Ticket(2, "Mannheim", 
        "Stuttgart", "GREEN", "MannStut.jpg");
        deckofShortTickets[46] = new Ticket(4, "Mannheim", 
        "Wurzburg", "GREEN", "MannWurz.jpg");
        deckofShortTickets[47] = new Ticket(8, "Munchen", 
        "Freiburg", "GREEN", "MuncFrei.jpg");
        deckofShortTickets[48] = new Ticket(6, "Munchen", 
        "Konstanz", "GREEN", "MuncKons.jpg");
        deckofShortTickets[49] = new Ticket(5, "Munchen", 
        "Stuttgart", "GREEN", "MuncStut.jpg");
        deckofShortTickets[50] = new Ticket(7, "Munchen", 
        "Wurzburg", "GREEN", "MuncWurz.jpg");
        deckofShortTickets[51] = new Ticket(9, "Munster", 
        "Stuttgart", "GREEN", "MunsStut.jpg");
        deckofShortTickets[52] = new Ticket(8, "Niederlande", 
        "Frankfurt", "GREEN","NiedFran.jpg" );
        deckofShortTickets[53] = new Ticket(9, "Niederlande", 
        "Karlsruhe", "GREEN", "NiedKarl.jpg");
        deckofShortTickets[54] = new Ticket(7, "Nurnberg", 
        "Stuttgart", "GREEN", "NurnStut.jpg");
        card = 0;
    }
    /**
     * Prints out the deck of cards, or null if 
     * the card has already been dealt.
     */
    public void returnDeckOfCards()
    {
        for(int i = 0; i<deckofShortTickets.length; i++)
        {
            if (deckofShortTickets[i] == null)
            {
                System.out.println("Card is dealt");
            }
            else
            {
                System.out.println(deckofShortTickets[i].getInfo());
            }
        }
        
    }
    /**
     * Shuffles the deck of short destination tickets.
     */
    public void shuffle()
    {
        int n = 3;
        int shuffle = n*10;
        for (int i = 0; i<n; i++)
        {
            for (int index = 0; index <shuffle; index++)
            {
                int num1 = (int) (55 * Math.random());
                int num2 = (int) (55 * Math.random());
                if (deckofShortTickets[num1] == null || 
                deckofShortTickets[num2] == null)
                {

                }
                else 
                {
                    Ticket tmp = deckofShortTickets[num1];
                    deckofShortTickets[num1] = deckofShortTickets[num2];
                    deckofShortTickets[num2] = tmp;
                }

            }
        }
    }
    /**
     * Deals the card from the short destination
     * ticket array. Sets the card that was dealt
     * to null and shifts that null card to
     * the back of the array. 
     * @return Ticket- dealt ticket
     */
    public Ticket dealCard()
    {
        Ticket tmp = deckofShortTickets[card];
        deckofShortTickets[card++] = null;
        shiftCardsinDeck(deckofShortTickets);
        return tmp;
    }
    /**
     * Shifts the cards in the deck if there is a null card
     * not already in the back of the array. 
     * @param Ticket[] - tickets
     */
    public void shiftCardsinDeck(Ticket[] t)
    {
        for(int i = 0; i<deckofShortTickets.length-1; i++)
        {
            if (deckofShortTickets[i] == null)
            {
                Ticket tmp = deckofShortTickets[i+1];
                deckofShortTickets[i+1] = deckofShortTickets[i];
                deckofShortTickets[i] = tmp;
            }
        }
    }
    /**
     * Adds a card back into the array of short destination tickets
     * at the first instance of a null card in the array.
     * @param int- l(length), String loc(location), 
     * String des(destination), String c(color), String p(picture). 
     */
    public void addCard(int l, String loc, String des, String c, String p)
    {
        for (int i = 0; i<deckofShortTickets.length; i++)
        {
            if (deckofShortTickets[i] == null)
            {
                c.toUpperCase();
                Ticket t = new Ticket(l, loc, des, c, p);
                deckofShortTickets[i] = t;
                break;
            }
        }
    }
    /**
     * Adds the ticket back into the array at the first instance
     * of a null in that array.
     * @param Ticket-t(short destination ticket).
     */
    public void addCard(Ticket t) {
        for (int i = 0; i<deckofShortTickets.length; i++)
        {
            if (deckofShortTickets[i] == null)
            {
                deckofShortTickets[i] = t;
                break;
            }
        }
    }
}
