package ArrayExamples;

public class ArrayExample3 {

    public static void main(String[] args) {
        int[] marks = {85, 90, 78, 88, 92};

        // Task1 : find the sum of all the students
        // Task2:  find the average of marks of the students

        double sum = 0;
        double average = 0;

        for(int i = 0; i < marks.length; i++){
//            sum = sum + marks[i];
            sum += marks[i];
        }

        System.out.println("Sum of the marks of all students: " + sum);

        average = sum / marks.length; // double / integer ---> double

        System.out.println("Average of the marks: " + average);




    }
}
