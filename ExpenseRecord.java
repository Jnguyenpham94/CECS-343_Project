import java.util.ArrayList;

public class ExpenseRecord 
{
	private ArrayList<Expense> expenseList;
	private double expenseTotal;
	
	public ExpenseRecord()
	{
		expenseList = new ArrayList<Expense>();
		expenseTotal = 0.0;
	}
	
	/** Not needed? Setter method serves the same purpose
	public ExpenseRecord(ArrayList<Expense> expenseAL)
	{
		expenseList = expenseAL;
	}
	*/
	
	public void addExpense(Expense e)
	{
		expenseList.add(e);
	}
	
	public void removeExpense(Expense e)
	{
		expenseList.remove(e);
	}
	
	public void clearExpenses()
	{
		expenseList.clear();
	}
	
	public void calculateExpenseTotal()
	{
		expenseTotal = 0.0;
		for(int i = 0; i < expenseList.size(); i++)
		{
			expenseTotal = expenseTotal + expenseList.get(i).getAmountPaid();
		}
	}

	public ArrayList<Expense> getExpenseList() {
		return expenseList;
	}

	/**
	public void setExpenseList(ArrayList<Expense> expenseList) {
		this.expenseList = expenseList;
	}
	*/
	public double getExpenseTotal() {
		return expenseTotal;
	}

	public void setExpenseTotal(double expenseTotal) {
		this.expenseTotal = expenseTotal;
	}
	
	public String toString()
	{
		String expenseRecordString = "";
		for(Expense e : expenseList)
		{
			expenseRecordString = expenseRecordString + e.toString() + "\n";
		}
		
		return expenseRecordString;
	}
	
}
