package LabSolutions.Lab3;

/**
 * Lab3: Loop Programming
 * File for code implementations using ONLY loops
 * NO arrays, NO recursion allowed
 * 
 * @author Dr. Sukhwant Kaur Sagar
 * @version 1.0
 * @since Fall 2025
 */
public class Lab3 {
	/**
     * Method 1: Arithmetic Sequence Statistics Generator
     * Generates statistics for subsequences of an arithmetic sequence
     * 
     * @param firstTerm the first term of the sequence
     * @param difference the common difference
     * @param size the size of the sequence
     * @return formatted string with sum and product statistics, or "Invalid" for invalid input
     */
    public static String getSeqStat(int firstTerm, int difference, int size) {
        String output = "{";
        for(int i = 1; i<= size; i++){
            int sum = 0;
            int mult = 1;
            String calculatedString = "[";
            String arrayString = "<";
            String mathString = "";
            int count = 1;
            for(int j = firstTerm; count<=i; j+=difference){
                arrayString+=j+" ";
                sum += j;
                mult *= j;
                count ++;
            }
            arrayString = arrayString.strip();
            if(count > 2){
                arrayString = arrayString.replace(" ", ", ");
            }
            arrayString += ">: ";
            calculatedString = calculatedString + arrayString+ sum + ", " + mult + "] ";
            output += calculatedString;
        }
        output = output.strip().replace("] ", "]; ");

        return output+"}";
    }

    /**
     * Method 2: Sequence Interleaving
     * Interleaves two arithmetic sequences
     * 
     * @param f1 first term of sequence 1
     * @param d1 difference of sequence 1
     * @param n1 size of sequence 1
     * @param f2 first term of sequence 2
     * @param d2 difference of sequence 2
     * @param n2 size of sequence 2
     * @return interleaved sequence as formatted string, or "Invalid" for invalid input
     */
    public static String seqInterleaving(int f1, int d1, int n1, int f2, int d2, int n2) {
        
        if (n1 <= 0 || n2 <= 0) {
            return "Invalid";
        }
        
        String output = "<";
        int term1 = f1;
        int term2 = f2;
        int i = 0, j = 0;

        while (i < n1 && j < n2){
            output += term1 + " ";
            term1 += d1;
            i++;

            output += term2 + " ";
            term2 += d2;
            j++;
        }

        while (i < n1){
            output += term1 + " ";
            term1 += d1;
            i++;
        }

        while (j < n2){
            output += term2 + " ";
            term2 += d2;
            j++;
        }

        output = output.strip().replace(" ", ", ") + ">";

        return output;
    }

    /**
     * Method 3: Number Properties Analyzer
     * Analyzes various mathematical properties of a number
     * 
     * @param number the number to analyze
     * @param property the property to check
     * @return analysis result as string, or "Invalid" for invalid input
     */
    public static String analyzeNumberProperties(int number, String property) {
        // Check for invalid input (negative numbers)
        if (number < 0) {
            return "Invalid";
        }
        
        if (property.equals("palindrome")) {
            
            int original = number;
            int reversed = 0;
            int temp = number;
            
            while (temp > 0) {
                reversed = reversed * 10 + temp % 10;
                temp /= 10;
            }
            
            return (original == reversed) ? "true" : "false";
            
        } else if (property.equals("armstrong")) {
            
            int original = number;
            int numDigits = 0;
            int temp = number;
            
            
            while (temp > 0) {
                numDigits++;
                temp /= 10;
            }
            
            int sum = 0;
            temp = number;
            while (temp > 0) {
                int digit = temp % 10;
                int power = 1;
                for (int i = 0; i < numDigits; i++) {
                    power *= digit;
                }
                sum += power;
                temp /= 10;
            }
            
            return (original == sum) ? "true" : "false";
            
        } else if (property.equals("divisors")) {
            
            if (number == 0) return "0";
            
            int count = 0;
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    count++;
                }
            }
            return String.valueOf(count);
            
        } else if (property.equals("digitSum")) {
            
            int temp = number;
            while (temp >= 10) {
                int sum = 0;
                while (temp > 0) {
                    sum += temp % 10;
                    temp /= 10;
                }
                temp = sum;
            }
            return String.valueOf(temp);
            
        } else if (property.equals("evenOdd")) {
            
            int evenCount = 0;
            int oddCount = 0;
            int temp = number;
            
            while (temp > 0) {
                int digit = temp % 10;
                if (digit % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
                temp /= 10;
            }
            
            return "even: " + evenCount + ", odd: " + oddCount;
            
        } else {
            return "Invalid";
        }
    }
}
