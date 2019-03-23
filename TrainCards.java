import java.util.Random;
/**
 * This class creates an array (deck) of train cards with their specified
 * color and picture. 
 * 
 * @author Ashley Hughes, Justyn McHarg, Devante Saenger, 
 * Collin Adams, Dylan Lane
 * 
 * @version Spring 2018
 */
public class TrainCards
{
    private TrainCard[] deckofTrainCards;
    private int card;
    /** 
     * Constructor for TrainCards. Creates all 
     * train cards and adds them to an array.
     */
    public TrainCards()
    {
        deckofTrainCards = new TrainCard[110];
        for (int i = 0; i < deckofTrainCards.length; i++)
        {
            if(i<12)
            {
              deckofTrainCards[i] = new TrainCard("Yellow", "YellowCard.jpg");
            }
            else if(i<24)
            {
              deckofTrainCards[i] = new TrainCard("Blue", "BlueCard.jpg");
            }
            else if(i<36)
            {
              deckofTrainCards[i] = new TrainCard("Green", "GreenCard.jpg");
            }
            else if (i<48)
            {
              deckofTrainCards[i] = new TrainCard("Purple", "PurpleCard.jpg");
            }
            else if(i<60)
            {
              deckofTrainCards[i] = new TrainCard("Red", "RedCard.jpg");
            }
            else if(i<72)
            {
              deckofTrainCards[i] = new TrainCard("Black", "BlackCard.jpg");
            }
            else if(i<84)
            {
              deckofTrainCards[i] = new TrainCard("Orange", "OrangeCard.jpg");
            }
            else if (i<96)
            {
              deckofTrainCards[i] = new TrainCard("White", "WhiteCard.jpg");
            }
            else 
            {
              deckofTrainCards[i] = new TrainCard("Rainbow", "RainbowCard.jpg");
            }

        }
        card = 0;
    }
    /**
     * Prints the array of cards if it has not already been dealt.
     * 
     */
    public void returnDeckOfCards()
    {
        for(int i = 0; i<deckofTrainCards.length; i++)
        {
            if (deckofTrainCards[i] == null)
            {
                System.out.println("Card is dealt");
            }
            else
            {
                System.out.println(deckofTrainCards[i].getColor());
            }
        }

    }
    /**
     * Shuffles the array(deck) of train cards. 
     */
    public void shuffle()
    {
        int n = 3;
        int shuffle = n*10;
        for (int i = 0; i<n; i++)
        {
            for (int index = 0; index <shuffle; index++)
            {
                int num1 = (int) (110 * Math.random());
                int num2 = (int) (110 * Math.random());
                if (deckofTrainCards[num1] == null || 
                deckofTrainCards[num2] == null)
                {

                }
                else 
                {
                    TrainCard tmp = deckofTrainCards[num1];
                    deckofTrainCards[num1] = deckofTrainCards[num2];
                    deckofTrainCards[num2] = tmp;
                }

            }
        }
    }
    /**
     * Deals the card at the front of the array.
     * Dealt card is set to null and shifted to 
     * back of the array.
     * @return TrainCard- train card
     */
    public TrainCard dealCard()
    {
        TrainCard tmp = deckofTrainCards[card];
        deckofTrainCards[card] = null;
        shiftCardsinDeck(deckofTrainCards);
        return tmp;
    }
    /**
     * Shifts the cards in the deck when a card is dealt
     * and set to null.
     * @param TrainCard[]- array of train cards
     */
    public void shiftCardsinDeck(TrainCard[] t)
    {
        for(int i = 0; i<deckofTrainCards.length-1; i++)
        {
            if (deckofTrainCards[i] == null)
            {
                TrainCard tmp = deckofTrainCards[i+1];
                deckofTrainCards[i+1] = deckofTrainCards[i];
                deckofTrainCards[i] = tmp;
            }
        }
    }
    /**
     * Adds a train card back into the array of traincards at
     * the location of the first instance of a null train card.
     * @param String- color, String picture.
     */
    public void addCard(String s, String p)
    {
        for (int i = 0; i<deckofTrainCards.length; i++)
        {
            if (deckofTrainCards[i] == null)
            {
                s.toUpperCase();
                TrainCard c = new TrainCard(s, p);
                deckofTrainCards[i] = c;
            }
        }
    }
}