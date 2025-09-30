package LoopExamples;

public class Example2 {
    public static void main(String[] args) {
        //printing from 1 to 100

        //for (initialization ; condition ; increment/decrement){ loop body}
        //
//        for(int i =1; i <= 100; i++){
//            System.out.println("value: "+ i);
//        }
//

        //printing the even numbers 200 - 300
//        for(int i = 200; i <= 300 ; i = i + 2){
//            System.out.println("value: " + i);
//        }
//
        // we are gonna initlize outside
        int i = 300;
        for( ; i>=200; ){
            System.out.println("value: "+ i);
            i = i -2;
        }
    }
}
