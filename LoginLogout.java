import java.util.Scanner;
public class LoginLogout{

    public LoginLogout()
    {
        this.userID = "JohnN";
        this.password = "1234";
    }

    public boolean login()
    {
        Scanner obj = new Scanner(System.in);
        promptUserName();
        String user = obj.nextLine();
        promptPassword();
        String pass = obj.nextLine();
        boolean entry = false;
        while(entry == false){
            if(user.equals(userID) && password.equals(pass)){
                entry = true;
            }
            else{
                System.out.println("Login Failed \n DO you want to try again y/n?");
                String temp = obj.nextLine();
                if(temp.equalsIgnoreCase("y")){
                    login();
                    entry = true;
                }
                else{
                    obj.close();
                    System.exit(0);
                }
            }
        }
        obj.close();
        UserInterface ui = new UserInterface();
        //ui.Menu();
        //TODO: NEED TO CONNECT THIS WITH UserInterface class
        return true;
    }

    public void promptUserName()
    {
        System.out.print("Enter username: ");
    }

    public void promptPassword()
    {
        System.out.print("Enter password: ");
    }

    public void logout()
    {
        System.exit(0);
    }

    private String userID;
    private String password;
    
}