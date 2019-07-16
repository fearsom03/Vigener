package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
public static   String upperLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
public static   String lowerLetters = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        // write your code here
        int a=4;
        System.out.println("Hello user ");
        while (a != 3) {
            Scanner in = new Scanner(System.in);
            System.out.println("What do you want ?");
            System.out.println("Press 1 for encr");
            System.out.println("Press 2 for decr");
            System.out.println("Press 3 for exit");
            a = in.nextInt();
            if (a == 1) {
                System.out.println("Please enter your text : ");
                String text = in.next();
                System.out.println("Please enter your key : ");
                String key = in.next();
                vigereLogic(text, key, "1");
            } else if (a == 2) {
                System.out.println("Please enter your ecrText : ");
                String text = in.next();
                System.out.println("Please enter your key : ");
                String key = in.next();
                vigereLogic(text, key, "2");
            } else {
            a=3;
            }

        }
    }

    public static void vigereLogic(String text,String key,String action) {
        //key abpple
        String encript = "";
        int count = 0;
        while (key.length() < text.length()) {
            key += key.charAt(count);
            count++;
        }
        ArrayList<Integer>arr3 = new ArrayList<Integer>();
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        ArrayList<String> arr = new ArrayList<String>();


        for (int i = 0; i < key.length(); i++) {
            for (int j = 0; j < upperLetters.length(); j++) {
                int move = 0;
                if (key.charAt(i) == upperLetters.charAt(j)) {
                    move = upperLetters.indexOf(upperLetters.charAt(j));
                    String newLetters = moveString(upperLetters, move);
                    arr.add(newLetters);
                }
                if (key.charAt(i) == lowerLetters.charAt(j)) {
                    move = lowerLetters.indexOf(lowerLetters.charAt(j));
                    String newLetters = moveString(lowerLetters, move);
                    arr.add(newLetters);
                }

            }
        }

        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < upperLetters.length(); j++) {
                int move2 = 0;
                if (text.charAt(i) == upperLetters.charAt(j)) {
                    move2 = upperLetters.indexOf(upperLetters.charAt(j));
                    arr2.add(move2);
                }
                if (text.charAt(i) == lowerLetters.charAt(j)) {
                    move2 = lowerLetters.indexOf(lowerLetters.charAt(j));
                    arr2.add(move2);
                }
            }
        }

        if (action.equals("1")) {
            System.out.println(arr.toString());
            System.out.println(arr2.toString());
            for (int i = 0; i < text.length(); i++) {
                String lettersForEncr = arr.get(i);
                int move2 = arr2.get(i);
                encript += lettersForEncr.charAt(move2);
            }
        }
        if (action.equals("2")) {
            for (int i = 0; i < text.length(); i++) {
                String lettersForEncr = arr.get(i);
                int move3 = lettersForEncr.indexOf(text.charAt(i));
                encript+= lowerLetters.charAt(move3);
            }
        }
        System.out.println(encript);
    }
        public static String moveString (String letters,int move){
            String newLetter = "";
            if (move == 0) {
                return letters;
            } else {
                for (int j = move; j < letters.length(); j++) {
                    newLetter += letters.charAt(j);
                }
                for (int i = 0; i < move; i++) {
                    newLetter += letters.charAt(i);
                }
                return newLetter;
            }
        }
}