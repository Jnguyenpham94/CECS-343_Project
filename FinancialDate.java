/**
 * FinancialDate class is used to set the day, month, and year
 */
public class FinancialDate
{
	//Member variables
	private int year;
	private int month;
	private int day;

	/**
	 * Constructor
	 */
	public FinancialDate()
	{
		year = 01;
		month = 01;
		day = 01;
	}

	/**
	 * Constructor with 3 parameters
	 * @param y
	 * @param m
	 * @param d
	 */
	public FinancialDate(int y, int m, int d)
	{
		year = y;
		month = m;
		day = d;
	}

	/**
	 * Accessor for year
	 * @return year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Mutator for year
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Accessor for month
	 * @return month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Mutator for month
	 * @param month
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * Accessor for day
	 * @return day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Mutator for day
	 * @param day
	 */
	public void setDay(int day) {
		this.day = day;
	}

	@Override
	public String toString()
	{
		String yearString = String.format("%04d", year);
		String monthString = String.format("%02d", month);
		String dayString = String.format("%02d", day);

		String fdateString =  dayString + "-" + monthString + "-" + yearString;
		return fdateString;

	}
}