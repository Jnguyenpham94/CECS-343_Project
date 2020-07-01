import java.util.Scanner;

/**
 * Allows the user to login/logout
 */
public class LoginLogout {

    //Member variables
    private String userID;
    private String password;

    /**
     * Constructor
     */
    public LoginLogout() {
        this.userID = "JohnN";
        this.password = "1234";
    }

    /**
     * Allows user to login. Checks if the inputted data
     * is correct to allow the user to continue.
     */
    public void login() {
        Scanner obj = new Scanner(System.in);
        promptUsername();
        String user = obj.nextLine();
        promptPassword();
        String pass = obj.nextLine();
        boolean entry = false;
        while (entry == false) {
            if (user.equals(userID) && password.equals(pass)) {
                entry = true;
            } else {
                invalidLogin();
                entry = true;
            }
        }
        //UserInterface instance
        UserInterface ui = new UserInterface();
        ui.Menu();
        ui.saveData(obj);
        obj.close();
        logout();
    }

    /**
     * Prompts the user for the username
     */
    public void promptUsername() {
        System.out.print("Enter username: ");
    }

    /**
     * Prompts the user for the password
     */
    public void promptPassword() {
        System.out.print("Enter password: ");
    }

    /**
     * If the username or password is incorrect,
     * the user is asked to try again or quit.
     */
    public void invalidLogin() {
        System.out.println("Login Failed \nDO you want to try again y/n?");
        Scanner obj = new Scanner(System.in);
        String temp = obj.nextLine();
        if (temp.equalsIgnoreCase("y")) {
            login();
        } else {
            obj.close();
            logout();
        }
    }

    /**
     * Allows the user to logout
     */
    public void logout() {
        System.out.println("Logging out.");
        System.exit(0);
    }
}