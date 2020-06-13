
public class Expense 
{
	private Finances financeObject; //includes the date and payment amount
	private String payee;
	private String budgetCategory;
	
	public Expense()
	{
		//constructor;
	}

	public Finances getFinanceObject() {
		return financeObject;
	}

	public void setFinanceObject(Finances financeObject) {
		this.financeObject = financeObject;
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
	
	
}
