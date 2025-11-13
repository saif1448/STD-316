package ArrayExamples;

public class ArrayExmple2 {
    public static void main(String[] args) {
        String[] studentAllIds = {"ABJDNJ", "ASKJKAJS", "KHKJKAS", "ASIUIQW", "AIPOP"};

        System.out.println(studentAllIds.length);

        for(String i : studentAllIds){
            System.out.println(i);
        }

        int[] marks = {85, 90, 78, 88, 92};

//        for(int m : marks){
//            System.out.println(m);
//        }

        for(int i  = 0; i < marks.length; i++){
            System.out.println(marks[i]);
        }
    }
}
