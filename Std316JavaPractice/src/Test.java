public class Test {
    public static void main(String[] args) {

        int t1 = 4;
        int d = 6;
        int n = 5;


        int sum = 0;
        int prod = 1;

        String termString = "";
        String finalOutput = "{";

        // t1 + t2 + t3 + t4 ... + tn
        // t1 * t2 * t3 * .... * tn

        for(int i = 1; i <= n; i++){
            int term = t1 + (i-1)*d;
            sum += term;
            prod *= term;

            termString += term + ", ";


            String output = "[<";
            output += termString;
            output += ">: ";
            output += sum + ", " + prod + "]";
            output = output.replace(", >", ">");
            finalOutput += output +"; ";
//            System.out.println(output);
        }

        finalOutput += "}";

        finalOutput = finalOutput.replace("; }", "}");

        System.out.println(finalOutput);

    }
}
