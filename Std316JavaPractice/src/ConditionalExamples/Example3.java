package ConditionalExamples;

public class Example3 {
    public static void main(String[] args) {
        // else if ladder
        System.out.println("Choose one of the following option: ");

        System.out.println("1. Show Example of Addition\n"
        + "2. Show example of Subtraction\n"
        + "3. Show Example of Multiplication\n");

        int option = 2;

        if(option == 1){
            System.out.println("Example of Addition 1+2 = : " + (1 + 2));
        }
        else if(option == 2){
            System.out.println("Example of Subtraction 1 - 2 = "+ (1-2));
        } else if (option == 3) {
            System.out.println("Example of Multiplication 1 * 2 = " + (1*2));
        }else {
            System.out.println("Wrong option is being chosen");
        }
    }
}
