------------------------------------------------------------------------
This is the project README file.
------------------------------------------------------------------------

PROJECT TITLE: Ticket to Ride Germany
VERSION or DATE: Spring 2018
HOW TO START THIS PROJECT:Run the main method from the GameBoard class.
AUTHORS: Ashley Hughes, Justyn McHarg, Devante Saenger, Collin Adams, Dylan Lane
USER INSTRUCTIONS:

SETUP: To run the program, begin by running the main method in the GameBoard class. This will then give you numerous prompts to begin the game.
First, select how many players you would like to begin the game. Between 2 and 5 players may play. After that, please type in the player's 
name, with the oldest going first. Next, select the number of short tickets you would like. The remaining tickets will be long tickets. 
You are then shown your tickets, and may choose if you would like to discard 0, 1, or 2 tickets. Finally for setup, you are then allowed to 
choose your player color. This repeats for each player playing, and then you are ready to play!


GAMEPLAY: On each turn, you may perform one of three actions, by selecting the corresponding button on the left side of the game board. 
At any given moment, you may view your tickets by selecting the button on the left side of the game board, it is below the taking turn 
buttons. Please take your turn when your name is on the board in your chosen color. Your tickets are on the right side of the board, 
along with your meeples, number of trains, and the general score board that will display the current player's score based on their routes
claimed during the game.


    1. Draw Train Cards: A player draws two train cards, each train card being one of 8 colors or a rainbow card; you will be given a prompt
       that has 5 face up cards labeled by their color and an option to choose face down cards from the deck. The rainbow card 
       can be used as a wildcard in combination with any other singular color when claiming a route. You may select one that is face up, 
       which is then immediately replaced with another face up card. A player may also draw a face down, blind draw card. If you draw a face
       up Rainbow card that is the only train card you can draw on that turn and it must be your first card drawn; you are not allowed to 
       draw a Rainbow train card after you have already selected another train card. 
                      
    2. Draw Destination Tickets: A player draws four Destination Tickets, which can be any combination of short and long tickets; you will
       be given a prompt asking how many short tickets you would like and the rest will be long tickets. You will then be given a prompt 
       asking if you would like to discard any of the tickets you have just drawn. You can select 0 to keep all four tickets or you can
       choose either 1, 2 or 3 to discard that many tickets. You must keep one ticket, that is why there isn't an option to discard all 4.
       Any tickets you discard you be put back into their respcetive piles.
       
    3. Claiming a Route: A player may choose a route on his turn. This can only be done if a player can play a set of train cards that 
       match the color and length of the route they are trying the claim. The rainbow card can be used as a wildcard in combination with 
       any other singular color when claiming a route.A line in your color is then drawn from one city to another, and your score is 
       adjusted according. Then you select a passenger  meeple from each of the cities surrounding the route.
       
       
Drawing Train Card Cards: There are 8 types of regular train cards in varying colors: purple, blue, red, white, black, orange, green, and yellow. A player may have any number of these cards at a time. When the deck is exhausted, the draw pile is shuffled and cards are reset. If players hoard their cards and there are none to be drawn or reshuffled, one may not choose to draw train cards on their turn. Rainbow cards are wild, and one may draw two from a blind draw. Otherwise, you may not draw more than one face up.

Drawing Destination Tickets: A player may draw four destination tickets, any combination of long and short but he must first tell the program which he is choosing. He may keep and return as many as he would like, but must keep one. Some cards use neighboring country names as oppose to German city names. If this route is successfully connected, they add these points to their score at the end. If they are not connected at the end of the game, they subtract these points from their total score. Destination tickets are to be kept secret from other players until the end of the game, in which case you may reveal them to all, and use them for scoring. A player can view their destination tickets at any given point by selecting the corresponding button on the left hand side of the game board. 

Claiming Routes: To claim a route, a player must play a set of cards equal to the number of spaces in the route. The set of cards must all be matching, along with any locomotive cards. Most routes require a color, and some are gray and may be claimed with a set of any one color. When a route is claimed, a line in the player's color is drawn from each city in that player's color. A player may claim any open route on the board. A player may only claim one route on their turn. Some cities are connected by double and triple routes. You may only claim one of these in a game. In two and three player games, only one route of a double or triple route can be claimed. Once a player has claimed one of these, the other double and triple routes are locked and unavailable. When a player has claimed a route, he may take one maple from each of the connecting cities/countries that were just connected. If there are numerous meeples, you may only take one from each city, and can choose which to take. If there are none left, you do not get one from that city. Meeples are visible to all of the players, if they want to see which you have.


SCORING: When any of the player's train count gets down to 0, 1, or 2 trains at the end of their turn, each player, including that player, gets one final turn. The game then ends and the program calculates your score based on the following criteria. The program should have already accounted for the points earned as they completed different routes. Then, add all their Destination Tickets and add (or subtract) the value of their Destination Tickets, based on whether or not they succeeded in connecting those cities (and/or countries) together. The player who has completed the most Destination Tickets receives the Globetrotter Bonus Card and this adds 15 points to their score. In the case of a tie for the most completed tickets, all tied players will score the 15 bonus points. Tickets that were not completed have no effect for the purpose of determining which player earns this bonus. Finally, each player scores additional points for the meeples they collected during the game. A player will score 20 points per color he leads in and 10 points per color he has the second most Passengers in. If two or more players are tied for the most Passengers in a color, they each score 20 points and no player scores points for the second most Passengers. If one player has the most Passengers in a color and two or more players are tied for the second most, all of the tied
players score 10 points. The player with the most points wins the game. If two or more players are tied for the most points, the player (among those tied) who has completed the most Destination Tickets wins. In the unlikely event that they are still tied, the player with the most Passenger Meeples wins. If players are somehow still tied after checking both of these conditions, they share in the victory.


ENDING THE GAME: At any given point, you may quit the game by resetting the Java Virtual Machine. All will reset, and you may begin a new game!

Credit for GamePlay and Scoring: Days of Wonder Ticket to Ride Germany Game Rules English PDF


