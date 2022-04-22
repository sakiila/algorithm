package me.bob.test;

public class ByteTest {


    public static void main(String[] args) {

        String yesB = new StringBuilder().append("aaabbb").toString();
        String yesC = yesB.intern();
        String yesA = "aaabbb";
        System.out.println(yesC == yesB);//false
        System.out.println(yesA == yesB);//false
        System.out.println(yesA == yesC);//true
    }
}
