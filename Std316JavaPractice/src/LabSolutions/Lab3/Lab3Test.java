package LabSolutions.Lab3;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 * Comprehensive test suite for Lab3 loop programming methods.
 * Tests are organized by method and executed in alphabetical order.
 * Each method has at least 10 test cases covering various scenarios.
 * 
 * @author Dr. Sukhwant Kaur Sagar
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Lab3Test {

    // ========== TEST CASES FOR getSeqStat() METHOD ==========
    
    @Test
    public void test01_getSeqStat_basicExample1() {
        String expected = "{[<10>: 10, 10]; [<10, 15>: 25, 150]}";
        assertEquals("Basic example with firstTerm=10, difference=5, size=2", expected, Lab3.getSeqStat(10, 5, 2));
    }
      
    @Test
    public void test04_getSeqStat_negativeDifference() {
        String expected = "{[<20>: 20, 20]; [<20, 15>: 35, 300]; [<20, 15, 10>: 45, 3000]}";
        assertEquals("Sequence with negative difference", expected, Lab3.getSeqStat(20, -5, 3));
    }
    
    @Test
    public void test05_getSeqStat_negativeFirstTerm() {
        String expected = "{[<-3>: -3, -3]; [<-3, 1>: -2, -3]}";
        assertEquals("Sequence starting with negative number", expected, Lab3.getSeqStat(-3, 4, 2));
    }
   
    // ========== TEST CASES FOR seqInterleaving() METHOD ==========
    
    @Test
    public void test14_seqInterleaving_firstLonger() {
        String expected = "<1, 100, 4, 200, 7, 10>";
        assertEquals("First sequence longer", expected, Lab3.seqInterleaving(1, 3, 4, 100, 100, 2));
    }
    
    @Test
    public void test15_seqInterleaving_secondLonger() {
        String expected = "<5, 1, 3, 5>";
        assertEquals("Second sequence longer", expected, Lab3.seqInterleaving(5, 10, 1, 1, 2, 3));
    }
   
    @Test
    public void test20_seqInterleaving_invalidSecondSize() {
        assertEquals("Invalid second sequence size", "Invalid", Lab3.seqInterleaving(1, 2, 3, 5, 3, -1));
    }

    // ========== TEST CASES FOR analyzeNumberProperties() METHOD ==========
    
    @Test
    public void test22_numberProperties_palindromeFalse() {
        assertEquals("123 should not be palindrome", "false", Lab3.analyzeNumberProperties(123, "palindrome"));
    }
    
    @Test
    public void test24_numberProperties_armstrongFalse() {
        assertEquals("123 should not be Armstrong number", "false", Lab3.analyzeNumberProperties(123, "armstrong"));
    }
    
    @Test
    public void test25_numberProperties_divisorsCount() {
        assertEquals("12 should have 6 divisors", "6", Lab3.analyzeNumberProperties(12, "divisors"));
    }
         
    @Test
    public void test27_numberProperties_digitSum() {
        assertEquals("9875 digital root should be 2", "2", Lab3.analyzeNumberProperties(9875, "digitSum"));
    }
          
    @Test
    public void test29_numberProperties_evenOdd() {
        assertEquals("546345922 should have even: 2, odd: 3", "even: 5, odd: 4", Lab3.analyzeNumberProperties(546345922, "evenOdd"));
    }
        
    @Test
    public void test34_numberProperties_invalidNumber() {
        assertEquals("Invalid number should return Invalid", "Invalid", Lab3.analyzeNumberProperties(-90, "evenOdd"));
    }
}