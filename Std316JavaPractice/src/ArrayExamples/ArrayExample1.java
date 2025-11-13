package ArrayExamples;

public class ArrayExample1 {

    public static void main(String[] args) {
        // Array can contain same types of multiple data inside a single variable
        // It puts the data sequentially in the memory


        // 1001,1002,1003,1004,1005
        // 0     1    2     3    4   -----> size = 5, index range == 0 --> (size-1) ===> 0 ---> 4

        String studentId1 = "ABCD1244";

        // DataType[] arrayName = new DataType[size];

        String[] studentAllIds = new String[5]; // it is storing 5 students data

        // to find a data inside an array, we use the index number
        // the first item index is always 0

        studentAllIds[0] = "ABCD";
        studentAllIds[1] = "OIQPW";
        studentAllIds[2] = "puiuqwe";
        studentAllIds[3] = "AIYUUIY";
        studentAllIds[4] = "QBMNX";

        System.out.println("The length of student array : "+ studentAllIds.length);  // lengh ---> the size of the array

//        for(int i = 0; i < studentAllIds.length; i++){
//            System.out.println(studentAllIds[i]);
//        }


        // extended for loop
        for(String i : studentAllIds){
            System.out.println(i);
        }




    }
}
