package MiscTopics;

public class IncrementAndDecrement {
    public static void main(String[] args) {
        // ++ ---> increment operator ---> unary operator ---> because it works with a single operand
        // -- ---> decrement operator ---> unary operator

        //Pre-incement ---> ++ ---> a = a + 1
        // when ++ is before the operand
        //Post-increment
        // wehn ++ is after the operand

        //Pre-decerement ---> a = a - 1
        // -- is before the operand
        //Post-decrement
        // -- is after the operand

//        int a = 10;
//        System.out.println("Pre-increment: " + ++a); // before printing, we are incrementing thr value of a then we are printing

//        int a = 10;
//        System.out.println("Post-increment: " + a++); //first print / use the existing value of a, then increment it
//        System.out.println("After increment "+ a);

//        int a = 22;
//
//        int b = a++ + 10;
//
//        System.out.println(b);  // we are gonna have 32, as for post increment

//        int a = 22;
//        int b = ++a + 10;
//        System.out.println(b); // we are gonna have 33, as for pre increment

//
//        int a = 22;
//        int b = a-- + 10;
//        System.out.println(b); // 32, because of post decrement
//
//        int a = 22;
//        int b = --a + 10;
//        System.out.println(b); // 31, because of pre-decrement


        int a = 5;
        int b = 11;
        int c = 8;
        int d = 3;

        int res = a++ + ++b + ++c + d++;

        System.out.println(res);


    }
}
