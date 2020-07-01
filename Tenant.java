/**
 * The user can create a tenant using the Tenant class
 */
public class Tenant
{
	//Member variables
	private String firstName;
	private String LastName;
	private int aptNumber;
	private double currentRentPaid;
	//An instance of RentPayment
	RentPayment rent;

	/**
	 * Constructor
	 */
	public Tenant()
	{
		this("NoFirstName", "NoLastName", 000);
	}

	/**
	 * Overloaded constructor with 3 parameters
	 * @param first
	 * @param last
	 * @param aptNum
	 */
	public Tenant(String first, String last, int aptNum)
	{
		this.firstName = first;
		this.LastName = last;
		this.aptNumber = aptNum;
		rent = new RentPayment();
	}

	/**
	 * Accessor for firstName
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Mutator for firstName
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Accessor for lastName
	 * @return lastName
	 */
	public String getLastName() {
		return LastName;
	}

	/**
	 * Mutator foe lastName
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		LastName = lastName;
	}

	/**
	 * Accessor for aptNumber
	 * @return aptNumber
	 */
	public int getAptNumber() {
		return aptNumber;
	}

	public void setAptNumber(int aptNumber) {
		this.aptNumber = aptNumber;
	}

	/**
	 * Accessor for getCurrentRentPaid
	 * @return currentRentPaid
	 */
	public double getCurrentRentPaid() {
		return currentRentPaid;
	}

	/**
	 * Mutator for currentRentPaid
	 * @param currentRentPaid
	 */
	public void setCurrentRentPaid(double currentRentPaid) {
		this.currentRentPaid = currentRentPaid;
	}

	@Override
	public String toString(){
		return getFirstName() + " " + getLastName();
	}
}
