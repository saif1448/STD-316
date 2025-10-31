package LoopExamples;

public class Example5 {
    public static void main(String[] args) {
        // 10 + 20 + 30 + 40 + ..... + 300 ---> find the sum of this series
        int sum = 0;
        for(int i = 10; i <= 300; i+=10){
//            System.out.println(i);
            sum += i;
        }

        System.out.println(sum);
    }
}
