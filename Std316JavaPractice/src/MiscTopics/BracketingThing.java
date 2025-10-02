package MiscTopics;

public class BracketingThing {

    public static void main(String[] args) {
        // if we have a single line of statement after if or else or for loop, we don't need bracket, it is not required
        // if more than one line, bracket is mandatory, otherwise you will have error

        int age = 20;
        String gender = "abc";

        if (age >= 20)
            if(gender.equals("male")) System.out.println("correct");
            else if (gender.equals("female")) System.out.println("female");
            else if (gender.equals("other")) System.out.println("problem");
            else System.out.println("Condition not met");

        System.out.println("outside the condition");

    }
}
