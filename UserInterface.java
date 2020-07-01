import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;

/**
 * UserInterface class allows the user to interact with
 * the program
 */
public class UserInterface extends LoginLogout {
    //Member variables
    final int CAPACITY = 20;
    private double totalExpense;
    private double totalIncome;
    //Keeps track of the Tenants and which apartment numbers are occupied
    HashMap<Integer, Tenant> tenantList = new HashMap<Integer, Tenant>(CAPACITY) {
        private static final long serialVersionUID = 1L;
    };
    //Keeps track of expenses
    HashMap<FinancialDate, Expense> expenseRecord = new HashMap<FinancialDate, Expense>();
    //Contains the expense categories
    HashMap<String, Double> expensePerCategory = new HashMap<>();

    /**
     * Constructor
     */
    public UserInterface() {
    }

    /**
     * Menu that calls the loadData, mainMenu, and userInput methods
     */
    public void Menu() {
        System.out.println("Login Successful");
        loadData();
        mainMenu();
        userInput();
    }

    /**
     * Displays the main menu to the user
     */
    public void mainMenu() {
        System.out.println("Choose a task: ");
        System.out.println("1. Input data");
        System.out.println("2. Display a report");
        System.out.println("3. Logout");
    }

    /**
     * Displays the input menu for the user
     * to choose what data they would like to input
     */
    public void inputMenu() {
        System.out.println("Choose data you'd like to input: ");
        System.out.println("1. Add a tenant");
        System.out.println("2. Record rent payment");
        System.out.println("3. Record expense:");
    }

    /**
     * Displays the display menu for the user
     * to choose what data they would like to see
     */
    public void displayMenu() {
        System.out.println("Choose a report: ");
        System.out.println("1. Display Tenant List");
        System.out.println("2. Display Rental Record");
        System.out.println("3. Display Expense Record");
        System.out.println("4. Display Annual Report");
    }

    /**
     * The user can input data so the program can do
     * what the user wants
     */
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
                            aptNum = apartmentAvailability(aptNum, data);
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
                            displayTenantList();
                            break;
                        case 2:
                            displayRentRecord();
                            break;
                        case 3:
                            displayExpenseRecord();
                            break;
                        case 4:
                            displayAnnualSummary();
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

    /**
     * Loads the data that was previously inputted
     */
    public void loadData() {
        System.out.println("Loading data from previous session");
        try {
            BufferedReader readT = new BufferedReader(new FileReader("TenantList.txt"));
            String line;
            while ((line = readT.readLine()) != null) {
                String parts = line.replaceAll("[\\[\\](){},]", "");
                String[] parts2 = parts.split("=");
                Integer key = Integer.parseInt(parts2[0].trim());
                String[] value = parts2[1].split(" ");
                tenantList.put(key, new Tenant(value[0], value[1], key));
            }
            readT.close();
        } catch (Exception e) {
            System.out.println("File Tenant List Error!");
        }

        try {
            BufferedReader readR = new BufferedReader(new FileReader("RentPayments.txt"));
            String line2;
            while ((line2 = readR.readLine()) != null) {
                String[] temp = line2.split("\\s+");
                String firstNum = temp[0];
                int aprtNum = Integer.parseInt(firstNum);
                for (int m = 1; m <= temp.length -1; m++) {
                    String s = temp[m];
                    double amount = Double.parseDouble(s);
                    tenantList.get(aprtNum).rent.addPayment(amount, m - 1);
                    totalIncome += amount;
                }
            }
            readR.close();
        } catch (Exception e) {
            System.out.println("File Rent Record Error!");
            e.printStackTrace();
        }

        try {
            BufferedReader readE = new BufferedReader(new FileReader("ExpenseRecord.txt"));
            String line;
            while ((line = readE.readLine()) != null) {
                String parts = line.replaceAll("[\\[\\](){},]", "");
                parts = parts.replaceAll("[-]", " ");
                String[] parts2 = parts.split("=");
                String[] partsDate = parts2[0].split(" ");
                Integer month = Integer.parseInt(partsDate[0].trim());
                Integer day = Integer.parseInt(partsDate[1].trim());
                Integer year = Integer.parseInt(partsDate[2].trim());
                String[] partsAmount = parts2[1].split("@");
                String[] partsPayee = partsAmount[0].split("/");
                Double pAmount = Double.valueOf(partsPayee[1]);
                String partsCategory = partsAmount[1];
                FinancialDate upDate = new FinancialDate(year, month, day);
                expenseRecord.put(upDate, new Expense(upDate, partsPayee[0].toString().trim(), pAmount, partsCategory));
                calculateAnnualExpense();
                totalExpense += pAmount;
            }
            readE.close();
        } catch (Exception e) {
            System.out.println("File Expense Record Error!");
        }

    }

    /**
     * Saves the data that was inputted by the user
     * @param input
     */
    public void saveData(Scanner input) {
        System.out.println("Do you want to save the inputted data y/n?");
        String option = input.next();
        if (option.equalsIgnoreCase("y")) {
            try {
                BufferedWriter fileT = new BufferedWriter(new FileWriter("TenantList.txt"));
                for (HashMap.Entry<Integer, Tenant> entry : tenantList.entrySet()) {
                    fileT.write(entry.getKey() + "=" + entry.getValue());
                    fileT.newLine();
                }
                fileT.close();
                BufferedWriter fileE = new BufferedWriter(new FileWriter("ExpenseRecord.txt"));
                for (HashMap.Entry<FinancialDate, Expense> entry : expenseRecord.entrySet()) {
                    fileE.write(entry.getKey() + "=" + entry.getValue().toStringExpense());
                }
                fileE.close();
                FileWriter fileR = new FileWriter("RentPayments.txt");
                for (Integer i : tenantList.keySet()) {
                    fileR.append(String.valueOf(tenantList.get(i).getAptNumber())).append(" ")
                            .append(tenantList.get(i).rent.toString()).append("\n");
                }
                fileR.close();
            } catch (IOException e) {
                System.out.println("File Not Found!");
            }
        }

    }

    /**
     * Checks if the apartment number is available
     * @param aptNum
     * @param in
     */
    public int apartmentAvailability(int aptNum, Scanner in) {
        // Handle duplicate apartment number error
        while (tenantList.containsKey(aptNum)) {
            System.out.printf("Apartment %d is occupied. Please enter another apartment number: ", aptNum);
            aptNum = in.nextInt();
        }
        return aptNum;
    }

    /**
     * Adds the new Tenant and their apartment number to
     * the tenantList
     * @param fName
     * @param lName
     * @param aptNum
     * @param in
     */
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

    /**
     * Checks if the apartment number is vacant. An occupied apartment number
     * will allow the user to continue
     * @param aptNum
     * @param in
     * @return
     */
    public int tenantApartment(int aptNum, Scanner in) {
        while (!tenantList.containsKey(aptNum)) {
            System.out.println("Apartment is vacant. Please enter the tenant's apartment number: ");
            aptNum = in.nextInt();
        }
        return aptNum;
    }

    /**
     * Adds the Tenant's rent payment by calling the addPayment method
     * from the RentPayment class.
     * @param tenantApt
     * @param amount
     * @param month
     * @param in
     */
    private void addTenantRentPayment(int tenantApt, double amount, int month, Scanner in) {
        System.out.println("Enter 'i' to input data, any other key to throw away.");
        String dataInput = in.next();
        if (dataInput.equals("i")) {
            tenantList.get(tenantApt).rent.addPayment(amount, month - 1);
            totalIncome += amount;
        }
    }

    /**
     * Sorts the tenantList by keys
     * @param TL
     * @return
     */
    private ArrayList<Integer> sortByKey(HashMap<Integer, Tenant> TL) {
        ArrayList<Integer> sortedKeys = new ArrayList<Integer>();

        sortedKeys.addAll(TL.keySet());

        Collections.sort(sortedKeys);
        return sortedKeys;
    }

    /**
     * Adds the expenses to expenseRecord
     * @param day
     * @param month
     * @param year
     * @param category
     * @param payee
     * @param amount
     * @param data
     */
    private void addToExpenseRecord(int day, int month, int year, String category, String payee, double amount,
                                    Scanner data) {
        System.out.println("Enter 'i' to input data, any other key to throw away.");
        String dataExpenseInput = data.next();
        if (dataExpenseInput.equals("i")) {
            FinancialDate expenseDate = new FinancialDate(year, month, day);
            Expense ex = new Expense(expenseDate, payee, amount, category);
            expenseRecord.put(expenseDate, ex);
            calculateAnnualExpense();
            totalExpense += amount;
        }

    }

    /**
     * Displays the Tenants and their apartment number
     */
    private void displayTenantList() {
        System.out.println("\nApt#  Tenant name");
        System.out.println("-------------------");
        if (!tenantList.isEmpty()) {
            for (Integer i : tenantList.keySet()) {
                String aptNum = i.toString();
                String person = tenantList.get(i).toString();
                System.out.printf("%4s  %s\n", aptNum, person);
            }
        } else {
            System.out.println("EMPTY Tenant List");
        }
    }

    /**
     * Displays all vacant apartment numbers and the rent payments
     * for each month
     */
    private void displayRentRecord() {
        System.out.println("AptNo    Jan    Feb    Mar    Apr    May    Jun    Jul    Aug    Sep    Oct    Nov    Dec");
        System.out.println("-----------------------------------------------------------------------------------------");
        if (!tenantList.isEmpty()) {
            var sortedAptList = sortByKey(tenantList);
            for (Integer i : sortedAptList) {
                String aptNum = i.toString();
                String rentDisplay = String.format("%5s %s", aptNum, tenantList.get(i).rent.toString());
                System.out.println(rentDisplay);
                // System.out.println(aptNum + " " + tenantList.get(i).rent.toString());
            }
        }
    }

    /**
     * Displays all expenses made with the date
     */
    private void displayExpenseRecord() {
        System.out.printf("%8s%19s%24s%20s\n", "Date", "Payee", "Amount", "Category");
        System.out.println("-----------------------------------------------------------------------");
        for (FinancialDate f : expenseRecord.keySet()) {
            String record = expenseRecord.get(f).toString();
            String fDate = f.toString();
            System.out.printf("%11s%s", fDate, record);
        }
    }

    /**
     * Calls the displayAnnualRent and displayAnnualExpense
     * Displays the profit for the year
     */
    private void displayAnnualSummary() {
        System.out.println("Annual Summary");
        System.out.println("---------------");
        if (!tenantList.isEmpty())
            displayAnnualRent();
        if (!expensePerCategory.isEmpty())
            displayAnnualExpense();
        if (tenantList.isEmpty() && expensePerCategory.isEmpty())
            System.out.println("No Annual Summary.");
        System.out.printf("Balance: %.2f\n", totalIncome - totalExpense);
    }

    /**
     * Displays the total income for the year
     */
    public void displayAnnualRent() {
        System.out.println("Income");
        System.out.println(totalIncome + "\n");
    }

    /**
     * Calculates the total expenses for the year
     */
    private void calculateAnnualExpense() {
        expensePerCategory.clear();
        for (Expense expense : expenseRecord.values()) {
            var category = expense.getBudgetCategory();
            var amountPaid = expense.getAmountPaid();
            if (expensePerCategory.containsKey(category)) {
                expensePerCategory.put(category, expensePerCategory.get(category) + amountPaid);
            } else {
                expensePerCategory.put(category, amountPaid);
            }
        }
    }

    /**
     * Displays the total expenses for the year
     */
    private void displayAnnualExpense() {
        System.out.println("Expenses");
        for (var category : expensePerCategory.keySet()) {
            System.out.printf("%s: %.2f\n", category, expensePerCategory.get(category));
        }
        System.out.println();
    }
}
