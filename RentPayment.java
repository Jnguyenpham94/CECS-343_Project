public class RentPayment {
    private int aptID;
    private double[] monthlyRent;
    private RentPayment rentPayment;

    public RentPayment(){
        monthlyRent = new double[12];
    }

    public void addPayment(double amountPaid, int monthPaid){
        monthlyRent[monthPaid] += amountPaid;
    }

    public double[] getMonthlyRent() {
        return monthlyRent;
    }

    @Override
    public String toString() {
        String s = "";
        for(Double rent : monthlyRent){
            s += rent + " ";
        }
        return s;
    }

    public int getAptID(){
        return aptID;
    }

    public void setAptID(int id){
        this.aptID = id;
    }


    public RentPayment getRentPayment(){
        return rentPayment;
    }

    public void setRentPayment(RentPayment rp){
        this.rentPayment = rp;
    }
}

