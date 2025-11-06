package LabSolutions.Lab2;

/** Lab2: Conditionals
 *  File for code implementations using ONLY conditionals
 * 	NO loops, NO recursion,allowed
 * @author Dr. Sukhwant Kaur Sagar
 * @version - 1.1
 * @since - Fall 2025
 */
public class Lab2 {
    
	/**
     * Method 1: Calculate BMI (Body Mass Index)
     * @param weight in kilograms (double)
     * @param height in meters (double)
     * @return BMI rounded to 2 decimal places, or -1.0 if invalid input
     */
    public static double calculateBMI(double weight, double height) {
        if(weight <= 0 || height <=0){
            return -1;
        }
        double bmiValue = weight/(height*height);
        bmiValue = Math.round(bmiValue*100)/100.0;
        return bmiValue;
    }
    
     
    /**
     * Method 2: Determine season based on month and day
     * @param month (1-12)
     * @param day (1-31)
     * @return season as String
     */
    public static String seasonDeterminer(int month, int day) {
    	if((month<1 || month>12) || (day<1 || day>31)){
            return "Invalid Date";
        }


        if((month == 3 && day >=20) || (month == 4) || (month == 5) || (month == 6 && day <= 20)){
            return "Spring";
        } else if ((month == 6 && day > 20) || (month == 7) || (month == 8) || (month == 9 && day <=22)) {
            return  "Summer";
        } else if ((month == 9 & day > 22) || (month == 10) || (month == 11) || (month == 12 && day <= 20)) {
            return "Fall";
        }else {
            return "Winter";
        }

    }
    
    /**
     * Method 3: Calculate parking fee based on hours
     * @param hours number of hours parked
     * @return total parking fee, or -1.0 if invalid input
     */
    public static double parkingFeeCalculator(int hours) {
    	if(hours < 0){
            return -1.0;
        }
        
        double calculatedFee = 0;
        
        if(hours <= 2){
            calculatedFee = hours * 3.0;
        } else if (hours <= 6 ) {
            calculatedFee = 2*3.0 + (hours-2)*2.5;
        } else{
            calculatedFee = 2*3.0 + 4*2.5 + (hours - 6)*2.0;
        }

        if(calculatedFee > 25.0){
            calculatedFee = 25.0;
        }

        return calculatedFee;
    }
    
    /**
     * Method 4: Classify triangle type based on three sides
     * @param side1 first side length
     * @param side2 second side length  
     * @param side3 third side length
     * @return triangle classification as String
     */
    public static String triangleClassifier(double side1, double side2, double side3) {
    	if(side1 <= 0 || side2 <= 0 || side3 <= 0){
            return "Invalid Input";
        }

        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            return "Not a Triangle";
        }

        if((side1 == side2) && (side2 == side3)){
            return "Equilateral";
        } else if ((side1 != side2) && (side2 != side3) && (side1 != side3)) {
            return "Scalene";
        }else {
            return "Isosceles";
        }

    }
    
    /**
     * Method 5:Calculates auto insurance premium based on driver profile and vehicle characteristics.
     * 
     * @param age driver's age in years
     * @param gender driver's gender ("Male" or "Female")  
     * @param drivingExperience years of driving experience
     * @param accidentCount number of accidents in recent years
     * @param vehicleType type of vehicle ("Sports", "Luxury", "SUV", "Sedan", "Compact")
     * @param coverageLevel coverage level ("Basic", "Standard", "Premium")
     * @return calculated annual premium in dollars, or -1 for invalid inputs
     */
    public static double calculateAutoInsurance(int age, String gender, int drivingExperience, 
                                              int accidentCount, String vehicleType, String coverageLevel) {

        if (age < 0  || gender == null  || drivingExperience < 0 || accidentCount < 0|| vehicleType == null || coverageLevel == null) {
            return -1.0;
        }

        double baseRateValue;
        if(age < 25){
            baseRateValue = 2000;
        } else if (age <= 35) {
            baseRateValue = 1500;
        } else if (age <= 50) {
            baseRateValue = 1200;
        }else{
            baseRateValue = 1000;
        }

        double riskFactorUnit = 1;

        if(age < 25 && gender.equals("Male")){
            riskFactorUnit += 0.25;
        }

        if(drivingExperience < 3){
            riskFactorUnit += 0.3;
        }

        double accidentPercentage = 0.2 * accidentCount;
        if(accidentPercentage > 1){
            accidentPercentage = 1;
        }
        riskFactorUnit += accidentPercentage;



        double vehicleTypeMult;
        if(vehicleType.equals("Sports")){
            vehicleTypeMult = 1.5;
        } else if (vehicleType.equals("Luxury")) {
            vehicleTypeMult = 1.3;
        }else if(vehicleType.equals("SUV")){
            vehicleTypeMult = 1.1;
        } else if (vehicleType.equals("Sedan")) {
            vehicleTypeMult = 1.0;
        } else if (vehicleType.equals("Compact")) {
            vehicleTypeMult = 0.9;
        } else {
            return -1;
        }

        double coverageLevelMult;
        if(coverageLevel.equals("Basic")){
            coverageLevelMult = 0.8;
        } else if (coverageLevel.equals("Standard")) {
            coverageLevelMult = 1.0;
        } else if (coverageLevel.equals("Premium")) {
            coverageLevelMult = 1.4;
        }else{
            return -1;
        }

        double insurancePremium = baseRateValue*riskFactorUnit*vehicleTypeMult*coverageLevelMult;

        return insurancePremium;
    }
}
