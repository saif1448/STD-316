package LabSolutions.Lab2;
/**
* Lab2Test.java 
* Test file for code implementations using ONLY conditionals
* NO loops, NO recursion,allowed
* @author Sukhwant Sagar
* @since Fall 2025
*/
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

@TestMethodOrder(MethodOrderer.MethodName.class)

/**
* Comprehensive test suite for Lab2 conditional methods.
* Tests are organized by method and executed in alphabetical order.
* Includes edge cases, boundary values, and various scenarios.
* 
*/
public class Lab2Test {

   private static final double DELTA = 0.01; // For double comparisons

   // ========== TEST CASES FOR calculateBMI() METHOD ==========
   
   @Test
   public void test01_bmi_normalWeight() {
       assertEquals("BMI for 70kg, 1.75m should be 22.86", 22.86, Lab2.calculateBMI(70, 1.75), DELTA);
   }
        
   @Test
   public void test05_bmi_zeroWeight() {
       assertEquals("BMI for zero weight should be -1.0", -1.0, Lab2.calculateBMI(0, 1.75), DELTA);
   }
   
   @Test
   public void test06_bmi_negativeHeight() {
       assertEquals("BMI for negative height should be -1.0", -1.0, Lab2.calculateBMI(70, -1.75), DELTA);
   }
   
   @Test
   public void test08_bmi_perfectSquare() {
       assertEquals("BMI for 64kg, 1.60m should be 25.00", 25.00, Lab2.calculateBMI(64, 1.60), DELTA);
   }

   // ========== TEST CASES FOR seasonDeterminer() METHOD ==========
   
  @Test
   public void test11_season_springEnd() {
       assertEquals("June 20 should be Spring", "Spring", Lab2.seasonDeterminer(6, 20));
   }
   
   @Test
   public void test12_season_summerStart() {
       assertEquals("June 21 should be Summer", "Summer", Lab2.seasonDeterminer(6, 21));
   }
   
   @Test
   public void test16_season_fallMiddle() {
       assertEquals("November 15 should be Fall", "Fall", Lab2.seasonDeterminer(11, 15));
   }
      
   @Test
   public void test22_season_invalidDay() {
       assertEquals("Day 32 should be Invalid Date", "Invalid Date", Lab2.seasonDeterminer(6, 32));
   }
      
   // ========== TEST CASES FOR parkingFeeCalculator() METHOD ==========
   
   @Test
   public void test24_parking_oneHour() {
       assertEquals("1 hour parking should cost $3.00", 3.0, Lab2.parkingFeeCalculator(1), DELTA);
   }
      
   @Test
   public void test26_parking_threeHours() {
       assertEquals("3 hours parking should cost $8.50", 8.5, Lab2.parkingFeeCalculator(3), DELTA);
   }
   
      @Test
   public void test29_parking_tenHours() {
       assertEquals("10 hours parking should cost $24.00", 24.0, Lab2.parkingFeeCalculator(10), DELTA);
   }
   
   @Test
   public void test30_parking_fifteenHours() {
       assertEquals("15 hours parking should hit $25.00 cap", 25.0, Lab2.parkingFeeCalculator(15), DELTA);
   }        
   
   // ========== TEST CASES FOR triangleClassifier() METHOD ==========
   
   @Test
   public void test34_triangle_equilateral() {
       assertEquals("Triangle (5,5,5) should be Equilateral", "Equilateral", Lab2.triangleClassifier(5, 5, 5));
   }
   
   @Test
   public void test37_triangle_invalidInequality() {
       assertEquals("Triangle (1,1,3) should be Not a Triangle", "Not a Triangle", Lab2.triangleClassifier(1, 1, 3));
   }
   
   @Test
   public void test39_triangle_negativeSide() {
       assertEquals("Triangle (-2,3,4) should be Invalid Input", "Invalid Input", Lab2.triangleClassifier(-2, 3, 4));
   }
   
   @Test
   public void test42_triangle_isoscelesVariant() {
       assertEquals("Triangle (7,3,7) should be Isosceles", "Isosceles", Lab2.triangleClassifier(7, 3, 7));
   }

   // ========== TEST CASES FOR calculateAutoInsurance() METHOD ==========
   
   @Test
   public void test44_auto_middleAgedFemaleSedan() {
       // 45, Female, 10 years exp, 0 accidents, Sedan, Standard coverage
       // Base: 1200, no surcharges, Sedan: 1.0x, Standard: 1.0x
       assertEquals("Middle-aged experienced female", 1200.0, Lab2.calculateAutoInsurance(45, "Female", 10, 0, "Sedan", "Standard"), DELTA);
   }
   
   @Test
   public void test45_auto_seniorCompactBasic() {
       // 65, Female, 20 years exp, 0 accidents, Compact, Basic
       // Base: 1000, Compact: 0.9x, Basic: 0.8x
       double expected = 1000 * 0.9 * 0.8;
       assertEquals("Senior with compact car", expected, Lab2.calculateAutoInsurance(65, "Female", 20, 0, "Compact", "Basic"), DELTA);
   }
   
   @Test
   public void test47_auto_luxuryCar() {
       // 40, Female, 15, 0, Luxury, Standard
       // Base: 1200, Luxury: 1.3x, Standard: 1.0x
       double expected = 1200 * 1.3 * 1.0;
       assertEquals("Luxury car premium", expected, Lab2.calculateAutoInsurance(40, "Female", 15, 0, "Luxury", "Standard"), DELTA);
   }
         
   @Test
   public void test52_auto_invalidCoverageLevel() {
       assertEquals("Invalid coverage level should return -1", -1.0, Lab2.calculateAutoInsurance(30, "Male", 5, 0, "Sedan", "Super"), DELTA);
   }
      
   @Test
   public void test55_auto_borderlineAge() {
       // Test age boundary: 24 vs 25
       double premium24 = Lab2.calculateAutoInsurance(24, "Female", 5, 0, "Sedan", "Standard");
       double premium25 = Lab2.calculateAutoInsurance(25, "Female", 5, 0, "Sedan", "Standard");
       assertTrue("24-year-old should have higher premium than 25-year-old", premium24 > premium25);
   }
}