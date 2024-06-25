import java.util.ArrayList;
import java.util.Random;

public class Hangman {
    //constant data members
    private final int MAX_ALLOWED_INCORRECT_TRIES = 6;
    private final String[] FIXED_LIST = {"APPLE", "SAMSUNG", "WATER", "SOUND", "SENTENCE", "BANANA", "HYUNDAI", "COMPUTER", "TOYOTA", "FORD", "DOOR", "DESKTOP", "CLOTH", "SHOES", "LIGHT", "TEST", "INSTAGRAM", "TESLA", "NUMBER", "PENCIL"};
    private final char[] ALL_LETTERS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    //instance data members
    private StringBuffer secretWord;
    private StringBuffer knownSoFar;
    private ArrayList<Character> usedLetters;
    private int numOfIncorrectTries;

    //constructor
    public Hangman() {
        secretWord = chooseSecretWord();
        knownSoFar = new StringBuffer(createKnownSoFar());
        numOfIncorrectTries = 0;
        usedLetters = new ArrayList<Character>();
    }

    //setters
    public void setSecretWord(StringBuffer secretWord) {
        this.secretWord = secretWord;
    }

    public void addUsedLetters(char ch) {
        usedLetters.add(ch);
    }

    public void setNumOfIncorrectTries(int numOfIncorrectTries) {
        this.numOfIncorrectTries = numOfIncorrectTries;
    }

    public void setKnownSoFar(StringBuffer knownSoFar) {
        this.knownSoFar = knownSoFar;
    }
    
    //getters
    public char[] getAllLetters() {
       return ALL_LETTERS;
    }

    public ArrayList<Character> getUsedLetters() {
        return usedLetters;
    }

    public int getNumOfIncorrectTries() {
        return numOfIncorrectTries;
    }

    public int getMaxAllowedIncorrectTries() {
        return MAX_ALLOWED_INCORRECT_TRIES;
    }

    public StringBuffer getKnownSoFar() {
        return knownSoFar;
    }

    public StringBuffer getSecretWord() {
        return secretWord;
    }

    //private helper methods

    /**
     * This method chooses a random secret word from the fixed list
     * @return StringBuffer object which is the chosen secret word from the fixed list
     */
    private StringBuffer chooseSecretWord() {
        Random rand = new Random();
        int wordPosition = rand.nextInt(FIXED_LIST.length);
        secretWord = new StringBuffer(FIXED_LIST[wordPosition]);

        return secretWord;
    }

    /**
     * This method checks if the given character can be found inside the knownSoFar object
     * @param ch a character to be checked if it is found in the knownSoFar object
     * @return a boolean variable that indicates the specified character is found within the knownSoFar object
     */
    private boolean knownSoFarContains(char ch) {
        for(int n = 0; n < knownSoFar.length(); n++) {
            if(knownSoFar.charAt(n) == ch) {
                return true;
            }
        }

        return false;
    }

    /**
     * This method creates the knownSoFar object which consists of "*" and its length is determined by the secretWord object
     * @return a String object that is turned into a StringBuffer object in the constructor
     */
    private String createKnownSoFar() {
        String knownSoFar;

        knownSoFar = "";
    
        for(int n = 0; n < secretWord.length(); n++) {
            knownSoFar += "*";
        }

        return knownSoFar;
    }

    //service methods

    /**
     * This method checks if the given character can be found inside the secretWord object
     * @param ch a character to be checked if it is found in the secretWord object
     * @return a boolean variable that indicates the specified character is found within the secretWord object
     */
    public boolean secretWordContains(char ch) {
        for(int n = 0; n < secretWord.length(); n++) {
            if(secretWord.charAt(n) == ch) {
                return true;
            }
        }

        return false;
    }

    /**
     * This method counts how many times the given character can be found inside the secretWord object and also updates the knownSoFar object by
     * replacing the "*" with the given character if it can be found
     * @param guess a character to be checked if it can be found in the secretWord object
     * @return a integer variable that indicates how many times the given character can be found inside the secretWord object
     */
    public int tryThis(char guess) {
        int letterCounter = 0;

        for(int index = 0; index < secretWord.length(); index++) {
            if(secretWord.charAt(index) == guess){
                letterCounter++;
                knownSoFar.setCharAt(index, guess);
            }
        }

        return letterCounter;
    }
    
    /**
     * This method checks whether the game is over by checking if the number of incorrect tries are equal to the maximum number of allowed
     * incorrect tries or knownSoFar object does not contain "*" in it which indicates the player guessed the word correctly
     * @return a boolean variable which indicates if the game is over or not
     */
    public boolean isGameOver() {
        if ( numOfIncorrectTries == MAX_ALLOWED_INCORRECT_TRIES || !knownSoFarContains('*')) {
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * This method checks if the player has lost the game by checking if the knownSoFar object includes "*" in it which indicates the player did not find all of the letters
     * in the word
     * @return a boolean variable which indicates whether the player has lost
     */
    public boolean hasLost() {
        if(knownSoFarContains('*')) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This method checks if the given letter can be found in the usedLetters object which is an Array List that includes the letters guessed so far
     * @param ch a character to be checked if it can be found in the usedLetters
     * @return a boolean variable which indicates whether the given letter is found
     */
    public boolean letterIsUsed(char ch) {
        if(usedLetters.size() == 0) {
            return false;
        }

        for(int n = 0; n < usedLetters.size(); n++) {
            if(usedLetters.get(n) == ch) {
                return true;
            }
        }

        return false;
    }

    /**
     * This method displays all of the letters included in the English alphabet and the letters guessed so far
     */
    public void displayLetters() {
        System.out.print("Letters included in the English alphabet: ");

        for(int n = 0; n < ALL_LETTERS.length; n++) {
            System.out.print(ALL_LETTERS[n] + " ");
        }

        System.out.print("\nLetters guessed so far: ");

        if(usedLetters.size() == 0) {
            System.out.println("You have not guessed any letters yet");
        }
        else {
            for(int n = 0; n < usedLetters.size(); n++) {
                System.out.print(usedLetters.get(n) + " ");
            }

            System.out.println();
        }
    }
}
