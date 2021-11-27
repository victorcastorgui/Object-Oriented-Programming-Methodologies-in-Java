package lunardrift;
/**
 *  Calculates the lunar drift from Earth to the moon as compared to a
 *  specified starting year.
 *
 * @author Foothill College, [Victor Castor]
 */
public class CalculateLunarDrift 
{
	public static void main(String [] args)
	{
		// TODO: Provide a welcome message.
		System.out.println("Hello. Welcome to Lunar Drift Calculator!\n");

		// TODO: Create and initialize variables of different types.
		double LUNAR_DRIFT = 3.8;
		int METERS_TO_CM = 100;
		int STARTING_YEAR = 1900;
		double STARTING_DISTANCE = 368042000;
		int yearOfInterest;
		int numYears;
		double resultingDistance;
		double difference;

		// TODO: Calculate the lunar distance from earth to the moon in meters.

		// Hint: We want to figure out the distance from the earth to the moon and 
		//		 we know the starting distance in year 1900. So, we can use the variables
		//       we create to calculate the value of the variable resultingDistance.
		
		// TODO: Output the distance from Earth to the moon from our starting year in meters.
		System.out.println("Distance of Earth to moon in year 1900 is " + STARTING_DISTANCE + " meters");
		
		
		// test case 1
		// TODO: Hard-code the year of interest to 1502.
		//       Calculate the distance from Earth to the moon for our year of interest.
		//       Include the difference in meters between the starting year and year of interest.
		yearOfInterest = 1502;
		numYears = (yearOfInterest-STARTING_YEAR);
		resultingDistance = (STARTING_DISTANCE+(LUNAR_DRIFT*numYears)/METERS_TO_CM);
		difference = (STARTING_DISTANCE-resultingDistance);

		System.out.println("Test case 1:");
		System.out.println("Distance of Earth to moon in year " + yearOfInterest + " was " + resultingDistance + " meters");
		System.out.println("History: In 1502 Portuguese navigators discover Rio de Janeiro.");
		System.out.println("Difference between moon in year " + yearOfInterest + " and year " + STARTING_YEAR + " is " + difference + " meters\n");
		
		
		// test case 2
		// TODO: Hard-code the year of interest to 1969.
		//       Repeat calculations and output that you did for test case 2.
		yearOfInterest = 1969;
		numYears = (yearOfInterest-STARTING_YEAR);
		resultingDistance = (STARTING_DISTANCE+(LUNAR_DRIFT*numYears)/METERS_TO_CM);
		difference = (STARTING_DISTANCE-resultingDistance);

		System.out.println("Test case 2:");
		System.out.println("Distance of Earth to moon in year " + yearOfInterest + " was " + resultingDistance + " meters");
		System.out.println("History: In 1969 Neil Armstrong and Edwin Aldrin became the first humans ever to land on moon.");
		System.out.println("Difference between moon in year " + yearOfInterest + " and year " + STARTING_YEAR + " is " + difference + " meters\n");

		
		
		// test case 3
		// TODO: Find a new year of interest.
		//       Provide a description of the year you chose.
		//       Repeat calculations and output that you did for test case 3.
		yearOfInterest = 2001;
		numYears = (yearOfInterest-STARTING_YEAR);
		resultingDistance = (STARTING_DISTANCE+(LUNAR_DRIFT*numYears)/METERS_TO_CM);
		difference = (STARTING_DISTANCE-resultingDistance);

		System.out.println("Test case 3:");
		System.out.println("Distance of Earth to moon in year " + yearOfInterest + " was " + resultingDistance + " meters");
		System.out.println("History: In 2001 two solar and three lunar eclipses occur.");
		System.out.println("Difference between moon in year " + yearOfInterest + " and year " + STARTING_YEAR + " is " + difference + " meters\n");

		System.out.println("Done with Luna Drift!");
	}
}
