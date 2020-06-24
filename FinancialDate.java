
public class FinancialDate 
{
	private int year;
	private int month;
	private int day;
	

	public FinancialDate()
	{
		year = 01;
		month = 01;
		day = 01;
	}
	
	public FinancialDate(int y, int m, int d)
	{
		year = y;
		month = m;
		day = d;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getDay() {
		return day;
	}

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
