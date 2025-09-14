package assignment2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final Scanner sc; //remove final if needed
    private String code;
    Game(Boolean testing, Scanner sc){
        this.code = SecretCodeGenerator.getInstance().getNewSecretCode();
        this.sc = sc;
        if(testing){
            //activate test mode
            System.out.println("\nGenerating secret code ...(for this example the secret code is " + code + ")\n");
        }else{
            //no test
            System.out.println("\nGenerating secret code ...\n");
        }
    }

    private int guesses = 0;
    private boolean valid = true;
    private final List<String> history = new ArrayList<>();

    public void runGame(){

        while((GameConfiguration.guessNumber - guesses) > 0){
            if(valid){
                System.out.println("You have " + (GameConfiguration.guessNumber - guesses) + " guesses left.");
            }
            System.out.println("What is your next guess?");
            System.out.println("Type in the next characters for your guess and press enter.");
            System.out.print("Enter guess: ");
            String guess = sc.nextLine();
            valid = true;
            //check validity
            if(guess.isEmpty()){
                valid = false;
            }else if(guess.equals("HISTORY")){
                System.out.println();
                for(String past : history){
                    System.out.println(past);
                }
                System.out.println();
                continue;
            }else if(guess.length() != GameConfiguration.pegNumber){
                valid = false;
            }else{
                for(int i = 0; i < GameConfiguration.pegNumber; i++){
                    boolean match = false;
                    for(int j = 0; j < GameConfiguration.colors.length; j++){
                        if(guess.substring(i, i + 1).equals(GameConfiguration.colors[j])) {
                            match = true;
                            break;
                        }
                    }
                    if (!match) {
                        valid = false;
                        break;
                    }
                }
            }

            //compute guess
            int B = 0;
            int W = 0;
            if(valid){
                //compute
                //count black pins
                StringBuilder codeCopy = new StringBuilder(code);
                StringBuilder guessCopy = new StringBuilder(guess);
                for(int i = 0; i < GameConfiguration.pegNumber; i++){
                    if(guessCopy.charAt(i) == codeCopy.charAt(i)){
                        B++;
                        guessCopy.replace(i, i + 1, "_");
                        codeCopy.replace(i, i + 1, "-");
                    }
                }
                for(int i = 0; i < GameConfiguration.pegNumber; i++){
                    if(guessCopy.charAt(i) == '-') continue;
                    for(int j = 0; j < code.length(); j++){
                        if(codeCopy.charAt(j) == '_') continue;
                        if(guessCopy.charAt(i) == codeCopy.charAt(j)){
                            W++;
                            codeCopy.replace(j, j + 1, "-");
                            break;
                        }
                    }
                }
                guesses++;
                if(B == GameConfiguration.pegNumber){
                    System.out.println("\n" + guess + " -> Result: " + B + "B_" + W + "W - You win !!\n");
                    break;
                }else if((GameConfiguration.guessNumber - guesses) == 0){
                    System.out.println("\nSorry, you are out of guesses. You lose, boo-hoo.\n");
                    break;
                }
                System.out.println("\n" + guess + " -> Result: " + B + "B_" + W + "W\n");
                //store history
                history.add(guess + "\t\t" + B + "B_" + W + "W");
            }else{
                System.out.println("\n" + guess + " -> INVALID \n");
            }
        }
    }
}
