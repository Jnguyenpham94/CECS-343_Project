import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;

public class UserInterface extends LoginLogout {
    final int CAPACITY = 20;
    HashMap<Integer, Tenant> tenantList = new HashMap<Integer, Tenant>(CAPACITY) {
        private static final long serialVersionUID = 1L;
    };
    HashMap<FinancialDate, Expense> expenseRecord = new HashMap<FinancialDate, Expense>();
    HashMap<String, Double> expensePerCategory = new HashMap<>();
    private double totalExpense;
    private double totalIncome;

    public UserInterface() {

    }

    public void Menu() {
        System.out.println("Login Successful");
        //loadData();
        mainMenu();
        userInput();
    }

    public void mainMenu() {
        System.out.println("Choose a task: ");
        System.out.println("1. Input data");
        System.out.println("2. Display a report");
        System.out.println("3. Logout");
    }

    public void inputMenu() {
        System.out.println("Choose data you'd like to input: ");
        System.out.println("1. Add a tenant");
        System.out.println("2. Record rent payment,");
        System.out.println("3. Record expense:");
    }

    public void displayMenu() {
        System.out.println("Choose a report: ");
        System.out.println("1. Display tenants");
        System.out.println("2. Display rents,");
        System.out.println("3. Display expenses,");
        System.out.println("4. Display annual report:");
    }

    public void userInput() {

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        // If invalid choice
        if (choice != 1 && choice != 2 && choice != 3) {
            do {
                System.out.println("Enter a valid task: ");
                choice = input.nextInt();
            } while (choice != 1 && choice != 2 && choice != 3);
        }

        // Looping menu unless choice is to logout
        do {
            switch (choice) {
                case 1:
                    inputMenu();
                    int subChoice = input.nextInt();
                    if (subChoice != 1 && subChoice != 2 && subChoice != 3) {
                        do {
                            System.out.println("Enter a valid task: ");
                            subChoice = input.nextInt();
                        } while (subChoice != 1 && subChoice != 2 && subChoice != 3);
                    }
                    // Submenu for data input
                    Scanner data = new Scanner(System.in);
                    switch (subChoice) {
                        case 1:
                            System.out.println("Enter tenant's first name (George): ");
                            String fName = data.nextLine();
                            System.out.println("Enter tenant's last name (Smith): ");
                            String lName = data.nextLine();
                            System.out.println("Enter tenant's apartment number (101):");
                            int aptNum = data.nextInt();
                            apartmentAvailability(aptNum, data);
                            addToTenantList(fName, lName, aptNum, data);
                            break;
                        case 2:
                            if (!tenantList.isEmpty()) {
                                System.out.println("Enter Tenant's apartment number: ");
                                int search = data.nextInt();
                                search = tenantApartment(search, data);
                                System.out.println("Enter amount paid (345.67):");
                                double amountPaid = data.nextDouble();
                                System.out.println("Enter month rent is for (1-12): ");
                                int monthPaid = data.nextInt();
                                addTenantRentPayment(search, amountPaid, monthPaid, data);
                            } else
                                System.out.println("There are no existing Tenants.");
                            break;
                        case 3:
                            System.out.println("Enter day (1-31): ");
                            int day = data.nextInt();
                            System.out.println("Enter month (1-12): ");
                            int month = data.nextInt();
                            System.out.println("Enter year (2020): ");
                            int year = data.nextInt();
                            data.nextLine();
                            System.out.println("Enter expense category (Repairing, Utilities): ");
                            String category = data.nextLine();
                            System.out.println("Enter payee (Bob's Hardware, Big Electric Co): ");
                            String payee = data.nextLine();
                            System.out.println("Enter amount (39.95): ");
                            double amount = data.nextDouble();
                            addToExpenseRecord(day, month, year, category, payee, amount, data);
                            break;
                        default:
                            System.out.println("Invalid input");
                            break;
                    }

                    mainMenu();
                    choice = input.nextInt();
                    if (choice != 1 && choice != 2 && choice != 3) {
                        do {
                            System.out.println("Enter a valid task: ");
                            choice = input.nextInt();
                        } while (choice != 1 && choice != 2 && choice != 3);
                    }
                    break;
                case 2:
                    displayMenu();
                    // subChoice = input.next().charAt(0);
                    subChoice = input.nextInt();
                    if (subChoice != 1 && subChoice != 2 && subChoice != 3 && subChoice != 4) {
                        do {
                            System.out.println("Enter a valid task: ");
                            subChoice = input.nextInt();
                        } while (subChoice != 1 && subChoice != 2 && subChoice != 3 && subChoice != 4);
                    }
                    // Submenu for displaying data
                    switch (subChoice) {
                        case 1:
                            System.out.println("\nApt# Tenant name");
                            System.out.println("-------------------");
                            if (!tenantList.isEmpty()) {
                                for (Integer i : tenantList.keySet()) {
                                    String aptNum = i.toString();
                                    String person = tenantList.get(i).toString();
                                    System.out.println(aptNum + " " + person);
                                }
                            } else {
                                System.out.println("EMPTY Tenant List");
                            }
                            break;
                        case 2:
                            System.out.println(
                                    "AptNo    Jan    Feb    Mar    Apr    May    Jun    Jul    Aug    Sep    Oct    Nov    Dec");
                            System.out.println(
                                    "-----------------------------------------------------------------------------------------");
                            if (!tenantList.isEmpty()) {
                                var sortedAptList = sortByKey(tenantList);
                                for (Integer i : sortedAptList) {
                                    String aptNum = i.toString();
                                    String rentDisplay = String.format("%5s %s", aptNum,
                                            tenantList.get(i).rent.toString());
                                    System.out.println(rentDisplay);
                                    // System.out.println(aptNum + " " + tenantList.get(i).rent.toString());
                                }
                            }
                            break;
                        case 3:
                            System.out.printf("%2s%15s%17s%22s\n", "Date", "Payee", "Amount", "Category");
                            System.out.println("---------------------------------------------------------");
                            for (FinancialDate f : expenseRecord.keySet()) {
                                String record = expenseRecord.get(f).toString();
                                String fDate = f.toString();
                                System.out.println(fDate + record);
                            }
                            break;
                        case 4:
                            System.out.println("Annual Summary");
                            System.out.println("---------------");
                            if (!tenantList.isEmpty())
                                displayAnnualRent();
                            if (!expensePerCategory.isEmpty())
                                displayAnnualExpense();
                            if (tenantList.isEmpty() && expensePerCategory.isEmpty())
                                System.out.println("No Annual Summary.");
                            System.out.printf("Balance: %.2f\n", totalIncome - totalExpense);
                            break;
                        default:
                            System.out.println("Invalid input.");
                    }
                    mainMenu();
                    choice = input.nextInt();
                    if (choice != 1 && choice != 2 && choice != 3) {
                        do {
                            System.out.println("Enter a valid task: ");
                            choice = input.nextInt();
                        } while (choice != 1 && choice != 2 && choice != 3);
                    }
                    break;
                case 3:
                    saveData(input);
                    input.close();
                    logout();
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        } while (choice != 3);
    }

    public void loadData(){
        String line;
        System.out.println("Loading data from previous session");
        try {
            BufferedReader fileR = new BufferedReader(new FileReader("TenantList.txt"));
            while(fileR.readLine() != null) {
                
            }
        } catch (Exception e) {
            System.out.println("File not Found!");
        }
    }
    public void saveData(Scanner input) {
        System.out.println("Do you want to save the inputted data y/n?");
        String option = input.next();
        if (option.equalsIgnoreCase("y")) {
            try {
                FileWriter fileT = new FileWriter("TenantList.txt");
                fileT.append(tenantList.toString());
                fileT.close();
                FileWriter fileE = new FileWriter("ExpenseRecord.txt");
                fileE.append(expenseRecord.toString());
                fileE.close();

            } 
            catch (IOException e) {
                System.out.println("File Not Found!");
            }
        }

    }

    public void apartmentAvailability(int aptNum, Scanner in) {
        // Handle duplicate apartment number error
        while (tenantList.containsKey(aptNum)) {
            System.out.printf("Apartment %d is occupied. Please enter another apartment number: ", aptNum);
            aptNum = in.nextInt();
        }
    }

    private void addToTenantList(String fName, String lName, int aptNum, Scanner in) {
        System.out.println("Enter 'i' to input data, any other key to throw away.");
        String dataInput = in.next();
        if (tenantList.size() != CAPACITY) {
            if (dataInput.equals("i")) {
                Tenant newTenant = new Tenant(fName, lName, aptNum);
                tenantList.put(Integer.valueOf(aptNum), newTenant);
            }
        } else {
            System.out.println("Cannot add more tenants apartment at capacity!!!");
        }
    }
    //Checks if apartment is vacant to add rent payment
    public int tenantApartment(int aptNum, Scanner in){
        while(!tenantList.containsKey(aptNum)){
            System.out.println("Apartment is vacant. Please enter the tenant's apartment number: ");
            aptNum = in.nextInt();
        }
        return aptNum;
    }

    //Adds rent payment
    private void addTenantRentPayment(int tenantApt, double amount, int month, Scanner in){
        System.out.println("Enter 'i' to input data, any other key to throw away.");
        String dataInput = in.next();
        if (dataInput.equals("i")) {
            tenantList.get(tenantApt).rent.addPayment(amount,month-1);
            totalIncome += amount;
        }
    }

    // Sort tenntList by keys
    private ArrayList<Integer> sortByKey(HashMap<Integer,Tenant> TL) 
    { 
        ArrayList<Integer> sortedKeys = 
                    new ArrayList<Integer>();
        
        sortedKeys.addAll(TL.keySet());
          
        Collections.sort(sortedKeys);  
        return sortedKeys;
    }

    private void addToExpenseRecord(int day, int month, int year, String category, String payee, double amount,
            Scanner data) {
        System.out.println("Enter 'i' to input data, any other key to throw away.");
        String dataExpenseInput = data.next();
        if(dataExpenseInput.equals("i")){
            FinancialDate expenseDate = new FinancialDate(year, month, day);
            Expense ex = new Expense(expenseDate, payee, amount, category);
            expenseRecord.put(expenseDate, ex);
            calculateAnnualExpense();
            totalExpense += amount;
        }

    }

    // Displays Annual Rent
    public void displayAnnualRent(){
        // double income = 0;
        // if(!tenantList.isEmpty()){
        //     for(Integer i : tenantList.keySet()){
        //         income += tenantList.get(i).rent.getYearlyRent();
        //     }
            System.out.println("Income");
            System.out.println(totalIncome);
        //} else System.out.println("No Annual Summary.");
    }

    // Calculate Anual Expense
    private void calculateAnnualExpense(){ 
        expensePerCategory.clear();
        for (Expense expense : expenseRecord.values()){ 
            var category = expense.getBudgetCategory();
            var amountPaid = expense.getAmountPaid();
            if (expensePerCategory.containsKey(category)){ 
                expensePerCategory.put(category, expensePerCategory.get(category) + amountPaid);
            }else { 
                expensePerCategory.put(category, amountPaid);
            }
        }
    }

    // Display Anual Expense
    private void displayAnnualExpense(){
        System.out.println("Expenses");
        for (var category : expensePerCategory.keySet()){ 
            System.out.printf("%s: %.2f\n", category, expensePerCategory.get(category));
        }
    }
}

