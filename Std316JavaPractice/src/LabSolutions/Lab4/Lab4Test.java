package LabSolutions.Lab4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class Lab4Test {

    // ===== Task 1: longestDecreasingSeq Tests =====
    
    @Test
    public void test01_longestDecreasingSeq_normalCase() {
        int[] arr = {15, 10, 9, 8, 5, 12, 7, 6};
        assertEquals(5, Lab4.longestDecreasingSeq(arr));
    }
    
    @Test
    public void test02_longestDecreasingSeq_noSequence() {
        int[] arr = {1, 5, 9, 12, 15};
        assertEquals(1, Lab4.longestDecreasingSeq(arr));
    }
    
    @Test
    public void test03_longestDecreasingSeq_emptyArray() {
        int[] arr = {};
        assertEquals(0, Lab4.longestDecreasingSeq(arr));
    }
          
    @Test
    public void test06_longestDecreasingSeq_multipleSequences() {
        int[] arr = {10, 9, 8, 5, 15, 14, 13, 12, 11};
        assertEquals(5, Lab4.longestDecreasingSeq(arr));
    }
            
    // ===== Task 2: frequencyArray Tests =====
    
    @Test
    public void test16_frequencyArray_normalCase() {
        int[] arr = {3, 15, 15, 49, 8, 72};
        String expected = "3: 1\n15: 2\n49: 1";
        assertEquals(expected, Lab4.frequencyArray(arr));
    }
    
    @Test
    public void test17_frequencyArray_multipleCounts() {
        int[] arr = {7, 11, 7, 7, 23, 40};
        String expected = "7: 3\n11: 1\n23: 1";
        assertEquals(expected, Lab4.frequencyArray(arr));
    }
    
    @Test
    public void test18_frequencyArray_emptyArray() {
        int[] arr = {};
        assertEquals("", Lab4.frequencyArray(arr));
    }
    
    @Test
    public void test27_frequencyArray_mixedValidInvalid() {
        int[] arr = {1, 2, 3, 50, 51, 49, 100, -5};
        String expected = "1: 1\n3: 1\n49: 1";
        assertEquals(expected, Lab4.frequencyArray(arr));
    }
    
       
    // ===== Task 3: canFormString Tests =====
          
    @Test
    public void test34_canFormString_emptyTarget() {
        assertTrue(Lab4.canFormString("hello", ""));
    }
    
    @Test
    public void test35_canFormString_emptySource() {
        assertFalse(Lab4.canFormString("", "hello"));
    }
    
           @Test
    public void test39_canFormString_bothEmpty() {
        assertTrue(Lab4.canFormString("", ""));
    }
        
    
    @Test
    public void test45_canFormString_complexValid() {
        assertTrue(Lab4.canFormString("heeaalolo", "hello"));
    }
    
    // ===== Task 4: matrixOperation Tests =====
    
    @Test
    public void test46_matrixOperation_normalCase() {
        int[][] matrix = {{2, 4, 6}, {8, 10, 12}, {14, 16, 18}};
        String expected = "Diagonal Sum:30, Anti-Diagonal Product:840";
        assertEquals(expected, Lab4.matrixOperation(matrix));
    }
    
    @Test
    public void test47_matrixOperation_emptyArray() {
        int[][] matrix = {};
        assertEquals("", Lab4.matrixOperation(matrix));
    }
       
    @Test
    public void test55_matrixOperation_largeNumbers() {
        int[][] matrix = {{100, 200}, {300, 400}};
        String expected = "Diagonal Sum:500, Anti-Diagonal Product:60000";
        assertEquals(expected, Lab4.matrixOperation(matrix));
    }
        
    // ===== Task 5: latinSquare Tests =====
    
    @Test
    public void test61_latinSquare_validCase1() {
        int[][] matrix = {{1, 2, 3}, {2, 3, 1}, {3, 1, 2}};
        assertTrue(Lab4.latinSquare(matrix));
    }
    
    @Test
    public void test62_latinSquare_validCase2() {
        int[][] matrix = {{1, 2, 3}, {3, 1, 2}, {2, 3, 1}};
        assertTrue(Lab4.latinSquare(matrix));
    }
    
    @Test
    public void test63_latinSquare_invalidRepeatedInRow() {
        int[][] matrix = {{1, 1, 3}, {3, 2, 2}, {2, 3, 1}};
        assertFalse(Lab4.latinSquare(matrix));
    }    
   
}