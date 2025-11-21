import java.util.Date;


// Loan() ----> Null Constructor ----> By Default java is giving you

public class Loan {

    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate;

    //null constructor
    public Loan(){
        annualInterestRate = 1.0;
        numberOfYears = 1;
        loanAmount = 2.0;
        loanDate = null;
    }

    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
    }

    // getter / accessors ----> get the attribute value
    public double getLoanAmount(){
        return loanAmount;
    }
    // setters / mutators  -----> set or change the attribute value
    public void setLoanAmount(double loanAmount){
        this.loanAmount = loanAmount;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "annualInterestRate=" + annualInterestRate +
                ", numberOfYears=" + numberOfYears +
                ", loanAmount=" + loanAmount +
                ", loanDate=" + loanDate +
                '}';
    }
}
