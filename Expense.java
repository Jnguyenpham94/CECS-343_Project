import java.text.DecimalFormat;
/**
 * Expense class keeps track of all the expenses of the building
 */
public class Expense {
	//Member variables
	private FinancialDate date;
	private String payee;
	private double amountPaid;
	private String budgetCategory;

	/**
	 * Constructor
	 */
	public Expense() {
		date = new FinancialDate();
		payee = "";
		amountPaid = 0.0;
		budgetCategory = "";
	}

	/**
	 * Overloaded constructor with 4 parameters
	 * @param fdate
	 * @param p
	 * @param ap
	 * @param bc
	 */
	public Expense(FinancialDate fdate, String p, double ap, String bc) {
		date = fdate;
		payee = p;
		amountPaid = ap;
		budgetCategory = bc;
	}

	/**
	 * Overloaded constructor with 6 parameters
	 * @param year
	 * @param month
	 * @param day
	 * @param p
	 * @param ap
	 * @param bc
	 */
	public Expense(int year, int month, int day, String p, double ap, String bc) {
		date = new FinancialDate(year, month, day);
		payee = p;
		amountPaid = ap;
		budgetCategory = bc;
	}

	/**
	 * Accessor for date
	 * @return date
	 */
	public FinancialDate getDate() {
		return date;
	}

	/**
	 * Mutator for date
	 * @param date
	 */
	public void setDate(FinancialDate date) {
		this.date = date;
	}

	/**
	 * Mutator for date
	 * @param y
	 * @param m
	 * @param d
	 */
	public void setDate(int y, int m, int d) {
		date.setYear(y);
		date.setMonth(m);
		date.setDay(d);
	}

	/**
	 * Accessor for amountPaid
	 * @return amountPaid
	 */
	public double getAmountPaid() {
		return amountPaid;
	}

	/**
	 * Mutator for amountPaid
	 * @param amountPaid
	 */
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	/**
	 * Accessor for payee
	 * @return payee
	 */
	public String getPayee() {
		return payee;
	}

	/**
	 * Mutator for payee
	 * @param payee
	 */
	public void setPayee(String payee) {
		this.payee = payee;
	}

	/**
	 * Accessor for budgetCategory
	 * @return budgetCategory
	 */
	public String getBudgetCategory() {
		return budgetCategory;
	}

	/**
	 * Mutator for budgetCategory
	 * @param budgetCategory
	 */
	public void setBudgetCategory(String budgetCategory) {
		this.budgetCategory = budgetCategory;
	}

	@Override
	public String toString() {
		double temp = amountPaid;
		DecimalFormat df = new DecimalFormat("#.00");
		String amountString = String.valueOf(df.format(temp));

		String expenseString = String.format("%20s%20s%20s\n", payee, amountString, budgetCategory);

		return expenseString;
	}

	/**
	 * returns a String for Expenses
	 * @return expenseString
	 */
	public String toStringExpense(){
		double temp = amountPaid;
		DecimalFormat df = new DecimalFormat("#.00");
		String amountString = String.valueOf(df.format(temp));

		String expenseString = String.format(" " +"%1s/%1s@%1s\n", payee, amountString, budgetCategory);

		return expenseString;

	}
}
