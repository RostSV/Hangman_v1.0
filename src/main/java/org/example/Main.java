package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {


        final int maxTriesCount = 5;

        WordGenerator generator = new WordGenerator("src/wordData");
        Image display = new Image();

        display.printWelcomeText();

        while(true){
            display.printStartPhrase();
            Scanner myScan = new Scanner(System.in);
            char letter;
            int count = 0;

            //get input while it is not "No" or "Yes"
            do {
                if(count++ > 0){
                    System.out.println("Invalid input, try again!");
                }
                letter = myScan.nextLine().charAt(0);

            } while (letter != 'y' && letter != 'n' && letter != 'N' && letter != 'Y');

            //check for "NO" input
            if(letter == 'n' || letter == 'N'){
                System.out.println("Thank you for playing!");
                myScan.close();
                break;
            }

            String secretWord = generator.getRandomWord();

            //System.out.println(secretWord);

            //main game loop
            Game game = new Game();
            if(game.play(secretWord,maxTriesCount)){
                display.clearSpace();
                display.printWin(secretWord);
            }else{
                display.clearSpace();
                display.showStage(maxTriesCount);
                display.printLoose(secretWord);
            }

        }
    }
}