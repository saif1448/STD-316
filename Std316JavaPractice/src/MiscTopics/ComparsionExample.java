package MiscTopics;

public class ComparsionExample {
    public static void main(String[] args) {
//        int a  = 10;
//        int b = 10;
//
//        System.out.println(a == b);
//
//
//        char c = 't';
//        char d = 't';
//
//        System.out.println( c == d);
//

        // for String equality check, we use .equals() method to check if a string is equal to another string

//        String s1 = "abc";
//        String s2 = "abc";
//
//        System.out.println(s1.equals(s2));


//        String s1 = "abc";
//
//        System.out.println(s1.charAt(1));
//
//        String str = "ABCD"; // length ----> 4 ---> so the last value is in 3 index
//
//        String s1 = "It is a big string reference";
//        int n1 = s1.indexOf('b');
//        int n2 = s1.length();
//        System.out.println("index of b: "+ n1);
//        System.out.println("length of s1 " + s1.length());
//        String s2 = s1.substring( s1.indexOf('b'), s1.length());
//        System.out.println(s2);
//
//
//        String name = "Saif Mahmud Parvez";
//        System.out.println(name.startsWith("Si"));
//        System.out.println(name.endsWith("ez"));

//        double a = 1.22134;
//
//        double b = 1.22134;
//
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(a == b); // we should not do this

        double a = (double) 22/7;
        System.out.println(a);
        double b = (double) 22/7;
        System.out.println(a==b);
        // instead of above, we need to check tolerance

        if(Math.abs(a-b) <= 0.0001){
            System.out.println("both are same number");
        }else {
            System.out.println("These are not same number");
        }


        if(Double.compare(a, b) == 0){
            System.out.println("Both are same");
        }else{
            System.out.println("both are not same");
        }


        // another one is Double.equals
    }
}
