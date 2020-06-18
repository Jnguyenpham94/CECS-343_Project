import java.util.Scanner;
public class UserInterface extends LoginLogout{

    public UserInterface(){
        
    }

    public void Menu()
    {
        System.out.println("Login Successful");
        mainMenu();
        //TODO: need to link this with userInput();
        //userInput();
    }

    public void mainMenu()
    {
        System.out.println("Choose a task: ");
        System.out.println("1. Input data");
        System.out.println("2. Display a report");
        System.out.println("3. Logout");
    }

    public void inputMenu(){
        System.out.println("Choose a data you'd like to input: ");
        System.out.println("1. Add a tenant");
        System.out.println("2. Record rent payment,");
        System.out.println("3. Record expense:");
    }
    public void displayMenu(){
        System.out.println("Choose a report: ");
        System.out.println("1. Display tenants");
        System.out.println("2. Display rents,");
        System.out.println("3. Display expenses,");
        System.out.println("4. Display annual report:");
    }

    public void userInput(){
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        //If invalid choice
        if(choice != 1 && choice != 2 && choice !=3) {
            do {
                System.out.println("Enter a valid task: ");
                choice = input.nextInt();
            } while (choice != 1 && choice != 2 && choice !=3);
        }

        //Looping menu unless choice is to logout
        do{
            switch (choice){
                case 1:
                    inputMenu();
                    int subChoice = input.nextInt();
                    if(subChoice != 1 && subChoice != 2 && subChoice !=3) {
                        do {
                            System.out.println("Enter a valid task: ");
                            subChoice = input.nextInt();
                        } while (subChoice != 1 && subChoice != 2 && subChoice !=3);
                    }
                    //Submenu for data input
                    switch (subChoice){
                        case 1:
                            System.out.println("1.Nothing yet");
                            break;
                        case 2:
                            System.out.println("2.Nothing yet");
                            break;
                        case 3:
                            System.out.println("3.Nothing yet");
                            break;
                        default:
                            System.out.println("Invalid input");
                            break;

                    }
                    mainMenu();
                    choice = input.nextInt();
                    if(choice != 1 && choice != 2 && choice !=3) {
                        do {
                            System.out.println("Enter a valid task: ");
                            choice = input.nextInt();
                        } while (choice != 1 && choice != 2 && choice !=3);
                    }
                    break;
                case 2:
                    displayMenu();
                    //subChoice = input.next().charAt(0);
                    subChoice = input.nextInt();
                    if(subChoice != 1 && subChoice != 2 && subChoice !=3) {
                        do {
                            System.out.println("Enter a valid task: ");
                            subChoice = input.nextInt();
                        } while (subChoice != 1 && subChoice != 2 && subChoice !=3);
                    }
                    //Submenu for displaying data
                    switch (subChoice){
                        case 1:
                            System.out.println("1.Nothing yet");
                            break;
                        case 2:
                            System.out.println("2.Nothing yet");
                            break;
                        case 3:
                            System.out.println("3.Nothing yet");
                            break;
                        case 4:
                            System.out.println("4.Nothing yet");
                            break;
                        default:
                            System.out.println("Invalid input.");
                    }
                    mainMenu();
                    choice = input.nextInt();
                    if(choice != 1 && choice != 2 && choice !=3) {
                        do {
                            System.out.println("Enter a valid task: ");
                            choice = input.nextInt();
                        } while (choice != 1 && choice != 2 && choice !=3);
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
        }while(choice != 3);
    }
}