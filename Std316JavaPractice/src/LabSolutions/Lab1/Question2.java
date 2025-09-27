package LabSolutions.Lab1;


public class Question2 {
    public static void main(String[] args) {
        int q = 9;
        int m = 6;
        int year = 2024;
        int K = year % 100;
        int J = year / 100;
        // 0 - 6
        int h = (int)(q + Math.floor(13*(m+1)/5) + K + Math.floor(K/4) + Math.floor(J/4) + (5*J)) % 7;

        System.out.println(h);
    }
}
