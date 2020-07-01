/**
 * When a tenant is created, a RentPayment object is also created using the RentPayment class
 */
public class RentPayment {
    //Member variables
    private int aptID;
    private double[] monthlyRent;

    /**
     * Constructor
     */
    public RentPayment(){
        monthlyRent = new double[12];
    }

    /**
     * Fills in the array using amountPaid as the element
     * and monthPaid as the index of the array
     * @param amountPaid
     * @param monthPaid
     */
    public void addPayment(double amountPaid, int monthPaid){
        monthlyRent[monthPaid] += amountPaid;
    }

    /**
     * Accessor for monthlyRent array
     * @return monthlyRent
     */
    public double[] getMonthlyRent() {
        return monthlyRent;
    }

    /**
     * Sums up the elements in the array to return the
     * total rent payments for the year
     * @return sum
     */
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

    /**
     * Accessor for aptID
     * @return aptID
     */
    public int getAptID(){
        return aptID;
    }

    /**
     * Mutator for aptID
     * @param id
     */
    public void setAptID(int id){
        this.aptID = id;
    }
}
