package org.example;

import java.util.List;

public class Image {
    public void showStage(int stage){
        System.out.println("_______");

        if(stage == 1){
            System.out.println("| /  |");
            System.out.println("|/");
            System.out.println('|');
            System.out.println('|');
            System.out.println('|');

        }else if(stage == 2){
            System.out.println("| /  |");
            System.out.println("|/   O");
            System.out.println('|');
            System.out.println('|');
            System.out.println('|');
        }
        else if(stage == 3){
            System.out.println("| /  |");
            System.out.println("|/   O");
            System.out.println("|   /|\\");
            System.out.println('|');
            System.out.println('|');
        }else if(stage == 4){
            System.out.println("| /  |");
            System.out.println("|/   O");
            System.out.println("|   /|\\");
            System.out.println("     |");
            System.out.println('|');
        }else if(stage == 5){
            System.out.println("| /  |");
            System.out.println("|/   O");
            System.out.println("|   /|\\");
            System.out.println("|    |");
            System.out.println("|   / \\");
        }else{
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }

        System.out.println("|\nTTTTTTTTTT");
    }

    public void showGuessedLetters(String secretWord , List<Character> lettersGuessed){

        char[] secretList = secretWord.toCharArray();

        for(char letter : secretList){
            if(lettersGuessed.contains(letter)){
                System.out.print(letter);
            }else{
                System.out.print('_');
            }
        }
        System.out.print('\n');
    }

    public void printWelcomeText(){
        System.out.println("Hello and welcome to 'Hangman' game!");
    }

    public void printStartPhrase(){
        System.out.println("Press [Y]es to start or [N]o to close the game!");
    }

    public void printInfo(int wordLength, int tries){
        System.out.println("The word's length is " + wordLength + " letters");
        System.out.println("You have " + tries + " tries!");
        System.out.println("Good luck!");
    }
    public void ShowAskForLetter(){
        System.out.println("What's your guess?: ");
    }

    public void showUsedLetters(List<Character> list){
        System.out.print("Used: [");
        for(char a : list){
            System.out.print(a + ", ");
        }
        System.out.print("]\n");
    }
//    public void printAlreadyUsed(){
//        System.out.println("Sorry, but you already used this letter");
//    }
    public void showTriesLeft(int tries){
        System.out.println("You have " + tries + " tries left.");
    }

    public void printWin(String word){
        System.out.println("\n\nCongratulation, You win!\n");
        System.out.println("The word was: " + word + "\n\n");
    }

    public void printLoose(String word){
        System.out.println("You're loser, you can't guess word: "+ word);
    }

    public void clearSpace(){
        for(int i = 0; i < 30; i++)
            System.out.println();
    }
}