

public class RentPayment {

    public RentPayment(){

    }

	public RentPayment(String name, double amount, int month) {
        
    }

    public int getAptID(){
        return aptID;
    }

    public void setAptID(int id){
        this.aptID = id;
    }

    public double[] getMonthlyRent(){
        return monthlyRent;
    }

    public RentPayment getRentPayment(){
        return rentPayment;
    }

    public void setRentPayment(RentPayment rp){
        this.rentPayment = rp;
    }
    
    private int aptID;
    private double monthlyRent[];
    private RentPayment rentPayment;

}
