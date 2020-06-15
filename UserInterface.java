import java.util.Scanner;
public class UserInterface extends LoginLogout{

    public UserInterface(){
        
    }

    public void Menu()
    {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter 'i' to input data,");
        System.out.println("'d' to display a report,");
        System.out.println("'q' to quit program");
        String choice = obj.next();
        obj.close();
    }
}