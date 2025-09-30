package ConditionalExamples;

import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the mark: ");
        int mark = sc.nextInt();

        // Grading code example
        // 81-100 --> A
        // 71-80 ---> B
        // 61 - 70 ---> C
        // 51 - 60 ---> D
        // Otherwise ---> F
//
//        100 / 10 --> 10
//        95/10 ---> 9
//        85/10 -->  8
//        78/10 ---> 7
//

        if(mark < 0 || mark > 100 ){
            System.out.println("Invalid Mark");

        }else {
            mark /= 10; // mark  = mark/10;
            switch (mark){
                case 10:
                case 9:
                case 8:
                    System.out.println("Grade A");
                    break;
                case 7:
                    System.out.println("Grade B");
                    break;
                case 6:
                    System.out.println("Grade C");
                    break;
                case 5:
                    System.out.println("Grade D");
                default:
                    System.out.println("Grade F");
            }
        }


    }
}
