import java.text.DecimalFormat;

public class Expense {
	// private Finances financeObject; //includes the date and payment amount
	private FinancialDate date;
	private String payee;
	private double amountPaid;
	private String budgetCategory;

	public Expense() {
		date = new FinancialDate();
		payee = "";
		amountPaid = 0.0;
		budgetCategory = "";
	}

	public Expense(FinancialDate fdate, String p, double ap, String bc) {
		date = fdate;
		payee = p;
		amountPaid = ap;
		budgetCategory = bc;
	}

	public Expense(int year, int month, int day, String p, double ap, String bc) {
		date = new FinancialDate(year, month, day);
		payee = p;
		amountPaid = ap;
		budgetCategory = bc;
	}

	// TODO: Maybe delete these 2 methods
	/*
	 * public Finances getFinanceObject() { return financeObject; }
	 * 
	 * public void setFinanceObject(Finances financeObject) { this.financeObject =
	 * financeObject; }
	 */

	public FinancialDate getDate() {
		return date;
	}

	public void setDate(FinancialDate date) {
		this.date = date;
	}

	public void setDate(int y, int m, int d) {
		date.setYear(y);
		date.setMonth(m);
		date.setDay(d);
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public String getBudgetCategory() {
		return budgetCategory;
	}

	public void setBudgetCategory(String budgetCategory) {
		this.budgetCategory = budgetCategory;
	}

	@Override
	public String toString() {
		double temp = amountPaid;
		DecimalFormat df = new DecimalFormat("#.00");
		String amountString = String.valueOf(df.format(temp));
		// String amountString = String.format("%2f", amountPaid);

		String expenseString = String.format("%15s%15s%15s\n", payee, amountString, budgetCategory);

		return expenseString;
	}
}
