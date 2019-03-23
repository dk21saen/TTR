/**
 * This class creates an array(deck) of long destination tickets with
 * correct locations, destinations, colors, lengths, and pictures. 
 * 
 * @author Ashley Hughes, Justyn McHarg, Devante Saenger, 
 * Collin Adams, Dylan Lane 
 * 
 * @version Spring 2018
 */
public class LongTicketsDeck
{
    public Ticket [] deckofLongTickets;
    private int card;
    /**
     * Constructor for LongTicketsDeck. Creates array of 
     * long destination tickets.
     */
    public LongTicketsDeck()
    {
        deckofLongTickets = new Ticket[34];
        deckofLongTickets[0] = new Ticket(13, "Niederlande", 
        "Berlin", "ORANGE", "NiedBerl.jpg");
        deckofLongTickets[1] = new Ticket(13, "Berlin", 
        "Dusseldorf", "ORANGE", "BerlDuss.jpg");
        deckofLongTickets[2] = new Ticket(14, "Berlin", 
        "Franfurt", "ORANGE", "BerlFran.jpg");
        deckofLongTickets[3] = new Ticket(15, "Berlin" , 
        "Mainz", "ORANGE", "BerlMain.jpg");
        deckofLongTickets[4] = new Ticket(15, "Berlin", 
        "Munchen", "ORANGE", "BerlMunc.jpg");
        deckofLongTickets[5] = new Ticket(14, "Berlin", 
        "Koln", "ORANGE", "BerlKoln.jpg");
        deckofLongTickets[6] = new Ticket(20, "Berlin", 
        "Schweiz", "ORANGE", "BerlSchw.jpg");
        deckofLongTickets[7] = new Ticket(18, "Berlin", 
        "Stuttgart", "ORANGE", "BerlStut.jpg");
        deckofLongTickets[8] = new Ticket(12, "Bremerhaven", 
        "Frankreich", "ORANGE", "BremFran.jpg");
        deckofLongTickets[9] = new Ticket(16, "Bremerhaven", 
        "Regensburg", "ORANGE", "BremRege.jpg");
        deckofLongTickets[10] = new Ticket(22, "Danemack", 
        "Lindau", "ORANGE", "DaneLind.jpg");
        deckofLongTickets[11] = new Ticket(13, "Dortmund", 
        "Munchen", "ORANGE", "DortMunc.jpg");
        deckofLongTickets[12] = new Ticket(12, "Dresden", 
        "Augsburg", "ORANGE", "DresAugs.jpg");
        deckofLongTickets[13] = new Ticket(16, "Dresden", 
        "Saarbrucken", "ORANGE", "DresSaar.jpg");
        deckofLongTickets[14] = new Ticket(15, "Emden", 
        "Freiburg", "ORANGE", "EmdeFrei.jpg");
        deckofLongTickets[15] = new Ticket(19, "Emden", 
        "Osterreich", "ORANGE", "EmdeOste.jpg");
        deckofLongTickets[16] = new Ticket(17, "Frankreich", 
        "Danemack", "ORANGE", "FranDane.jpg");
        deckofLongTickets[17] = new Ticket(15, "Frankreich", 
        "Leipzig", "ORANGE", "FranLeip.jpg");
        deckofLongTickets[18] = new Ticket(12, "Hamburg", 
        "Dresden", "ORANGE", "HambDres.jpg");
        deckofLongTickets[19] = new Ticket(14, "Hamburg", 
        "Karlsruhe", "ORANGE", "HambKarl.jpg");
        deckofLongTickets[20] = new Ticket(18, "Hamburg", 
        "Munchen", "ORANGE", "HambMunc.jpg");
        deckofLongTickets[21] = new Ticket(15, "Hamburg", 
        "Stuttgart", "ORANGE", "HambStut.jpg");
        deckofLongTickets[22] = new Ticket(15, "Kiel", 
        "Nurnberg", "ORANGE", "KielNurn.jpg");
        deckofLongTickets[23] = new Ticket(20, "Kiel", 
        "Schweiz", "ORANGE", "KielSchw.jpg");
        deckofLongTickets[24] = new Ticket(17, "Kiel", 
        "Stuttgart", "ORANGE", "KielStut.jpg");
        deckofLongTickets[25] = new Ticket(12, "Koln", 
        "Leipzig", "ORANGE", "KolnLeip.jpg");
        deckofLongTickets[26] = new Ticket(14, "Leipzig", 
        "Stuttgart", "ORANGE", "LeipStut.jpg");
        deckofLongTickets[27] = new Ticket(12, "Leipzig", 
        "Ulm", "ORANGE", "LeipUlm.jpg");
        deckofLongTickets[28] = new Ticket(14, "Munster", 
        "Munchen", "ORANGE", "MunsMunc.jpg");
        deckofLongTickets[29] = new Ticket(15, "Munster", 
        "Osterreich", "ORANGE", "MunsOste.jpg");
        deckofLongTickets[30] = new Ticket(22, "Rostock", 
        "Konstanz", "ORANGE", "RostKons.jpg");
        deckofLongTickets[31] = new Ticket(22, "Rostock", 
        "Osterreich", "ORANGE", "RostOste.jpg");
        deckofLongTickets[32] = new Ticket(12, "Schwerin", 
        "Koblenz", "ORANGE", "SchKob.jpg");
        deckofLongTickets[33] = new Ticket(13, "Schwerin", 
        "Frankfurt", "ORANGE", "SchwFran.jpg");
        card = 0;
    }
    /**
     * Prints out the deck of cards, or null if 
     * the card has already been dealt.
     */
    public void returnDeckOfCards()
    {
        for(int i = 0; i<deckofLongTickets.length; i++)
        {
            if (deckofLongTickets[i] == null)
            {
                System.out.println("Card is dealt");
            }
            else
            {
                System.out.println(deckofLongTickets[i].getInfo());
            }
        }
        
    }
    /**
     * Shuffles the deck of long destination tickets.
     */
    public void shuffle()
    {
        int n = 3;
        int shuffle = n*10;
        for (int i = 0; i<n; i++)
        {
            for (int index = 0; index <shuffle; index++)
            {
                int num1 = (int) (34 * Math.random());
                int num2 = (int) (34 * Math.random());
                if (deckofLongTickets[num1] == null || 
                deckofLongTickets[num2] == null)
                {

                }
                else 
                {
                    Ticket tmp = deckofLongTickets[num1];
                    deckofLongTickets[num1] = deckofLongTickets[num2];
                    deckofLongTickets[num2] = tmp;
                }

            }
        }
    }    
    /**
     * Deals the card from the long destination
     * ticket array. Sets the card that was dealt
     * to null and shifts that null card to
     * the back of the array. 
     * @return Ticket- dealt ticket
     */
    public Ticket dealCard()
    {
        Ticket tmp = deckofLongTickets[card];
        deckofLongTickets[card++] = null;
        shiftCardsinDeck(deckofLongTickets);
        return tmp;
    }
    /**
     * Shifts the cards in the deck if there is a null card
     * not already in the back of the array. 
     * @param Ticket[] - tickets
     */
    public void shiftCardsinDeck(Ticket[] t)
    {
        for(int i = 0; i<deckofLongTickets.length-1; i++)
        {
            if (deckofLongTickets[i] == null)
            {
                Ticket tmp = deckofLongTickets[i+1];
                deckofLongTickets[i+1] = deckofLongTickets[i];
                deckofLongTickets[i] = tmp;
            }
        }
    }
    /**
     * Adds a card back into the array of long destination tickets
     * at the first instance of a null card in the array.
     * @param int- l(length), String loc(location), 
     * String des(destination), String c(color), String p(picture). 
     */
    public void addCard(int l, String loc, String des, String c, String p)
    {
        for (int i = 0; i<deckofLongTickets.length; i++)
        {
            if (deckofLongTickets[i] == null)
            {
                c.toUpperCase();
                Ticket t = new Ticket(l, loc, des, c, p);
                deckofLongTickets[i] = t;
                break;
            }
        }
    }
    /**
     * Adds the ticket back into the array at the first instance
     * of a null in that array.
     * @param Ticket-t(long destination ticket).
     */
    public void addCard(Ticket t) {
        for (int i = 0; i<deckofLongTickets.length; i++)
        {
            if (deckofLongTickets[i] == null)
            {
                deckofLongTickets[i] = t;
                break;
            }
        }
    }
}
