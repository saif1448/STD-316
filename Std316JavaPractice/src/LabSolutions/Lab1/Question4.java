package LabSolutions.Lab1;

public class Question4 {
    public static void main(String[] args) {
        double P = 1500;
        double r = 0.043;
        double t = 6;
        int n = 4;
        double ratePart = Math.pow(1 + (r/n), n*t);
        double A = P * ratePart;

        System.out.println(A-P);

    }
}
