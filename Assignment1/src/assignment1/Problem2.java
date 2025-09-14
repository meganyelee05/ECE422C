/* Student Name: Megan Lee, Lab Section: 18535 */
package assignment1;
import java.util.Scanner;
public class Problem2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        //convert string to lowercase
        String str = s.toLowerCase();

        printdollarwords(s, str);
    }
    public static void printdollarwords(String s, String str){
        //create ranking array
        String abc = "abcdefghijklmnopqrstuvwxyz";

        //loop through string
        //for each word, loop through abc, if match char, value += i, if no match, += 0
        //if value = 100, print
        String[] words = str.split("\\s+");
        String[] origword = s.split("\\s+");
        for(int i = 0; i < words.length; i++) { //how many words in string
            int value = 0;
            for (int j = 0; j < words[i].length(); j++) { //how many letters in word
                for (int k = 0; k < 26; k++) {
                    if (words[i].charAt(j) == abc.charAt(k)) {
                        value += k + 1;
                    }
                }
            }
            if (value == 100) {
                System.out.println(origword[i]);
            }
        }
    }
}
