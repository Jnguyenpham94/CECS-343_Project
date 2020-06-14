import java.util.Scanner;
public class LoginLogout{

    public LoginLogout()
    {
        this.userID = "JohnN";
        this.password = "1234";
    }

    public String login(){
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter username: ");
        String user = obj.nextLine();
        System.out.print("Enter password: ");
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
        //TODO: NEED TO CONNECT THIS WITH UserInterface class
        return "STILL STUFF TO DO!!!!";
    }

    private String userID;
    private String password;
    
}