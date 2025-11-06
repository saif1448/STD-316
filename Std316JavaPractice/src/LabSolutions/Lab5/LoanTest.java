package LabSolutions.Lab5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

/**
 * JUnit 5 Test Class for the Loan class.
 * Tests are executed in order of method names (test01_, test02_, etc.)
 * Each method of the Loan class has at least 7 test cases.
 * 
 * @author DR. SUKHWANT KAUR SAGAR
 * @version 1.0
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class LoanTest {
    
    private static final double DELTA = 0.2; // Tolerance for double comparisons
    
    // ========================================================================
    // TEST CASES FOR DEFAULT CONSTRUCTOR 
    // ========================================================================
    
    @Test
    @DisplayName("Test 01: Default Constructor - Annual Interest Rate")
    public void test01_defaultConstructor_annualInterestRate() {
        Loan loan = new Loan();
        assertEquals(2.5, loan.getAnnualInterestRate(), DELTA, 
                     "Default annual interest rate should be 2.5");
    }
           
    @Test
    @DisplayName("Test 05: Default Constructor - Monthly Payment")
    public void test05_defaultConstructor_monthlyPayment() {
        Loan loan = new Loan();
        assertEquals(84.47, loan.getMonthlyPayment(), DELTA, 
                     "Default monthly payment should be approximately 84.47");
    }
    
    @Test
    @DisplayName("Test 06: Default Constructor - Total Payment")
    public void test06_defaultConstructor_totalPayment() {
        Loan loan = new Loan();
        assertEquals(1013.64, loan.getTotalPayment(), DELTA, 
                     "Default total payment should be approximately 1013.64");
    }
        
    // ========================================================================
    // TEST CASES FOR PARAMETERIZED CONSTRUCTOR
    // ========================================================================
    
    @Test
    @DisplayName("Test 08: Parameterized Constructor - Valid Values")
    public void test08_parameterizedConstructor_validValues() {
        Loan loan = new Loan(5.0, 10, 10000);
        assertEquals(5.0, loan.getAnnualInterestRate(), DELTA);
        assertEquals(10, loan.getNumberOfYears());
        assertEquals(10000, loan.getLoanAmount(), DELTA);
    }
    
    @Test
    @DisplayName("Test 11: Parameterized Constructor - One Year")
    public void test11_parameterizedConstructor_oneYear() {
        Loan loan = new Loan(4.5, 1, 12000);
        assertEquals(4.5, loan.getAnnualInterestRate(), DELTA);
        assertEquals(1, loan.getNumberOfYears());
        assertEquals(12000, loan.getLoanAmount(), DELTA);
    }
           
    @Test
    @DisplayName("Test 14: Parameterized Constructor - Large Amount")
    public void test14_parameterizedConstructor_largeAmount() {
        Loan loan = new Loan(4.0, 25, 500000);
        assertEquals(4.0, loan.getAnnualInterestRate(), DELTA);
        assertEquals(25, loan.getNumberOfYears());
        assertEquals(500000, loan.getLoanAmount(), DELTA);
    }
    
    // ========================================================================
    // TEST CASES FOR getAnnualInterestRate() 
    // ========================================================================
          
    @Test
    @DisplayName("Test 19: getAnnualInterestRate - Zero Rate")
    public void test19_getAnnualInterestRate_zeroRate() {
        Loan loan = new Loan(0, 10, 10000);
        assertEquals(0, loan.getAnnualInterestRate(), DELTA);
    }
    
    @Test
    @DisplayName("Test 20: getAnnualInterestRate - Decimal Rate")
    public void test20_getAnnualInterestRate_decimalRate() {
        Loan loan = new Loan(3.75, 10, 10000);
        assertEquals(3.75, loan.getAnnualInterestRate(), DELTA);
    }
    
    @Test
    @DisplayName("Test 21: getAnnualInterestRate - After Setter")
    public void test21_getAnnualInterestRate_afterSetter() {
        Loan loan = new Loan();
        loan.setAnnualInterestRate(8.5);
        assertEquals(8.5, loan.getAnnualInterestRate(), DELTA);
    }
    
    // ========================================================================
    // TEST CASES FOR getNumberOfYears() 
    // ========================================================================
    
    @Test
    @DisplayName("Test 22: getNumberOfYears - Default Constructor")
    public void test22_getNumberOfYears_defaultConstructor() {
        Loan loan = new Loan();
        assertEquals(1, loan.getNumberOfYears());
    }
    
    @Test
    @DisplayName("Test 23: getNumberOfYears - One Year")
    public void test23_getNumberOfYears_oneYear() {
        Loan loan = new Loan(5.0, 1, 10000);
        assertEquals(1, loan.getNumberOfYears());
    }
       
    @Test
    @DisplayName("Test 27: getNumberOfYears - Ten Years")
    public void test27_getNumberOfYears_tenYears() {
        Loan loan = new Loan(5.0, 10, 10000);
        assertEquals(10, loan.getNumberOfYears());
    }
            
    // ========================================================================
    // TEST CASES FOR getLoanAmount() 
    // ========================================================================
    
    @Test
    @DisplayName("Test 29: getLoanAmount - Default Constructor")
    public void test29_getLoanAmount_defaultConstructor() {
        Loan loan = new Loan();
        assertEquals(1000.0, loan.getLoanAmount(), DELTA);
    }
    
    @Test
    @DisplayName("Test 30: getLoanAmount - Small Amount")
    public void test30_getLoanAmount_smallAmount() {
        Loan loan = new Loan(5.0, 10, 5000);
        assertEquals(5000, loan.getLoanAmount(), DELTA);
    }
    
      
    @Test
    @DisplayName("Test 35: getLoanAmount - After Setter")
    public void test35_getLoanAmount_afterSetter() {
        Loan loan = new Loan();
        loan.setLoanAmount(75000);
        assertEquals(75000, loan.getLoanAmount(), DELTA);
    }
    
    // ========================================================================
    // TEST CASES FOR getLoanDate() 
    // ========================================================================
    
    @Test
    @DisplayName("Test 36: getLoanDate - Not Null Default")
    public void test36_getLoanDate_notNullDefault() {
        Loan loan = new Loan();
        assertNotNull(loan.getLoanDate());
    }
       
    @Test
    @DisplayName("Test 39: getLoanDate - Recent Date Default")
    public void test39_getLoanDate_recentDateDefault() {
        Date before = new Date();
        Loan loan = new Loan();
        Date after = new Date();
        
        assertTrue(loan.getLoanDate().getTime() >= before.getTime() &&
                   loan.getLoanDate().getTime() <= after.getTime());
    }
    
    @Test
    @DisplayName("Test 40: getLoanDate - Recent Date Parameterized")
    public void test40_getLoanDate_recentDateParameterized() {
        Date before = new Date();
        Loan loan = new Loan(5.0, 10, 10000);
        Date after = new Date();
        
        assertTrue(loan.getLoanDate().getTime() >= before.getTime() &&
                   loan.getLoanDate().getTime() <= after.getTime());
    }
    
    
    
    // ========================================================================
    // TEST CASES FOR setAnnualInterestRate() 
    // ========================================================================
    
    @Test
    @DisplayName("Test 43: setAnnualInterestRate - Low Rate")
    public void test43_setAnnualInterestRate_lowRate() {
        Loan loan = new Loan();
        loan.setAnnualInterestRate(1.5);
        assertEquals(1.5, loan.getAnnualInterestRate(), DELTA);
    }
      
    
    @Test
    @DisplayName("Test 47: setAnnualInterestRate - Decimal Rate")
    public void test47_setAnnualInterestRate_decimalRate() {
        Loan loan = new Loan();
        loan.setAnnualInterestRate(4.75);
        assertEquals(4.75, loan.getAnnualInterestRate(), DELTA);
    }
    
    @Test
    @DisplayName("Test 48: setAnnualInterestRate - Multiple Changes")
    public void test48_setAnnualInterestRate_multipleChanges() {
        Loan loan = new Loan();
        loan.setAnnualInterestRate(5.0);
        assertEquals(5.0, loan.getAnnualInterestRate(), DELTA);
        loan.setAnnualInterestRate(7.5);
        assertEquals(7.5, loan.getAnnualInterestRate(), DELTA);
        loan.setAnnualInterestRate(3.0);
        assertEquals(3.0, loan.getAnnualInterestRate(), DELTA);
    }
      
    
    // ========================================================================
    // TEST CASES FOR setNumberOfYears() 
    // ========================================================================
    
    @Test
    @DisplayName("Test 50: setNumberOfYears - One Year")
    public void test50_setNumberOfYears_oneYear() {
        Loan loan = new Loan();
        loan.setNumberOfYears(1);
        assertEquals(1, loan.getNumberOfYears());
    }
        
    @Test
    @DisplayName("Test 54: setNumberOfYears - Two Years")
    public void test54_setNumberOfYears_twoYears() {
        Loan loan = new Loan();
        loan.setNumberOfYears(2);
        assertEquals(2, loan.getNumberOfYears());
    }
    
    @Test
    @DisplayName("Test 55: setNumberOfYears - Multiple Changes")
    public void test55_setNumberOfYears_multipleChanges() {
        Loan loan = new Loan();
        loan.setNumberOfYears(5);
        assertEquals(5, loan.getNumberOfYears());
        loan.setNumberOfYears(10);
        assertEquals(10, loan.getNumberOfYears());
        loan.setNumberOfYears(15);
        assertEquals(15, loan.getNumberOfYears());
    }
           
    // ========================================================================
    // TEST CASES FOR setLoanAmount() 
    // ========================================================================
    
    @Test
    @DisplayName("Test 57: setLoanAmount - Small Amount")
    public void test57_setLoanAmount_smallAmount() {
        Loan loan = new Loan();
        loan.setLoanAmount(5000);
        assertEquals(5000, loan.getLoanAmount(), DELTA);
    }
        
    @Test
    @DisplayName("Test 60: setLoanAmount - Decimal Amount")
    public void test60_setLoanAmount_decimalAmount() {
        Loan loan = new Loan();
        loan.setLoanAmount(12345.67);
        assertEquals(12345.67, loan.getLoanAmount(), DELTA);
    }
    
    @Test
    @DisplayName("Test 61: setLoanAmount - Very Large Amount")
    public void test61_setLoanAmount_veryLargeAmount() {
        Loan loan = new Loan();
        loan.setLoanAmount(1000000);
        assertEquals(1000000, loan.getLoanAmount(), DELTA);
    }
           
    // ========================================================================
    // TEST CASES FOR getMonthlyPayment() 
    // ========================================================================
    
    @Test
    @DisplayName("Test 64: getMonthlyPayment - Default Constructor")
    public void test64_getMonthlyPayment_defaultConstructor() {
        Loan loan = new Loan();
        assertEquals(84.47, loan.getMonthlyPayment(), DELTA);
    }
            
    @Test
    @DisplayName("Test 68: getMonthlyPayment - Low Interest Rate")
    public void test68_getMonthlyPayment_lowInterestRate() {
        Loan loan = new Loan(2.0, 10, 15000);
        assertEquals(138.02, loan.getMonthlyPayment(), DELTA);
    }
    
    @Test
    @DisplayName("Test 69: getMonthlyPayment - One Year Loan")
    public void test69_getMonthlyPayment_oneYearLoan() {
        Loan loan = new Loan(5.0, 1, 12000);
        assertEquals(1027.29, loan.getMonthlyPayment(), DELTA);
    }
    
    
    // ========================================================================
    // TEST CASES FOR getTotalPayment() 
    // ========================================================================
    
    @Test
    @DisplayName("Test 74: getTotalPayment - Default Constructor")
    public void test74_getTotalPayment_defaultConstructor() {
        Loan loan = new Loan();
        assertEquals(1013.64, loan.getTotalPayment(), DELTA);
    }
    
    @Test
    @DisplayName("Test 75: getTotalPayment - Zero Interest Rate")
    public void test75_getTotalPayment_zeroInterestRate() {
        Loan loan = new Loan(0, 5, 10000);
        assertEquals(10000.2, loan.getTotalPayment(), DELTA);
    }
    
    @Test
    @DisplayName("Test 76: getTotalPayment - Standard Mortgage")
    public void test76_getTotalPayment_standardMortgage() {
        Loan loan = new Loan(4.5, 30, 250000);
        assertEquals(456015.6, loan.getTotalPayment(), DELTA);
    }
    
    @Test
    @DisplayName("Test 77: getTotalPayment - High Interest Rate")
    public void test77_getTotalPayment_highInterestRate() {
        Loan loan = new Loan(12.0, 2, 5000);
        assertEquals(5648.88, loan.getTotalPayment(), DELTA);
    }
    
        
    // ========================================================================
    // INTEGRATION TESTS
    // ========================================================================
    
    @Test
    @DisplayName("Test 84: Integration - All Setters Work Together")
    public void test84_integration_allSettersWorkTogether() {
        Loan loan = new Loan();
        loan.setAnnualInterestRate(6.0);
        loan.setNumberOfYears(15);
        loan.setLoanAmount(50000);
        
        assertEquals(6.0, loan.getAnnualInterestRate(), DELTA);
        assertEquals(15, loan.getNumberOfYears());
        assertEquals(50000, loan.getLoanAmount(), DELTA);
        assertEquals(421.93, loan.getMonthlyPayment(), DELTA);
        assertEquals(75947.40, loan.getTotalPayment(), DELTA);
    }
    
    @Test
    @DisplayName("Test 85: Integration - Total Greater Than Loan Amount")
    public void test85_integration_totalGreaterThanLoanAmount() {
        Loan loan = new Loan(5.0, 10, 10000);
        assertTrue(loan.getTotalPayment() > loan.getLoanAmount(),
                   "Total payment should be greater than loan amount when interest > 0");
    }
    
       
    // ========================================================================
    // TEST CASES FOR getTotalInterest() 
    // ========================================================================
    
    @Test
    @DisplayName("Test 91: getTotalInterest - Default Constructor")
    public void test91_getTotalInterest_defaultConstructor() {
        Loan loan = new Loan();
        double expectedInterest = loan.getTotalPayment() - loan.getLoanAmount();
        assertEquals(expectedInterest, loan.getTotalInterest(), DELTA);
    }
    
    @Test
    @DisplayName("Test 92: getTotalInterest - Zero Interest Rate")
    public void test92_getTotalInterest_zeroInterestRate() {
        Loan loan = new Loan(0, 5, 10000);
        assertEquals(0.0, loan.getTotalInterest(), DELTA,
                     "Zero interest rate should result in zero total interest");
    }       
    
    @Test
    @DisplayName("Test 96: getTotalInterest - Increases with Rate")
    public void test96_getTotalInterest_increasesWithRate() {
        Loan loan1 = new Loan(3.0, 10, 10000);
        Loan loan2 = new Loan(6.0, 10, 10000);
        
        assertTrue(loan2.getTotalInterest() > loan1.getTotalInterest(),
                   "Higher interest rate should result in more total interest");
    }
    
      
        // ========================================================================
    // TEST CASES FOR getRemainingBalance(int monthsPaid) 
    // ========================================================================
    
    @Test
    @DisplayName("Test 98: getRemainingBalance - Zero Months Paid")
    public void test98_getRemainingBalance_zeroMonthsPaid() {
        Loan loan = new Loan(5.0, 10, 10000);
        assertEquals(10000, loan.getRemainingBalance(0), DELTA,
                     "Zero months paid should return full loan amount");
    }
    
    @Test
    @DisplayName("Test 99: getRemainingBalance - All Months Paid")
    public void test99_getRemainingBalance_allMonthsPaid() {
        Loan loan = new Loan(5.0, 10, 10000);
        assertEquals(0.0, loan.getRemainingBalance(120), DELTA,
                     "All months paid should return zero balance");
    }
    
    @Test
    @DisplayName("Test 100: getRemainingBalance - Half Months Paid")
    public void test100_getRemainingBalance_halfMonthsPaid() {
        Loan loan = new Loan(5.0, 10, 10000);
        double remaining = loan.getRemainingBalance(60);
        
        assertTrue(remaining > 0 && remaining < 10000,
                   "Half months paid should have balance between 0 and loan amount");
    }
    
   
    // ========================================================================
    // TEST CASES FOR isAffordable(double monthlyIncome) 
    // ========================================================================
    
    @Test
    @DisplayName("Test 105: isAffordable - Affordable Loan")
    public void test105_isAffordable_affordableLoan() {
        Loan loan = new Loan(5.0, 10, 10000); // Monthly payment ~$106
        assertTrue(loan.isAffordable(5000),
                   "Loan with $106 payment should be affordable on $5000/month income");
    }
    
    @Test
    @DisplayName("Test 106: isAffordable - Not Affordable Loan")
    public void test106_isAffordable_notAffordableLoan() {
        Loan loan = new Loan(5.0, 10, 10000); // Monthly payment ~$106
        assertFalse(loan.isAffordable(300),
                    "Loan with $106 payment should not be affordable on $300/month income");
    }
        
    
    @Test
    @DisplayName("Test 111: isAffordable - Different Incomes Different Results")
    public void test111_isAffordable_differentIncomesResults() {
        Loan loan = new Loan(5.0, 10, 10000);
        
        boolean affordableHigh = loan.isAffordable(10000);
        boolean affordableLow = loan.isAffordable(100);
        
        assertTrue(affordableHigh && !affordableLow,
                   "Same loan should be affordable on high income but not on low income");
    }
                
}
