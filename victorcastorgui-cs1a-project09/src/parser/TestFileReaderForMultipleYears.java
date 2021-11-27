package parser;

/**
 * Reads an input file and creates an array of temperatures for multiple years.
 */
public class TestFileReaderForMultipleYears
{
	/**
	 * Creates an object of type TemperaturesCSVFileReader to read an input file
	 * in which stores temperatures in Comma Separated Value (CSV) format.
	 * @param args  Not used.
	 */
	public static void main(String[] args)
	{
		// Note: This requires manually changing your test file and
		//       adding a comment in your RUN.txt clarifying the output of which test file
		//       you have pasted.
		// The path and name of the input file
		//final String filename = "resources/temperatures01.csv";
		//final String filename = "resources/temperatures02.csv";
		//final String filename = "resources/temperatures_invalid01.csv";
		//final String filename = "resources/temperatures_invalid02.csv";
		final String filename = "resources/temperatures_invalid03.csv";
		
		// Now, try reading from the input file
		TemperaturesCSVReaderForMultipleYears reader;

		// parses a CSV file
		reader = new TemperaturesCSVReaderForMultipleYears(filename);
		
		// Get the data parsed
		MonthlyTemperature temperatures[][] = reader.getTemperatures();

		// Iterate over the data
		for(int currentYear = 0; currentYear < temperatures.length; currentYear++)
		{
			for(int currentMonth = 0; currentMonth < temperatures[currentYear].length; currentMonth++)
			{
				System.out.println(temperatures[currentYear][currentMonth]);
			}
		}
	}
}
