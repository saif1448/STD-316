public class StringExample {

    public static void main(String[] args) {
        String name = "Saif";

        int age = 30;

        System.out.println(name);

        // String concatenation ---> we use + operator
        // When you append a primitive type with a string, it will automatically convered to a string
        System.out.println("My name is: " + name + ", and My age is: " + age);

        // we check the length of the string
        // we use length function with dot operator

        int nameStringLength = name.length();
        System.out.println("Length of name : " + name.length());

    }
}
