package LoopExamples;

public class Example3 {
    public static void main(String[] args) {
        // 5-7 --- number tables
        // i * j
        // 5 * 1 = 5
        // 5 * 2 = 10
        // 5 * 3 = 15 ....
        // 5 * 10 = 50

        // 6 * 1 = 6
        // 6 * 2 = 12 ...
        // 6 * 10 == 60

        for(int i = 5; i <= 7; i++){

            for(int j = 1; j <= 10; j++){
                System.out.println(i + " * " + j + " = " + i *j);
            }

            System.out.println("--------------");

        }

    }
}
