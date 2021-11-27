package parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * An object of type FileReader parses a input file which stores MULTIPLE months and
 * temperatures in the following Comma Separated Values (CSV) format:
 * Historic Average High Temperatures...
 * [month],[year]
 */
public class TemperaturesCSVReaderForMultipleYears
{
    private final int NUM_MONTHS = 12;
    private MonthlyTemperature[][] temperatures = null;
    private int[] years = new int[100];

    /**
     * Receives the name of the file (including directory path information) from the caller.
     * Sets the parsed data to temperatures.
     *
     * @param temperatures
     */

    public void setTemperatures(MonthlyTemperature[][] temperatures)
    {
        this.temperatures = temperatures;
    }

    public TemperaturesCSVReaderForMultipleYears(String filename)
    {
        // Instantiates a File object given a file path
        File infile = new File(filename);

        // Creates an object of type from the input file.
        Scanner input = null;
        try
        {
            input = new Scanner(infile);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("File " + filename + " not found!");
        }

        // Parses the temperatures read from the input file.
        temperatures = parseInput(input);

        // close the file when all data has been read
        input.close();
    }

        /**
         * Converts the lines from the data file into an array of MonthlyTemperature objects.
         * @param source The file to be scanned.
         * @return  The array of parsed temperatures.
         * @throws NumberFormatException  If the format of the year(s) list is invalid.
         * @throws ArrayIndexOutOfBoundsException  If the specified month does not exist.
         */
        private MonthlyTemperature[][] parseInput(Scanner source) throws NumberFormatException
        {
            MonthlyTemperature[][] temperatures = new MonthlyTemperature[4][NUM_MONTHS] ;

            String header = source.nextLine();
            // Assume the first row is the title of the file
            if (header.contains("Historic Average"))
            {
                // Note: For now we just print the title of the data
                System.out.println(header);
            }

            header = source.nextLine();
            // Assume the second row is the source of the data
            if (header.contains("Source"))
            {
                // Note: For now we just print the source
                System.out.println(header);
            }

            header = source.nextLine();
            // Assume the third row is the year for the data
            int NumYears = 5;
            if (header.contains("Year"))
            {
                String [] tokens = header.split(",");
               NumYears = tokens.length;
                //System.out.println(NumYears);
                for (int i = 1; i < NumYears; i++) {
                    try{
                        years[i-1] = Integer.parseInt(tokens[i]);
                    }catch(NumberFormatException e) {
                        System.out.println("Invalid year format");
                        throw e;
                    }
                }
                // Note: Assume an invalid year is anything that cannot be parsed into an int value
            }

            // Parses the data portion of the file
            while (source.hasNextLine())
            {
                String line = source.nextLine();
                // Tokenize the String by commas "," and store into an array.
                // for more details see Javadocs:
                // https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/lang/String.html#split(java.lang.String)
                String [] tokens = line.split(",");

                // The first token is the month.
                String month = tokens[0];
                MonthlyTemperature[] currentMonth = new MonthlyTemperature[100];
                int[] temperature = new int[100];
                for (int i = 1; i < NumYears; i++) {
                    try {
                        temperature[i-1] = Integer.parseInt(tokens[i]);
                    }catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                        System.out.println("Invalid temperature format");
                        throw new NumberFormatException();
                    }
                    currentMonth[i-1] = new MonthlyTemperature(years[i-1], month, temperature[i-1]);
                }
                // Instantiates a new object to store the temperature and the associated year and month.

                // Stores the temperature in the index representing the month.
                for (int i = 0; i < NumYears-1; i++) {
                    switch (month) {
                        case "January":
                            temperatures[i][0] = currentMonth[i];
                            break;
                        case "February":
                            temperatures[i][1] = currentMonth[i];
                            break;
                        case "March":
                            temperatures[i][2] = currentMonth[i];
                            break;
                        case "April":
                            temperatures[i][3] = currentMonth[i];
                            break;
                        case "May":
                            temperatures[i][4] = currentMonth[i];
                            break;
                        case "June":
                            temperatures[i][5] = currentMonth[i];
                            break;
                        case "July":
                            temperatures[i][6] = currentMonth[i];
                            break;
                        case "August":
                            temperatures[i][7] = currentMonth[i];
                            break;
                        case "September":
                            temperatures[i][8] = currentMonth[i];
                            break;
                        case "October":
                            temperatures[i][9] = currentMonth[i];
                            break;
                        case "November":
                            temperatures[i][10] = currentMonth[i];
                            break;
                        case "December":
                            temperatures[i][11] = currentMonth[i];
                            break;

                        default:
                            System.out.println("Error months out of bounds");
                            throw new ArrayIndexOutOfBoundsException();

                    }
                }
            }
            return temperatures;
        }

        /**
         * Getter method for the temperatures.
         * @return An array of temperatures.
         */
        public MonthlyTemperature[][] getTemperatures()
        {
            return temperatures;
        }
    }

