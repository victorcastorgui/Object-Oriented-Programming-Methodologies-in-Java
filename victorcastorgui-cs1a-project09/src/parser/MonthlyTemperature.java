package parser;

/** To return the monthly temperature
 */
public class MonthlyTemperature 
{
	private String month;
	private int temperature;
	private int year;
	
	/**
	 * Stores the name of the month and current temperature.
	 * @param year The year for the temperature.
	 * @param month The name of the month.
	 * @param temperature The whole number for the temperature.
	 */
	public MonthlyTemperature(int year, String month, int temperature)
	{
		this.year = year;
		this.month = month;
		this.temperature = temperature;
	}
	
	/**
	 * Returns the current year.
	 * @return The year for the stored temperatures
	 */
	public int getYear()
	{
		return year;
	}
	
	/**
	 * Returns the current month.
	 * @return The name of the current month
	 */
	public String getName()
	{
		return month;
	}
	
	/**
	 * Returns the temperature.
	 * @return An int for the stored temperature
	 */
	public int getTemperature()
	{
		return temperature;
	}
	
	/**
	 * Provide a String representation of the current instance.
	 */
	public String toString()
	{
		StringBuffer info = new StringBuffer();
		info.append("Temperature during " + year + " " + month);
		info.append(" is " + this.temperature + " degrees.");
		return info.toString();
	}
}
