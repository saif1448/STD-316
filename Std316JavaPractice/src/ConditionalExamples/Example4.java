package ConditionalExamples;

import java.util.Scanner;

public class Example4 {
    public static void main(String[] args) {
        // Switch Case Statement

        System.out.println("Choose one of the following option: ");

        System.out.println("1. Show Example of Addition\n"
                + "2. Show example of Subtraction\n"
                + "3. Show Example of Multiplication\n");

        Scanner sc = new Scanner(System.in);

        int option = sc.nextInt();

        switch (option){
            case 1:
                System.out.println("You have chosen option 1");
                System.out.println("Example of Addition 1+2 = : " + (1 + 2));
                break;
            case 2:
                System.out.println("You have chosen option 2");
                System.out.println("Example of Subtraction 1 - 2 = "+ (1-2));
                break;
            case 3:
                System.out.println("You have chosen option 3");
                System.out.println("Example of Multiplication 1 * 2 = " + (1*2));
                break;
            default:
                System.out.println("You have chosen wrong operation");
        }





    }
}
