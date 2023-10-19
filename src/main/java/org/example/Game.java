package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {

    private final List<Character> guessedLetter = new ArrayList<>();
    private int triesCount = 0;
    private int score = 0;


    //convert String to List
    private List<Character> getList(String string){
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < string.length(); i++){
            list.add(string.charAt(i));
        }
        return list;
    }

    //main play method
    public boolean play(String secretWord,int maxTries){

        List<Character> secretList = getList(secretWord);
        Image display = new Image();
        Scanner myScan = new Scanner(System.in);
        char tmpChar;
        //show info like amount of tries and word's length
        display.printInfo(secretWord.length(),maxTries);

        //aka simulation of loading
        try {
            System.out.print("\nLoading.");
            for(int i = 0; i < 10; i++){
                System.out.print('.');
                TimeUnit.MILLISECONDS.sleep(300);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //game loop
        while(triesCount < maxTries){
            display.clearSpace();
            display.showTriesLeft(maxTries - triesCount);
            display.showStage(triesCount);
            display.showGuessedLetters(secretWord, guessedLetter);
            display.showUsedLetters(this.guessedLetter);
            display.ShowAskForLetter();


            //get user input while it is not a letter
            while(true){
                tmpChar = myScan.nextLine().charAt(0);
                if(Character.isAlphabetic(tmpChar)){
                    tmpChar = Character.toLowerCase(tmpChar);
                    break;
                }else{
                    System.out.println("Invalid input:");
                }
            }

            //add guessed letter to a List
            if(!guessedLetter.contains(tmpChar)){
                if(secretList.contains(tmpChar)){
                    guessedLetter.add(tmpChar);
                }else{
                    guessedLetter.add(tmpChar);
                    this.triesCount++;
                }
            }

            //count score by guessed letters
            for(char i : secretList){
                if(i == tmpChar){
                    score++;
                    if(score == secretWord.length()){
                        return true;
                    }
                }
            }
        }

        return false;

    }
}
