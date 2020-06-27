
public class Tenant 
{
	private String firstName;
	private String LastName;
	private int aptNumber;
	private double currentRentPaid;
	RentPayment rent;
	//private ArrayList<Finances> rentPaymentHistory;
	
	public Tenant()
	{
		this("NoFirstName", "NoLastName", 000);
	}

	public Tenant(String first, String last, int aptNum)
	{
		this.firstName = first;
		this.LastName = last;
		this.aptNumber = aptNum;
		rent = new RentPayment();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public int getAptNumber() {
		return aptNumber;
	}

	public void setAptNumber(int aptNumber) {
		this.aptNumber = aptNumber;
	}

	public double getCurrentRentPaid() {
		return currentRentPaid;
	}

	public void setCurrentRentPaid(double currentRentPaid) {
		this.currentRentPaid = currentRentPaid;
	}

	@Override
	public String toString(){
		return getFirstName() + " " + getLastName();
	}

}
