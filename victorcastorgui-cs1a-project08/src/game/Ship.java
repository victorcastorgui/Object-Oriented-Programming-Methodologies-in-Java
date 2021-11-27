package game;

public class Ship
{
    private int numOfHits;
    private boolean isAlive;
    private int maxHitsAllowed;
    private int numOfSailRows;
    // ASCII representation of ship
    private static final String asciiMast = "                 |         |         |\n";
    private static final String asciiSail = "              )____)    )____)    )____)\n";
    private static final String asciiConnect = "		 ________|_________|_________|_________\n";
    private static final String asciiBody = "         \\|_|VC|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|/\n";
    private static final String asciiWater = "^%^%^^^%^%%^%%^%^^^%^%%^%%^%^VC%^%%^%%^%^^^%^%%^%%^%^^^%^%^\n" +
                                             "^%^%^^^%^%%^%%^%^^^%^%%^%%^%^^^%^%%^%%^%^^^%^%%^%%^%^^^%^%^\n";

    public Ship (int maximumHeight)
    {
        numOfHits = 0;
        isAlive = true;
        maxHitsAllowed = maximumHeight;
        numOfSailRows = maximumHeight - 3;
    }

    // To add the number of hits
    public void addHits()
    {
        numOfHits++;
        if (numOfHits>=maxHitsAllowed)
            isAlive = false;
    }

    // To check if the hits is equal or exceeds the maximum allowed of hits
    public boolean getIsAlive()
    {
        return isAlive;
    }
    // Creates a String representation of the ASCII ship in its current state.
    public String toString()
    {
        if (getIsAlive()==false)
            return asciiWater;
        String fullShip[] = new String[maxHitsAllowed+1];

        fullShip[0] = asciiMast;
        int i;
        for (i = 1; i <= numOfSailRows; i++)
        {
            fullShip[i] = asciiSail;
        }
        fullShip[i] = asciiConnect;
        fullShip[i + 1] = asciiBody;
        String theShips = "";
        for (int x = 0; x <= i+1-numOfHits; x++)
        {
            theShips += fullShip[x];
        }
        theShips += asciiWater;
        return theShips;
    }
}
