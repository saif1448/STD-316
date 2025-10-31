package LoopExamples;

public class Example4 {
    public static void main(String[] args) {
//       int i = 0;
//       while (i <= 5){
//
//           System.out.println(i);
//           i++;
//       }

//        for(int i = 0; i<=5; i++){
//            System.out.println(i);
//        }

        // this is printing even numbers between 1 to 10
//        for(int i = 1; i<=10; i++){
//            if(i % 2 == 0){
//                System.out.println(i);
//            }
//        }

        // this is doing the same but we are incrementing by 2

//        for(int i = 2; i <= 10; i+=2){
//            System.out.println(i);
//        }

        printCube(5);
        printCube(3);

    }

    // you are gonna print the cube of 1 to n
    public static void printCube(int n){
        for(int i =1; i<=n; i++){
            System.out.println(Math.pow(i, 3));
        }
    }
}
