public class RentPayment {
    private int aptID;
    private double[] monthlyRent;

    public RentPayment(){
        monthlyRent = new double[12];
    }

    public void addPayment(double amountPaid, int monthPaid){
        monthlyRent[monthPaid] += amountPaid;
    }

    public double[] getMonthlyRent() {
        return monthlyRent;
    }

    public double getYearlyRent(){
        int sum = 0;
        for (double rent : monthlyRent) {
            sum += rent;
        }
        return sum;
    }

    @Override
    public String toString() {
        String s = "";
        for(Double rent : monthlyRent){
            s += String.format("%6.1f ", rent);
        }
        return s;
    }

    public int getAptID(){
        return aptID;
    }

    public void setAptID(int id){
        this.aptID = id;
    }

}
