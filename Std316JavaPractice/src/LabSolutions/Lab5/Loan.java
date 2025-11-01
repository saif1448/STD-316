package lab5;

import java.util.Date;

/**
 * The Loan class represents a loan with an annual interest rate, number of years,
 * loan amount, and loan date. It provides methods to calculate monthly and total payments.
 * 
 * @author DR. SUKHWANT KAUR SAGAR
 * @version 1.0
 */
public class Loan {
    // Instance variables
    
    
    /**
     * Default constructor that creates a Loan object with default values:
     * annualInterestRate = 2.5%, numberOfYears = 1, loanAmount = $1000
     */
    
	
    
    /**
     * Parameterized constructor that creates a Loan object with specified values.
     * 
     * @param annualInterestRate the annual interest rate of the loan
     * @param numberOfYears the number of years for the loan
     * @param loanAmount the loan amount
     */
    
	
	
    
    /**
     * Returns the annual interest rate of this loan.
     * 
     * @return the annual interest rate
     */


	
    
    /**
     * Returns the number of years of this loan.
     * 
     * @return the number of years
     */


	
	
    
    /**
     * Returns the amount of this loan.
     * 
     * @return the loan amount
     */


	
    
    /**
     * Returns the date of the creation of this loan.
     * 
     * @return the loan date
     */


	
    /**
     * Sets a new annual interest rate for this loan.
     * 
     * @param annualInterestRate the new annual interest rate
     */


	
    
    /**
     * Sets a new number of years for this loan.
     * 
     * @param numberOfYears the new number of years
     */


	
    
    /**
     * Sets a new amount for this loan.
     * 
     * @param loanAmount the new loan amount
     */


	
    
    /**
     * Calculates and returns the monthly payment for this loan.
     * Formula: monthlyPayment = (loanAmount * monthlyInterestRate) / 
     *          (1 - (1 / (1 + monthlyInterestRate)^numberOfMonths))
     * Special case: If interest rate is 0%, returns loanAmount / numberOfMonths
     * 
     * @return the monthly payment rounded to 2 decimal places
     */


	
	
	
	
	
    
    /**
     * Calculates and returns the total payment for this loan.
     * Formula: totalPayment = monthlyPayment * numberOfYears * 12
     * 
     * @return the total payment rounded to 2 decimal places
     */


	
	
	
	
    
    /**
     * Calculates and returns the total interest paid over the life of the loan.
     * Formula: totalInterest = getTotalPayment() - loanAmount
     * 
     * @return the total interest rounded to 2 decimal places
     */


	
	
	
	
    
    /**
     * Returns a string representation of this loan.
     * Format: Loan[amount=$X.XX, rate=X.X%, years=X, monthly=$X.XX]
     * 
     * @return a formatted string representing this loan
     */
    @Override
    public String toString() {
        return String.format("Loan[amount=$%.2f, rate=%.1f%%, years=%d, monthly=$%.2f]",
                             loanAmount, annualInterestRate, numberOfYears, getMonthlyPayment());
    }
    
    /**
     * Calculates the remaining balance on the loan after a specified number of months.
     * Uses the amortization formula to determine how much principal is left to pay.
     * 
     * @param monthsPaid the number of months already paid
     * @return the remaining balance rounded to 2 decimal places, or 0 if loan is paid off
     */


    
    
    
    
    
    /**
     * Determines if this loan is affordable based on the borrower's monthly income.
     * Uses the 28% rule: monthly payment should not exceed 28% of monthly income.
     * 
     * @param monthlyIncome the borrower's monthly income
     * @return true if the loan is affordable, false otherwise
     */


    
    
    
    
    /**
     * Calculates and returns the date when this loan will be paid off.
     * Adds the number of months (years * 12) to the loan creation date.
     * 
     * @return the payoff date
     */
    public Date getPayoffDate() {
        // Create a calendar instance and set it to the loan date
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(loanDate);
        
        // Add the number of months
        calendar.add(java.util.Calendar.MONTH, numberOfYears * 12);
        
        return calendar.getTime();
    }
    
 }
