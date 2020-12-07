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
                while (readF.hasNextLine()) {
                    String data = readF.nextLine();
                    String[] arr = data.split(" ");
                    count += arr.length;
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
