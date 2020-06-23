import java.util.HashMap;
import java.util.Scanner;

public class UserInterface extends LoginLogout {
    final int CAPACITY = 20;
    HashMap<Integer, Tenant> tenantList = new HashMap<Integer, Tenant>(CAPACITY) {
        private static final long serialVersionUID = 1L;
    };

    public UserInterface() {

    }

    public void Menu() {
        System.out.println("Login Successful");
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
                            addToList(fName, lName, aptNum, data);
                            break;
                        case 2:
                            System.out.println("Enter Tenant's name: ");
                            String tenantName = data.nextLine();
                            System.out.println("Enter amount paid (345.67):");
                            double amountPaid = data.nextDouble();
                            System.out.println("Enter month rent is for (1-12): ");
                            int monthPaid = data.nextInt();
                            System.out.println("Enter 'i' to input data, any other key to throw away.");
                            String dataRentInput = data.next();
                            if (dataRentInput.equals("i")) {
                                RentPayment newRentRecord = new RentPayment(tenantName, amountPaid, monthPaid);
                            }
                            break;
                        case 3:
                            System.out.println("Enter day (1-31): ");
                            System.out.println("Enter month (1-12): ");
                            System.out.println("Enter year (0-99): ");
                            System.out.println("Enter expense category (Repairing, Utilities): ");
                            System.out.println("Enter payee (Bob's Hardware, Big Electric Co): ");
                            System.out.println("Enter amount (39.95): ");
                            System.out.println("Enter 'i' to input data, any other key to throw away.");
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
                    if (subChoice != 1 && subChoice != 2 && subChoice != 3) {
                        do {
                            System.out.println("Enter a valid task: ");
                            subChoice = input.nextInt();
                        } while (subChoice != 1 && subChoice != 2 && subChoice != 3);
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
                            System.out.println("AptNo Jan Feb Mar Apr May Jun Jul Aug Sep Oct Nov Dec");
                            System.out.println("---------------------------------------------------------");
                            break;
                        case 3:
                            System.out.println("Date Payee Amount Category");
                            System.out.println("---------------------------------------------------------");
                            break;
                        case 4:
                            System.out.println("Annual Summary");
                            System.out.println("---------------");
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
                    System.out.println("Logging out.");
                    input.close();
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        } while (choice != 3);
    }



    public void apartmentAvailability(int aptNum, Scanner in) {
        // Handle duplicate apartment number error
        while (tenantList.containsKey(aptNum)) {
            System.out.printf("Apartment %d is occupied. Please enter another apartment number: ", aptNum);
            aptNum = in.nextInt();
        }
    }

    private void addToList(String fName, String lName, int aptNum, Scanner in) {
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
}