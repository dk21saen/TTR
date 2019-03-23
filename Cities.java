
/**
 * Creates city objects and adds the city to an array of cities in Germany
 * with correct xy-coordinates, names, and number of meeples allowed.
 * Meeples are added to the cities.
 * 
 * @author Ashley Hughes, Justyn McHarg, Devante Saenger, 
 * Collin Adams, Dylan Lane
 * 
 * @version Spring 2018
 */
public class Cities
{
    public City[] cities;
    /**
     * Cities constructor. Adds individual cities to the array of 
     * cities.
     * 
     */
    public Cities() {
        cities = new City[40];
        cities[0] = new City("Denemach", 385, 425 ,25, 70, 1);
        
        cities[1] = new City("Kiel", 418, 441, 90, 110, 1);
        cities[2] = new City("Hamburg",435, 455, 157 ,177, 4);
        cities[3] = new City("Rostock", 541, 559 , 90, 110, 1);
        cities[4] = new City("Schwerin", 499,518 , 145, 165, 1);
        cities[5] = new City("Berlin", 613 , 630, 242, 260, 5);
        cities[6] = new City("Hannover", 406, 426, 273, 290, 1);
        cities[7] = new City("Magdeburg",526,545, 288, 305, 1);
        cities[8] = new City("Bremerhaven",343, 361, 158,178, 1);
        cities[9] = new City("Bremen", 348, 366, 203, 221, 1);
        cities[10] = new City("Emden", 259, 276, 171, 193, 1);
        cities[11] = new City("Munster", 286, 306, 289, 309,1);
        cities[12] = new City("Niedeclande", 201, 256, 225, 281, 1);
        cities[13] = new City("Dortmund",280, 298, 337, 357, 1);
        cities[14] = new City("Dusseldorf",238, 254, 359, 378, 1);
        cities[15] = new City("Koln", 235, 253, 404,424, 4);
        cities[16] = new City("Koblenz",245, 264, 454, 472, 1);
        cities[17] = new City("Kassel", 395, 415, 366, 384, 1);
        cities[18] = new City("Frankfurt", 341, 362, 470, 489, 4);
        cities[19] = new City("Mainz", 302, 323, 495, 515, 1);
        cities[20] = new City("Mannheim", 320, 343, 537, 557, 1);
        cities[21] = new City("Saarbrucken", 220, 240, 552, 571,1);
        cities[22] = new City("Karlsruhe", 319, 337, 584, 605, 1);
        cities[23] = new City("Frankreich",197, 266, 604, 683 , 1);
        cities[24] = new City("Freiburg", 290,310, 681,701, 1);
        cities[25] = new City("Schweiz", 303, 355, 720,770, 1);
        cities[26] = new City("Wurzburg", 415,434, 494,515, 1);
        cities[27] = new City("Stuttgart", 367,388, 594,617, 3);
        cities[28] = new City("Ulm", 429,448, 637,657, 1);
        cities[29] = new City("Lindau", 409, 429, 708,728, 1);
        cities[30] = new City("Erfurt", 481,502, 393,414, 1);
        cities[31] = new City("Nurnberg", 484,504, 514,535, 1);
        cities[32] = new City("Augsburg", 471,491, 640,661, 1);
        cities[33] = new City("Munchen", 547,565, 656,678, 4);
        cities[34] = new City("Osterreich", 480,695, 673,768, 1);
        cities[35] = new City("Leipzig", 559,577, 348,368 , 3);
        cities[36] = new City("Dresden", 648,668, 380,400, 1);
        cities[37] = new City("Chemnitz", 607, 625, 402,420, 1);
        cities[38] = new City("Regensburg",580, 600, 570,589,1);
        cities[39] = new City("Konstaz", 364,383, 701, 721, 1);
        
        for (int i = 0; i < cities.length; i++) {
            cities[i].addMeeples();
        }
    }
     
}

