package LabSolutions.Lab3;

public class TestNumberProperties {
    public static void main(String[] args) {
        System.out.println("Testing Lab3.analyzeNumberProperties method:");
        System.out.println("===========================================");
        
        // Test cases from Lab3Test.java
        
        // Test 1: palindrome false
        String result1 = Lab3.analyzeNumberProperties(123, "palindrome");
        System.out.println("Test 1 - 123 palindrome: " + result1 + " (expected: false) " + 
                          (result1.equals("false") ? "✓ PASS" : "✗ FAIL"));
        
        // Test 2: armstrong false  
        String result2 = Lab3.analyzeNumberProperties(123, "armstrong");
        System.out.println("Test 2 - 123 armstrong: " + result2 + " (expected: false) " + 
                          (result2.equals("false") ? "✓ PASS" : "✗ FAIL"));
        
        // Test 3: divisors count
        String result3 = Lab3.analyzeNumberProperties(12, "divisors");
        System.out.println("Test 3 - 12 divisors: " + result3 + " (expected: 6) " + 
                          (result3.equals("6") ? "✓ PASS" : "✗ FAIL"));
        
        // Test 4: digital root
        String result4 = Lab3.analyzeNumberProperties(9875, "digitSum");
        System.out.println("Test 4 - 9875 digitSum: " + result4 + " (expected: 2) " + 
                          (result4.equals("2") ? "✓ PASS" : "✗ FAIL"));
        
        // Test 5: even/odd count
        String result5 = Lab3.analyzeNumberProperties(546345922, "evenOdd");
        String expected5 = "even: 5, odd: 4";
        System.out.println("Test 5 - 546345922 evenOdd: " + result5 + " (expected: " + expected5 + ") " + 
                          (result5.equals(expected5) ? "✓ PASS" : "✗ FAIL"));
        
        // Test 6: invalid number
        String result6 = Lab3.analyzeNumberProperties(-90, "evenOdd");
        System.out.println("Test 6 - -90 evenOdd: " + result6 + " (expected: Invalid) " + 
                          (result6.equals("Invalid") ? "✓ PASS" : "✗ FAIL"));
        
        // Additional tests
        System.out.println("\nAdditional verification tests:");
        System.out.println("==============================");
        
        // Test palindrome true
        String resultP = Lab3.analyzeNumberProperties(121, "palindrome");
        System.out.println("121 palindrome: " + resultP + " (expected: true) " + 
                          (resultP.equals("true") ? "✓ PASS" : "✗ FAIL"));
        
        // Test armstrong true (153 = 1³ + 5³ + 3³ = 1 + 125 + 27 = 153)
        String resultA = Lab3.analyzeNumberProperties(153, "armstrong");
        System.out.println("153 armstrong: " + resultA + " (expected: true) " + 
                          (resultA.equals("true") ? "✓ PASS" : "✗ FAIL"));
    }
}