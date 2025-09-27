package ConditionalExamples;

public class Example2 {
    public static void main(String[] args) {
        // nested if else
        // nested means ----> one thing inside another thing

        // we are gonna check if a number if first even or odd
        // then we aer gonna check if the number is even, it is also divisible by 3
        // if the number is odd, if it is also divisible by 7

        int num = 23;

        if(num % 2 == 0){
            if(num % 3 == 0){
                System.out.println("The number is even and divisible by 3");
            }else{
                System.out.println("It is not following the criteria");
            }
        }else{
            if(num % 7 == 0){
                System.out.println("The number is odd and divisible by 7");
            }
            else{
                System.out.println("It is not following the criteria");
            }
        }

    }
}
