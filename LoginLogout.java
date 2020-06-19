import java.util.Scanner;

public class LoginLogout {

    public LoginLogout() {
        this.userID = "JohnN";
        this.password = "1234";
    }

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
        // obj.close(); have to comment this line to get thing works
        UserInterface ui = new UserInterface();
        ui.Menu();
        ui.userInput();
    }

    public void promptUsername() {
        System.out.print("Enter username: ");
    }

    public void promptPassword() {
        System.out.print("Enter password: ");
    }

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

    public void logout() {
        System.out.println("Logging out.");
        System.exit(0);
    }

    private String userID;
    private String password;

}