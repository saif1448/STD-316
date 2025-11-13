package ArrayExamples;

public class ArrayExample5 {
    public static void main(String[] args) {
        int[] marks = {85, 90, 78, 88, 92};

        int minMarks = Integer.MAX_VALUE;
        int maxMarks = Integer.MIN_VALUE;

        // min
        // minMarks > marks[0] ---> 85 ---> minMarks = 85
        // minMarks > marks[1] ----> 90 ----> minMarks = 85
        // minMakrs > marks[2] ----> 78 ----> minMarks = 78
        // minMarks > marks[3] ----> 88 -----> minMarks = 78
        // minMarks > marks[4] ----> 92 ----> minMarks = 78

        // max
        // maxMarks < marks[0] ---> 85 ---> maxMarks = 85
        // maxMarks < marks[1] ----> 90 ----> maxMarks = 90
        // maxMarks < marks[2] ----> 78 ----> maxMarks = 90
        // maxMarks < marks[3] ----> 88 -----> maxMarks = 90
        // maxMarks < marks[4] ----> 92 ----> maxMarks = 92

        for(int i = 0; i < marks.length; i++){
            if(marks[i] < minMarks){
                minMarks = marks[i];
            }

            if(marks[i] > maxMarks){
                maxMarks = marks[i];
            }
        }

        System.out.println("Minmum value: " + minMarks);
        System.out.println("Max value: " + maxMarks);


    }
}
