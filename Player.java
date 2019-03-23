import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    public ArrayList<Ticket> tickets;
    public ArrayList<TrainCard> trainCards;
    public Color color;
    public int numColoredTrains;
    public ArrayList<Color> trains;
    public int score;
    public ArrayList<Ticket> tempTickets;
    public ArrayList<Route> claimedRoutes;
    public ArrayList<Ticket> unclaimedTicketRoutes;
    public ArrayList<Ticket> claimedTicketRoutes;
    public ArrayList<Meeple> redMeeples;
    public ArrayList<Meeple> blackMeeples;
    public ArrayList<Meeple> greenMeeples;
    public ArrayList<Meeple> yellowMeeples;
    public ArrayList<Meeple> blueMeeples;
    public ArrayList<Meeple> whiteMeeples;
    private Routes r;
    public String loc;
    public String des; 
    public Ticket t;
    public String name;
    public int numWhiteCards;
    public int numRedCards;
    public int numBlueCards;
    public int numYellowCards;
    public int numGreenCards;
    public int numBlackCards;
    public int numOrangeCards;
    public int numPurpleCards;
    public int numRainCards;
    public int redM;
    public int greenM;
    public int whiteM;
    public int blueM;
    public int blackM;
    public int yellowM;
    public boolean done;
    static final Color PURPLE = new Color(150, 0, 150);

    public Player(String n) {
        tickets = new ArrayList<Ticket>();
        tempTickets = new ArrayList<Ticket>();
        Object[] options = {"0", "1", "2", "3", "4"};
        int numShorts = JOptionPane.showOptionDialog(null,"How many short tickets would you like to start?\n(The rest if the 4 will be long tickets)","Ticket to Ride - Number of Short Tickets - " + name,JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,null);
        for (int i = 0; i < numShorts; i++) {
            tempTickets.add(GameBoard.sdDeck.dealCard());
        }
        for (int i = numShorts; i < 4; i++) {
            tempTickets.add(GameBoard.ldDeck.dealCard());
        }
        discardTickets(2);

        trainCards = new ArrayList<TrainCard>();
        for (int i = 0; i < 4; i++) {
            trainCards.add(GameBoard.trainDeck.dealCard());
        }

        Object[] colorOps = new Object[GameBoard.colorNames.size()];
        for (int i = 0; i < colorOps.length; i++) {
            colorOps[i] = GameBoard.colorNames.get(i);
        }
        int colorChoice = JOptionPane.showOptionDialog(null,"Which Color Would You Like to Be?\n(cannot choose same as previous player)","Ticket to Ride - Color Choice - " + name,JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,colorOps,null);
        for (int i = 0; i < 5; i++) {
            if (colorChoice == i) {
                color = GameBoard.colors.get(i);
                GameBoard.colors.remove(i);
                GameBoard.colorNames.remove(i);
            }
        }

        trains = new ArrayList<Color>();
        for (int i = 0; i < numColoredTrains; i++) {
            trains.add(color);
        }

        claimedRoutes = new ArrayList<Route>();
        claimedTicketRoutes = new ArrayList<Ticket>();
        unclaimedTicketRoutes = new ArrayList<Ticket>();
        redMeeples = new ArrayList<Meeple>();
        blackMeeples = new ArrayList<Meeple>();
        blueMeeples = new ArrayList<Meeple>();
        yellowMeeples = new ArrayList<Meeple>();
        greenMeeples = new ArrayList<Meeple>();
        whiteMeeples = new ArrayList<Meeple>();
        numColoredTrains = 3;
        score = 0;
        name = n;
        done = false;
        int redM = 0;
        int greenM = 0;
        int whiteM = 0;
        int blueM = 0;
        int blackM = 0;
        int yellowM = 0;
        numWhiteCards = 0;
        numRedCards = 0;
        numBlueCards = 0;
        numYellowCards = 0;
        numGreenCards = 0;
        numBlackCards = 0;
        numOrangeCards = 0;
        numPurpleCards = 0;
        numRainCards = 0;
    }

    public void drawTickets() {        
        tempTickets = new ArrayList<Ticket>();
        if(GameBoard.sdDeck.deckofShortTickets.length + GameBoard.ldDeck.deckofLongTickets.length < 4){
            if(GameBoard.sdDeck.deckofShortTickets.length == 0 && GameBoard.ldDeck.deckofLongTickets.length == 0){

                JOptionPane.showMessageDialog(null, "There are no more tickets to draw",
                    "Destination Tickets Drawn", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            else{
                
            }
        }
        Object[] options = {"0", "1", "2", "3", "4"};
        int numShorts = JOptionPane.showOptionDialog(null,"How many short tickets would you like to draw?\n(The rest of the 4 will be long tickets)","Ticket to Ride - Number of Short Tickets - " + name,JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,null);

        for (int i = 0; i < numShorts; i++) {
            tempTickets.add(GameBoard.sdDeck.dealCard());
        }
        for (int i = numShorts; i < 4; i++) {
            tempTickets.add(GameBoard.ldDeck.dealCard());
        }
        discardTickets(3);
    }

    public void discardTickets(int max) {
        int numDiscards = 0;
        ArrayList<Ticket> removed = new ArrayList<Ticket>();

        JOptionPane.showMessageDialog(null, "You drew:\n" + tempTickets.get(0).location + ", " + tempTickets.get(0).destination + " (" + tempTickets.get(0).length + ")\n"
            + tempTickets.get(1).location + ", " + tempTickets.get(1).destination + " (" + tempTickets.get(1).length + ")\n"
            + tempTickets.get(2).location + ", " + tempTickets.get(2).destination + " (" + tempTickets.get(2).length + ")\n"
            + tempTickets.get(3).location + ", " + tempTickets.get(3).destination + " (" + tempTickets.get(3).length + ")\n",
            "Destination Tickets Drawn", JOptionPane.INFORMATION_MESSAGE);

        if (max == 2) {
            Object[] options = {"0", "1", "2"};
            numDiscards = JOptionPane.showOptionDialog(null,"How many tickets would you like to discard","Ticket to Ride - Number of Discards - " + name,JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,null);
        }
        else if (max == 3) {
            Object[] options = {"0", "1", "2", "3"};
            numDiscards = JOptionPane.showOptionDialog(null,"How many tickets would you like to discard","Ticket to Ride - Number of Discards - " + name,JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,null);
        }

        if (numDiscards >= 1) {
            Object[] options = {tempTickets.get(0).location + ", " + tempTickets.get(0).destination + " (" + tempTickets.get(0).length + ")",
                    tempTickets.get(1).location + ", " + tempTickets.get(1).destination + " (" + tempTickets.get(1).length + ")",
                    tempTickets.get(2).location + ", " + tempTickets.get(2).destination + " (" + tempTickets.get(2).length + ")",
                    tempTickets.get(3).location + ", " + tempTickets.get(3).destination + " (" + tempTickets.get(3).length + ")"};

            int choice = JOptionPane.showOptionDialog(null,"Which ticket would you like to discard?","Ticket to Ride - Ticket to Discard - " + name,JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,null);
            if (choice == 0) {
                removed.add(tempTickets.get(0));
                tempTickets.remove(0);
            }
            else if (choice == 1) {
                removed.add(tempTickets.get(1));
                tempTickets.remove(1);
            }
            else if (choice == 2) {
                removed.add(tempTickets.get(2));
                tempTickets.remove(2);
            }
            else if (choice == 3) {
                removed.add(tempTickets.get(3));
                tempTickets.remove(3);
            }
        }

        if (numDiscards >= 2) {
            Object[] options = {tempTickets.get(0).location + ", " + tempTickets.get(0).destination + " (" + tempTickets.get(0).length + ")",
                    tempTickets.get(1).location + ", " + tempTickets.get(1).destination + " (" + tempTickets.get(1).length + ")",
                    tempTickets.get(2).location + ", " + tempTickets.get(2).destination + " (" + tempTickets.get(2).length + ")"};

            int choice = JOptionPane.showOptionDialog(null,"Which ticket would you like to discard next?","Ticket to Ride - Ticket to Discard - " + name,JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,null);
            if (choice == 0) {
                removed.add(tempTickets.get(0));
                tempTickets.remove(0);
            }
            else if (choice == 1) {
                removed.add(tempTickets.get(1));
                tempTickets.remove(1);
            }
            else if (choice == 2) {
                removed.add(tempTickets.get(2));
                tempTickets.remove(2);
            }
        }

        if (numDiscards >= 3) {
            Object[] options = {tempTickets.get(0).location + ", " + tempTickets.get(0).destination + " (" + tempTickets.get(0).length + ")",
                    tempTickets.get(1).location + ", " + tempTickets.get(1).destination + " (" + tempTickets.get(1).length + ")"};

            int choice = JOptionPane.showOptionDialog(null,"Which ticket would you like to discard next?","Ticket to Ride - Ticket to Discard - " + name,JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,null);
            if (choice == 0) {
                removed.add(tempTickets.get(0));
                tempTickets.remove(0);
            }
            else if (choice == 1) {
                removed.add(tempTickets.get(1));
                tempTickets.remove(1);
            }
        }

        for (int j = 0; j < removed.size(); j++) {
            if (removed.get(j).length <= 11) {
                GameBoard.sdDeck.addCard(removed.get(j));
            }
            else {
                GameBoard.ldDeck.addCard(removed.get(j));
            }
        }

        for (int i = 0; i < tempTickets.size(); i++) {
            tickets.add(tempTickets.get(i));
        }
    }

    public void countTrainCards(){
        numYellowCards = numRedCards = numBlueCards = numRainCards = numBlackCards = numPurpleCards = numWhiteCards = numOrangeCards = numGreenCards = 0;
        for (int i = 0; i < trainCards.size(); i++){
            if(trainCards.get(i).getColor().equals("Yellow")){
                numYellowCards++;
            }
            if(trainCards.get(i).getColor().equals("Red")){
                numRedCards++;
            }
            if(trainCards.get(i).getColor().equals("Rainbow")){
                numRainCards++;
            }
            if(trainCards.get(i).getColor().equals("Blue")){
                numBlueCards++;
            }
            if(trainCards.get(i).getColor().equals("White")){
                numWhiteCards++;
            }
            if(trainCards.get(i).getColor().equals("Black")){
                numBlackCards++;
            }
            if(trainCards.get(i).getColor().equals("Purple")){
                numPurpleCards++;
            }
            if(trainCards.get(i).getColor().equals("Orange")){
                numOrangeCards++;
            }
            if(trainCards.get(i).getColor().equals("Green")){
                numGreenCards++;
            }
        }
    }

    public int getScore() {
        routeScore();
        destinationScore();
        return score;
    }

    public void drawTrainCards(int time) {
        Object[] options = {GameBoard.faceUp[0].color, GameBoard.faceUp[1].color, GameBoard.faceUp[2].color,
                GameBoard.faceUp[3].color, GameBoard.faceUp[4].color, "Draw Face Down"};
        int choice = JOptionPane.showOptionDialog(null,"Which Card Would You Like to Draw?\nIf you choose a face up Locomotive,"
                + " you may not choose a second card","Ticket to Ride - Draw Train Card",
                JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,null);

        if (choice != 5) {
            if (GameBoard.faceUp[choice].color.equals("Rainbow")) {
                if (time == 1) {
                    trainCards.add(GameBoard.faceUp[choice]);
                    GameBoard.faceUp[choice] = GameBoard.trainDeck.dealCard();
                    JOptionPane.showMessageDialog(null, "You drew:\n" +
                        trainCards.get(trainCards.size()-1).color,
                        "Train Cards Drawn", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                else drawTrainCards(2);
            }
            else {
                trainCards.add(GameBoard.faceUp[choice]);
                GameBoard.faceUp[choice] = GameBoard.trainDeck.dealCard();
                if (time == 1) {
                    drawTrainCards(2);
                    return;
                }
                else {
                    JOptionPane.showMessageDialog(null, "You drew:\n" + trainCards.get(trainCards.size()-2).color + "\n"
                        + trainCards.get(trainCards.size()-1).color, "Train Cards Drawn", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
        }
        else {
            trainCards.add(GameBoard.trainDeck.dealCard());
            if (time == 1) {
                drawTrainCards(2);
                return;
            }
            else {
                JOptionPane.showMessageDialog(null, "You drew:\n" + trainCards.get(trainCards.size()-2).color + "\n"
                    + trainCards.get(trainCards.size()-1).color, "Train Cards Drawn", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
    }

    public boolean claimRoute(int start, int end) {
        ArrayList<Route> possible = new ArrayList<Route>();
        Color routeColor;

        for (int i = 0; i < GameBoard.routes.routes.length; i++) {
            if ((GameBoard.routes.routes[i].location.equalsIgnoreCase(GameBoard.cities.cities[start].name)
                && GameBoard.routes.routes[i].destination.equalsIgnoreCase(GameBoard.cities.cities[end].name))
            || (GameBoard.routes.routes[i].location.equalsIgnoreCase(GameBoard.cities.cities[end].name)
                && GameBoard.routes.routes[i].destination.equalsIgnoreCase(GameBoard.cities.cities[start].name))) {
                if (GameBoard.routes.routes[i].claimedBy == 0) {
                    possible.add(GameBoard.routes.routes[i]);
                }
                else {
                    if (GameBoard.currentPlayer == GameBoard.p1) {
                        if (GameBoard.routes.routes[i].claimedBy == 1) return false;
                    }
                    if (GameBoard.currentPlayer == GameBoard.p2) {
                        if (GameBoard.routes.routes[i].claimedBy == 2) return false;
                    }
                    if (GameBoard.currentPlayer == GameBoard.p3) {
                        if (GameBoard.routes.routes[i].claimedBy == 3) return false;
                    }
                    if (GameBoard.currentPlayer == GameBoard.p4) {
                        if (GameBoard.routes.routes[i].claimedBy == 4) return false;
                    }
                    if (GameBoard.currentPlayer == GameBoard.p5) {
                        if (GameBoard.routes.routes[i].claimedBy == 5) return false;
                    }
                }
            }
        }

        for (int i = possible.size() - 1; i >= 0; i--) {
            Route thisRoute = possible.get(i);
            routeColor = thisRoute.color;
            countTrainCards();

            if (routeColor.equals(Color.WHITE)) {
                if (thisRoute.length > numWhiteCards + numRainCards) possible.remove(i);
            }
            if (routeColor.equals(Color.RED)) {
                if (thisRoute.length > numRedCards + numRainCards) possible.remove(i);
            }
            if (routeColor.equals(Color.BLACK)) {
                if (thisRoute.length > numBlackCards + numRainCards) possible.remove(i);
            }
            if (routeColor.equals(Color.BLUE)) {
                if (thisRoute.length > numBlueCards + numRainCards) possible.remove(i);
            }
            if (routeColor .equals(Color.YELLOW)) {
                if (thisRoute.length > numYellowCards + numRainCards) possible.remove(i);
            }
            if (routeColor.equals(PURPLE)) {
                if (thisRoute.length > numPurpleCards + numRainCards) possible.remove(i);
            }
            if (routeColor.equals(Color.ORANGE)) {
                if (thisRoute.length > numOrangeCards + numRainCards) possible.remove(i);
            }
            if (routeColor.equals(Color.GREEN)) {
                if (thisRoute.length > numGreenCards + numRainCards) possible.remove(i);
            }
            if (routeColor.equals(Color.GRAY)) {
                if (thisRoute.length > numWhiteCards + numRainCards &&
                thisRoute.length > numRedCards + numRainCards &&
                thisRoute.length > numBlackCards + numRainCards &&
                thisRoute.length > numBlueCards + numRainCards &&
                thisRoute.length > numYellowCards + numRainCards &&
                thisRoute.length > numPurpleCards + numRainCards &&
                thisRoute.length > numOrangeCards + numRainCards &&
                thisRoute.length > numGreenCards + numRainCards) {
                    possible.remove(i);
                }
            }
            else if (thisRoute.length > numColoredTrains) possible.remove(i);
        }
        if (possible.size() == 0) return false;

        Object[] options = new Object[possible.size()];
        for (int i = 0; i < options.length; i++) {
            options[i] = possible.get(i).location + ", " + possible.get(i).destination +
            " (" + possible.get(i).length + ")" + " - " + string(possible.get(i).color);
        }
        int choice = JOptionPane.showOptionDialog(null,"Which route would you like to claim","Ticket to Ride - Claim Route",
                JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,null);
        Route chosen = possible.get(choice);
        for (int i = 0; i < possible.size(); i++) {
            if (i != choice) possible.get(i).claimedBy = 6;
        }
        int count = 0;
        ArrayList<Object> used = new ArrayList<Object>();
        while (used.size() < chosen.length) {
            if (chosen.color.equals(Color.WHITE)) {
                options = new Object[numWhiteCards + numRainCards];
                for (int i = 0; i < numWhiteCards; i++) {
                    options[i] = "White";
                }
                for (int i = numWhiteCards; i < options.length; i++) {
                    options[i] = "Rainbow";
                }
            }
            if (chosen.color.equals(Color.RED)) {
                options = new Object[numRedCards + numRainCards];
                for (int i = 0; i < numRedCards; i++) {
                    options[i] = "Red";
                }
                for (int i = numRedCards; i < options.length; i++) {
                    options[i] = "Rainbow";
                }
            }
            if (chosen.color.equals(Color.BLACK)) {
                options = new Object[numBlackCards + numRainCards];
                for (int i = 0; i < numBlackCards; i++) {
                    options[i] = "Black";
                }
                for (int i = numBlackCards; i < options.length; i++) {
                    options[i] = "Rainbow";
                }
            }
            if (chosen.color.equals(Color.BLUE)) {
                options = new Object[numBlueCards + numRainCards];
                for (int i = 0; i < numBlueCards; i++) {
                    options[i] = "Blue";
                }
                for (int i = numBlueCards; i < options.length; i++) {
                    options[i] = "Rainbow";
                }
            }
            if (chosen.color.equals(Color.YELLOW)) {
                options = new Object[numYellowCards + numRainCards];
                for (int i = 0; i < numYellowCards; i++) {
                    options[i] = "Yellow";
                }
                for (int i = numYellowCards; i < options.length; i++) {
                    options[i] = "Rainbow";
                }
            }
            if (chosen.color.equals(new Color(150, 0, 150))) {
                options = new Object[numPurpleCards + numRainCards];
                for (int i = 0; i < numPurpleCards; i++) {
                    options[i] = "Purple";
                }
                for (int i = numPurpleCards; i < options.length; i++) {
                    options[i] = "Rainbow";
                }
            }
            if (chosen.color.equals(Color.ORANGE)) {
                options = new Object[numOrangeCards + numRainCards];
                for (int i = 0; i < numOrangeCards; i++) {
                    options[i] = "Orange";
                }
                for (int i = numOrangeCards; i < options.length; i++) {
                    options[i] = "Rainbow";
                }
            }
            if (chosen.color.equals(Color.GREEN)) {
                options = new Object[numGreenCards + numRainCards];
                for (int i = 0; i < numGreenCards; i++) {
                    options[i] = "Green";
                }
                for (int i = numGreenCards; i < options.length; i++) {
                    options[i] = "Rainbow";
                }
            }
            if (chosen.color.equals(Color.GRAY)) {
                ArrayList<Object> tempArray = new ArrayList<Object>();

                if(used.size() == 0){
                    if(numRainCards != 0){
                        for(int i = 0; i < numRainCards; i++){
                            tempArray.add("Rainbow");
                        }
                        if(numBlackCards + numRainCards < chosen.getLength()){
                        }
                        else{
                            for (int i = 0; i < numBlackCards; i++) {
                                tempArray.add("Black");
                            }
                        }
                        if(numGreenCards + numRainCards < chosen.getLength()){
                        }
                        else{
                            for (int i = 0; i < numGreenCards; i++) {
                                tempArray.add("Green");
                            }
                        }
                        if(numBlueCards + numRainCards < chosen.getLength()){
                        }
                        else{
                            for (int i = 0; i < numBlueCards; i++) {
                                tempArray.add("Blue");
                            }
                        }
                        if(numWhiteCards + numRainCards < chosen.getLength()){
                        }
                        else{
                            for (int i = 0; i < numWhiteCards; i++) {
                                tempArray.add("White");
                            }
                        }
                        if(numYellowCards + numRainCards < chosen.getLength()){
                        }
                        else{
                            for (int i = 0; i < numYellowCards; i++) {
                                tempArray.add("Yellow");
                            }
                        }
                        if(numPurpleCards + numRainCards < chosen.getLength()){
                        }
                        else{
                            for (int i = 0; i < numPurpleCards; i++) {
                                tempArray.add("Purple");
                            }
                        }
                        if(numRedCards + numRainCards < chosen.getLength()){
                        }
                        else{
                            for (int i = 0; i < numRedCards; i++) {
                                tempArray.add("Red");
                            }
                        }
                        if(numOrangeCards + numRainCards < chosen.getLength()){
                        }
                        else{
                            for (int i = 0; i < numOrangeCards; i++) {
                                tempArray.add("Orange");
                            }
                        }
                        options = new Object[tempArray.size()];
                        if(tempArray.size() - numRainCards != 0){
                            for(int i = 0; i < tempArray.size(); i++){
                                options[i] = tempArray.get(i);
                            }
                        }
                        else{
                            for(int i = 0; i < tempArray.size(); i++){
                                options[i] = tempArray.get(i);
                            }
                        }
                    }

                    else if(numRainCards == 0){
                        if(numBlackCards < chosen.getLength()){
                        }
                        else{
                            for (int i = 0; i < numBlackCards; i++) {
                                tempArray.add("Black");
                            }
                        }
                        if(numGreenCards < chosen.getLength()){
                        }
                        else{
                            for (int i = 0; i < numGreenCards; i++) {
                                tempArray.add("Green");
                            }
                        }
                        if(numBlueCards < chosen.getLength()){
                        }
                        else{
                            for (int i = 0; i < numBlueCards; i++) {
                                tempArray.add("Blue");
                            }
                        }
                        if(numWhiteCards < chosen.getLength()){
                        }
                        else{
                            for (int i = 0; i < numWhiteCards; i++) {
                                tempArray.add("White");
                            }
                        }
                        if(numYellowCards < chosen.getLength()){
                        }
                        else{
                            for (int i = 0; i < numYellowCards; i++) {
                                tempArray.add("Yellow");
                            }
                        }
                        if(numPurpleCards < chosen.getLength()){
                        }
                        else{
                            for (int i = 0; i < numPurpleCards; i++) {
                                tempArray.add("Purple");
                            }
                        }
                        if(numRedCards < chosen.getLength()){
                        }
                        else{
                            for (int i = 0; i < numRedCards; i++) {
                                tempArray.add("Red");
                            }
                        }
                        if(numOrangeCards < chosen.getLength()){
                        }
                        else{
                            for (int i = 0; i < numOrangeCards; i++) {
                                tempArray.add("Orange");
                            }
                        }
                        options = new Object[tempArray.size()];
                        if(tempArray.size() - numRainCards != 0){
                            for(int i = 0; i < tempArray.size(); i++){
                                options[i] = tempArray.get(i);
                            }
                        }
                        else{
                            for(int i = 0; i < tempArray.size(); i++){
                                options[i] = tempArray.get(i);
                            }
                        }
                    }
                }
                else if(used.size() > 0){
                    if(numRainCards == 0 && used.contains("Rainbow")){
                        int rainNum = 0;
                        for(int j = 0; j < used.size(); j++){
                            if(used.contains("Rainbow")){
                                rainNum++;
                            }
                        }
                        if(numBlackCards < chosen.getLength() - rainNum){
                        }
                        else{
                            for (int i = 0; i < numBlackCards; i++) {
                                tempArray.add("Black");
                            }
                        }
                        if(numGreenCards < chosen.getLength() - rainNum){
                        }
                        else{
                            for (int i = 0; i < numGreenCards; i++) {
                                tempArray.add("Green");
                            }
                        }
                        if(numBlueCards < chosen.getLength() - rainNum){
                        }
                        else{
                            for (int i = 0; i < numBlueCards; i++) {
                                tempArray.add("Blue");
                            }
                        }
                        if(numWhiteCards < chosen.getLength() - rainNum){
                        }
                        else{
                            for (int i = 0; i < numWhiteCards; i++) {
                                tempArray.add("White");
                            }
                        }
                        if(numYellowCards < chosen.getLength() - rainNum){
                        }
                        else{
                            for (int i = 0; i < numYellowCards; i++) {
                                tempArray.add("Yellow");
                            }
                        }
                        if(numPurpleCards < chosen.getLength() - rainNum){
                        }
                        else{
                            for (int i = 0; i < numPurpleCards; i++) {
                                tempArray.add("Purple");
                            }
                        }
                        if(numRedCards < chosen.getLength() - rainNum){
                        }
                        else{
                            for (int i = 0; i < numRedCards; i++) {
                                tempArray.add("Red");
                            }
                        }
                        if(numOrangeCards < chosen.getLength() - rainNum){
                        }
                        else{
                            for (int i = 0; i < numOrangeCards; i++) {
                                tempArray.add("Orange");
                            }
                        }
                        options = new Object[tempArray.size()];
                        if(tempArray.size() - numRainCards != 0){
                            for(int i = 0; i < tempArray.size(); i++){
                                options[i] = tempArray.get(i);
                            }
                        }
                        else{
                            for(int i = 0; i < tempArray.size(); i++){
                                options[i] = tempArray.get(i);
                            }
                        }  
                    }
                    else if(used.contains("Orange")){
                        for (int i = 0; i < numOrangeCards; i++) {
                            tempArray.add("Orange");
                        }
                        for (int i = 0; i < numRainCards; i++) {
                            tempArray.add("Rainbow");
                        }
                    }
                    else if(used.contains("Blue")){
                        for (int i = 0; i < numBlueCards; i++) {
                            tempArray.add("Blue");
                        }
                        for (int i = 0; i < numRainCards; i++) {
                            tempArray.add("Rainbow");
                        }
                    }
                    else if(used.contains("Red")){
                        for (int i = 0; i < numRedCards; i++) {
                            tempArray.add("Red");
                        }
                        for (int i = 0; i < numRainCards; i++) {
                            tempArray.add("Rainbow");
                        }
                    }
                    else if(used.contains("Black")){
                        for (int i = 0; i < numBlackCards; i++) {
                            tempArray.add("Black");
                        }
                        for (int i = 0; i < numRainCards; i++) {
                            tempArray.add("Rainbow");
                        }
                    }
                    else if(used.contains("White")){
                        for (int i = 0; i < numWhiteCards; i++) {
                            tempArray.add("White");
                        }
                        for (int i = 0; i < numRainCards; i++) {
                            tempArray.add("Rainbow");
                        }
                    }
                    else if(used.contains("Green")){
                        for (int i = 0; i < numGreenCards; i++) {
                            tempArray.add("Green");
                        }
                        for (int i = 0; i < numRainCards; i++) {
                            tempArray.add("Rainbow");
                        }
                    }
                    else if(used.contains("Purple")){
                        for (int i = 0; i < numPurpleCards; i++) {
                            tempArray.add("Purple");
                        }
                        for (int i = 0; i < numRainCards; i++) {
                            tempArray.add("Rainbow");
                        }
                    }
                    else if(used.contains("Yellow")){
                        for (int i = 0; i < numYellowCards; i++) {
                            tempArray.add("Yellow");
                        }
                        for (int i = 0; i < numRainCards; i++) {
                            tempArray.add("Rainbow");
                        }
                    }
                    else if(used.contains("Rainbow")){
                        int rainNum = 0;
                        for(int j = 0; j < used.size(); j++){
                            if(used.contains("Rainbow")){
                                rainNum++;
                            }
                        }
                        if(numBlackCards < chosen.getLength() - rainNum){
                        }
                        else{
                            for (int i = 0; i < numBlackCards; i++) {
                                tempArray.add("Black");
                            }
                        }
                        if(numGreenCards < chosen.getLength() - rainNum){
                        }
                        else{
                            for (int i = 0; i < numGreenCards; i++) {
                                tempArray.add("Green");
                            }
                        }
                        if(numBlueCards < chosen.getLength() - rainNum){
                        }
                        else{
                            for (int i = 0; i < numBlueCards; i++) {
                                tempArray.add("Blue");
                            }
                        }
                        if(numWhiteCards < chosen.getLength() - rainNum){
                        }
                        else{
                            for (int i = 0; i < numWhiteCards; i++) {
                                tempArray.add("White");
                            }
                        }
                        if(numYellowCards < chosen.getLength() - rainNum){
                        }
                        else{
                            for (int i = 0; i < numYellowCards; i++) {
                                tempArray.add("Yellow");
                            }
                        }
                        if(numPurpleCards < chosen.getLength() - rainNum){
                        }
                        else{
                            for (int i = 0; i < numPurpleCards; i++) {
                                tempArray.add("Purple");
                            }
                        }
                        if(numRedCards < chosen.getLength() - rainNum){
                        }
                        else{
                            for (int i = 0; i < numRedCards; i++) {
                                tempArray.add("Red");
                            }
                        }
                        if(numOrangeCards < chosen.getLength() - rainNum){
                        }
                        else{
                            for (int i = 0; i < numOrangeCards; i++) {
                                tempArray.add("Orange");
                            }
                        }
                        options = new Object[tempArray.size()];
                        if(tempArray.size() - numRainCards != 0){
                            for(int i = 0; i < tempArray.size(); i++){
                                options[i] = tempArray.get(i);
                            }
                        }
                        else{
                            for(int i = 0; i < tempArray.size(); i++){
                                options[i] = tempArray.get(i);
                            }
                        }
                    }
                    options = new Object[tempArray.size()];
                    if(tempArray.size() - numRainCards != 0){
                        for(int i = 0; i < tempArray.size(); i++){
                            options[i] = tempArray.get(i);
                        }
                    }
                    else{
                        for(int i = 0; i < tempArray.size(); i++){
                            options[i] = tempArray.get(i);
                        }
                    }
                }
            }
            choice = JOptionPane.showOptionDialog(null,"Which card would you like to use to claim route",
                "Ticket to Ride - Claim Route", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,null,options,null);

            for (int i = 0; i < trainCards.size(); i++) {
                if (trainCards.get(i).color.equalsIgnoreCase((String)options[choice])) {
                    used.add(trainCards.get(i).getColor());
                    trainCards.remove(i);
                    countTrainCards();
                    break;
                }
            }

            count++;
        }
        City c1 = GameBoard.cities.cities[start];
        City c2 = GameBoard.cities.cities[end];
        ArrayList<Meeple> tempMeeples = new ArrayList<Meeple>();
        ArrayList<Meeple> tmpMeeples = new ArrayList<Meeple>();
        if (GameBoard.currentPlayer == GameBoard.p1) {
            chosen.claimedBy = 1;
            claimedRoutes.add(chosen);
            Object[] o1 = new Object[c1.numMeeples];
            for(int i = 0; i <c1.numMeeples; i++)
            {
                tempMeeples.add(c1.meeples[i]);
                o1[i] = c1.meeples[i].getColor();
            }
            int m = JOptionPane.showOptionDialog(null,"Which meeples would you like to claim?",
                    "Ticket to Ride - Claim Meeples", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null,o1,null);
            Meeple meep = tempMeeples.remove(m);

            for(int i = 0; i < tempMeeples.size(); i ++)
            {
                if(!(tempMeeples.get(i).color.equalsIgnoreCase((String)o1[m])))
                {
                    c1.meeples[i] = null;
                    for (int j = 0; j<c1.meeples.length; j++)
                    {
                        if(c1.meeples[j] == null && j != c1.meeples.length-1)
                        {
                            Meeple tmp = c1.meeples[j+1];
                            c1.meeples[j + 1] = c1.meeples[j];
                            c1.meeples[j] = tmp;
                        }

                    }
                }
            }
            if (meep.getColor().equals("Red"))
            {
                redMeeples.add(meep);
                redM++;
            }
            else if (meep.getColor().equals("Blue"))
            {
                blueMeeples.add(meep);
                blueM++;
            }
            else if (meep.getColor().equals("Yellow"))
            {
                yellowMeeples.add(meep);
                yellowM++;
            }
            else if (meep.getColor().equals("Green"))
            {
                greenMeeples.add(meep);
                greenM++;
            }
            else if (meep.getColor().equals("White"))
            {
                whiteMeeples.add(meep);
                whiteM++;
            }
            else if (meep.getColor().equals("Black"))
            {
                blackMeeples.add(meep);
                blackM++;
            }

            Object[] o2 = new Object[c2.numMeeples];
            for(int i = 0; i <c2.numMeeples; i++)
            {
                tmpMeeples.add(c2.meeples[i]);
                o2[i] = c2.meeples[i].getColor();
            }
            int n = JOptionPane.showOptionDialog(null,"Which meeples would you like to claim?",
                    "Ticket to Ride - Claim Meeples", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null,o2,null);
            Meeple mple = tmpMeeples.remove(n);

            for(int i = 0; i <tmpMeeples.size(); i ++)
            {
                if(!(tmpMeeples.get(i).color.equalsIgnoreCase((String)o2[n])))
                {
                    c2.meeples[i] = null;
                    for (int j = 0; j<c2.meeples.length ; j++)
                    {
                        if(c2.meeples[j] == null && j != c2.meeples.length-1)
                        {
                            Meeple tmp = c2.meeples[j+1];
                            c2.meeples[j + 1] = c2.meeples[j];
                            c2.meeples[j] = tmp;
                        }

                    }
                }
            }
            if (mple.getColor().equals("Red"))
            {
                redMeeples.add(mple);
                redM++;
            }
            else if (mple.getColor().equals("Blue"))
            {
                blueMeeples.add(mple);
                blueM++;
            }
            else if (mple.getColor().equals("Yellow"))
            {
                yellowMeeples.add(mple);
                yellowM++;
            }
            else if (mple.getColor().equals("Green"))
            {
                greenMeeples.add(mple);
                greenM++;
            }
            else if (mple.getColor().equals("White"))
            {
                whiteMeeples.add(mple);
                whiteM++;
            }
            else if (mple.getColor().equals("Black"))
            {
                blackMeeples.add(mple);
                blackM++;
            }

            numColoredTrains = numColoredTrains - chosen.getLength();
        }
        if (GameBoard.currentPlayer == GameBoard.p2) {
            chosen.claimedBy = 2;

            claimedRoutes.add(chosen);
            Object[] o1 = new Object[c1.numMeeples];
            for(int i = 0; i <c1.numMeeples; i++)
            {
                tempMeeples.add(c1.meeples[i]);
                o1[i] = c1.meeples[i].getColor();
            }
            int m = JOptionPane.showOptionDialog(null,"Which meeples would you like to claim?",
                    "Ticket to Ride - Claim Meeples", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null,o1,null);
            Meeple meep = tempMeeples.remove(m);

            for(int i = 0; i < tempMeeples.size(); i ++)
            {
                if(!(tempMeeples.get(i).color.equalsIgnoreCase((String)o1[m])))
                {
                    c1.meeples[i] = null;
                    for (int j = 0; j<c1.meeples.length; j++)
                    {
                        if(c1.meeples[j] == null && j != c1.meeples.length-1)
                        {
                            Meeple tmp = c1.meeples[j+1];
                            c1.meeples[j + 1] = c1.meeples[j];
                            c1.meeples[j] = tmp;
                        }

                    }
                }
            }
            if (meep.getColor().equals("Red"))
            {
                redMeeples.add(meep);
                redM++;
            }
            else if (meep.getColor().equals("Blue"))
            {
                blueMeeples.add(meep);
                blueM++;
            }
            else if (meep.getColor().equals("Yellow"))
            {
                yellowMeeples.add(meep);
                yellowM++;
            }
            else if (meep.getColor().equals("Green"))
            {
                greenMeeples.add(meep);
                greenM++;
            }
            else if (meep.getColor().equals("White"))
            {
                whiteMeeples.add(meep);
                whiteM++;
            }
            else if (meep.getColor().equals("Black"))
            {
                blackMeeples.add(meep);
                blackM++;
            }

            Object[] o2 = new Object[c2.numMeeples];
            for(int i = 0; i <c2.numMeeples; i++)
            {
                tmpMeeples.add(c2.meeples[i]);
                o2[i] = c2.meeples[i].getColor();
            }
            int n = JOptionPane.showOptionDialog(null,"Which meeples would you like to claim?",
                    "Ticket to Ride - Claim Meeples", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null,o2,null);
            Meeple mple = tmpMeeples.remove(n);

            for(int i = 0; i <tmpMeeples.size(); i ++)
            {
                if(!(tmpMeeples.get(i).color.equalsIgnoreCase((String)o2[n])))
                {
                    c2.meeples[i] = null;
                    for (int j = 0; j<c2.meeples.length ; j++)
                    {
                        if(c2.meeples[j] == null && j != c2.meeples.length-1)
                        {
                            Meeple tmp = c2.meeples[j+1];
                            c2.meeples[j + 1] = c2.meeples[j];
                            c2.meeples[j] = tmp;
                        }

                    }
                }
            }
            if (mple.getColor().equals("Red"))
            {
                redMeeples.add(mple);
                redM++;
            }
            else if (mple.getColor().equals("Blue"))
            {
                blueMeeples.add(mple);
                blueM++;
            }
            else if (mple.getColor().equals("Yellow"))
            {
                yellowMeeples.add(mple);
                yellowM++;
            }
            else if (mple.getColor().equals("Green"))
            {
                greenMeeples.add(mple);
                greenM++;
            }
            else if (mple.getColor().equals("White"))
            {
                whiteMeeples.add(mple);
                whiteM++;
            }
            else if (mple.getColor().equals("Black"))
            {
                blackMeeples.add(mple);
                blackM++;
            }

            numColoredTrains = numColoredTrains - chosen.getLength();
        }
        if (GameBoard.currentPlayer == GameBoard.p3) {
            chosen.claimedBy = 3;

            claimedRoutes.add(chosen);
            Object[] o1 = new Object[c1.numMeeples];
            for(int i = 0; i <c1.numMeeples; i++)
            {
                tempMeeples.add(c1.meeples[i]);
                o1[i] = c1.meeples[i].getColor();
            }
            int m = JOptionPane.showOptionDialog(null,"Which meeples would you like to claim?",
                    "Ticket to Ride - Claim Meeples", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null,o1,null);
            Meeple meep = tempMeeples.remove(m);

            for(int i = 0; i < tempMeeples.size(); i ++)
            {
                if(!(tempMeeples.get(i).color.equalsIgnoreCase((String)o1[m])))
                {
                    c1.meeples[i] = null;
                    for (int j = 0; j<c1.meeples.length; j++)
                    {
                        if(c1.meeples[j] == null && j != c1.meeples.length-1)
                        {
                            Meeple tmp = c1.meeples[j+1];
                            c1.meeples[j + 1] = c1.meeples[j];
                            c1.meeples[j] = tmp;
                        }

                    }
                }
            }
            if (meep.getColor().equals("Red"))
            {
                redMeeples.add(meep);
                redM++;
            }
            else if (meep.getColor().equals("Blue"))
            {
                blueMeeples.add(meep);
                blueM++;
            }
            else if (meep.getColor().equals("Yellow"))
            {
                yellowMeeples.add(meep);
                yellowM++;
            }
            else if (meep.getColor().equals("Green"))
            {
                greenMeeples.add(meep);
                greenM++;
            }
            else if (meep.getColor().equals("White"))
            {
                whiteMeeples.add(meep);
                whiteM++;
            }
            else if (meep.getColor().equals("Black"))
            {
                blackMeeples.add(meep);
                blackM++;
            }

            Object[] o2 = new Object[c2.numMeeples];
            for(int i = 0; i <c2.numMeeples; i++)
            {
                tmpMeeples.add(c2.meeples[i]);
                o2[i] = c2.meeples[i].getColor();
            }
            int n = JOptionPane.showOptionDialog(null,"Which meeples would you like to claim?",
                    "Ticket to Ride - Claim Meeples", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null,o2,null);
            Meeple mple = tmpMeeples.remove(n);

            for(int i = 0; i <tmpMeeples.size(); i ++)
            {
                if(!(tmpMeeples.get(i).color.equalsIgnoreCase((String)o2[n])))
                {
                    c2.meeples[i] = null;
                    for (int j = 0; j<c2.meeples.length ; j++)
                    {
                        if(c2.meeples[j] == null && j != c2.meeples.length-1)
                        {
                            Meeple tmp = c2.meeples[j+1];
                            c2.meeples[j + 1] = c2.meeples[j];
                            c2.meeples[j] = tmp;
                        }

                    }
                }
            }
            if (mple.getColor().equals("Red"))
            {
                redMeeples.add(mple);
                redM++;
            }
            else if (mple.getColor().equals("Blue"))
            {
                blueMeeples.add(mple);
                blueM++;
            }
            else if (mple.getColor().equals("Yellow"))
            {
                yellowMeeples.add(mple);
                yellowM++;
            }
            else if (mple.getColor().equals("Green"))
            {
                greenMeeples.add(mple);
                greenM++;
            }
            else if (mple.getColor().equals("White"))
            {
                whiteMeeples.add(mple);
                whiteM++;
            }
            else if (mple.getColor().equals("Black"))
            {
                blackMeeples.add(mple);
                blackM++;
            }

            numColoredTrains = numColoredTrains - chosen.getLength();
        }
        if (GameBoard.currentPlayer == GameBoard.p4) {
            chosen.claimedBy = 4;

            claimedRoutes.add(chosen);
            Object[] o1 = new Object[c1.numMeeples];
            for(int i = 0; i <c1.numMeeples; i++)
            {
                tempMeeples.add(c1.meeples[i]);
                o1[i] = c1.meeples[i].getColor();
            }
            int m = JOptionPane.showOptionDialog(null,"Which meeples would you like to claim?",
                    "Ticket to Ride - Claim Meeples", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null,o1,null);
            Meeple meep = tempMeeples.remove(m);

            for(int i = 0; i < tempMeeples.size(); i ++)
            {
                if(!(tempMeeples.get(i).color.equalsIgnoreCase((String)o1[m])))
                {
                    c1.meeples[i] = null;
                    for (int j = 0; j<c1.meeples.length; j++)
                    {
                        if(c1.meeples[j] == null && j != c1.meeples.length-1)
                        {
                            Meeple tmp = c1.meeples[j+1];
                            c1.meeples[j + 1] = c1.meeples[j];
                            c1.meeples[j] = tmp;
                        }

                    }
                }
            }
            if (meep.getColor().equals("Red"))
            {
                redMeeples.add(meep);
                redM++;
            }
            else if (meep.getColor().equals("Blue"))
            {
                blueMeeples.add(meep);
                blueM++;
            }
            else if (meep.getColor().equals("Yellow"))
            {
                yellowMeeples.add(meep);
                yellowM++;
            }
            else if (meep.getColor().equals("Green"))
            {
                greenMeeples.add(meep);
                greenM++;
            }
            else if (meep.getColor().equals("White"))
            {
                whiteMeeples.add(meep);
                whiteM++;
            }
            else if (meep.getColor().equals("Black"))
            {
                blackMeeples.add(meep);
                blackM++;
            }

            Object[] o2 = new Object[c2.numMeeples];
            for(int i = 0; i <c2.numMeeples; i++)
            {
                tmpMeeples.add(c2.meeples[i]);
                o2[i] = c2.meeples[i].getColor();
            }
            int n = JOptionPane.showOptionDialog(null,"Which meeples would you like to claim?",
                    "Ticket to Ride - Claim Meeples", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null,o2,null);
            Meeple mple = tmpMeeples.remove(n);

            for(int i = 0; i <tmpMeeples.size(); i ++)
            {
                if(!(tmpMeeples.get(i).color.equalsIgnoreCase((String)o2[n])))
                {
                    c2.meeples[i] = null;
                    for (int j = 0; j<c2.meeples.length ; j++)
                    {
                        if(c2.meeples[j] == null && j != c2.meeples.length-1)
                        {
                            Meeple tmp = c2.meeples[j+1];
                            c2.meeples[j + 1] = c2.meeples[j];
                            c2.meeples[j] = tmp;
                        }

                    }
                }
            }
            if (mple.getColor().equals("Red"))
            {
                redMeeples.add(mple);
                redM++;
            }
            else if (mple.getColor().equals("Blue"))
            {
                blueMeeples.add(mple);
                blueM++;
            }
            else if (mple.getColor().equals("Yellow"))
            {
                yellowMeeples.add(mple);
                yellowM++;
            }
            else if (mple.getColor().equals("Green"))
            {
                greenMeeples.add(mple);
                greenM++;
            }
            else if (mple.getColor().equals("White"))
            {
                whiteMeeples.add(mple);
                whiteM++;
            }
            else if (mple.getColor().equals("Black"))
            {
                blackMeeples.add(mple);
                blackM++;
            }

            numColoredTrains = numColoredTrains - chosen.getLength();
        }
        if (GameBoard.currentPlayer == GameBoard.p5) {
            chosen.claimedBy = 5;

            claimedRoutes.add(chosen);
            Object[] o1 = new Object[c1.numMeeples];
            for(int i = 0; i <c1.numMeeples; i++)
            {
                tempMeeples.add(c1.meeples[i]);
                o1[i] = c1.meeples[i].getColor();
            }
            int m = JOptionPane.showOptionDialog(null,"Which meeples would you like to claim?",
                    "Ticket to Ride - Claim Meeples", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null,o1,null);
            Meeple meep = tempMeeples.remove(m);

            for(int i = 0; i < tempMeeples.size(); i ++)
            {
                if(!(tempMeeples.get(i).color.equalsIgnoreCase((String)o1[m])))
                {
                    c1.meeples[i] = null;
                    for (int j = 0; j<c1.meeples.length; j++)
                    {
                        if(c1.meeples[j] == null && j != c1.meeples.length-1)
                        {
                            Meeple tmp = c1.meeples[j+1];
                            c1.meeples[j + 1] = c1.meeples[j];
                            c1.meeples[j] = tmp;
                        }

                    }
                }
            }
            if (meep.getColor().equals("Red"))
            {
                redMeeples.add(meep);
                redM++;
            }
            else if (meep.getColor().equals("Blue"))
            {
                blueMeeples.add(meep);
                blueM++;
            }
            else if (meep.getColor().equals("Yellow"))
            {
                yellowMeeples.add(meep);
                yellowM++;
            }
            else if (meep.getColor().equals("Green"))
            {
                greenMeeples.add(meep);
                greenM++;
            }
            else if (meep.getColor().equals("White"))
            {
                whiteMeeples.add(meep);
                whiteM++;
            }
            else if (meep.getColor().equals("Black"))
            {
                blackMeeples.add(meep);
                blackM++;
            }

            Object[] o2 = new Object[c2.numMeeples];
            for(int i = 0; i <c2.numMeeples; i++)
            {
                tmpMeeples.add(c2.meeples[i]);
                o2[i] = c2.meeples[i].getColor();
            }
            int n = JOptionPane.showOptionDialog(null,"Which meeples would you like to claim?",
                    "Ticket to Ride - Claim Meeples", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null,o2,null);
            Meeple mple = tmpMeeples.remove(n);

            for(int i = 0; i <tmpMeeples.size(); i ++)
            {
                if(!(tmpMeeples.get(i).color.equalsIgnoreCase((String)o2[n])))
                {
                    c2.meeples[i] = null;
                    for (int j = 0; j<c2.meeples.length ; j++)
                    {
                        if(c2.meeples[j] == null && j != c2.meeples.length-1)
                        {
                            Meeple tmp = c2.meeples[j+1];
                            c2.meeples[j + 1] = c2.meeples[j];
                            c2.meeples[j] = tmp;
                        }

                    }
                }
            }
            if (mple.getColor().equals("Red"))
            {
                redMeeples.add(mple);
                redM++;
            }
            else if (mple.getColor().equals("Blue"))
            {
                blueMeeples.add(mple);
                blueM++;
            }
            else if (mple.getColor().equals("Yellow"))
            {
                yellowMeeples.add(mple);
                yellowM++;
            }
            else if (mple.getColor().equals("Green"))
            {
                greenMeeples.add(mple);
                greenM++;
            }
            else if (mple.getColor().equals("White"))
            {
                whiteMeeples.add(mple);
                whiteM++;
            }
            else if (mple.getColor().equals("Black"))
            {
                blackMeeples.add(mple);
                blackM++;
            }

            numColoredTrains = numColoredTrains - chosen.getLength();
        }

        return true;
    }

    public String string(Color c) {
        if (c.equals(Color.RED)) return "Red";
        if (c.equals(Color.BLACK)) return "Black";
        if (c.equals(Color.WHITE)) return "White";
        if (c.equals(Color.GRAY)) return "Gray";
        if (c.equals(Color.BLUE)) return "Blue";
        if (c.equals(Color.ORANGE)) return "Orange";
        if (c.equals(Color.GREEN)) return "Green";
        if (c.equals(Color.YELLOW)) return "Yellow";
        if (c.equals(new Color(150, 0, 150))) return "Purple";

        return "Color not found";
    }

    public void destinationScore() {
        for (int i = 0; i < tickets.size(); i++) {
            if (completedDestination(tickets.get(i).location, tickets.get(i).destination, claimedRoutes)) {
                score += tickets.get(i).length;
                claimedTicketRoutes.add(tickets.get(i));
            }
            else {
                score -= tickets.get(i).length;
                unclaimedTicketRoutes.add(tickets.get(i));
            }
        }
    }

    public boolean completedDestination(String start, String end, ArrayList<Route> temp)
    {
        for (int j = 0; j < temp.size(); j++) {
            if (start.equalsIgnoreCase(temp.get(j).location)) {
                if (temp.get(j).destination.equals(end)) return true;
                String newStart = temp.get(j).destination;
                temp.remove(j);
                return completedDestination(newStart, end, temp);
            }

            if (start.equalsIgnoreCase(temp.get(j).destination)) {
                if (temp.get(j).location.equals(end)) return true;
                String newStart = temp.get(j).location;
                temp.remove(j);
                return completedDestination(newStart, end, temp);
            }
        }

        return false;
    }

    public boolean notLastTurn() {
        if (numColoredTrains == 0 || numColoredTrains == 1 || numColoredTrains == 2) {
            return false;
        }
        return true;
    }

    public void routeScore()
    {   
        score = 0;
        for (int i = 0; i < claimedRoutes.size(); i++) {
            int length = claimedRoutes.get(i).length;
            if (length == 1)
            {
                score = score + 1;
            }
            else if (length == 2)
            {
                score = score + 2;
            }
            else if (length == 3)
            {
                score = score + 4;
            }
            else if (length == 4)
            {
                score = score + 7;
            }
            else if (length == 5)
            {
                score = score + 10;
            }
            else if (length == 6)
            {
                score = score + 15;
            }
            else if (length == 7)
            {
                score = score + 18;
            }
        }
    }

    public void claimedTickets()
    {
        for(int i = 0; i <claimedTicketRoutes.size(); i++)
        {
            score = score + claimedTicketRoutes.get(i).getLength();
        }

    }

    public void unclaimedTickets()
    {
        for(int i = 0; i <unclaimedTicketRoutes.size(); i++)
        {
            score = score - unclaimedTicketRoutes.get(i).getLength();
        }

    }

    public int getClaimedRoutes()
    {
        int amount = 0;
        for (int i = 0; i<claimedTicketRoutes.size(); i++)
        {
            amount = amount + 1;
        }
        return amount;
    }

    public static void globeTrotterBonus()
    {
        ArrayList<Player> temp = new ArrayList<Player>();
        if (GameBoard.numPlayers == 2) {
            if (GameBoard.p1.claimedTicketRoutes.size() >= GameBoard.p2.claimedTicketRoutes.size()) {
                temp.add(GameBoard.p1);
            }
            if (GameBoard.p2.claimedTicketRoutes.size() >= GameBoard.p1.claimedTicketRoutes.size()) {
                temp.add(GameBoard.p2);
            }
        }
        else if (GameBoard.numPlayers == 3) {
            if (GameBoard.p1.claimedTicketRoutes.size() >= GameBoard.p2.claimedTicketRoutes.size() &&
            GameBoard.p1.claimedTicketRoutes.size() >= GameBoard.p3.claimedTicketRoutes.size()) {
                temp.add(GameBoard.p1);
            }
            if (GameBoard.p2.claimedTicketRoutes.size() >= GameBoard.p1.claimedTicketRoutes.size() &&
            GameBoard.p2.claimedTicketRoutes.size() >= GameBoard.p3.claimedTicketRoutes.size()) {
                temp.add(GameBoard.p2);
            }
            if (GameBoard.p3.claimedTicketRoutes.size() >= GameBoard.p1.claimedTicketRoutes.size() &&
            GameBoard.p3.claimedTicketRoutes.size() >= GameBoard.p2.claimedTicketRoutes.size()) {
                temp.add(GameBoard.p3);
            }
        }
        else if (GameBoard.numPlayers == 4) {
            if (GameBoard.p1.claimedTicketRoutes.size() >= GameBoard.p2.claimedTicketRoutes.size() &&
            GameBoard.p1.claimedTicketRoutes.size() >= GameBoard.p3.claimedTicketRoutes.size() &&
            GameBoard.p1.claimedTicketRoutes.size() >= GameBoard.p4.claimedTicketRoutes.size()) {
                temp.add(GameBoard.p1);
            }
            if (GameBoard.p2.claimedTicketRoutes.size() >= GameBoard.p1.claimedTicketRoutes.size() &&
            GameBoard.p2.claimedTicketRoutes.size() >= GameBoard.p3.claimedTicketRoutes.size() &&
            GameBoard.p2.claimedTicketRoutes.size() >= GameBoard.p4.claimedTicketRoutes.size()) {
                temp.add(GameBoard.p2);
            }
            if (GameBoard.p3.claimedTicketRoutes.size() >= GameBoard.p1.claimedTicketRoutes.size() &&
            GameBoard.p3.claimedTicketRoutes.size() >= GameBoard.p2.claimedTicketRoutes.size() &&
            GameBoard.p3.claimedTicketRoutes.size() >= GameBoard.p4.claimedTicketRoutes.size()) {
                temp.add(GameBoard.p3);
            }
            if (GameBoard.p4.claimedTicketRoutes.size() >= GameBoard.p1.claimedTicketRoutes.size() &&
            GameBoard.p4.claimedTicketRoutes.size() >= GameBoard.p2.claimedTicketRoutes.size() &&
            GameBoard.p4.claimedTicketRoutes.size() >= GameBoard.p3.claimedTicketRoutes.size()) {
                temp.add(GameBoard.p4);
            }
        }
        else if (GameBoard.numPlayers == 5) {
            if (GameBoard.p1.claimedTicketRoutes.size() >= GameBoard.p2.claimedTicketRoutes.size() &&
            GameBoard.p1.claimedTicketRoutes.size() >= GameBoard.p3.claimedTicketRoutes.size() &&
            GameBoard.p1.claimedTicketRoutes.size() >= GameBoard.p4.claimedTicketRoutes.size() &&
            GameBoard.p1.claimedTicketRoutes.size() >= GameBoard.p5.claimedTicketRoutes.size()) {
                temp.add(GameBoard.p1);
            }
            if (GameBoard.p2.claimedTicketRoutes.size() >= GameBoard.p1.claimedTicketRoutes.size() &&
            GameBoard.p2.claimedTicketRoutes.size() >= GameBoard.p3.claimedTicketRoutes.size() &&
            GameBoard.p2.claimedTicketRoutes.size() >= GameBoard.p4.claimedTicketRoutes.size() &&
            GameBoard.p2.claimedTicketRoutes.size() >= GameBoard.p5.claimedTicketRoutes.size()) {
                temp.add(GameBoard.p2);
            }
            if (GameBoard.p3.claimedTicketRoutes.size() >= GameBoard.p1.claimedTicketRoutes.size() &&
            GameBoard.p3.claimedTicketRoutes.size() >= GameBoard.p2.claimedTicketRoutes.size() &&
            GameBoard.p3.claimedTicketRoutes.size() >= GameBoard.p4.claimedTicketRoutes.size() &&
            GameBoard.p3.claimedTicketRoutes.size() >= GameBoard.p5.claimedTicketRoutes.size()) {
                temp.add(GameBoard.p3);
            }
            if (GameBoard.p4.claimedTicketRoutes.size() >= GameBoard.p1.claimedTicketRoutes.size() &&
            GameBoard.p4.claimedTicketRoutes.size() >= GameBoard.p2.claimedTicketRoutes.size() &&
            GameBoard.p4.claimedTicketRoutes.size() >= GameBoard.p3.claimedTicketRoutes.size() &&
            GameBoard.p4.claimedTicketRoutes.size() >= GameBoard.p5.claimedTicketRoutes.size()) {
                temp.add(GameBoard.p4);
            }
            if (GameBoard.p5.claimedTicketRoutes.size() >= GameBoard.p1.claimedTicketRoutes.size() &&
            GameBoard.p5.claimedTicketRoutes.size() >= GameBoard.p2.claimedTicketRoutes.size() &&
            GameBoard.p5.claimedTicketRoutes.size() >= GameBoard.p3.claimedTicketRoutes.size() &&
            GameBoard.p5.claimedTicketRoutes.size() >= GameBoard.p4.claimedTicketRoutes.size()) {
                temp.add(GameBoard.p5);
            }
        }

        for (int i = 0; i < temp.size(); i++) {
            temp.get(i).score += 15;
        }
    }

    public static void meepleScore() {
        redMeepleScore();
        greenMeepleScore();
        blackMeepleScore();
        whiteMeepleScore();
        yellowMeepleScore();
        blueMeepleScore();
    }

    public static void blueMeepleScore() {
        ArrayList<Player> temp = new ArrayList<Player>();
        if (GameBoard.numPlayers == 2) {
            if (GameBoard.p1.returnBlueMeeples() >= GameBoard.p2.returnBlueMeeples()) {
                temp.add(GameBoard.p1);
            }
            if (GameBoard.p2.returnBlueMeeples() >= GameBoard.p1.returnBlueMeeples()) {
                temp.add(GameBoard.p2);
            }
        }
        else if (GameBoard.numPlayers == 3) {
            if (GameBoard.p1.returnBlueMeeples() >= GameBoard.p2.returnBlueMeeples() &&
            GameBoard.p1.returnBlueMeeples() >= GameBoard.p3.returnBlueMeeples()) {
                temp.add(GameBoard.p1);
            }
            if (GameBoard.p2.returnBlueMeeples() >= GameBoard.p1.returnBlueMeeples() &&
            GameBoard.p2.returnBlueMeeples() >= GameBoard.p3.returnBlueMeeples()) {
                temp.add(GameBoard.p2);
            }
            if (GameBoard.p3.returnBlueMeeples() >= GameBoard.p1.returnBlueMeeples() &&
            GameBoard.p3.returnBlueMeeples() >= GameBoard.p2.returnBlueMeeples()) {
                temp.add(GameBoard.p3);
            }
        }
        else if (GameBoard.numPlayers == 4) {
            if (GameBoard.p1.returnBlueMeeples() >= GameBoard.p2.returnBlueMeeples() &&
            GameBoard.p1.returnBlueMeeples() >= GameBoard.p3.returnBlueMeeples() &&
            GameBoard.p1.returnBlueMeeples() >= GameBoard.p4.returnBlueMeeples()) {
                temp.add(GameBoard.p1);
            }
            if (GameBoard.p2.returnBlueMeeples() >= GameBoard.p1.returnBlueMeeples() &&
            GameBoard.p2.returnBlueMeeples() >= GameBoard.p3.returnBlueMeeples() &&
            GameBoard.p2.returnBlueMeeples() >= GameBoard.p4.returnBlueMeeples()) {
                temp.add(GameBoard.p2);
            }
            if (GameBoard.p3.returnBlueMeeples() >= GameBoard.p1.returnBlueMeeples() &&
            GameBoard.p3.returnBlueMeeples() >= GameBoard.p2.returnBlueMeeples() &&
            GameBoard.p3.returnBlueMeeples() >= GameBoard.p4.returnBlueMeeples()) {
                temp.add(GameBoard.p3);
            }
            if (GameBoard.p4.returnBlueMeeples() >= GameBoard.p1.returnBlueMeeples() &&
            GameBoard.p4.returnBlueMeeples() >= GameBoard.p2.returnBlueMeeples() &&
            GameBoard.p4.returnBlueMeeples() >= GameBoard.p3.returnBlueMeeples()) {
                temp.add(GameBoard.p4);
            }
        }
        else if (GameBoard.numPlayers == 5) {
            if (GameBoard.p1.returnBlueMeeples() >= GameBoard.p2.returnBlueMeeples() &&
            GameBoard.p1.returnBlueMeeples() >= GameBoard.p3.returnBlueMeeples() &&
            GameBoard.p1.returnBlueMeeples() >= GameBoard.p4.returnBlueMeeples() &&
            GameBoard.p1.returnBlueMeeples() >= GameBoard.p5.returnBlueMeeples()) {
                temp.add(GameBoard.p1);
            }
            if (GameBoard.p2.returnBlueMeeples() >= GameBoard.p1.returnBlueMeeples() &&
            GameBoard.p2.returnBlueMeeples() >= GameBoard.p3.returnBlueMeeples() &&
            GameBoard.p2.returnBlueMeeples() >= GameBoard.p4.returnBlueMeeples() &&
            GameBoard.p2.returnBlueMeeples() >= GameBoard.p5.returnBlueMeeples()) {
                temp.add(GameBoard.p2);
            }
            if (GameBoard.p3.returnBlueMeeples() >= GameBoard.p1.returnBlueMeeples() &&
            GameBoard.p3.returnBlueMeeples() >= GameBoard.p2.returnBlueMeeples() &&
            GameBoard.p3.returnBlueMeeples() >= GameBoard.p4.returnBlueMeeples() &&
            GameBoard.p3.returnBlueMeeples() >= GameBoard.p5.returnBlueMeeples()) {
                temp.add(GameBoard.p3);
            }
            if (GameBoard.p4.returnBlueMeeples() >= GameBoard.p1.returnBlueMeeples() &&
            GameBoard.p4.returnBlueMeeples() >= GameBoard.p2.returnBlueMeeples() &&
            GameBoard.p4.returnBlueMeeples() >= GameBoard.p3.returnBlueMeeples() &&
            GameBoard.p4.returnBlueMeeples() >= GameBoard.p5.returnBlueMeeples()) {
                temp.add(GameBoard.p4);
            }
            if (GameBoard.p5.returnBlueMeeples() >= GameBoard.p1.returnBlueMeeples() &&
            GameBoard.p5.returnBlueMeeples() >= GameBoard.p2.returnBlueMeeples() &&
            GameBoard.p5.returnBlueMeeples() >= GameBoard.p3.returnBlueMeeples() &&
            GameBoard.p5.returnBlueMeeples() >= GameBoard.p4.returnBlueMeeples()) {
                temp.add(GameBoard.p5);
            }
        }

        int highest = temp.get(0).returnBlueMeeples();

        for (int i = 0; i < temp.size(); i++) {
            temp.get(i).score += 20;
        }

        if (temp.size() == 1) {
            temp.get(0).score += 20;
            ArrayList<Player> second = new ArrayList<Player>();
            if (GameBoard.numPlayers == 2) {
                if (GameBoard.p1.returnBlueMeeples() < highest &&
                GameBoard.p1.returnBlueMeeples() >= GameBoard.p2.returnBlueMeeples()) {
                    second.add(GameBoard.p1);
                }
                if (GameBoard.p2.returnBlueMeeples() < highest &&
                GameBoard.p2.returnBlueMeeples() >= GameBoard.p1.returnBlueMeeples()) {
                    second.add(GameBoard.p2);
                }
            }
            else if (GameBoard.numPlayers == 3) {
                if (GameBoard.p1.returnBlueMeeples() < highest &&
                GameBoard.p1.returnBlueMeeples() >= GameBoard.p2.returnBlueMeeples() &&
                GameBoard.p1.returnBlueMeeples() >= GameBoard.p3.returnBlueMeeples()) {
                    second.add(GameBoard.p1);
                }
                if (GameBoard.p2.returnBlueMeeples() < highest &&
                GameBoard.p2.returnBlueMeeples() >= GameBoard.p1.returnBlueMeeples() &&
                GameBoard.p2.returnBlueMeeples() >= GameBoard.p3.returnBlueMeeples()) {
                    second.add(GameBoard.p2);
                }
                if (GameBoard.p3.returnBlueMeeples() < highest &&
                GameBoard.p3.returnBlueMeeples() >= GameBoard.p1.returnBlueMeeples() &&
                GameBoard.p3.returnBlueMeeples() >= GameBoard.p2.returnBlueMeeples()) {
                    second.add(GameBoard.p3);
                }
            }
            else if (GameBoard.numPlayers == 4) {
                if (GameBoard.p1.returnBlueMeeples() < highest &&
                GameBoard.p1.returnBlueMeeples() >= GameBoard.p2.returnBlueMeeples() &&
                GameBoard.p1.returnBlueMeeples() >= GameBoard.p3.returnBlueMeeples() &&
                GameBoard.p1.returnBlueMeeples() >= GameBoard.p4.returnBlueMeeples()) {
                    second.add(GameBoard.p1);
                }
                if (GameBoard.p2.returnBlueMeeples() < highest &&
                GameBoard.p2.returnBlueMeeples() >= GameBoard.p1.returnBlueMeeples() &&
                GameBoard.p2.returnBlueMeeples() >= GameBoard.p3.returnBlueMeeples() &&
                GameBoard.p2.returnBlueMeeples() >= GameBoard.p4.returnBlueMeeples()) {
                    second.add(GameBoard.p2);
                }
                if (GameBoard.p3.returnBlueMeeples() < highest &&
                GameBoard.p3.returnBlueMeeples() >= GameBoard.p1.returnBlueMeeples() &&
                GameBoard.p3.returnBlueMeeples() >= GameBoard.p2.returnBlueMeeples() &&
                GameBoard.p3.returnBlueMeeples() >= GameBoard.p4.returnBlueMeeples()) {
                    second.add(GameBoard.p3);
                }
                if (GameBoard.p4.returnBlueMeeples() < highest &&
                GameBoard.p4.returnBlueMeeples() >= GameBoard.p1.returnBlueMeeples() &&
                GameBoard.p4.returnBlueMeeples() >= GameBoard.p2.returnBlueMeeples() &&
                GameBoard.p4.returnBlueMeeples() >= GameBoard.p3.returnBlueMeeples()) {
                    second.add(GameBoard.p4);
                }
            }
            else if (GameBoard.numPlayers == 5) {
                if (GameBoard.p1.returnBlueMeeples() < highest &&
                GameBoard.p1.returnBlueMeeples() >= GameBoard.p2.returnBlueMeeples() &&
                GameBoard.p1.returnBlueMeeples() >= GameBoard.p3.returnBlueMeeples() &&
                GameBoard.p1.returnBlueMeeples() >= GameBoard.p4.returnBlueMeeples() &&
                GameBoard.p1.returnBlueMeeples() >= GameBoard.p5.returnBlueMeeples()) {
                    second.add(GameBoard.p1);
                }
                if (GameBoard.p2.returnBlueMeeples() < highest &&
                GameBoard.p2.returnBlueMeeples() >= GameBoard.p1.returnBlueMeeples() &&
                GameBoard.p2.returnBlueMeeples() >= GameBoard.p3.returnBlueMeeples() &&
                GameBoard.p2.returnBlueMeeples() >= GameBoard.p4.returnBlueMeeples() &&
                GameBoard.p2.returnBlueMeeples() >= GameBoard.p5.returnBlueMeeples()) {
                    second.add(GameBoard.p2);
                }
                if (GameBoard.p3.returnBlueMeeples() < highest &&
                GameBoard.p3.returnBlueMeeples() >= GameBoard.p1.returnBlueMeeples() &&
                GameBoard.p3.returnBlueMeeples() >= GameBoard.p2.returnBlueMeeples() &&
                GameBoard.p3.returnBlueMeeples() >= GameBoard.p4.returnBlueMeeples() &&
                GameBoard.p3.returnBlueMeeples() >= GameBoard.p5.returnBlueMeeples()) {
                    second.add(GameBoard.p3);
                }
                if (GameBoard.p4.returnBlueMeeples() < highest &&
                GameBoard.p4.returnBlueMeeples() >= GameBoard.p1.returnBlueMeeples() &&
                GameBoard.p4.returnBlueMeeples() >= GameBoard.p2.returnBlueMeeples() &&
                GameBoard.p4.returnBlueMeeples() >= GameBoard.p3.returnBlueMeeples() &&
                GameBoard.p4.returnBlueMeeples() >= GameBoard.p5.returnBlueMeeples()) {
                    second.add(GameBoard.p4);
                }
                if (GameBoard.p5.returnBlueMeeples() < highest &&
                GameBoard.p5.returnBlueMeeples() >= GameBoard.p1.returnBlueMeeples() &&
                GameBoard.p5.returnBlueMeeples() >= GameBoard.p2.returnBlueMeeples() &&
                GameBoard.p5.returnBlueMeeples() >= GameBoard.p3.returnBlueMeeples() &&
                GameBoard.p5.returnBlueMeeples() >= GameBoard.p4.returnBlueMeeples()) {
                    second.add(GameBoard.p5);
                }
            }
            for (int i = 0; i < second.size(); i++) {
                second.get(i).score += 10;
            }
        }
    }

    public static void yellowMeepleScore() {
        ArrayList<Player> temp = new ArrayList<Player>();
        if (GameBoard.numPlayers == 2) {
            if (GameBoard.p1.returnYellowMeeples() >= GameBoard.p2.returnYellowMeeples()) {
                temp.add(GameBoard.p1);
            }
            if (GameBoard.p2.returnYellowMeeples() >= GameBoard.p1.returnYellowMeeples()) {
                temp.add(GameBoard.p2);
            }
        }
        else if (GameBoard.numPlayers == 3) {
            if (GameBoard.p1.returnYellowMeeples() >= GameBoard.p2.returnYellowMeeples() &&
            GameBoard.p1.returnYellowMeeples() >= GameBoard.p3.returnYellowMeeples()) {
                temp.add(GameBoard.p1);
            }
            if (GameBoard.p2.returnYellowMeeples() >= GameBoard.p1.returnYellowMeeples() &&
            GameBoard.p2.returnYellowMeeples() >= GameBoard.p3.returnYellowMeeples()) {
                temp.add(GameBoard.p2);
            }
            if (GameBoard.p3.returnYellowMeeples() >= GameBoard.p1.returnYellowMeeples() &&
            GameBoard.p3.returnYellowMeeples() >= GameBoard.p2.returnYellowMeeples()) {
                temp.add(GameBoard.p3);
            }
        }
        else if (GameBoard.numPlayers == 4) {
            if (GameBoard.p1.returnYellowMeeples() >= GameBoard.p2.returnYellowMeeples() &&
            GameBoard.p1.returnYellowMeeples() >= GameBoard.p3.returnYellowMeeples() &&
            GameBoard.p1.returnYellowMeeples() >= GameBoard.p4.returnYellowMeeples()) {
                temp.add(GameBoard.p1);
            }
            if (GameBoard.p2.returnYellowMeeples() >= GameBoard.p1.returnYellowMeeples() &&
            GameBoard.p2.returnYellowMeeples() >= GameBoard.p3.returnYellowMeeples() &&
            GameBoard.p2.returnYellowMeeples() >= GameBoard.p4.returnYellowMeeples()) {
                temp.add(GameBoard.p2);
            }
            if (GameBoard.p3.returnYellowMeeples() >= GameBoard.p1.returnYellowMeeples() &&
            GameBoard.p3.returnYellowMeeples() >= GameBoard.p2.returnYellowMeeples() &&
            GameBoard.p3.returnYellowMeeples() >= GameBoard.p4.returnYellowMeeples()) {
                temp.add(GameBoard.p3);
            }
            if (GameBoard.p4.returnYellowMeeples() >= GameBoard.p1.returnYellowMeeples() &&
            GameBoard.p4.returnYellowMeeples() >= GameBoard.p2.returnYellowMeeples() &&
            GameBoard.p4.returnYellowMeeples() >= GameBoard.p3.returnYellowMeeples()) {
                temp.add(GameBoard.p4);
            }
        }
        else if (GameBoard.numPlayers == 5) {
            if (GameBoard.p1.returnYellowMeeples() >= GameBoard.p2.returnYellowMeeples() &&
            GameBoard.p1.returnYellowMeeples() >= GameBoard.p3.returnYellowMeeples() &&
            GameBoard.p1.returnYellowMeeples() >= GameBoard.p4.returnYellowMeeples() &&
            GameBoard.p1.returnYellowMeeples() >= GameBoard.p5.returnYellowMeeples()) {
                temp.add(GameBoard.p1);
            }
            if (GameBoard.p2.returnYellowMeeples() >= GameBoard.p1.returnYellowMeeples() &&
            GameBoard.p2.returnYellowMeeples() >= GameBoard.p3.returnYellowMeeples() &&
            GameBoard.p2.returnYellowMeeples() >= GameBoard.p4.returnYellowMeeples() &&
            GameBoard.p2.returnYellowMeeples() >= GameBoard.p5.returnYellowMeeples()) {
                temp.add(GameBoard.p2);
            }
            if (GameBoard.p3.returnYellowMeeples() >= GameBoard.p1.returnYellowMeeples() &&
            GameBoard.p3.returnYellowMeeples() >= GameBoard.p2.returnYellowMeeples() &&
            GameBoard.p3.returnYellowMeeples() >= GameBoard.p4.returnYellowMeeples() &&
            GameBoard.p3.returnYellowMeeples() >= GameBoard.p5.returnYellowMeeples()) {
                temp.add(GameBoard.p3);
            }
            if (GameBoard.p4.returnYellowMeeples() >= GameBoard.p1.returnYellowMeeples() &&
            GameBoard.p4.returnYellowMeeples() >= GameBoard.p2.returnYellowMeeples() &&
            GameBoard.p4.returnYellowMeeples() >= GameBoard.p3.returnYellowMeeples() &&
            GameBoard.p4.returnYellowMeeples() >= GameBoard.p5.returnYellowMeeples()) {
                temp.add(GameBoard.p4);
            }
            if (GameBoard.p5.returnYellowMeeples() >= GameBoard.p1.returnYellowMeeples() &&
            GameBoard.p5.returnYellowMeeples() >= GameBoard.p2.returnYellowMeeples() &&
            GameBoard.p5.returnYellowMeeples() >= GameBoard.p3.returnYellowMeeples() &&
            GameBoard.p5.returnYellowMeeples() >= GameBoard.p4.returnYellowMeeples()) {
                temp.add(GameBoard.p5);
            }
        }

        int highest = temp.get(0).returnYellowMeeples();

        for (int i = 0; i < temp.size(); i++) {
            temp.get(i).score += 20;
        }

        if (temp.size() == 1) {
            temp.get(0).score += 20;
            ArrayList<Player> second = new ArrayList<Player>();
            if (GameBoard.numPlayers == 2) {
                if (GameBoard.p1.returnYellowMeeples() < highest &&
                GameBoard.p1.returnYellowMeeples() >= GameBoard.p2.returnYellowMeeples()) {
                    second.add(GameBoard.p1);
                }
                if (GameBoard.p2.returnYellowMeeples() < highest &&
                GameBoard.p2.returnYellowMeeples() >= GameBoard.p1.returnYellowMeeples()) {
                    second.add(GameBoard.p2);
                }
            }
            else if (GameBoard.numPlayers == 3) {
                if (GameBoard.p1.returnYellowMeeples() < highest &&
                GameBoard.p1.returnYellowMeeples() >= GameBoard.p2.returnYellowMeeples() &&
                GameBoard.p1.returnYellowMeeples() >= GameBoard.p3.returnYellowMeeples()) {
                    second.add(GameBoard.p1);
                }
                if (GameBoard.p2.returnYellowMeeples() < highest &&
                GameBoard.p2.returnYellowMeeples() >= GameBoard.p1.returnYellowMeeples() &&
                GameBoard.p2.returnYellowMeeples() >= GameBoard.p3.returnYellowMeeples()) {
                    second.add(GameBoard.p2);
                }
                if (GameBoard.p3.returnYellowMeeples() < highest &&
                GameBoard.p3.returnYellowMeeples() >= GameBoard.p1.returnYellowMeeples() &&
                GameBoard.p3.returnYellowMeeples() >= GameBoard.p2.returnYellowMeeples()) {
                    second.add(GameBoard.p3);
                }
            }
            else if (GameBoard.numPlayers == 4) {
                if (GameBoard.p1.returnYellowMeeples() < highest &&
                GameBoard.p1.returnYellowMeeples() >= GameBoard.p2.returnYellowMeeples() &&
                GameBoard.p1.returnYellowMeeples() >= GameBoard.p3.returnYellowMeeples() &&
                GameBoard.p1.returnYellowMeeples() >= GameBoard.p4.returnYellowMeeples()) {
                    second.add(GameBoard.p1);
                }
                if (GameBoard.p2.returnYellowMeeples() < highest &&
                GameBoard.p2.returnYellowMeeples() >= GameBoard.p1.returnYellowMeeples() &&
                GameBoard.p2.returnYellowMeeples() >= GameBoard.p3.returnYellowMeeples() &&
                GameBoard.p2.returnYellowMeeples() >= GameBoard.p4.returnYellowMeeples()) {
                    second.add(GameBoard.p2);
                }
                if (GameBoard.p3.returnYellowMeeples() < highest &&
                GameBoard.p3.returnYellowMeeples() >= GameBoard.p1.returnYellowMeeples() &&
                GameBoard.p3.returnYellowMeeples() >= GameBoard.p2.returnYellowMeeples() &&
                GameBoard.p3.returnYellowMeeples() >= GameBoard.p4.returnYellowMeeples()) {
                    second.add(GameBoard.p3);
                }
                if (GameBoard.p4.returnYellowMeeples() < highest &&
                GameBoard.p4.returnYellowMeeples() >= GameBoard.p1.returnYellowMeeples() &&
                GameBoard.p4.returnYellowMeeples() >= GameBoard.p2.returnYellowMeeples() &&
                GameBoard.p4.returnYellowMeeples() >= GameBoard.p3.returnYellowMeeples()) {
                    second.add(GameBoard.p4);
                }
            }
            else if (GameBoard.numPlayers == 5) {
                if (GameBoard.p1.returnYellowMeeples() < highest &&
                GameBoard.p1.returnYellowMeeples() >= GameBoard.p2.returnYellowMeeples() &&
                GameBoard.p1.returnYellowMeeples() >= GameBoard.p3.returnYellowMeeples() &&
                GameBoard.p1.returnYellowMeeples() >= GameBoard.p4.returnYellowMeeples() &&
                GameBoard.p1.returnYellowMeeples() >= GameBoard.p5.returnYellowMeeples()) {
                    second.add(GameBoard.p1);
                }
                if (GameBoard.p2.returnYellowMeeples() < highest &&
                GameBoard.p2.returnYellowMeeples() >= GameBoard.p1.returnYellowMeeples() &&
                GameBoard.p2.returnYellowMeeples() >= GameBoard.p3.returnYellowMeeples() &&
                GameBoard.p2.returnYellowMeeples() >= GameBoard.p4.returnYellowMeeples() &&
                GameBoard.p2.returnYellowMeeples() >= GameBoard.p5.returnYellowMeeples()) {
                    second.add(GameBoard.p2);
                }
                if (GameBoard.p3.returnYellowMeeples() < highest &&
                GameBoard.p3.returnYellowMeeples() >= GameBoard.p1.returnYellowMeeples() &&
                GameBoard.p3.returnYellowMeeples() >= GameBoard.p2.returnYellowMeeples() &&
                GameBoard.p3.returnYellowMeeples() >= GameBoard.p4.returnYellowMeeples() &&
                GameBoard.p3.returnYellowMeeples() >= GameBoard.p5.returnYellowMeeples()) {
                    second.add(GameBoard.p3);
                }
                if (GameBoard.p4.returnYellowMeeples() < highest &&
                GameBoard.p4.returnYellowMeeples() >= GameBoard.p1.returnYellowMeeples() &&
                GameBoard.p4.returnYellowMeeples() >= GameBoard.p2.returnYellowMeeples() &&
                GameBoard.p4.returnYellowMeeples() >= GameBoard.p3.returnYellowMeeples() &&
                GameBoard.p4.returnYellowMeeples() >= GameBoard.p5.returnYellowMeeples()) {
                    second.add(GameBoard.p4);
                }
                if (GameBoard.p5.returnYellowMeeples() < highest &&
                GameBoard.p5.returnYellowMeeples() >= GameBoard.p1.returnYellowMeeples() &&
                GameBoard.p5.returnYellowMeeples() >= GameBoard.p2.returnYellowMeeples() &&
                GameBoard.p5.returnYellowMeeples() >= GameBoard.p3.returnYellowMeeples() &&
                GameBoard.p5.returnYellowMeeples() >= GameBoard.p4.returnYellowMeeples()) {
                    second.add(GameBoard.p5);
                }
            }
            for (int i = 0; i < second.size(); i++) {
                second.get(i).score += 10;
            }
        }
    }

    public static void whiteMeepleScore() {
        ArrayList<Player> temp = new ArrayList<Player>();
        if (GameBoard.numPlayers == 2) {
            if (GameBoard.p1.returnWhiteMeeples() >= GameBoard.p2.returnWhiteMeeples()) {
                temp.add(GameBoard.p1);
            }
            if (GameBoard.p2.returnWhiteMeeples() >= GameBoard.p1.returnWhiteMeeples()) {
                temp.add(GameBoard.p2);
            }
        }
        else if (GameBoard.numPlayers == 3) {
            if (GameBoard.p1.returnWhiteMeeples() >= GameBoard.p2.returnWhiteMeeples() &&
            GameBoard.p1.returnWhiteMeeples() >= GameBoard.p3.returnWhiteMeeples()) {
                temp.add(GameBoard.p1);
            }
            if (GameBoard.p2.returnWhiteMeeples() >= GameBoard.p1.returnWhiteMeeples() &&
            GameBoard.p2.returnWhiteMeeples() >= GameBoard.p3.returnWhiteMeeples()) {
                temp.add(GameBoard.p2);
            }
            if (GameBoard.p3.returnWhiteMeeples() >= GameBoard.p1.returnWhiteMeeples() &&
            GameBoard.p3.returnWhiteMeeples() >= GameBoard.p2.returnWhiteMeeples()) {
                temp.add(GameBoard.p3);
            }
        }
        else if (GameBoard.numPlayers == 4) {
            if (GameBoard.p1.returnWhiteMeeples() >= GameBoard.p2.returnWhiteMeeples() &&
            GameBoard.p1.returnWhiteMeeples() >= GameBoard.p3.returnWhiteMeeples() &&
            GameBoard.p1.returnWhiteMeeples() >= GameBoard.p4.returnWhiteMeeples()) {
                temp.add(GameBoard.p1);
            }
            if (GameBoard.p2.returnWhiteMeeples() >= GameBoard.p1.returnWhiteMeeples() &&
            GameBoard.p2.returnWhiteMeeples() >= GameBoard.p3.returnWhiteMeeples() &&
            GameBoard.p2.returnWhiteMeeples() >= GameBoard.p4.returnWhiteMeeples()) {
                temp.add(GameBoard.p2);
            }
            if (GameBoard.p3.returnWhiteMeeples() >= GameBoard.p1.returnWhiteMeeples() &&
            GameBoard.p3.returnWhiteMeeples() >= GameBoard.p2.returnWhiteMeeples() &&
            GameBoard.p3.returnWhiteMeeples() >= GameBoard.p4.returnWhiteMeeples()) {
                temp.add(GameBoard.p3);
            }
            if (GameBoard.p4.returnWhiteMeeples() >= GameBoard.p1.returnWhiteMeeples() &&
            GameBoard.p4.returnWhiteMeeples() >= GameBoard.p2.returnWhiteMeeples() &&
            GameBoard.p4.returnWhiteMeeples() >= GameBoard.p3.returnWhiteMeeples()) {
                temp.add(GameBoard.p4);
            }
        }
        else if (GameBoard.numPlayers == 5) {
            if (GameBoard.p1.returnWhiteMeeples() >= GameBoard.p2.returnWhiteMeeples() &&
            GameBoard.p1.returnWhiteMeeples() >= GameBoard.p3.returnWhiteMeeples() &&
            GameBoard.p1.returnWhiteMeeples() >= GameBoard.p4.returnWhiteMeeples() &&
            GameBoard.p1.returnWhiteMeeples() >= GameBoard.p5.returnWhiteMeeples()) {
                temp.add(GameBoard.p1);
            }
            if (GameBoard.p2.returnWhiteMeeples() >= GameBoard.p1.returnWhiteMeeples() &&
            GameBoard.p2.returnWhiteMeeples() >= GameBoard.p3.returnWhiteMeeples() &&
            GameBoard.p2.returnWhiteMeeples() >= GameBoard.p4.returnWhiteMeeples() &&
            GameBoard.p2.returnWhiteMeeples() >= GameBoard.p5.returnWhiteMeeples()) {
                temp.add(GameBoard.p2);
            }
            if (GameBoard.p3.returnWhiteMeeples() >= GameBoard.p1.returnWhiteMeeples() &&
            GameBoard.p3.returnWhiteMeeples() >= GameBoard.p2.returnWhiteMeeples() &&
            GameBoard.p3.returnWhiteMeeples() >= GameBoard.p4.returnWhiteMeeples() &&
            GameBoard.p3.returnWhiteMeeples() >= GameBoard.p5.returnWhiteMeeples()) {
                temp.add(GameBoard.p3);
            }
            if (GameBoard.p4.returnWhiteMeeples() >= GameBoard.p1.returnWhiteMeeples() &&
            GameBoard.p4.returnWhiteMeeples() >= GameBoard.p2.returnWhiteMeeples() &&
            GameBoard.p4.returnWhiteMeeples() >= GameBoard.p3.returnWhiteMeeples() &&
            GameBoard.p4.returnWhiteMeeples() >= GameBoard.p5.returnWhiteMeeples()) {
                temp.add(GameBoard.p4);
            }
            if (GameBoard.p5.returnWhiteMeeples() >= GameBoard.p1.returnWhiteMeeples() &&
            GameBoard.p5.returnWhiteMeeples() >= GameBoard.p2.returnWhiteMeeples() &&
            GameBoard.p5.returnWhiteMeeples() >= GameBoard.p3.returnWhiteMeeples() &&
            GameBoard.p5.returnWhiteMeeples() >= GameBoard.p4.returnWhiteMeeples()) {
                temp.add(GameBoard.p5);
            }
        }

        int highest = temp.get(0).returnWhiteMeeples();

        for (int i = 0; i < temp.size(); i++) {
            temp.get(i).score += 20;
        }

        if (temp.size() == 1) {
            temp.get(0).score += 20;
            ArrayList<Player> second = new ArrayList<Player>();
            if (GameBoard.numPlayers == 2) {
                if (GameBoard.p1.returnWhiteMeeples() < highest &&
                GameBoard.p1.returnWhiteMeeples() >= GameBoard.p2.returnWhiteMeeples()) {
                    second.add(GameBoard.p1);
                }
                if (GameBoard.p2.returnWhiteMeeples() < highest &&
                GameBoard.p2.returnWhiteMeeples() >= GameBoard.p1.returnWhiteMeeples()) {
                    second.add(GameBoard.p2);
                }
            }
            else if (GameBoard.numPlayers == 3) {
                if (GameBoard.p1.returnWhiteMeeples() < highest &&
                GameBoard.p1.returnWhiteMeeples() >= GameBoard.p2.returnWhiteMeeples() &&
                GameBoard.p1.returnWhiteMeeples() >= GameBoard.p3.returnWhiteMeeples()) {
                    second.add(GameBoard.p1);
                }
                if (GameBoard.p2.returnWhiteMeeples() < highest &&
                GameBoard.p2.returnWhiteMeeples() >= GameBoard.p1.returnWhiteMeeples() &&
                GameBoard.p2.returnWhiteMeeples() >= GameBoard.p3.returnWhiteMeeples()) {
                    second.add(GameBoard.p2);
                }
                if (GameBoard.p3.returnWhiteMeeples() < highest &&
                GameBoard.p3.returnWhiteMeeples() >= GameBoard.p1.returnWhiteMeeples() &&
                GameBoard.p3.returnWhiteMeeples() >= GameBoard.p2.returnWhiteMeeples()) {
                    second.add(GameBoard.p3);
                }
            }
            else if (GameBoard.numPlayers == 4) {
                if (GameBoard.p1.returnWhiteMeeples() < highest &&
                GameBoard.p1.returnWhiteMeeples() >= GameBoard.p2.returnWhiteMeeples() &&
                GameBoard.p1.returnWhiteMeeples() >= GameBoard.p3.returnWhiteMeeples() &&
                GameBoard.p1.returnWhiteMeeples() >= GameBoard.p4.returnWhiteMeeples()) {
                    second.add(GameBoard.p1);
                }
                if (GameBoard.p2.returnWhiteMeeples() < highest &&
                GameBoard.p2.returnWhiteMeeples() >= GameBoard.p1.returnWhiteMeeples() &&
                GameBoard.p2.returnWhiteMeeples() >= GameBoard.p3.returnWhiteMeeples() &&
                GameBoard.p2.returnWhiteMeeples() >= GameBoard.p4.returnWhiteMeeples()) {
                    second.add(GameBoard.p2);
                }
                if (GameBoard.p3.returnWhiteMeeples() < highest &&
                GameBoard.p3.returnWhiteMeeples() >= GameBoard.p1.returnWhiteMeeples() &&
                GameBoard.p3.returnWhiteMeeples() >= GameBoard.p2.returnWhiteMeeples() &&
                GameBoard.p3.returnWhiteMeeples() >= GameBoard.p4.returnWhiteMeeples()) {
                    second.add(GameBoard.p3);
                }
                if (GameBoard.p4.returnWhiteMeeples() < highest &&
                GameBoard.p4.returnWhiteMeeples() >= GameBoard.p1.returnWhiteMeeples() &&
                GameBoard.p4.returnWhiteMeeples() >= GameBoard.p2.returnWhiteMeeples() &&
                GameBoard.p4.returnWhiteMeeples() >= GameBoard.p3.returnWhiteMeeples()) {
                    second.add(GameBoard.p4);
                }
            }
            else if (GameBoard.numPlayers == 5) {
                if (GameBoard.p1.returnWhiteMeeples() < highest &&
                GameBoard.p1.returnWhiteMeeples() >= GameBoard.p2.returnWhiteMeeples() &&
                GameBoard.p1.returnWhiteMeeples() >= GameBoard.p3.returnWhiteMeeples() &&
                GameBoard.p1.returnWhiteMeeples() >= GameBoard.p4.returnWhiteMeeples() &&
                GameBoard.p1.returnWhiteMeeples() >= GameBoard.p5.returnWhiteMeeples()) {
                    second.add(GameBoard.p1);
                }
                if (GameBoard.p2.returnWhiteMeeples() < highest &&
                GameBoard.p2.returnWhiteMeeples() >= GameBoard.p1.returnWhiteMeeples() &&
                GameBoard.p2.returnWhiteMeeples() >= GameBoard.p3.returnWhiteMeeples() &&
                GameBoard.p2.returnWhiteMeeples() >= GameBoard.p4.returnWhiteMeeples() &&
                GameBoard.p2.returnWhiteMeeples() >= GameBoard.p5.returnWhiteMeeples()) {
                    second.add(GameBoard.p2);
                }
                if (GameBoard.p3.returnWhiteMeeples() < highest &&
                GameBoard.p3.returnWhiteMeeples() >= GameBoard.p1.returnWhiteMeeples() &&
                GameBoard.p3.returnWhiteMeeples() >= GameBoard.p2.returnWhiteMeeples() &&
                GameBoard.p3.returnWhiteMeeples() >= GameBoard.p4.returnWhiteMeeples() &&
                GameBoard.p3.returnWhiteMeeples() >= GameBoard.p5.returnWhiteMeeples()) {
                    second.add(GameBoard.p3);
                }
                if (GameBoard.p4.returnWhiteMeeples() < highest &&
                GameBoard.p4.returnWhiteMeeples() >= GameBoard.p1.returnWhiteMeeples() &&
                GameBoard.p4.returnWhiteMeeples() >= GameBoard.p2.returnWhiteMeeples() &&
                GameBoard.p4.returnWhiteMeeples() >= GameBoard.p3.returnWhiteMeeples() &&
                GameBoard.p4.returnWhiteMeeples() >= GameBoard.p5.returnWhiteMeeples()) {
                    second.add(GameBoard.p4);
                }
                if (GameBoard.p5.returnWhiteMeeples() < highest &&
                GameBoard.p5.returnWhiteMeeples() >= GameBoard.p1.returnWhiteMeeples() &&
                GameBoard.p5.returnWhiteMeeples() >= GameBoard.p2.returnWhiteMeeples() &&
                GameBoard.p5.returnWhiteMeeples() >= GameBoard.p3.returnWhiteMeeples() &&
                GameBoard.p5.returnWhiteMeeples() >= GameBoard.p4.returnWhiteMeeples()) {
                    second.add(GameBoard.p5);
                }
            }
            for (int i = 0; i < second.size(); i++) {
                second.get(i).score += 10;
            }
        }
    }

    public static void redMeepleScore() {
        ArrayList<Player> temp = new ArrayList<Player>();
        if (GameBoard.numPlayers == 2) {
            if (GameBoard.p1.returnRedMeeples() >= GameBoard.p2.returnRedMeeples()) {
                temp.add(GameBoard.p1);
            }
            if (GameBoard.p2.returnRedMeeples() >= GameBoard.p1.returnRedMeeples()) {
                temp.add(GameBoard.p2);
            }
        }
        else if (GameBoard.numPlayers == 3) {
            if (GameBoard.p1.returnRedMeeples() >= GameBoard.p2.returnRedMeeples() &&
            GameBoard.p1.returnRedMeeples() >= GameBoard.p3.returnRedMeeples()) {
                temp.add(GameBoard.p1);
            }
            if (GameBoard.p2.returnRedMeeples() >= GameBoard.p1.returnRedMeeples() &&
            GameBoard.p2.returnRedMeeples() >= GameBoard.p3.returnRedMeeples()) {
                temp.add(GameBoard.p2);
            }
            if (GameBoard.p3.returnRedMeeples() >= GameBoard.p1.returnRedMeeples() &&
            GameBoard.p3.returnRedMeeples() >= GameBoard.p2.returnRedMeeples()) {
                temp.add(GameBoard.p3);
            }
        }
        else if (GameBoard.numPlayers == 4) {
            if (GameBoard.p1.returnRedMeeples() >= GameBoard.p2.returnRedMeeples() &&
            GameBoard.p1.returnRedMeeples() >= GameBoard.p3.returnRedMeeples() &&
            GameBoard.p1.returnRedMeeples() >= GameBoard.p4.returnRedMeeples()) {
                temp.add(GameBoard.p1);
            }
            if (GameBoard.p2.returnRedMeeples() >= GameBoard.p1.returnRedMeeples() &&
            GameBoard.p2.returnRedMeeples() >= GameBoard.p3.returnRedMeeples() &&
            GameBoard.p2.returnRedMeeples() >= GameBoard.p4.returnRedMeeples()) {
                temp.add(GameBoard.p2);
            }
            if (GameBoard.p3.returnRedMeeples() >= GameBoard.p1.returnRedMeeples() &&
            GameBoard.p3.returnRedMeeples() >= GameBoard.p2.returnRedMeeples() &&
            GameBoard.p3.returnRedMeeples() >= GameBoard.p4.returnRedMeeples()) {
                temp.add(GameBoard.p3);
            }
            if (GameBoard.p4.returnRedMeeples() >= GameBoard.p1.returnRedMeeples() &&
            GameBoard.p4.returnRedMeeples() >= GameBoard.p2.returnRedMeeples() &&
            GameBoard.p4.returnRedMeeples() >= GameBoard.p3.returnRedMeeples()) {
                temp.add(GameBoard.p4);
            }
        }
        else if (GameBoard.numPlayers == 5) {
            if (GameBoard.p1.returnRedMeeples() >= GameBoard.p2.returnRedMeeples() &&
            GameBoard.p1.returnRedMeeples() >= GameBoard.p3.returnRedMeeples() &&
            GameBoard.p1.returnRedMeeples() >= GameBoard.p4.returnRedMeeples() &&
            GameBoard.p1.returnRedMeeples() >= GameBoard.p5.returnRedMeeples()) {
                temp.add(GameBoard.p1);
            }
            if (GameBoard.p2.returnRedMeeples() >= GameBoard.p1.returnRedMeeples() &&
            GameBoard.p2.returnRedMeeples() >= GameBoard.p3.returnRedMeeples() &&
            GameBoard.p2.returnRedMeeples() >= GameBoard.p4.returnRedMeeples() &&
            GameBoard.p2.returnRedMeeples() >= GameBoard.p5.returnRedMeeples()) {
                temp.add(GameBoard.p2);
            }
            if (GameBoard.p3.returnRedMeeples() >= GameBoard.p1.returnRedMeeples() &&
            GameBoard.p3.returnRedMeeples() >= GameBoard.p2.returnRedMeeples() &&
            GameBoard.p3.returnRedMeeples() >= GameBoard.p4.returnRedMeeples() &&
            GameBoard.p3.returnRedMeeples() >= GameBoard.p5.returnRedMeeples()) {
                temp.add(GameBoard.p3);
            }
            if (GameBoard.p4.returnRedMeeples() >= GameBoard.p1.returnRedMeeples() &&
            GameBoard.p4.returnRedMeeples() >= GameBoard.p2.returnRedMeeples() &&
            GameBoard.p4.returnRedMeeples() >= GameBoard.p3.returnRedMeeples() &&
            GameBoard.p4.returnRedMeeples() >= GameBoard.p5.returnRedMeeples()) {
                temp.add(GameBoard.p4);
            }
            if (GameBoard.p5.returnRedMeeples() >= GameBoard.p1.returnRedMeeples() &&
            GameBoard.p5.returnRedMeeples() >= GameBoard.p2.returnRedMeeples() &&
            GameBoard.p5.returnRedMeeples() >= GameBoard.p3.returnRedMeeples() &&
            GameBoard.p5.returnRedMeeples() >= GameBoard.p4.returnRedMeeples()) {
                temp.add(GameBoard.p5);
            }
        }

        int highest = temp.get(0).returnRedMeeples();

        for (int i = 0; i < temp.size(); i++) {
            temp.get(i).score += 20;
        }

        if (temp.size() == 1) {
            temp.get(0).score += 20;
            ArrayList<Player> second = new ArrayList<Player>();
            if (GameBoard.numPlayers == 2) {
                if (GameBoard.p1.returnRedMeeples() < highest &&
                GameBoard.p1.returnRedMeeples() >= GameBoard.p2.returnRedMeeples()) {
                    second.add(GameBoard.p1);
                }
                if (GameBoard.p2.returnRedMeeples() < highest &&
                GameBoard.p2.returnRedMeeples() >= GameBoard.p1.returnRedMeeples()) {
                    second.add(GameBoard.p2);
                }
            }
            else if (GameBoard.numPlayers == 3) {
                if (GameBoard.p1.returnRedMeeples() < highest &&
                GameBoard.p1.returnRedMeeples() >= GameBoard.p2.returnRedMeeples() &&
                GameBoard.p1.returnRedMeeples() >= GameBoard.p3.returnRedMeeples()) {
                    second.add(GameBoard.p1);
                }
                if (GameBoard.p2.returnRedMeeples() < highest &&
                GameBoard.p2.returnRedMeeples() >= GameBoard.p1.returnRedMeeples() &&
                GameBoard.p2.returnRedMeeples() >= GameBoard.p3.returnRedMeeples()) {
                    second.add(GameBoard.p2);
                }
                if (GameBoard.p3.returnRedMeeples() < highest &&
                GameBoard.p3.returnRedMeeples() >= GameBoard.p1.returnRedMeeples() &&
                GameBoard.p3.returnRedMeeples() >= GameBoard.p2.returnRedMeeples()) {
                    second.add(GameBoard.p3);
                }
            }
            else if (GameBoard.numPlayers == 4) {
                if (GameBoard.p1.returnRedMeeples() < highest &&
                GameBoard.p1.returnRedMeeples() >= GameBoard.p2.returnRedMeeples() &&
                GameBoard.p1.returnRedMeeples() >= GameBoard.p3.returnRedMeeples() &&
                GameBoard.p1.returnRedMeeples() >= GameBoard.p4.returnRedMeeples()) {
                    second.add(GameBoard.p1);
                }
                if (GameBoard.p2.returnRedMeeples() < highest &&
                GameBoard.p2.returnRedMeeples() >= GameBoard.p1.returnRedMeeples() &&
                GameBoard.p2.returnRedMeeples() >= GameBoard.p3.returnRedMeeples() &&
                GameBoard.p2.returnRedMeeples() >= GameBoard.p4.returnRedMeeples()) {
                    second.add(GameBoard.p2);
                }
                if (GameBoard.p3.returnRedMeeples() < highest &&
                GameBoard.p3.returnRedMeeples() >= GameBoard.p1.returnRedMeeples() &&
                GameBoard.p3.returnRedMeeples() >= GameBoard.p2.returnRedMeeples() &&
                GameBoard.p3.returnRedMeeples() >= GameBoard.p4.returnRedMeeples()) {
                    second.add(GameBoard.p3);
                }
                if (GameBoard.p4.returnRedMeeples() < highest &&
                GameBoard.p4.returnRedMeeples() >= GameBoard.p1.returnRedMeeples() &&
                GameBoard.p4.returnRedMeeples() >= GameBoard.p2.returnRedMeeples() &&
                GameBoard.p4.returnRedMeeples() >= GameBoard.p3.returnRedMeeples()) {
                    second.add(GameBoard.p4);
                }
            }
            else if (GameBoard.numPlayers == 5) {
                if (GameBoard.p1.returnRedMeeples() < highest &&
                GameBoard.p1.returnRedMeeples() >= GameBoard.p2.returnRedMeeples() &&
                GameBoard.p1.returnRedMeeples() >= GameBoard.p3.returnRedMeeples() &&
                GameBoard.p1.returnRedMeeples() >= GameBoard.p4.returnRedMeeples() &&
                GameBoard.p1.returnRedMeeples() >= GameBoard.p5.returnRedMeeples()) {
                    second.add(GameBoard.p1);
                }
                if (GameBoard.p2.returnRedMeeples() < highest &&
                GameBoard.p2.returnRedMeeples() >= GameBoard.p1.returnRedMeeples() &&
                GameBoard.p2.returnRedMeeples() >= GameBoard.p3.returnRedMeeples() &&
                GameBoard.p2.returnRedMeeples() >= GameBoard.p4.returnRedMeeples() &&
                GameBoard.p2.returnRedMeeples() >= GameBoard.p5.returnRedMeeples()) {
                    second.add(GameBoard.p2);
                }
                if (GameBoard.p3.returnRedMeeples() < highest &&
                GameBoard.p3.returnRedMeeples() >= GameBoard.p1.returnRedMeeples() &&
                GameBoard.p3.returnRedMeeples() >= GameBoard.p2.returnRedMeeples() &&
                GameBoard.p3.returnRedMeeples() >= GameBoard.p4.returnRedMeeples() &&
                GameBoard.p3.returnRedMeeples() >= GameBoard.p5.returnRedMeeples()) {
                    second.add(GameBoard.p3);
                }
                if (GameBoard.p4.returnRedMeeples() < highest &&
                GameBoard.p4.returnRedMeeples() >= GameBoard.p1.returnRedMeeples() &&
                GameBoard.p4.returnRedMeeples() >= GameBoard.p2.returnRedMeeples() &&
                GameBoard.p4.returnRedMeeples() >= GameBoard.p3.returnRedMeeples() &&
                GameBoard.p4.returnRedMeeples() >= GameBoard.p5.returnRedMeeples()) {
                    second.add(GameBoard.p4);
                }
                if (GameBoard.p5.returnRedMeeples() < highest &&
                GameBoard.p5.returnRedMeeples() >= GameBoard.p1.returnRedMeeples() &&
                GameBoard.p5.returnRedMeeples() >= GameBoard.p2.returnRedMeeples() &&
                GameBoard.p5.returnRedMeeples() >= GameBoard.p3.returnRedMeeples() &&
                GameBoard.p5.returnRedMeeples() >= GameBoard.p4.returnRedMeeples()) {
                    second.add(GameBoard.p5);
                }
            }
            for (int i = 0; i < second.size(); i++) {
                second.get(i).score += 10;
            }
        }
    }

    public static void greenMeepleScore() {
        ArrayList<Player> temp = new ArrayList<Player>();
        if (GameBoard.numPlayers == 2) {
            if (GameBoard.p1.returnGreenMeeples() >= GameBoard.p2.returnGreenMeeples()) {
                temp.add(GameBoard.p1);
            }
            if (GameBoard.p2.returnGreenMeeples() >= GameBoard.p1.returnGreenMeeples()) {
                temp.add(GameBoard.p2);
            }
        }
        else if (GameBoard.numPlayers == 3) {
            if (GameBoard.p1.returnGreenMeeples() >= GameBoard.p2.returnGreenMeeples() &&
            GameBoard.p1.returnGreenMeeples() >= GameBoard.p3.returnGreenMeeples()) {
                temp.add(GameBoard.p1);
            }
            if (GameBoard.p2.returnGreenMeeples() >= GameBoard.p1.returnGreenMeeples() &&
            GameBoard.p2.returnGreenMeeples() >= GameBoard.p3.returnGreenMeeples()) {
                temp.add(GameBoard.p2);
            }
            if (GameBoard.p3.returnGreenMeeples() >= GameBoard.p1.returnGreenMeeples() &&
            GameBoard.p3.returnGreenMeeples() >= GameBoard.p2.returnGreenMeeples()) {
                temp.add(GameBoard.p3);
            }
        }
        else if (GameBoard.numPlayers == 4) {
            if (GameBoard.p1.returnGreenMeeples() >= GameBoard.p2.returnGreenMeeples() &&
            GameBoard.p1.returnGreenMeeples() >= GameBoard.p3.returnGreenMeeples() &&
            GameBoard.p1.returnGreenMeeples() >= GameBoard.p4.returnGreenMeeples()) {
                temp.add(GameBoard.p1);
            }
            if (GameBoard.p2.returnGreenMeeples() >= GameBoard.p1.returnGreenMeeples() &&
            GameBoard.p2.returnGreenMeeples() >= GameBoard.p3.returnGreenMeeples() &&
            GameBoard.p2.returnGreenMeeples() >= GameBoard.p4.returnGreenMeeples()) {
                temp.add(GameBoard.p2);
            }
            if (GameBoard.p3.returnGreenMeeples() >= GameBoard.p1.returnGreenMeeples() &&
            GameBoard.p3.returnGreenMeeples() >= GameBoard.p2.returnGreenMeeples() &&
            GameBoard.p3.returnGreenMeeples() >= GameBoard.p4.returnGreenMeeples()) {
                temp.add(GameBoard.p3);
            }
            if (GameBoard.p4.returnGreenMeeples() >= GameBoard.p1.returnGreenMeeples() &&
            GameBoard.p4.returnGreenMeeples() >= GameBoard.p2.returnGreenMeeples() &&
            GameBoard.p4.returnGreenMeeples() >= GameBoard.p3.returnGreenMeeples()) {
                temp.add(GameBoard.p4);
            }
        }
        else if (GameBoard.numPlayers == 5) {
            if (GameBoard.p1.returnGreenMeeples() >= GameBoard.p2.returnGreenMeeples() &&
            GameBoard.p1.returnGreenMeeples() >= GameBoard.p3.returnGreenMeeples() &&
            GameBoard.p1.returnGreenMeeples() >= GameBoard.p4.returnGreenMeeples() &&
            GameBoard.p1.returnGreenMeeples() >= GameBoard.p5.returnGreenMeeples()) {
                temp.add(GameBoard.p1);
            }
            if (GameBoard.p2.returnGreenMeeples() >= GameBoard.p1.returnGreenMeeples() &&
            GameBoard.p2.returnGreenMeeples() >= GameBoard.p3.returnGreenMeeples() &&
            GameBoard.p2.returnGreenMeeples() >= GameBoard.p4.returnGreenMeeples() &&
            GameBoard.p2.returnGreenMeeples() >= GameBoard.p5.returnGreenMeeples()) {
                temp.add(GameBoard.p2);
            }
            if (GameBoard.p3.returnGreenMeeples() >= GameBoard.p1.returnGreenMeeples() &&
            GameBoard.p3.returnGreenMeeples() >= GameBoard.p2.returnGreenMeeples() &&
            GameBoard.p3.returnGreenMeeples() >= GameBoard.p4.returnGreenMeeples() &&
            GameBoard.p3.returnGreenMeeples() >= GameBoard.p5.returnGreenMeeples()) {
                temp.add(GameBoard.p3);
            }
            if (GameBoard.p4.returnGreenMeeples() >= GameBoard.p1.returnGreenMeeples() &&
            GameBoard.p4.returnGreenMeeples() >= GameBoard.p2.returnGreenMeeples() &&
            GameBoard.p4.returnGreenMeeples() >= GameBoard.p3.returnGreenMeeples() &&
            GameBoard.p4.returnGreenMeeples() >= GameBoard.p5.returnGreenMeeples()) {
                temp.add(GameBoard.p4);
            }
            if (GameBoard.p5.returnGreenMeeples() >= GameBoard.p1.returnGreenMeeples() &&
            GameBoard.p5.returnGreenMeeples() >= GameBoard.p2.returnGreenMeeples() &&
            GameBoard.p5.returnGreenMeeples() >= GameBoard.p3.returnGreenMeeples() &&
            GameBoard.p5.returnGreenMeeples() >= GameBoard.p4.returnGreenMeeples()) {
                temp.add(GameBoard.p5);
            }
        }

        int highest = temp.get(0).returnGreenMeeples();

        for (int i = 0; i < temp.size(); i++) {
            temp.get(i).score += 20;
        }

        if (temp.size() == 1) {
            temp.get(0).score += 20;
            ArrayList<Player> second = new ArrayList<Player>();
            if (GameBoard.numPlayers == 2) {
                if (GameBoard.p1.returnGreenMeeples() < highest &&
                GameBoard.p1.returnGreenMeeples() >= GameBoard.p2.returnGreenMeeples()) {
                    second.add(GameBoard.p1);
                }
                if (GameBoard.p2.returnGreenMeeples() < highest &&
                GameBoard.p2.returnGreenMeeples() >= GameBoard.p1.returnGreenMeeples()) {
                    second.add(GameBoard.p2);
                }
            }
            else if (GameBoard.numPlayers == 3) {
                if (GameBoard.p1.returnGreenMeeples() < highest &&
                GameBoard.p1.returnGreenMeeples() >= GameBoard.p2.returnGreenMeeples() &&
                GameBoard.p1.returnGreenMeeples() >= GameBoard.p3.returnGreenMeeples()) {
                    second.add(GameBoard.p1);
                }
                if (GameBoard.p2.returnGreenMeeples() < highest &&
                GameBoard.p2.returnGreenMeeples() >= GameBoard.p1.returnGreenMeeples() &&
                GameBoard.p2.returnGreenMeeples() >= GameBoard.p3.returnGreenMeeples()) {
                    second.add(GameBoard.p2);
                }
                if (GameBoard.p3.returnGreenMeeples() < highest &&
                GameBoard.p3.returnGreenMeeples() >= GameBoard.p1.returnGreenMeeples() &&
                GameBoard.p3.returnGreenMeeples() >= GameBoard.p2.returnGreenMeeples()) {
                    second.add(GameBoard.p3);
                }
            }
            else if (GameBoard.numPlayers == 4) {
                if (GameBoard.p1.returnGreenMeeples() < highest &&
                GameBoard.p1.returnGreenMeeples() >= GameBoard.p2.returnGreenMeeples() &&
                GameBoard.p1.returnGreenMeeples() >= GameBoard.p3.returnGreenMeeples() &&
                GameBoard.p1.returnGreenMeeples() >= GameBoard.p4.returnGreenMeeples()) {
                    second.add(GameBoard.p1);
                }
                if (GameBoard.p2.returnGreenMeeples() < highest &&
                GameBoard.p2.returnGreenMeeples() >= GameBoard.p1.returnGreenMeeples() &&
                GameBoard.p2.returnGreenMeeples() >= GameBoard.p3.returnGreenMeeples() &&
                GameBoard.p2.returnGreenMeeples() >= GameBoard.p4.returnGreenMeeples()) {
                    second.add(GameBoard.p2);
                }
                if (GameBoard.p3.returnGreenMeeples() < highest &&
                GameBoard.p3.returnGreenMeeples() >= GameBoard.p1.returnGreenMeeples() &&
                GameBoard.p3.returnGreenMeeples() >= GameBoard.p2.returnGreenMeeples() &&
                GameBoard.p3.returnGreenMeeples() >= GameBoard.p4.returnGreenMeeples()) {
                    second.add(GameBoard.p3);
                }
                if (GameBoard.p4.returnGreenMeeples() < highest &&
                GameBoard.p4.returnGreenMeeples() >= GameBoard.p1.returnGreenMeeples() &&
                GameBoard.p4.returnGreenMeeples() >= GameBoard.p2.returnGreenMeeples() &&
                GameBoard.p4.returnGreenMeeples() >= GameBoard.p3.returnGreenMeeples()) {
                    second.add(GameBoard.p4);
                }
            }
            else if (GameBoard.numPlayers == 5) {
                if (GameBoard.p1.returnGreenMeeples() < highest &&
                GameBoard.p1.returnGreenMeeples() >= GameBoard.p2.returnGreenMeeples() &&
                GameBoard.p1.returnGreenMeeples() >= GameBoard.p3.returnGreenMeeples() &&
                GameBoard.p1.returnGreenMeeples() >= GameBoard.p4.returnGreenMeeples() &&
                GameBoard.p1.returnGreenMeeples() >= GameBoard.p5.returnGreenMeeples()) {
                    second.add(GameBoard.p1);
                }
                if (GameBoard.p2.returnGreenMeeples() < highest &&
                GameBoard.p2.returnGreenMeeples() >= GameBoard.p1.returnGreenMeeples() &&
                GameBoard.p2.returnGreenMeeples() >= GameBoard.p3.returnGreenMeeples() &&
                GameBoard.p2.returnGreenMeeples() >= GameBoard.p4.returnGreenMeeples() &&
                GameBoard.p2.returnGreenMeeples() >= GameBoard.p5.returnGreenMeeples()) {
                    second.add(GameBoard.p2);
                }
                if (GameBoard.p3.returnGreenMeeples() < highest &&
                GameBoard.p3.returnGreenMeeples() >= GameBoard.p1.returnGreenMeeples() &&
                GameBoard.p3.returnGreenMeeples() >= GameBoard.p2.returnGreenMeeples() &&
                GameBoard.p3.returnGreenMeeples() >= GameBoard.p4.returnGreenMeeples() &&
                GameBoard.p3.returnGreenMeeples() >= GameBoard.p5.returnGreenMeeples()) {
                    second.add(GameBoard.p3);
                }
                if (GameBoard.p4.returnGreenMeeples() < highest &&
                GameBoard.p4.returnGreenMeeples() >= GameBoard.p1.returnGreenMeeples() &&
                GameBoard.p4.returnGreenMeeples() >= GameBoard.p2.returnGreenMeeples() &&
                GameBoard.p4.returnGreenMeeples() >= GameBoard.p3.returnGreenMeeples() &&
                GameBoard.p4.returnGreenMeeples() >= GameBoard.p5.returnGreenMeeples()) {
                    second.add(GameBoard.p4);
                }
                if (GameBoard.p5.returnGreenMeeples() < highest &&
                GameBoard.p5.returnGreenMeeples() >= GameBoard.p1.returnGreenMeeples() &&
                GameBoard.p5.returnGreenMeeples() >= GameBoard.p2.returnGreenMeeples() &&
                GameBoard.p5.returnGreenMeeples() >= GameBoard.p3.returnGreenMeeples() &&
                GameBoard.p5.returnGreenMeeples() >= GameBoard.p4.returnGreenMeeples()) {
                    second.add(GameBoard.p5);
                }
            }
            for (int i = 0; i < second.size(); i++) {
                second.get(i).score += 10;
            }
        }
    }

    public static void blackMeepleScore() {
        ArrayList<Player> temp = new ArrayList<Player>();
        if (GameBoard.numPlayers == 2) {
            if (GameBoard.p1.returnBlackMeeples() >= GameBoard.p2.returnBlackMeeples()) {
                temp.add(GameBoard.p1);
            }
            if (GameBoard.p2.returnBlackMeeples() >= GameBoard.p1.returnBlackMeeples()) {
                temp.add(GameBoard.p2);
            }
        }
        else if (GameBoard.numPlayers == 3) {
            if (GameBoard.p1.returnBlackMeeples() >= GameBoard.p2.returnBlackMeeples() &&
            GameBoard.p1.returnBlackMeeples() >= GameBoard.p3.returnBlackMeeples()) {
                temp.add(GameBoard.p1);
            }
            if (GameBoard.p2.returnBlackMeeples() >= GameBoard.p1.returnBlackMeeples() &&
            GameBoard.p2.returnBlackMeeples() >= GameBoard.p3.returnBlackMeeples()) {
                temp.add(GameBoard.p2);
            }
            if (GameBoard.p3.returnBlackMeeples() >= GameBoard.p1.returnBlackMeeples() &&
            GameBoard.p3.returnBlackMeeples() >= GameBoard.p2.returnBlackMeeples()) {
                temp.add(GameBoard.p3);
            }
        }
        else if (GameBoard.numPlayers == 4) {
            if (GameBoard.p1.returnBlackMeeples() >= GameBoard.p2.returnBlackMeeples() &&
            GameBoard.p1.returnBlackMeeples() >= GameBoard.p3.returnBlackMeeples() &&
            GameBoard.p1.returnBlackMeeples() >= GameBoard.p4.returnBlackMeeples()) {
                temp.add(GameBoard.p1);
            }
            if (GameBoard.p2.returnBlackMeeples() >= GameBoard.p1.returnBlackMeeples() &&
            GameBoard.p2.returnBlackMeeples() >= GameBoard.p3.returnBlackMeeples() &&
            GameBoard.p2.returnBlackMeeples() >= GameBoard.p4.returnBlackMeeples()) {
                temp.add(GameBoard.p2);
            }
            if (GameBoard.p3.returnBlackMeeples() >= GameBoard.p1.returnBlackMeeples() &&
            GameBoard.p3.returnBlackMeeples() >= GameBoard.p2.returnBlackMeeples() &&
            GameBoard.p3.returnBlackMeeples() >= GameBoard.p4.returnBlackMeeples()) {
                temp.add(GameBoard.p3);
            }
            if (GameBoard.p4.returnBlackMeeples() >= GameBoard.p1.returnBlackMeeples() &&
            GameBoard.p4.returnBlackMeeples() >= GameBoard.p2.returnBlackMeeples() &&
            GameBoard.p4.returnBlackMeeples() >= GameBoard.p3.returnBlackMeeples()) {
                temp.add(GameBoard.p4);
            }
        }
        else if (GameBoard.numPlayers == 5) {
            if (GameBoard.p1.returnBlackMeeples() >= GameBoard.p2.returnBlackMeeples() &&
            GameBoard.p1.returnBlackMeeples() >= GameBoard.p3.returnBlackMeeples() &&
            GameBoard.p1.returnBlackMeeples() >= GameBoard.p4.returnBlackMeeples() &&
            GameBoard.p1.returnBlackMeeples() >= GameBoard.p5.returnBlackMeeples()) {
                temp.add(GameBoard.p1);
            }
            if (GameBoard.p2.returnBlackMeeples() >= GameBoard.p1.returnBlackMeeples() &&
            GameBoard.p2.returnBlackMeeples() >= GameBoard.p3.returnBlackMeeples() &&
            GameBoard.p2.returnBlackMeeples() >= GameBoard.p4.returnBlackMeeples() &&
            GameBoard.p2.returnBlackMeeples() >= GameBoard.p5.returnBlackMeeples()) {
                temp.add(GameBoard.p2);
            }
            if (GameBoard.p3.returnBlackMeeples() >= GameBoard.p1.returnBlackMeeples() &&
            GameBoard.p3.returnBlackMeeples() >= GameBoard.p2.returnBlackMeeples() &&
            GameBoard.p3.returnBlackMeeples() >= GameBoard.p4.returnBlackMeeples() &&
            GameBoard.p3.returnBlackMeeples() >= GameBoard.p5.returnBlackMeeples()) {
                temp.add(GameBoard.p3);
            }
            if (GameBoard.p4.returnBlackMeeples() >= GameBoard.p1.returnBlackMeeples() &&
            GameBoard.p4.returnBlackMeeples() >= GameBoard.p2.returnBlackMeeples() &&
            GameBoard.p4.returnBlackMeeples() >= GameBoard.p3.returnBlackMeeples() &&
            GameBoard.p4.returnBlackMeeples() >= GameBoard.p5.returnBlackMeeples()) {
                temp.add(GameBoard.p4);
            }
            if (GameBoard.p5.returnBlackMeeples() >= GameBoard.p1.returnBlackMeeples() &&
            GameBoard.p5.returnBlackMeeples() >= GameBoard.p2.returnBlackMeeples() &&
            GameBoard.p5.returnBlackMeeples() >= GameBoard.p3.returnBlackMeeples() &&
            GameBoard.p5.returnBlackMeeples() >= GameBoard.p4.returnBlackMeeples()) {
                temp.add(GameBoard.p5);
            }
        }

        int highest = temp.get(0).returnBlackMeeples();

        for (int i = 0; i < temp.size(); i++) {
            temp.get(i).score += 20;
        }

        if (temp.size() == 1) {
            temp.get(0).score += 20;
            ArrayList<Player> second = new ArrayList<Player>();
            if (GameBoard.numPlayers == 2) {
                if (GameBoard.p1.returnBlackMeeples() < highest &&
                GameBoard.p1.returnBlackMeeples() >= GameBoard.p2.returnBlackMeeples()) {
                    second.add(GameBoard.p1);
                }
                if (GameBoard.p2.returnBlackMeeples() < highest &&
                GameBoard.p2.returnBlackMeeples() >= GameBoard.p1.returnBlackMeeples()) {
                    second.add(GameBoard.p2);
                }
            }
            else if (GameBoard.numPlayers == 3) {
                if (GameBoard.p1.returnBlackMeeples() < highest &&
                GameBoard.p1.returnBlackMeeples() >= GameBoard.p2.returnBlackMeeples() &&
                GameBoard.p1.returnBlackMeeples() >= GameBoard.p3.returnBlackMeeples()) {
                    second.add(GameBoard.p1);
                }
                if (GameBoard.p2.returnBlackMeeples() < highest &&
                GameBoard.p2.returnBlackMeeples() >= GameBoard.p1.returnBlackMeeples() &&
                GameBoard.p2.returnBlackMeeples() >= GameBoard.p3.returnBlackMeeples()) {
                    second.add(GameBoard.p2);
                }
                if (GameBoard.p3.returnBlackMeeples() < highest &&
                GameBoard.p3.returnBlackMeeples() >= GameBoard.p1.returnBlackMeeples() &&
                GameBoard.p3.returnBlackMeeples() >= GameBoard.p2.returnBlackMeeples()) {
                    second.add(GameBoard.p3);
                }
            }
            else if (GameBoard.numPlayers == 4) {
                if (GameBoard.p1.returnBlackMeeples() < highest &&
                GameBoard.p1.returnBlackMeeples() >= GameBoard.p2.returnBlackMeeples() &&
                GameBoard.p1.returnBlackMeeples() >= GameBoard.p3.returnBlackMeeples() &&
                GameBoard.p1.returnBlackMeeples() >= GameBoard.p4.returnBlackMeeples()) {
                    second.add(GameBoard.p1);
                }
                if (GameBoard.p2.returnBlackMeeples() < highest &&
                GameBoard.p2.returnBlackMeeples() >= GameBoard.p1.returnBlackMeeples() &&
                GameBoard.p2.returnBlackMeeples() >= GameBoard.p3.returnBlackMeeples() &&
                GameBoard.p2.returnBlackMeeples() >= GameBoard.p4.returnBlackMeeples()) {
                    second.add(GameBoard.p2);
                }
                if (GameBoard.p3.returnBlackMeeples() < highest &&
                GameBoard.p3.returnBlackMeeples() >= GameBoard.p1.returnBlackMeeples() &&
                GameBoard.p3.returnBlackMeeples() >= GameBoard.p2.returnBlackMeeples() &&
                GameBoard.p3.returnBlackMeeples() >= GameBoard.p4.returnBlackMeeples()) {
                    second.add(GameBoard.p3);
                }
                if (GameBoard.p4.returnBlackMeeples() < highest &&
                GameBoard.p4.returnBlackMeeples() >= GameBoard.p1.returnBlackMeeples() &&
                GameBoard.p4.returnBlackMeeples() >= GameBoard.p2.returnBlackMeeples() &&
                GameBoard.p4.returnBlackMeeples() >= GameBoard.p3.returnBlackMeeples()) {
                    second.add(GameBoard.p4);
                }
            }
            else if (GameBoard.numPlayers == 5) {
                if (GameBoard.p1.returnBlackMeeples() < highest &&
                GameBoard.p1.returnBlackMeeples() >= GameBoard.p2.returnBlackMeeples() &&
                GameBoard.p1.returnBlackMeeples() >= GameBoard.p3.returnBlackMeeples() &&
                GameBoard.p1.returnBlackMeeples() >= GameBoard.p4.returnBlackMeeples() &&
                GameBoard.p1.returnBlackMeeples() >= GameBoard.p5.returnBlackMeeples()) {
                    second.add(GameBoard.p1);
                }
                if (GameBoard.p2.returnBlackMeeples() < highest &&
                GameBoard.p2.returnBlackMeeples() >= GameBoard.p1.returnBlackMeeples() &&
                GameBoard.p2.returnBlackMeeples() >= GameBoard.p3.returnBlackMeeples() &&
                GameBoard.p2.returnBlackMeeples() >= GameBoard.p4.returnBlackMeeples() &&
                GameBoard.p2.returnBlackMeeples() >= GameBoard.p5.returnBlackMeeples()) {
                    second.add(GameBoard.p2);
                }
                if (GameBoard.p3.returnBlackMeeples() < highest &&
                GameBoard.p3.returnBlackMeeples() >= GameBoard.p1.returnBlackMeeples() &&
                GameBoard.p3.returnBlackMeeples() >= GameBoard.p2.returnBlackMeeples() &&
                GameBoard.p3.returnBlackMeeples() >= GameBoard.p4.returnBlackMeeples() &&
                GameBoard.p3.returnBlackMeeples() >= GameBoard.p5.returnBlackMeeples()) {
                    second.add(GameBoard.p3);
                }
                if (GameBoard.p4.returnBlackMeeples() < highest &&
                GameBoard.p4.returnBlackMeeples() >= GameBoard.p1.returnBlackMeeples() &&
                GameBoard.p4.returnBlackMeeples() >= GameBoard.p2.returnBlackMeeples() &&
                GameBoard.p4.returnBlackMeeples() >= GameBoard.p3.returnBlackMeeples() &&
                GameBoard.p4.returnBlackMeeples() >= GameBoard.p5.returnBlackMeeples()) {
                    second.add(GameBoard.p4);
                }
                if (GameBoard.p5.returnBlackMeeples() < highest &&
                GameBoard.p5.returnBlackMeeples() >= GameBoard.p1.returnBlackMeeples() &&
                GameBoard.p5.returnBlackMeeples() >= GameBoard.p2.returnBlackMeeples() &&
                GameBoard.p5.returnBlackMeeples() >= GameBoard.p3.returnBlackMeeples() &&
                GameBoard.p5.returnBlackMeeples() >= GameBoard.p4.returnBlackMeeples()) {
                    second.add(GameBoard.p5);
                }
            }
            for (int i = 0; i < second.size(); i++) {
                second.get(i).score += 10;
            }
        }
    }

    public void mostColorMeeples()
    {
        score = score + 20;
    }

    public void secondMostColorMeeples()
    {
        score = score + 10;
    }

    public void addRedMeeple(Meeple m)
    {
        redMeeples.add(m);
    }

    public void addBlackMeeple(Meeple m)
    {
        blackMeeples.add(m);
    }

    public void addWhiteMeeple(Meeple m)
    {
        whiteMeeples.add(m);
    }

    public void addBlueMeeple(Meeple m)
    {
        blueMeeples.add(m);
    }

    public void addGreenMeeple(Meeple m)
    {
        greenMeeples.add(m);
    }

    public void addYellowMeeple(Meeple m)
    {
        yellowMeeples.add(m);
    }

    public int returnRedMeeples()
    {
        return redMeeples.size();
    }

    public int returnBlueMeeples()
    {
        return blueMeeples.size();
    }

    public int returnYellowMeeples()
    {
        return yellowMeeples.size();
    }

    public int returnGreenMeeples()
    {
        return greenMeeples.size();
    }

    public int returnBlackMeeples()
    {
        return blackMeeples.size();
    }

    public int returnWhiteMeeples()
    {
        return whiteMeeples.size();
    }

    public int numMeeples() {
        return returnRedMeeples() + returnBlueMeeples() + returnBlackMeeples() + 
        returnWhiteMeeples() + returnYellowMeeples() + returnGreenMeeples();
    }
}
