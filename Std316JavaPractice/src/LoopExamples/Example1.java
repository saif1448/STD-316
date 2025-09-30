package LoopExamples;

public class Example1 {
    public static void main(String[] args) {
        // Printing from 1 -- 100
        //while
//        int i = 1; // initialization
//        while(i <= 10){ // condition
//            System.out.println("Value: "+ i); // loop body
//
//            i++; // increment / decrement ---> in case of while loop, this is the last statement in the loop body
//        }
//        System.out.println("---------------------------------");
//        // printing from 10 to 1
//        i = 10; // initialization
//        while (i > 0){ // condition
//            System.out.println("Value: "+ i); // loop body
//            i--; // decrement
//        }
//
//        System.out.println("-----------------------");
//        //we are gonna print the even number between 1 to 100
//        // 2, 4, 6, 8, ...., 100
//        i = 2;
//        while (i <= 100){
//            System.out.println("Value: " + i);
//            i += 2;
//        }

        System.out.println("---------------------------");
        // printing odd numbers from 1 to 100
        // 1, 3, ... 99
        int i = 1;
        while (i < 100){
            System.out.println("Value: " + i);
            i += 2;
        }


    }
}
