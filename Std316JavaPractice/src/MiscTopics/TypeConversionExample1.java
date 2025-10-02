package MiscTopics;

public class TypeConversionExample1 {
    public static void main(String[] args) {
        // Autoboxing ---> Auto data type conversion
        // byte → short → int → long → float → double
        // if you + something with a string, it will become a string
//        int a = 20;
//        double c = 6.5;


        // Manual conversion

//        int a = 20;
//        int b = 5;
//
//        System.out.println(a/b);  // int / int ---> int

//        int a = 25;
//        int b = 3;
//        System.out.println(a/b); // int / int ---> int ---> the floating point side is removed

//        int a = 25;
//        int b = 3;
//        System.out.println((double) (a/b));
//        // inside the bracket ---> int / int ---> int ---> 8
//        // then you are converting to the 8 to doubl e ---> 8.0

//
//        int a = 25;
//        int b = 3;
//        System.out.println((double) a/b);
//        // first, i am casting a to double ---> (double) a ---> 25 is becoming 25.0
//        // then double / int ---> result of double ---> 8.334

        int a = 25;
        int b = 3;
        System.out.println(a / (double)b );




    }
}
