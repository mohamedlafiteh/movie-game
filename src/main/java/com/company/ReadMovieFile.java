package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadMovieFile {
    public void readMovieFile() {

        int count = 0;
        try {
            File file = new File("/home/mohamed/IdeaProjects/course/src/com/company/movieLists.txt");
            if (file.exists()) {
                Scanner readF = new Scanner(file);
                Scanner input = new Scanner(System.in);
                String m = "chinatown";
                String newLetters = "";
                int guessCounter = 0;
                while (readF.hasNextLine()) {
                    // string of movie names
                    String data = readF.nextLine();
                    int movieLength = m.length();
                    String letters = "";
                    //fixed pug len-1, we got extra _ before

                    for (int i = 0; i < movieLength - 1; i++) {
                        letters += "_";
                    }
                    System.out.println("You are guessing: " + letters);
                    System.out.println("You have guessed " + "(" + guessCounter + ") " + "letters:");
                    System.out.print("Guess letter: ");
                    Character letter = input.next().charAt(0);
                    String [] indexes = new String[m.length()];
                    for (int i = 0; i < m.length(); i++) {
                        if(m.contains(String.valueOf(letter))){
                            indexes[i]= String.valueOf(m.indexOf(letter));
                        }
                    }
                    System.out.println(indexes[1]);
                    System.out.println(indexes.length);
                    int ind = m.indexOf(letter);
                    if (newLetters.length() == 0 && m.contains(letter.toString())) {
                        newLetters += letters.substring(0, ind) + letter + letters.substring(ind);
                    } else if (newLetters.length() > 0 && m.contains(letter.toString())) {
                        String[] l = newLetters.split("");
                        l[ind] = String.valueOf(letter);
                        String n = "";
                        for (int i = 0; i < l.length; i++) {
                            n += l[i];
                        }
                        newLetters = n;
                    } else {
                        guessCounter++;
                        if (guessCounter >= 10) {
                            System.out.println("You failed the game");
                        }
                        System.out.println("The letter is wrong");
                    }
                    System.out.println("You are guessing: " + newLetters);

                }
            } else {
                System.out.println("Mo the file is not here do some thing about it man");
            }
        } catch (IOException e) {
            System.out.println("Error occurred mo");
            e.printStackTrace();
        }


    }
}
