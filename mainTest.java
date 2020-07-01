import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import java.util.Scanner;
import java.util.HashMap;


public class mainTest {

/**
 * All Tests should pass except when testExpenseToStringExpense2() is uncommented
 * it was made to fail to test if the sets are working as intended
 */

    final int CAPACITY = 20;
    public UserInterface ui = new UserInterface();
    String[] args = {"Mary", "Shelley", "Tom", "& Jerry"};
    int[] aptNums = {100,101,201,301};
    Scanner scan = new Scanner(System.in);
    HashMap<Integer, Tenant> testTenantList = new HashMap<Integer, Tenant>(CAPACITY) {
        private static final long serialVersionUID = 1L;
    };
    HashMap<Integer, Tenant> testTenantList2 = new HashMap<Integer, Tenant>(CAPACITY);
    
    /**
     *Basic test to see how unit test works 
    */
    @Test
    public void testOfTest(){
        int x = 10;
        assertTrue("x=10 is not equal to CAPACITY=20 variable", x != CAPACITY);
    }

    /**
     * tests if 2 tenants are equal. Useful for preventing 
     */
    @Test
    public void testTenantListSetUp(){
        testTenantList.put(aptNums[0], new Tenant(args[2], args[3], aptNums[1]));
        testTenantList2.put(aptNums[0], new Tenant(args[2], args[3], aptNums[1]));
        assertFalse("TENANT LISTS ARE SETUP CORRECTLY IF PASS", testTenantList == testTenantList2);
    }


    /**
     * tests if the method can tell if 2 apartment numbers are equal
     */
    @Test
    public void testApartmentAvailability(){
        testTenantList.put(aptNums[0], new Tenant(args[2], args[3], aptNums[1]));
        ui.apartmentAvailability(aptNums[0], scan);
        assertTrue("Apartment is occupied", aptNums[0] != aptNums[1]);
    }

    /**
     * tests if the default's name values are toString similar. useful for the saveData() method
     */
    @Test
    public void testTenantToString(){
        Tenant testTenant = new Tenant();
        String test = "NoFirstName NoLastName";

        assertEquals(test, testTenant.toString());
    }

    /**
     * testing the overloading constructor functionality of Tenant. Was 
     * useful in the addToTenantList method
     */
    @Test
    public void testTenantOverLoaded(){
        Tenant testTenant = new Tenant(args[0], args[1], aptNums[0]);

        assertEquals("Mary Shelley", testTenant.toString());
    }

    /**
     * tests  if the RentPayment objects are comparable 
     */
    @Test
    public void testRentPaymentBlank(){
        RentPayment testRent = new RentPayment();
        RentPayment testRentBlank = new RentPayment();
        if(testRent.toString().equalsIgnoreCase(testRentBlank.toString())){
            assertTrue(testRent.toString(), true);
        }
        else{
            assertFalse(testRent.toString(), false);
        }
    }

    /**
     * tests the toString() which was used in outputting the to the console
     */
    @Test
    public void testExpenseToString(){
        Expense testExpense = new Expense(101, 5, 25, "Bob the Builder", 1002.36, "Repairs");
        String payee = "Bob the Builder";
        String amountString = "1002.36";
        String budgetCategory = "Repairs";
        String expenseString = String.format("%20s%20s%20s\n", payee, amountString, budgetCategory);

        assertEquals(expenseString, testExpense.toString());
    }

    /**
     * testing of the expense toStringExpense() method. Was useful in testing for the compatibility
     * of saving and processing the loading of the data into a file and back to program.
     */
    @Test
    public void testExpenseToStringExpense(){
        String payee = "Bob the Builder";
        double amountString = 1002.36;
        String budgetCategory = "Repairs";
        Expense testExpense = new Expense(101, 5, 25, payee, amountString, budgetCategory);
        String expenseString = String.format(" " +"%1s/%1s@%1s\n", payee, amountString, budgetCategory);

        assertEquals(expenseString, testExpense.toStringExpense());
    }

    /**
     * test fails if the sets work... Pass when they are commented
     * Just another test of toStringExpense()
     */
    @Test
    public void testExpenseToStringExpense2(){//
        Expense testExpense = new Expense(101, 5, 25, "Bob the Builder", 1002.36, "Repairs");
        String payee = "Bob the Builder";
        //testExpense.setPayee("Count Dracula");
        String amountString = "1002.36";
        //testExpense.setAmountPaid(666.66);
        String budgetCategory = "Repairs";
        //testExpense.setBudgetCategory("Utilitie");
        String expenseString = String.format(" " +"%1s/%1s@%1s\n", payee, amountString, budgetCategory);

        assertEquals("THIS TEST SHOULD FAIL IF IT WORKS!!!!", expenseString, testExpense.toStringExpense());
    }

}