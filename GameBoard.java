import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
/**
 * Main class for Ticket to Ride. This is wear the graphics
 * takes place as well as gameplay for each player. 
 *
 * @author Ashley Hughes, Justyn McHarg, Devante Saenger, 
 * Collin Adams, Dylan Lane
 * 
 * @version Spring 2018
 */
public class GameBoard extends JPanel
{
    private ImageIcon board;
    private ImageIcon background;
    private int width;
    private int height;
    private Toolkit toolkit;
    public static ArrayList<String> colorNames;
    public static ArrayList<Color> colors;
    public static ShortTicketsDeck sdDeck;
    public static LongTicketsDeck ldDeck;
    public static TrainCards trainDeck;
    public static TrainCards discardDeck;
    public static TrainCard[] faceUp;
    public static Meeples meeples;
    public static Routes routes;
    public static Cities cities;
    public int startCity;
    public int endCity;
    public static int numPlayers;
    private int player;
    private static boolean gameOver;
    public static Player p1;
    public static Player p2;
    public static Player p3;
    public static Player p4;
    public static Player p5;
    public static Player currentPlayer;
    private static final long serialVersionUID = 1;
    private static final Color DEFAULT_TEXT_COLOR = Color.WHITE;
    private static final Color HOVER_TEXT_COLOR = Color.WHITE;
    private Font font = new Font("Arial", Font.BOLD, 16);
    public static int claimingRoute;

    public int sx;
    public int sy;
    public int ex;
    public int ey;

    public String text1 = "Danemach";
    public String text2 = "KIEL";
    public String text3 = "HAMBURG";
    public String text4 = "ROSTOCK";
    public String text5 = "BERLIN";
    public String text6 = "SCHWERIN";
    public String text7 = "HANNOVER";
    public String text8 = "MAGDEBURG";
    public String text9 = "BREMERHAVEN";
    public String text10 = "BREMEN";
    public String text11 = "EMDEN";
    public String text12 = "MUNSTER";
    public String text13 = "NIEDERLANDE";
    public String text14 = "DORTMUND";
    public String text15= "DUSSELDORF";
    public String text16 = "KOIN";
    public String text17 = "KOBLENZ";
    public String text18 = "KASSEL";
    public String text19 = "FRANKFURT";
    public String text20 = "MAINZ";
    public String text21 = "MANNHEIM";
    public String text22 = "KIEL";
    public String text23 = "HAMBURG";
    public String text24 = "ROSTOCK";
    public String text25 = "BERLIN";
    public String text26 = "SCHWERIN";
    public String text27 = "HANNOVER";
    public String text28 = "MAGDEBURG";
    public String text29 = "BREMERHAVEN";
    public String text30 = "BREMEN";
    public String text31 = "EMDEN";
    public String text32 = "MUNSTER";
    public String text33 = "NIEDECLANDE";
    public String text34 = "DORTMUND";
    public String text35= "DUSSELDORF";
    public String text36 = "KOIN";
    public String text37 = "KOBLENZ";
    public String text38 = "KASSEL";
    public String text39 = "FRANKFURT";
    public String text40 = "MAINZ";
    public String text41 = "MAINZ";

    private Color textColor = DEFAULT_TEXT_COLOR;

    private Point textLocation1 = new Point(375, 50);
    private Point textLocation2 = new Point(410, 100);
    private Point textLocation3 = new Point(425, 165);
    private Point textLocation4 = new Point(550, 100);
    private Point textLocation5 = new Point(622, 247);
    private Point textLocation6 = new Point(508, 153);
    private Point textLocation7 = new Point(411, 273);
    private Point textLocation8 = new Point(538, 291);
    private Point textLocation9 = new Point(349, 162);
    private Point textLocation10 = new Point(357, 205);
    private Point textLocation11= new Point(265, 174);
    private Point textLocation12 = new Point(295, 290);
    private Point textLocation13 = new Point(231, 245);
    private Point textLocation14 = new Point(282, 334);
    private Point textLocation15 = new Point(242, 356);
    private Point textLocation16= new Point(237, 404);
    private Point textLocation17 = new Point(244, 452);
    private Point textLocation18= new Point(388, 364);
    private Point textLocation19 = new Point(340, 465);
    private Point textLocation20 = new Point(299, 493);
    private Point textLocation21 = new Point(317,544);
    private Point textLocation22 = new Point(205,560);
    private Point textLocation23 = new Point(285,589);
    private Point textLocation24 = new Point(204,641);
    private Point textLocation25 = new Point(286,682);
    private Point textLocation26 = new Point(296,740);
    private Point textLocation27 = new Point(404,497);
    private Point textLocation28 = new Point(372,602);
    private Point textLocation29 = new Point(425,645);
    private Point textLocation30 = new Point(422,715);
    private Point textLocation31= new Point(475,402);
    private Point textLocation32 = new Point(491,519);
    private Point textLocation33 = new Point(482,643);
    private Point textLocation34 = new Point(555,658);
    private Point textLocation35 = new Point(487,736);
    private Point textLocation36= new Point(541,354);
    private Point textLocation37 = new Point(651,379);
    private Point textLocation38= new Point(602,408);
    private Point textLocation39 = new Point(567,574);
    private Point textLocation40 = new Point(342,704);
    private Point textLocation41 = new Point(615,709);

    ArrayList<Line> lines;

    public MouseEvent event;

    /**
     * Constructor for objects of class DisplayImagePanel
     */
    public GameBoard()
    {        
        trainDeck = new TrainCards();
        trainDeck.shuffle();

        faceUp = new TrainCard[5];
        for (int j = 0; j < 5; j++) {
            faceUp[j] = trainDeck.dealCard();
        }

        discardDeck = new TrainCards();

        sdDeck = new ShortTicketsDeck();
        sdDeck.shuffle();

        ldDeck = new LongTicketsDeck();
        ldDeck.shuffle();

        meeples = new Meeples();
        meeples.shuffle();

        cities = new Cities();
        routes = new Routes();

        colorNames = new ArrayList<String>();
        colorNames.add("Purple");
        colorNames.add("Red");
        colorNames.add("Yellow");
        colorNames.add("Black");
        colorNames.add("White");

        colors = new ArrayList<Color>();
        colors.add(new Color(150, 0, 150));
        colors.add(Color.RED);
        colors.add(Color.YELLOW);
        colors.add(Color.BLACK);
        colors.add(Color.WHITE);

        lines = new ArrayList<Line>();

        setPreferredSize(new Dimension(1250, 1000));
        toolkit = Toolkit.getDefaultToolkit();

        board = new ImageIcon("TTRBOARD.jpg");
        background = new ImageIcon("BACK.jpg");

        width = getPreferredSize().width;
        height = getPreferredSize().height;

        /**
         * Anonymous inner class for when the mouse 
         * hovers over certain points on the board.
         * @param MouseAdapter()
         */
        addMouseListener(new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent event) {
                    checkForHover(event);
                }

                @Override
                public void mouseExited(MouseEvent event) {
                    checkForHover(event);
                }

                /**
                 * This method uses the mouse event for when
                 * a player is claiming a particular route
                 * and clicks on one end of the 
                 * route(starting city) and the other
                 * end of the route(ending city). 
                 * @param MouseEvent e
                 */
                @Override
                public void mouseClicked( MouseEvent e ) {
                    if (claimingRoute == 0) {
                        if (e.getX() >= 0 && e.getX() <= 100 &&
                        e.getY() >= 0 && e.getY() <= 100) {
                            currentPlayer.drawTrainCards(1);
                            if(currentPlayer.done) {
                                gameOver = true;
                                endGame();
                            }

                            currentPlayer = nextPlayer();
                            repaint();
                        }
                        else if (e.getX() >= 0 && e.getX() <= 100 &&
                        e.getY() >= 150 && e.getY() <= 250) {
                            currentPlayer.drawTickets();
                            if (currentPlayer.done) {
                                gameOver = true;
                                endGame();
                            }

                            currentPlayer = nextPlayer();
                            repaint();
                        }

                        else if (e.getX() >= 0 && e.getX() <= 100 &&
                        e.getY() >= 300 && e.getY() <= 400) {
                            claimingRoute = 1;
                            JOptionPane.showMessageDialog
                            (null,"Choose One Endpoint of Route",
                                "Ticket to Ride - Claiming Route - " + 
                                currentPlayer.name,
                                JOptionPane.INFORMATION_MESSAGE);
                            repaint();
                        }

                        else if (e.getX() >= 0 && e.getX() <= 100 &&
                        e.getY() >= 450 && e.getY() <= 550) {
                            String playerTickets = "Your Tickets:\n";
                            for (int i = 0; i < currentPlayer.tickets.size(); 
                            i++) {
                                playerTickets += (
                                    currentPlayer.tickets.get(i).location 
                                    + ", " 
                                    +currentPlayer.tickets.get(i).destination+ 
                                    " (" 
                                    +currentPlayer.tickets.get(i).length + 
                                    ")\n");
                            }

                            JOptionPane.showMessageDialog(null,playerTickets,
                                "Ticket to Ride - Destination Tickets - " + 
                                currentPlayer.name,
                                JOptionPane.INFORMATION_MESSAGE);
                        }
                    }

                    else {
                        if (e.getX() >= 0 && e.getX() <= 100 &&
                        e.getY() >= 600 && e.getY() <= 700) {
                            claimingRoute = 0;
                            repaint();
                        }
                        for (int i = 0; i < cities.cities.length; i++){
                            if (e.getX() >= cities.cities[i].startX &&
                            e.getX() <= cities.cities[i].endX &&
                            e.getY() >= cities.cities[i].startY &&
                            e.getY() <= cities.cities[i].endY) {
                                if (claimingRoute == 1) {
                                    JOptionPane.showMessageDialog(null,
                                        "Choose Other Endpoint of Route",
                                        "Ticket to Ride - " +
                                        "Destination Tickets - "+ 
                                        currentPlayer.name,
                                        JOptionPane.INFORMATION_MESSAGE);
                                    startCity = i;
                                    sx = cities.cities[startCity].startX + 10;
                                    sy = cities.cities[startCity].startY + 10;
                                    claimingRoute = 2;
                                    repaint();
                                }

                                else {
                                    endCity = i;
                                    repaint();
                                    if (!(startCity == endCity)) {
                                        if (currentPlayer.claimRoute(startCity, 
                                            endCity)) {

                                            lines.add(new Line(
                                                    cities.cities[endCity].
                                                    startX + 
                                                    10,cities.cities[endCity].
                                                    startY + 10, sx, sy,  
                                                    currentPlayer.color));
                                            repaint();
                                            if (currentPlayer.done) {
                                                gameOver = true;
                                                endGame();
                                            }

                                            if (!currentPlayer.notLastTurn()){
                                                currentPlayer.done = true;
                                            }
                                            currentPlayer = nextPlayer();
                                            repaint();
                                        }

                                        else {
                                            JOptionPane.showMessageDialog(null,
                                                "Cannot Claim This Route",
                                                "Ticket to Ride - " +
                                                "Error Message - "
                                                + currentPlayer.name,
                                                JOptionPane.
                                                INFORMATION_MESSAGE);
                                        }
                                        claimingRoute = 0;
                                        repaint();
                                    }
                                }
                            }
                        }
                        repaint();
                    }
                    e.consume();
                }
            });

        addMouseMotionListener(new 
            MouseMotionListener() {
                @Override
                public void mouseMoved(MouseEvent event) {
                    checkForHover(event);
                }

                @Override
                public void mouseDragged(MouseEvent event) {
                    checkForHover(event);
                }
            });

    }

    /**
     * This method calculates each player's score based on
     * meeples claimed, routes claimed, completed 
     * destination tickets and the globeTrotter bonus
     * and determines the winner for Ticket to Ride.
     */
    public static void endGame() {
        int p1score = 0;
        int p2score = 0;
        int p3score = 0;
        int p4score = 0;
        int p5score = 0;
        Player winner = null;

        p1score = p1.getScore();
        p2score = p2.getScore();
        if (numPlayers >= 3) p3score = p3.getScore();
        if (numPlayers >= 4) p4score = p4.getScore();
        if (numPlayers >= 5) p5score = p5.getScore();

        Player.globeTrotterBonus();
        Player.meepleScore();

        ArrayList<Player> winners = new ArrayList<Player>();
        winners.add(p1);
        int winnerscore = p1score;
        if (p2score > winnerscore) {
            winners.clear();
            winners.add(p2);
            winnerscore = p2score;
        }
        else if (p2score == winnerscore) winners.add(p2);
        if (numPlayers >= 3) {
            if (p3score > winnerscore) {
                winners.clear();
                winners.add(p3);
                winnerscore = p3score;
            }
            else if (p3score == winnerscore) winners.add(p3);
        }
        if (numPlayers >= 4) {
            if (p4score > winnerscore) {
                winners.clear();
                winners.add(p4);
                winnerscore = p4score;
            }
            else if (p4score == winnerscore) winners.add(p4);
        }
        if (numPlayers >= 5) {
            if (p5score > winnerscore) {
                winners.clear();
                winners.add(p5);
                winnerscore = p5score;
            }
            else if (p5score == winnerscore) winners.add(p5);
        }

        if (winners.size() == 2) winners = tiebreak(winners.get(0), 
                winners.get(1));
        if (winners.size() == 3) winners = tiebreak(winners.get(0), 
                winners.get(1),
                winners.get(2));
        if (winners.size() == 4) winners = tiebreak(winners.get(0), 
                winners.get(1),
                winners.get(2), winners.get(3));
        if (winners.size() == 5) winners = tiebreak(winners.get(0),
                winners.get(1),
                winners.get(2), winners.get(3), winners.get(4));
        String winnerMessage = "";
        if (winners.size() == 1) {
            winnerMessage += winners.get(0).name + " wins! Score: "
            + winners.get(0).getScore();
        }
        else {
            winnerMessage += "There was a tie. Winners:\n";
            for (int i = 0; i < winners.size(); i++) {
                winnerMessage += winners.get(0).name + "\n";
            }
            winnerMessage += "Score: " + winners.get(0).score;
        }

        JOptionPane.showMessageDialog(null,winnerMessage,
            "Ticket to Ride - Game Over - " + currentPlayer.name,
            JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * If players are tied for the lead at the end
     * of the game, destination tickets are compared between those
     * players and the player with the most destintion tickets
     * claimed wins the tiebreaker and Ticket to Ride.
     * @param Player- player1(first player tied),
     * player2(second player tied)
     * @returns the Arraylist of the player that won
     * or if still tied calls the second tie break method
     */
    public static ArrayList<Player> tiebreak(Player player1, Player player2){
        ArrayList<Player> possible = new ArrayList<Player>();
        if (player1.claimedTicketRoutes.size() >= 
        player2.claimedTicketRoutes.size()) {
            possible.add(player1);
        }
        else if (player2.claimedTicketRoutes.size() >= 
        player1.claimedTicketRoutes.size()) {
            possible.add(player1);
        }

        if (possible.size() == 1) return possible;
        else return tiebreak2(possible.get(0), possible.get(1));
    }

    /**
     * If players are tied for the lead at the end
     * of the game, meeples are compared between those
     * players and the player with the most meeples
     * claimed wins the tiebreaker and Ticket to Ride.
     * @param Player- player1(first player tied),
     * player2(second player tied)
     * @returns the Arraylist of the player that won
     */
    public static ArrayList<Player> tiebreak2(Player player1, Player player2){
        ArrayList<Player> possible = new ArrayList<Player>();
        if (player1.numMeeples() >= player2.numMeeples()) {
            possible.add(player1);
        }
        if (player2.numMeeples() >= player1.numMeeples()) {
            possible.add(player2);
        }
        return possible;
    }

    /**
     * If players are tied for the lead at the end
     * of the game, destination tickets are compared between those
     * players and the player with the most destintion tickets
     * claimed wins the tiebreaker and Ticket to Ride.
     * @param Player- player1(first player tied),
     * player2(second player tied), player3(third player tied).
     * @returns the Arraylist of the player that won
     * or if still tied calls the second tie break method.
     */
    public static ArrayList<Player> tiebreak(Player player1, Player player2, 
    Player player3) {
        ArrayList<Player> possible = new ArrayList<Player>();
        if (player1.claimedTicketRoutes.size() >=
        player2.claimedTicketRoutes.size() &&
        player1.claimedTicketRoutes.size() >= 
        player3.claimedTicketRoutes.size()) {
            possible.add(player1);
        }
        else if (player2.claimedTicketRoutes.size() > 
        player1.claimedTicketRoutes.size() &&
        player2.claimedTicketRoutes.size() >= 
        player3.claimedTicketRoutes.size()) {
            possible.add(player2);
        }
        else if (player3.claimedTicketRoutes.size() > 
        player1.claimedTicketRoutes.size() &&
        player3.claimedTicketRoutes.size() >= 
        player2.claimedTicketRoutes.size()) {
            possible.add(player3);
        }

        if (possible.size() == 1) return possible;
        if (possible.size() == 2) return 
            tiebreak2(possible.get(0), possible.get(1));
        else return 
            tiebreak2(possible.get(0), possible.get(1), possible.get(2));
    }

    /**
     * If players are tied for the lead at the end
     * of the game, meeples are compared between those
     * players and the player with the most meeples
     * claimed wins the tiebreaker and Ticket to Ride.
     * @param Player- player1(first player tied),
     * player2(second player tied), player3(third player tied).
     * @returns the Arraylist of the player that won.
     */
    public static ArrayList<Player> tiebreak2(Player player1, 
    Player player2, Player player3) {
        ArrayList<Player> possible = new ArrayList<Player>();
        if (player1.numMeeples() >= player2.numMeeples() &&
        player1.numMeeples() >= player3.numMeeples()) {
            possible.add(player1);
        }
        if (player2.numMeeples() >= player1.numMeeples() &&
        player2.numMeeples() >= player3.numMeeples()) {
            possible.add(player2);
        }
        if (player3.numMeeples() >= player1.numMeeples() &&
        player3.numMeeples() >= player2.numMeeples()) {
            possible.add(player3);
        }
        return possible;
    }

    /**
     * If players are tied for the lead at the end
     * of the game, destination tickets are compared between those
     * players and the player with the most destintion tickets
     * claimed wins the tiebreaker and Ticket to Ride.
     * @param Player- player1(first player tied),
     * player2(second player tied), player3(third player tied),
     * player4(fourth player tied).
     * @returns the Arraylist of the player that won
     * or if still tied calls the second tie break method.
     */
    public static ArrayList<Player> tiebreak(Player player1, Player player2,
    Player player3, Player player4) {
        ArrayList<Player> possible = new ArrayList<Player>();
        if (player1.claimedTicketRoutes.size() >= 
        player2.claimedTicketRoutes.size() &&
        player1.claimedTicketRoutes.size() >= 
        player3.claimedTicketRoutes.size() &&
        player1.claimedTicketRoutes.size() >= 
        player4.claimedTicketRoutes.size()) {
            possible.add(player1);
        }
        if (player2.claimedTicketRoutes.size() >= 
        player1.claimedTicketRoutes.size() &&
        player2.claimedTicketRoutes.size() >= 
        player3.claimedTicketRoutes.size() &&
        player2.claimedTicketRoutes.size() >= 
        player4.claimedTicketRoutes.size()) {
            possible.add(player2);
        }
        if (player3.claimedTicketRoutes.size() >= 
        player1.claimedTicketRoutes.size() &&
        player3.claimedTicketRoutes.size() >= 
        player2.claimedTicketRoutes.size() &&
        player3.claimedTicketRoutes.size() >= 
        player4.claimedTicketRoutes.size()) {
            possible.add(player3);
        }
        if (player4.claimedTicketRoutes.size() >= 
        player1.claimedTicketRoutes.size() &&
        player4.claimedTicketRoutes.size() >= 
        player2.claimedTicketRoutes.size() &&
        player4.claimedTicketRoutes.size() >= 
        player3.claimedTicketRoutes.size()) {
            possible.add(player4);
        }

        if (possible.size() == 1) return possible;
        if (possible.size() == 2) return 
            tiebreak2(possible.get(0), possible.get(1));
        if (possible.size() == 3) return 
            tiebreak2(possible.get(0), possible.get(1),
                possible.get(2));
        else return tiebreak2(possible.get(0), possible.get(1),
                possible.get(2), possible.get(3));
    }

    /**
     * If players are tied for the lead at the end
     * of the game, meeples are compared between those
     * players and the player with the most meeples
     * claimed wins the tiebreaker and Ticket to Ride.
     * @param Player- player1(first player tied),
     * player2(second player tied), player3(third player tied), 
     * player4(fourth player tied).
     * @returns the Arraylist of the player that won.
     */
    public static ArrayList<Player> tiebreak2(Player player1, Player player2,
    Player player3, Player player4) {
        ArrayList<Player> possible = new ArrayList<Player>();
        if (player1.numMeeples() >= player2.numMeeples() &&
        player1.numMeeples() >= player3.numMeeples() &&
        player1.numMeeples() >= player4.numMeeples()) {
            possible.add(player1);
        }
        if (player2.numMeeples() >= player1.numMeeples() &&
        player2.numMeeples() >= player3.numMeeples() &&
        player2.numMeeples() >= player4.numMeeples()) {
            possible.add(player2);
        }
        if (player3.numMeeples() >= player1.numMeeples() &&
        player3.numMeeples() >= player2.numMeeples() &&
        player3.numMeeples() >= player4.numMeeples()) {
            possible.add(player3);
        }
        if (player4.numMeeples() >= player1.numMeeples() &&
        player4.numMeeples() >= player2.numMeeples() &&
        player4.numMeeples() >= player3.numMeeples()) {
            possible.add(player4);
        }
        return possible;
    }

    /**
     * If players are tied for the lead at the end
     * of the game, destination tickets are compared between those
     * players and the player with the most destintion tickets
     * claimed wins the tiebreaker and Ticket to Ride.
     * @param Player- player1(first player tied),
     * player2(second player tied), player3(third player tied),
     * player4(fourth player tied), player5(fifth player tied).
     * @returns the Arraylist of the player that won
     * or if still tied calls the second tie break method.
     */
    public static ArrayList<Player> tiebreak(Player player1, Player player2,
    Player player3, Player player4, Player player5) {
        ArrayList<Player> possible = new ArrayList<Player>();
        if (player1.claimedTicketRoutes.size() >= 
        player2.claimedTicketRoutes.size() &&
        player1.claimedTicketRoutes.size() >= 
        player3.claimedTicketRoutes.size() &&
        player1.claimedTicketRoutes.size() >= 
        player4.claimedTicketRoutes.size() &&
        player1.claimedTicketRoutes.size() >= 
        player5.claimedTicketRoutes.size()) {
            possible.add(player1);
        }
        if (player2.claimedTicketRoutes.size() >= 
        player1.claimedTicketRoutes.size() &&
        player2.claimedTicketRoutes.size() >= 
        player3.claimedTicketRoutes.size() &&
        player2.claimedTicketRoutes.size() >= 
        player4.claimedTicketRoutes.size() &&
        player2.claimedTicketRoutes.size() >= 
        player5.claimedTicketRoutes.size()) {
            possible.add(player2);
        }
        if (player3.claimedTicketRoutes.size() >= 
        player1.claimedTicketRoutes.size() &&
        player3.claimedTicketRoutes.size() >= 
        player2.claimedTicketRoutes.size() &&
        player3.claimedTicketRoutes.size() >= 
        player4.claimedTicketRoutes.size() &&
        player3.claimedTicketRoutes.size() >= 
        player5.claimedTicketRoutes.size()) {
            possible.add(player3);
        }
        if (player4.claimedTicketRoutes.size() >= 
        player1.claimedTicketRoutes.size() &&
        player4.claimedTicketRoutes.size() >= 
        player2.claimedTicketRoutes.size() &&
        player4.claimedTicketRoutes.size() >= 
        player3.claimedTicketRoutes.size() &&
        player4.claimedTicketRoutes.size() >= 
        player5.claimedTicketRoutes.size()) {
            possible.add(player4);
        }
        if (player5.claimedTicketRoutes.size() >= 
        player1.claimedTicketRoutes.size() &&
        player5.claimedTicketRoutes.size() >= 
        player2.claimedTicketRoutes.size() &&
        player5.claimedTicketRoutes.size() >= 
        player3.claimedTicketRoutes.size() &&
        player5.claimedTicketRoutes.size() >= 
        player4.claimedTicketRoutes.size()) {
            possible.add(player5);
        }

        if (possible.size() == 1) return possible;
        if (possible.size() == 2) return 
            tiebreak2(possible.get(0), possible.get(1));
        if (possible.size() == 3) return 
            tiebreak2(possible.get(0), possible.get(1),
                possible.get(2));
        if (possible.size() == 4) return 
            tiebreak2(possible.get(0), possible.get(1),
                possible.get(2), possible.get(3));
        else return tiebreak2(possible.get(0), possible.get(1),
                possible.get(2), possible.get(3), possible.get(4));
    }

    /**
     * If players are tied for the lead at the end
     * of the game, meeples are compared between those
     * players and the player with the most meeples
     * claimed wins the tiebreaker and Ticket to Ride.
     * @param Player- player1(first player tied),
     * player2(second player tied), player3(third player tied), 
     * player4(fourth player tied), player5(fifth player tied).
     * @returns the Arraylist of the player that won.
     */
    public static ArrayList<Player> tiebreak2(Player player1, Player player2,
    Player player3, Player player4, Player player5) {
        ArrayList<Player> possible = new ArrayList<Player>();
        if (player1.numMeeples() >= player2.numMeeples() &&
        player1.numMeeples() >= player3.numMeeples() &&
        player1.numMeeples() >= player4.numMeeples() &&
        player1.numMeeples() >= player5.numMeeples()) {
            possible.add(player1);
        }
        if (player2.numMeeples() >= player1.numMeeples() &&
        player2.numMeeples() >= player3.numMeeples() &&
        player2.numMeeples() >= player4.numMeeples() &&
        player2.numMeeples() >= player5.numMeeples()) {
            possible.add(player2);
        }
        if (player3.numMeeples() >= player1.numMeeples() &&
        player3.numMeeples() >= player2.numMeeples() &&
        player3.numMeeples() >= player4.numMeeples() &&
        player3.numMeeples() >= player5.numMeeples()) {
            possible.add(player3);
        }
        if (player4.numMeeples() >= player1.numMeeples() &&
        player4.numMeeples() >= player2.numMeeples() &&
        player4.numMeeples() >= player3.numMeeples() &&
        player4.numMeeples() >= player5.numMeeples()) {
            possible.add(player4);
        }
        if (player5.numMeeples() >= player1.numMeeples() &&
        player5.numMeeples() >= player2.numMeeples() &&
        player5.numMeeples() >= player3.numMeeples() &&
        player5.numMeeples() >= player4.numMeeples()) {
            possible.add(player4);
        }
        return possible;
    }

    /**
     * Gets the next player.
     * @return Player - next player. 
     */
    public Player nextPlayer() {
        if (numPlayers == 2) {
            if (currentPlayer == p1) return p2;
            else return p1;
        }

        else if (numPlayers == 3) {
            if (currentPlayer == p1) return p2;
            else if (currentPlayer == p2) return p3;
            else return p1;
        }

        else if (numPlayers == 4) {
            if (currentPlayer == p1) return p2;
            else if (currentPlayer == p2) return p3;
            else if (currentPlayer == p3) return p4;
            else return p1;
        }
        else {
            if (currentPlayer == p1) return p2;
            else if (currentPlayer == p2) return p3;
            else if (currentPlayer == p3) return p4;
            else if (currentPlayer == p4) return p5;
            else return p1;
        }
    }

    /**
     * Checks for the mouse to hover over the bounds of the
     * name of the city.
     * If so, the name of the city will appear on the board.
     * @param MouseEvent- event
     */
    public void checkForHover(MouseEvent event) {
        FontMetrics metrics = getFontMetrics(font);

        Graphics g = getGraphics();
        Rectangle textBounds1 = 
            metrics.getStringBounds(text1, g).getBounds();
        Rectangle textBounds2 = 
            metrics.getStringBounds(text2, g).getBounds();
        Rectangle textBounds3 = 
            metrics.getStringBounds(text3, g).getBounds();
        Rectangle textBounds4 = 
            metrics.getStringBounds(text4, g).getBounds();
        Rectangle textBounds5 = 
            metrics.getStringBounds(text5, g).getBounds();
        Rectangle textBounds6 = 
            metrics.getStringBounds(text6, g).getBounds();
        Rectangle textBounds7 = 
            metrics.getStringBounds(text7, g).getBounds();
        Rectangle textBounds8 = 
            metrics.getStringBounds(text8, g).getBounds();
        Rectangle textBounds9 = 
            metrics.getStringBounds(text9, g).getBounds();
        Rectangle textBounds10 = 
            metrics.getStringBounds(text10, g).getBounds();
        Rectangle textBounds11 = 
            metrics.getStringBounds(text11, g).getBounds();
        Rectangle textBounds12 = 
            metrics.getStringBounds(text12, g).getBounds();
        Rectangle textBounds13 = 
            metrics.getStringBounds(text13, g).getBounds();
        Rectangle textBounds14 = 
            metrics.getStringBounds(text14, g).getBounds();
        Rectangle textBounds15 = 
            metrics.getStringBounds(text15, g).getBounds();
        Rectangle textBounds16 = 
            metrics.getStringBounds(text16, g).getBounds();
        Rectangle textBounds17 = 
            metrics.getStringBounds(text17, g).getBounds();
        Rectangle textBounds18 = 
            metrics.getStringBounds(text18, g).getBounds();
        Rectangle textBounds19 = 
            metrics.getStringBounds(text19, g).getBounds();
        Rectangle textBounds20 = 
            metrics.getStringBounds(text20, g).getBounds();
        Rectangle textBounds21 = 
            metrics.getStringBounds(text21, g).getBounds();
        Rectangle textBounds22 = 
            metrics.getStringBounds(text22, g).getBounds();
        Rectangle textBounds23 = 
            metrics.getStringBounds(text23, g).getBounds();
        Rectangle textBounds24 = 
            metrics.getStringBounds(text24, g).getBounds();
        Rectangle textBounds25 = 
            metrics.getStringBounds(text25, g).getBounds();
        Rectangle textBounds26 = 
            metrics.getStringBounds(text26, g).getBounds();
        Rectangle textBounds27 = 
            metrics.getStringBounds(text27, g).getBounds();
        Rectangle textBounds28 = 
            metrics.getStringBounds(text28, g).getBounds();
        Rectangle textBounds29 = 
            metrics.getStringBounds(text29, g).getBounds();
        Rectangle textBounds30 = 
            metrics.getStringBounds(text30, g).getBounds();
        Rectangle textBounds31 = 
            metrics.getStringBounds(text31, g).getBounds();
        Rectangle textBounds32 = 
            metrics.getStringBounds(text32, g).getBounds();
        Rectangle textBounds33 = 
            metrics.getStringBounds(text33, g).getBounds();
        Rectangle textBounds34 = 
            metrics.getStringBounds(text34, g).getBounds();
        Rectangle textBounds35 = 
            metrics.getStringBounds(text35, g).getBounds();
        Rectangle textBounds36 = 
            metrics.getStringBounds(text36, g).getBounds();
        Rectangle textBounds37 = 
            metrics.getStringBounds(text37, g).getBounds();
        Rectangle textBounds38 = 
            metrics.getStringBounds(text38, g).getBounds();
        Rectangle textBounds39 = 
            metrics.getStringBounds(text39, g).getBounds();
        Rectangle textBounds40 = 
            metrics.getStringBounds(text40, g).getBounds();
        Rectangle textBounds41 = 
            metrics.getStringBounds(text41, g).getBounds();
        g.dispose();
        textBounds1.translate(textLocation1.x, textLocation1.y);
        textBounds2.translate(textLocation2.x, textLocation2.y);
        textBounds3.translate(textLocation3.x, textLocation3.y);
        textBounds4.translate(textLocation4.x, textLocation4.y);
        textBounds5.translate(textLocation5.x, textLocation5.y);
        textBounds6.translate(textLocation6.x, textLocation6.y);
        textBounds7.translate(textLocation7.x, textLocation7.y);
        textBounds8.translate(textLocation8.x, textLocation8.y);
        textBounds9.translate(textLocation9.x, textLocation9.y);
        textBounds10.translate(textLocation10.x, textLocation10.y);
        textBounds11.translate(textLocation11.x, textLocation11.y);
        textBounds12.translate(textLocation12.x, textLocation12.y);
        textBounds13.translate(textLocation13.x, textLocation13.y);
        textBounds14.translate(textLocation14.x, textLocation14.y);
        textBounds15.translate(textLocation15.x, textLocation15.y);
        textBounds16.translate(textLocation16.x, textLocation16.y);
        textBounds17.translate(textLocation17.x, textLocation17.y);
        textBounds18.translate(textLocation18.x, textLocation18.y);
        textBounds19.translate(textLocation19.x, textLocation19.y);
        textBounds20.translate(textLocation20.x, textLocation20.y);
        textBounds21.translate(textLocation21.x, textLocation21.y);
        textBounds22.translate(textLocation22.x, textLocation22.y);
        textBounds23.translate(textLocation23.x, textLocation23.y);
        textBounds24.translate(textLocation24.x, textLocation24.y);
        textBounds25.translate(textLocation25.x, textLocation25.y);
        textBounds26.translate(textLocation26.x, textLocation26.y);
        textBounds27.translate(textLocation27.x, textLocation27.y);
        textBounds28.translate(textLocation28.x, textLocation28.y);
        textBounds29.translate(textLocation29.x, textLocation29.y);
        textBounds30.translate(textLocation30.x, textLocation30.y);
        textBounds31.translate(textLocation31.x, textLocation31.y);
        textBounds32.translate(textLocation32.x, textLocation32.y);
        textBounds33.translate(textLocation33.x, textLocation33.y);
        textBounds34.translate(textLocation34.x, textLocation34.y);
        textBounds35.translate(textLocation35.x, textLocation35.y);
        textBounds36.translate(textLocation36.x, textLocation36.y);
        textBounds37.translate(textLocation37.x, textLocation37.y);
        textBounds38.translate(textLocation38.x, textLocation38.y);
        textBounds39.translate(textLocation39.x, textLocation39.y);
        textBounds40.translate(textLocation40.x, textLocation40.y);
        textBounds41.translate(textLocation41.x, textLocation41.y);
        if (textBounds1.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text1 = "DANEMACH";
        } 
        else if (textBounds2.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text2 = "KIEL";
        } 
        else if (textBounds3.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text3 = "HAMBURG";
        } 
        else if (textBounds4.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text4 = "ROSTOCK";
        } 
        else if (textBounds5.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text5 = "BERLIN";
        } 
        else if (textBounds6.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text6 = "SCHWERIN";
        } 
        else if (textBounds7.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text7 = "HANNOVER";
        } 
        else if (textBounds8.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text8 = "MAGDEBURG";
        } 
        else if (textBounds9.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text9 = "BREMERHAVEN";
        } 
        else if (textBounds10.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text10 = "BREMEN";
        } 
        else if (textBounds11.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text11 = "EMDEN";
        } 
        else if (textBounds12.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text12 = "MUNSTER";
        } 
        else if (textBounds13.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text13 = "NIEDERLANDE";
        }
        else if (textBounds14.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text14 = "DORTMUND";
        } 
        else if (textBounds15.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text15 = "DUSSELDORF";
        } 
        else if (textBounds16.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text16 = "KOIN";
        } 
        else if (textBounds17.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text17 = "KOBLENZ";
        } 
        else if (textBounds18.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text18 = "KASSEL";
        } 
        else if (textBounds19.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text19 = "FRANKFURT";
        } 
        else if (textBounds20.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text20 = "MAINZ";
        }
        else if (textBounds21.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text21 = "MANNHEIM";
        } 
        else if (textBounds22.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text22 = "SAARBRUCKEN";
        } 
        else if (textBounds23.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text23 = "KARLSRUHE";
        } 
        else if (textBounds24.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text24 = "FRANKREICH";
        } 
        else if (textBounds25.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text25 = "FREIBURG";
        } 
        else if (textBounds26.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text26 = "SCHWEIZ";
        } 
        else if (textBounds27.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text27 = "WURZBURG";
        } 
        else if (textBounds28.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text28 = "STUTTGART";
        } 
        else if (textBounds29.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text29 = "ULM";
        } 
        else if (textBounds30.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text30 = "LINDAU";
        } 
        else if (textBounds31.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text31 = "ERFURT";
        } 
        else if (textBounds32.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text32 = "NURNBERG";
        } 
        else if (textBounds33.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text33 = "AUGSBURG";
        }
        else if (textBounds34.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text34 = "MUNCHEN";
        } 
        else if (textBounds35.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text35 = "OSTERREICH";
        } 
        else if (textBounds36.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text36 = "LEIPZIG";
        } 
        else if (textBounds37.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text37 = "DRESDEN";
        } 
        else if (textBounds38.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text38 = "CHEMNITZ";
        } 
        else if (textBounds39.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text39 = "REGENSBURG";
        } 
        else if (textBounds40.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text40 = "KONSTAZ";
        }
        else if (textBounds41.contains(event.getPoint())) {
            textColor = HOVER_TEXT_COLOR;
            this.text41 = "OSTERREICH";
        }
        else {
            textColor = DEFAULT_TEXT_COLOR;
            this.text1 = "           ";
            this.text2 = "           ";
            this.text3 = "           ";
            this.text4 = "           ";
            this.text5 = "           ";
            this.text6 = "           ";
            this.text7 = "           ";
            this.text8 = "           ";
            this.text9 = "           ";
            this.text10 = "           ";
            this.text11 = "           ";
            this.text12 = "           ";
            this.text13 = "           ";
            this.text14 = "           ";
            this.text15 = "           ";
            this.text16 = "           ";
            this.text17 = "           ";
            this.text18 = "           ";
            this.text19 = "           ";
            this.text20 = "           ";
            this.text21 = "           ";
            this.text22 = "           ";
            this.text23 = "           ";
            this.text24 = "           ";
            this.text25 = "           ";
            this.text26 = "           ";
            this.text27 = "           ";
            this.text28 = "           ";
            this.text29 = "           ";
            this.text30 = "           ";
            this.text31 = "           ";
            this.text32 = "           ";
            this.text33 = "           ";
            this.text34 = "           ";
            this.text35 = "           ";
            this.text36 = "           ";
            this.text37 = "           ";
            this.text38 = "           ";
            this.text39 = "           ";
            this.text40 = "           ";
            this.text41 = "                 ";
        }
        repaint(textBounds1);
        repaint(textBounds2);
        repaint(textBounds3);
        repaint(textBounds4);
        repaint(textBounds5);
        repaint(textBounds6);
        repaint(textBounds7);
        repaint(textBounds8);
        repaint(textBounds9);
        repaint(textBounds10);
        repaint(textBounds11);
        repaint(textBounds12);
        repaint(textBounds13);
        repaint(textBounds14);
        repaint(textBounds15);
        repaint(textBounds16);
        repaint(textBounds17);
        repaint(textBounds18);
        repaint(textBounds19);
        repaint(textBounds20);
        repaint(textBounds21);
        repaint(textBounds22);
        repaint(textBounds23);
        repaint(textBounds24);
        repaint(textBounds25);
        repaint(textBounds26);
        repaint(textBounds27);
        repaint(textBounds28);
        repaint(textBounds29);
        repaint(textBounds30);
        repaint(textBounds31);
        repaint(textBounds32);
        repaint(textBounds33);
        repaint(textBounds34);
        repaint(textBounds35);
        repaint(textBounds36);
        repaint(textBounds37);
        repaint(textBounds38);
        repaint(textBounds39);
        repaint(textBounds40);
        repaint(textBounds41);
    }

    /**
     * PaintComponent method for JPanel.
     * 
     * @param  g   the Graphics object for this applet
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        background.paintIcon(this, g, 0, 0);
        board.paintIcon(this, g, 150, 0);

        Toolkit k = Toolkit.getDefaultToolkit();
        g.setFont(font);
        g.setColor(textColor);
        if(this.text1.equals("DANEMACH"))
        {
            g.drawString(text1, textLocation1.x, textLocation1.y);
            g.drawString("(" + cities.cities[0].numMeeples + ")", 
                textLocation1.x, textLocation1.y + 20);
        }
        else if(this.text2.equals("KIEL"))
        {
            g.drawString(text2, textLocation2.x, textLocation2.y);
            g.drawString("(" + cities.cities[1].numMeeples + ")", 
                textLocation2.x, textLocation2.y + 20);
        }
        else if(this.text3.equals("HAMBURG"))
        {
            g.drawString(text3, textLocation3.x, textLocation3.y);
            g.drawString("(" + cities.cities[2].numMeeples + ")", 
                textLocation3.x, textLocation3.y + 20);
        }
        else if(this.text4.equals("ROSTOCK"))
        {
            g.drawString(text4, textLocation4.x, textLocation4.y);
            g.drawString("(" + cities.cities[3].numMeeples + ")", 
                textLocation4.x, textLocation4.y + 20);
        }
        else if(this.text5.equals("BERLIN"))
        {
            g.drawString(text5, textLocation5.x, textLocation5.y);
            g.drawString("(" + cities.cities[4].numMeeples + ")", 
                textLocation5.x, textLocation5.y + 20);
        }
        else if(this.text6.equals("SCHWERIN"))
        {
            g.drawString(text6, textLocation6.x, textLocation6.y);
            g.drawString("(" + cities.cities[5].numMeeples + ")", 
                textLocation6.x, textLocation6.y + 20);
        }
        else if(this.text7.equals("HANNOVER"))
        {
            g.drawString(text7, textLocation7.x, textLocation7.y);
            g.drawString("(" + cities.cities[6].numMeeples + ")", 
                textLocation7.x, textLocation7.y + 20);
        }
        else if(this.text8.equals("MAGDEBURG"))
        {
            g.drawString(text8, textLocation8.x, textLocation8.y);
            g.drawString("(" + cities.cities[7].numMeeples + ")", 
                textLocation8.x, textLocation8.y + 20);
        }
        else if(this.text9.equals("BREMERHAVEN"))
        {
            g.drawString(text9, textLocation9.x, textLocation9.y);
            g.drawString("(" + cities.cities[8].numMeeples + ")", 
                textLocation9.x, textLocation9.y + 20);
        }
        else if(this.text10.equals("BREMEN"))
        {
            g.drawString(text10, textLocation10.x, textLocation10.y);
            g.drawString("(" + cities.cities[9].numMeeples + ")", 
                textLocation10.x, textLocation10.y + 20);
        }
        else if(this.text11.equals("EMDEN"))
        {
            g.drawString(text11, textLocation11.x, textLocation11.y);
            g.drawString("(" + cities.cities[10].numMeeples + ")", 
                textLocation11.x, textLocation11.y + 20);
        }
        else if(this.text12.equals("MUNSTER"))
        {
            g.drawString(text12, textLocation12.x, textLocation12.y);
            g.drawString("(" + cities.cities[11].numMeeples + ")", 
                textLocation12.x, textLocation12.y + 20);
        }
        else if(this.text13.equals("NIEDERLANDE"))
        {
            g.drawString(text13, textLocation13.x, textLocation13.y);
            g.drawString("(" + cities.cities[12].numMeeples + ")", 
                textLocation13.x, textLocation13.y + 20);
        }
        else if(this.text14.equals("DORTMUND"))
        {
            g.drawString(text14, textLocation14.x, textLocation14.y);
            g.drawString("(" + cities.cities[13].numMeeples + ")", 
                textLocation14.x, textLocation14.y + 20);
        }
        else if(this.text15.equals("DUSSELDORF"))
        {
            g.drawString(text15, textLocation15.x, textLocation15.y);
            g.drawString("(" + cities.cities[14].numMeeples + ")", 
                textLocation15.x, textLocation15.y + 20);
        }
        else if(this.text16.equals("KOIN"))
        {
            g.drawString(text16, textLocation16.x, textLocation16.y);
            g.drawString("(" + cities.cities[15].numMeeples + ")", 
                textLocation16.x, textLocation16.y + 20);
        }
        else if(this.text17.equals("KOBLENZ"))
        {
            g.drawString(text17, textLocation17.x, textLocation17.y);
            g.drawString("(" + cities.cities[16].numMeeples + ")", 
                textLocation17.x, textLocation17.y + 20);
        }
        else if(this.text18.equals("KASSEL"))
        {
            g.drawString(text18, textLocation18.x, textLocation18.y);
            g.drawString("(" + cities.cities[17].numMeeples + ")", 
                textLocation18.x, textLocation18.y + 20);
        }
        else if(this.text19.equals("FRANKFURT"))
        {
            g.drawString(text19, textLocation19.x, textLocation19.y);
            g.drawString("(" + cities.cities[18].numMeeples + ")", 
                textLocation19.x, textLocation19.y + 20);
        }
        else if(this.text20.equals("MAINZ"))
        {
            g.drawString(text20, textLocation20.x, textLocation20.y);
            g.drawString("(" + cities.cities[19].numMeeples + ")", 
                textLocation20.x, textLocation20.y + 20);
        }
        else if(this.text21.equals("MANNHEIM"))
        {
            g.drawString(text21, textLocation21.x, textLocation21.y);
            g.drawString("(" + cities.cities[20].numMeeples + ")", 
                textLocation21.x, textLocation21.y + 20);
        }
        else if(this.text22.equals("SAARBRUCKEN"))
        {
            g.drawString(text22, textLocation22.x, textLocation22.y);
            g.drawString("(" + cities.cities[21].numMeeples + ")", 
                textLocation22.x, textLocation22.y + 20);
        }
        else if(this.text23.equals("KARLSRUHE"))
        {
            g.drawString(text23, textLocation23.x, textLocation23.y);
            g.drawString("(" + cities.cities[22].numMeeples + ")", 
                textLocation23.x, textLocation23.y + 20);
        }
        else if(this.text24.equals("FRANKREICH"))
        {
            g.drawString(text24, textLocation24.x, textLocation24.y);
            g.drawString("(" + cities.cities[23].numMeeples + ")", 
                textLocation24.x, textLocation24.y + 20);
        }
        else if(this.text25.equals("FREIBURG"))
        {
            g.drawString(text25, textLocation25.x, textLocation25.y);
            g.drawString("(" + cities.cities[24].numMeeples + ")", 
                textLocation25.x, textLocation25.y + 20);
        }
        else if(this.text26.equals("SCHWEIZ"))
        {
            g.drawString(text26, textLocation26.x, textLocation26.y);
            g.drawString("(" + cities.cities[25].numMeeples + ")", 
                textLocation26.x, textLocation26.y + 20);
        }
        else if(this.text27.equals("WURZBURG"))
        {
            g.drawString(text27, textLocation27.x, textLocation27.y);
            g.drawString("(" + cities.cities[26].numMeeples + ")", 
                textLocation27.x, textLocation27.y + 20);
        }
        else if(this.text28.equals("STUTTGART"))
        {
            g.drawString(text28, textLocation28.x, textLocation28.y);
            g.drawString("(" + cities.cities[27].numMeeples + ")", 
                textLocation28.x, textLocation28.y + 20);
        }
        else if(this.text29.equals("ULM"))
        {
            g.drawString(text29, textLocation29.x, textLocation29.y);
            g.drawString("(" + cities.cities[28].numMeeples + ")", 
                textLocation29.x, textLocation29.y + 20);
        }
        else if(this.text30.equals("LINDAU"))
        {
            g.drawString(text30, textLocation30.x, textLocation30.y);
            g.drawString("(" + cities.cities[29].numMeeples + ")", 
                textLocation30.x, textLocation30.y + 20);
        }
        else if(this.text31.equals("ERFURT"))
        {
            g.drawString(text31, textLocation31.x, textLocation31.y);
            g.drawString("(" + cities.cities[30].numMeeples + ")", 
                textLocation31.x, textLocation31.y + 20);
        }
        else if(this.text32.equals("NURNBERG"))
        {
            g.drawString(text32, textLocation32.x, textLocation32.y);
            g.drawString("(" + cities.cities[31].numMeeples + ")", 
                textLocation32.x, textLocation32.y + 20);
        }
        else if(this.text33.equals("AUGSBURG"))
        {
            g.drawString(text33, textLocation33.x, textLocation33.y);
            g.drawString("(" + cities.cities[32].numMeeples + ")", 
                textLocation33.x, textLocation33.y + 20);
        }
        else if(this.text34.equals("MUNCHEN"))
        {
            g.drawString(text34, textLocation34.x, textLocation34.y);
            g.drawString("(" + cities.cities[33].numMeeples + ")", 
                textLocation34.x, textLocation34.y + 20);
        }
        else if(this.text35.equals("OSTERREICH"))
        {
            g.drawString(text35, textLocation35.x, textLocation35.y);
            g.drawString("(" + cities.cities[34].numMeeples + ")", 
                textLocation35.x, textLocation35.y + 20);
        }
        else if(this.text36.equals("LEIPZIG"))
        {
            g.drawString(text36, textLocation36.x, textLocation36.y);
            g.drawString("(" + cities.cities[35].numMeeples + ")", 
                textLocation36.x, textLocation36.y + 20);
        }
        else if(this.text37.equals("DRESDEN"))
        {
            g.drawString(text37, textLocation37.x, textLocation37.y);
            g.drawString("(" + cities.cities[36].numMeeples + ")", 
                textLocation37.x, textLocation37.y + 20);
        }
        else if(this.text38.equals("CHEMNITZ"))
        {
            g.drawString(text38, textLocation38.x, textLocation38.y);
            g.drawString("(" + cities.cities[37].numMeeples + ")", 
                textLocation38.x, textLocation38.y + 20);
        }
        else if(this.text39.equals("REGENSBURG"))
        {
            g.drawString(text39, textLocation39.x, textLocation39.y);
            g.drawString("(" + cities.cities[38].numMeeples + ")", 
                textLocation39.x, textLocation39.y + 20);
        }
        else if(this.text40.equals("KONSTAZ"))
        {
            g.drawString(text40, textLocation40.x, textLocation40.y);
            g.drawString("(" + cities.cities[39].numMeeples + ")", 
                textLocation40.x, textLocation40.y + 20);
        }
        else if(this.text41.equals("OSTERREICH"))
        {
            g.drawString(text41, textLocation41.x, textLocation41.y);
            g.drawString("(" + cities.cities[34].numMeeples + ")", 
                textLocation41.x, textLocation41.y + 20);
        }

        Image YellowCard = k.getImage("YellowCard.jpg");
        g.drawImage(YellowCard,760, 550,150, 100, null);

        Image RedCard = k.getImage("RedCard.jpg");
        g.drawImage(RedCard,920, 550,150, 100, null);

        Image BlueCard = k.getImage("BlueCard.jpg");
        g.drawImage(BlueCard,1080, 550,150, 100, null);

        Image BlackCard = k.getImage("BlackCard.jpg");
        g.drawImage(BlackCard,760, 660,150, 100, null);

        Image GreenCard = k.getImage("GreenCard.jpg");
        g.drawImage(GreenCard,920, 660,150, 100, null);

        Image WhiteCard = k.getImage("WhiteCard.jpg");
        g.drawImage(WhiteCard,1080, 660,150, 100, null);

        Image OrangeCard = k.getImage("OrangeCard.jpg");
        g.drawImage(OrangeCard,760, 770,150, 100, null);

        Image PurpleCard = k.getImage("PurpleCard.jpg");
        g.drawImage(PurpleCard,920, 770,150, 100, null);

        Image RainbowCard = k.getImage("RainbowCard.jpg");
        g.drawImage(RainbowCard,1080, 770,150, 100, null);

        String empty = "";
        g.setFont(new Font("TimesRoman",Font.PLAIN,32));
        g.setColor(Color.BLACK);
        g.fillRect( 820, 585, 30, 30 );
        g.fillRect( 980, 585, 30, 30 );
        g.fillRect( 1140, 585, 30, 30 );
        g.fillRect( 820, 695, 30, 30 );
        g.fillRect( 980, 695, 30, 30 );
        g.fillRect( 1140, 695, 30, 30 );
        g.fillRect( 820, 805, 30, 30 );
        g.fillRect( 980, 805, 30, 30 );
        g.fillRect( 1140, 805, 30, 30 );

        currentPlayer.countTrainCards();
        g.setColor(currentPlayer.color);
        g.drawString(currentPlayer.name, 950, 500);
        g.setColor(Color.WHITE);
        g.drawString(currentPlayer.numYellowCards + empty, 826, 612);
        g.drawString(currentPlayer.numRedCards + empty, 986, 612);
        g.drawString(currentPlayer.numBlueCards + empty, 1146, 612);
        g.drawString(currentPlayer.numBlackCards + empty, 826, 722);
        g.drawString(currentPlayer.numGreenCards + empty, 986, 722);
        g.drawString(currentPlayer.numWhiteCards + empty, 1146, 722);
        g.drawString(currentPlayer.numOrangeCards + empty, 826, 832);
        g.drawString(currentPlayer.numPurpleCards + empty, 986, 832);
        g.drawString(currentPlayer.numRainCards + empty, 1146, 832);

        g.setColor(currentPlayer.color);
        g.drawString("Number of trains: " + currentPlayer.numColoredTrains, 850, 900);

        g.setColor(Color.RED);
        g.fillRect(0, 0, 100, 100);
        g.fillRect(0, 150, 100, 100);
        g.fillRect(0, 300, 100, 100);
        g.fillRect(0, 450, 100, 100);
        if (claimingRoute != 0) g.fillRect(0, 600, 100, 100);
        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString("Draw Cards", 5, 50);
        g.drawString("Draw Tickets", 0, 200);
        g.drawString("Claim Route", 3, 350);
        g.drawString("View Tickets", 2, 500);
        if (claimingRoute != 0) g.drawString("Back", 15, 650);

        Image RedMeeple = k.getImage("RedMeeple.jpg");
        g.drawImage(RedMeeple,845, 25,100, 100, null);

        Image GreenMeeple = k.getImage("GreenMeeple.jpg");
        g.drawImage(GreenMeeple,955, 25,100, 100, null);

        Image WhiteMeeple = k.getImage("WhiteMeeple.jpg");
        g.drawImage(WhiteMeeple,1065, 25,100, 100, null);

        Image BlueMeeple = k.getImage("BlueMeeple.jpg");
        g.drawImage(BlueMeeple,845, 135,100, 100, null);

        Image BlackMeeple = k.getImage("BlackMeeple.jpg");
        g.drawImage(BlackMeeple,955, 135,100, 100, null);

        Image YellowMeeple = k.getImage("YellowMeeple.jpg");
        g.drawImage(YellowMeeple,1065, 135,100, 100, null);

        g.setFont(new Font("TimesRoman",Font.PLAIN,32));
        g.setColor(Color.BLACK);
        g.fillRect( 880, 60, 30, 30 );
        g.fillRect( 990, 60, 30, 30 );
        g.fillRect( 1100, 60, 30, 30 );
        g.fillRect( 880, 170, 30, 30 );
        g.fillRect( 990, 170, 30, 30 );
        g.fillRect( 1100, 170, 30, 30 );

        g.setColor(Color.WHITE);
        g.drawString(currentPlayer.redM + empty, 886, 87);
        g.drawString(currentPlayer.greenM + empty, 996, 87);
        g.drawString(currentPlayer.whiteM + empty, 1106, 87);
        g.drawString(currentPlayer.blueM + empty, 886, 197);
        g.drawString(currentPlayer.blackM + empty, 996, 197);
        g.drawString(currentPlayer.yellowM + empty, 1106, 197);

        g.setFont(new Font("TimesRoman",Font.PLAIN,32));
        g.setColor(Color.GREEN);
        g.fillRect( 845, 245, 320, 140 );

        g.setFont(new Font("TimesRoman",Font.PLAIN,36));
        g.setColor(currentPlayer.color);
        g.drawString(currentPlayer.name, 865, 275);
        g.setFont(new Font("TimesRoman",Font.PLAIN,70));
        currentPlayer.routeScore();
        g.drawString("" + currentPlayer.score, 900, 350);

        for(Line l: lines)
        {
            g.setColor(l.col);
            g.drawLine(l.sX, l.sY, l.eX, l.eY); 
        }
    }

    /**
     * Creates the Jframe and panel so everything will
     * appear on the GameBoard.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Ticket To Ride");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GameBoard panel = new GameBoard();
        frame.getContentPane().add(panel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Main method for Gameboard.
     * @param String[] - args
     */
    public static void main(String[] args) {

        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        Object[] options = {"2","3","4","5"};
        GameBoard g = new GameBoard();
        numPlayers = JOptionPane.showOptionDialog(null,
            "How many players? The first player entered must be the oldest "+
            "as they go first","Ticket to Ride - Number of Players",
            JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,
            null,options,null);

        if (numPlayers == 0)
        {
            numPlayers = numPlayers + 2;
        }
        else if (numPlayers == 1)
        {
            numPlayers = numPlayers + 2;
        }
        else if (numPlayers == 2)
        {
            numPlayers = numPlayers + 2;
        }
        else if (numPlayers == 3)
        {
            numPlayers = numPlayers + 2;
        }
        int i = 1;
        do
        {
            String name = JOptionPane.showInputDialog("Enter player " + i +
                    "'s name.");
            if(i == 1)
            {
                p1 = new Player(name);
                currentPlayer = p1;
            }
            else if(i == 2)
            {
                p2 = new Player(name);
            }
            else if(i == 3)
            {
                p3 = new Player(name);
            }
            else if(i == 4)
            {
                p4 = new Player(name);
            }
            else if(i == 5)
            {
                p5 = new Player(name);
            }
            i++;
        }while (i <= numPlayers);
        if(numPlayers < 4)
        {
            for(int j = 0; j < routes.routes.length ; j++)
            {
                routes.routes[j].setSingleRoute();
            }
        }
        for(int x = 0 ;x <cities.cities.length; x++)
        {
            cities.cities[x].addMeeples();
        }
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
    }
}
