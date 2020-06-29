import java.text.DecimalFormat;

public class Expense {
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

		String expenseString = String.format("%20s%20s%20s\n", payee, amountString, budgetCategory);

		return expenseString;
	}

	public String toStringExpense(){
		double temp = amountPaid;
		DecimalFormat df = new DecimalFormat("#.00");
		String amountString = String.valueOf(df.format(temp));

		String expenseString = String.format(" " +"%1s/%1s@%1s\n", payee, amountString, budgetCategory);

		return expenseString;
        
    }
}
