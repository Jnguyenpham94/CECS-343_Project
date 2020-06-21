import java.util.ArrayList;
public class Tenant 
{
	private String firstName;
	private String LastName;
	private int aptNumber;
	private double currentRentPaid;
	//private ArrayList<Finances> rentPaymentHistory;
	
	public Tenant()
	{
		this("NoFirstName", "NoLastName");
	}

	public Tenant(String first, String last)
	{
		this.firstName = first;
		this.LastName = last;
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

	//TODO: Maybed delete these 2 methods
	/*
	public ArrayList<Finances> getRentPaymentHistory() {
		return rentPaymentHistory;
	}

	public void setRentPaymentHistory(ArrayList<Finances> rentPaymentHistory) {
		this.rentPaymentHistory = rentPaymentHistory;
	}
	*/
}
