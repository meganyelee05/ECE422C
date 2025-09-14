/* Student Name: Megan Lee, Lab Section: 18535 */
package assignment1;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.util.Scanner;
public class Problem3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        tagline(s);
    }
    public static void tagline(String s){
        MaxentTagger tagger = new MaxentTagger(Problem3.class.getResourceAsStream("/assignment1/english-left3words-distsim.tagger"));

        String tagged = tagger.tagString(s);
        System.out.println(tagged);
    }
}
