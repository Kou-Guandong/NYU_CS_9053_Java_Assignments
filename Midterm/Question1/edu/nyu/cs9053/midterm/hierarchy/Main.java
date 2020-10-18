package edu.nyu.cs9053.midterm.hierarchy;

import java.io.*;

class Main {
    public static void main(String[] args) {
        FileReader file;
        try {
            System.out.println(System.getProperty("user.dir"));
            file = new FileReader("data.txt");
            BufferedReader fileInput = new BufferedReader(file);
            String inLine = fileInput.readLine();
            while (inLine != null) {
                String[] numbers = inLine.split(" ");
                Integer a = Integer.parseInt(numbers[0]);
                Integer b = Integer.parseInt(numbers[1]);
                try {
                    Integer c = a / b;
                    System.out.println("result = " + c);
                } catch (ArithmeticException e) {
                    e.printStackTrace();
                }
                inLine = fileInput.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("program ended.");
        }
    }
}