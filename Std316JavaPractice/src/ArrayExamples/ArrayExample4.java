package ArrayExamples;

import java.util.Scanner;

public class ArrayExample4 {

    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);

        int[] marks = new int[5];  // this is blank array

        // i == 0, marks[0]  = mark
        // i == 1, marks[1]  = mark

        for(int i = 0; i < marks.length; i++){
            System.out.print("Enter a new marK: ");
            int mark = sc.nextInt();
            marks[i] = mark;
        }

        //Student[0] : 12
        //Student[1] : 42
       for(int i = 0; i< marks.length; i++){
           System.out.println("Student[" + i + "] : " + marks[i]);
       }


    }
}
