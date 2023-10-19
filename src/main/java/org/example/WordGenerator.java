package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class WordGenerator {
    private final String address;

    public WordGenerator(String dataAddress){
        this.address = dataAddress;
    }

    private int getSizeOfData(){
        int count = 0;
        BufferedReader reader;
        {
            try {
                reader = new BufferedReader(new FileReader("src/wordData"));
                while((reader.readLine() != null)){
                    count++;
                }
                reader.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return count;
    }

    public String getRandomWord(){
        Random rnd = new Random();
        int wordPosition = rnd.nextInt(getSizeOfData());

        try {
            return Files.readAllLines(Paths.get(address)).get(wordPosition);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
