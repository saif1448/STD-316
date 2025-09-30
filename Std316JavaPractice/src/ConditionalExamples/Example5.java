package ConditionalExamples;

import java.util.Scanner;

public class Example5 {
    public static void main(String[] args) {
        // Grading code example
        // 81-100 --> A
        // 71-80 ---> B
        // 61 - 70 ---> C
        // 51 - 60 ---> D
        // Otherwise ---> F

        Scanner sc = new Scanner(System.in);

        int mark = sc.nextInt();

        //we have to validate first
//        if(mark < 0 || mark > 100){
//            System.out.println("Invalid Mark");
//        }else{
//            if(mark>80 && mark <= 100){
//                System.out.println("Grade A");
//            } else if (mark > 70 && mark <=80) {
//                System.out.println("Grade B");
//            } else if (mark > 60 && mark <= 70) {
//                System.out.println("Grade C");
//            } else if (mark > 50 && mark <= 60) {
//                System.out.println("Grade D");
//            } else{
//                System.out.println("Grade F");
//            }
//
//        }

        if(mark < 0 || mark > 100){
            System.out.println("Invalid Mark");
        }else{
            if(mark>=80){
                System.out.println("Grade A");
            } else if (mark >=70) {
                System.out.println("Grade B");
            } else if (mark >=60) {
                System.out.println("Grade C");
            } else if (mark >=50) {
                System.out.println("Grade D");
            } else{
                System.out.println("Grade F");
            }

        }



    }
}
