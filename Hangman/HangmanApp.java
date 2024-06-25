import java.util.Scanner;

public class HangmanApp {
    public static void main(String[] args) {
        //variables
        char letter;
        int occurrence;

        //objects
        Hangman hangman1 = new Hangman();
        Scanner input = new Scanner(System.in);

        //initializing the variables
        occurrence = 0;

        //entering the loop which starts the Hangman game, this loop ends when the number of incorrect tries reached the maximum number of allowed incorrect tries or when the player guesses the word entirely
        while(!hangman1.isGameOver()) {
            //revealing how many tries the player has and the letters of the word guessed so far
            System.out.println("You have " + (hangman1.getMaxAllowedIncorrectTries() - hangman1.getNumOfIncorrectTries()) + " tries left");
            System.out.println(hangman1.getKnownSoFar());
            //displaying all of the letters in the English alphabet and the letters guessed so far
            hangman1.displayLetters();

            //the player guesses the letter and that letter is turned into uppercase since the fixed list in the Hangman class includes only uppercase words
            System.out.print("Guess a letter:");
            letter = Character.toUpperCase(input.next().charAt(0));

            //checking if the guessed letter was previously guessed by the player
            if(hangman1.letterIsUsed(letter)) {
                System.out.println("You already guessed this letter! Please guess a different letter");
            }
            else {
                hangman1.addUsedLetters(letter);

                //if the secret word does not contain the letter, the number of incorrect tries is updated; if it contains the letter, the letters are revealed in the knownSoFar objects
                if(!hangman1.secretWordContains(letter)) {
                    System.out.println("The letter '" + letter + "' cannot be found in the secret word");
                    hangman1.setNumOfIncorrectTries(hangman1.getNumOfIncorrectTries() + 1);
                }
                else {
                    occurrence = hangman1.tryThis(letter);
                    System.out.println("There are " + occurrence + " occurrences of the letter: " + letter);
                }
            }

            System.out.println();
        }

        //checking whether the player has lost the game by checking if the knownSoFar includes "*" in it which indicates the player was not able to guess every letter in the secret word
        if(hangman1.hasLost()) {
            System.out.println("You lost!");
            System.out.println("The word was: " + hangman1.getSecretWord());
        }
        else {
            System.out.println("You win!");
            System.out.println("You guessed the word " + hangman1.getSecretWord() + " correctly");
        }

        input.close();
    }
}
