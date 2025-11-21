public class Test {
    public static void main(String[] args) {

        // DataType objectName = new DataType();

        Loan loan1 = new Loan();

        Loan loan2 = new Loan(.78, 5, 10000);



        System.out.println(loan2.getLoanAmount());

        loan2.setLoanAmount(500000);

        System.out.println(loan2.getLoanAmount());

    }
}
