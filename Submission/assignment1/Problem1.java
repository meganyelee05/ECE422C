/* Student Name: Megan Lee, Lab Section: 18535 */
package assignment1;
import java.util.Scanner;
//inputs:
//n (int) = number of maximum adjacent digits
//s (string) = 1000-digit number to search through
public class Problem1 {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       String s = sc.next();

       long result = findMaxProduct(n, s);

       System.out.println(result);
   }
   public static long findMaxProduct(int n, String s){
        long product;
        long max = 0;
        int[] nums = new int[1000];
        for(int i = 0; i < 1000; i++){
            nums[i] = s.charAt(i) - '0';
        }
        for(int i = 0; i < (1000 - n); i++){
            //for each i, do a for loop til n of multiplying, if greater than max set max = to product
            product = 1;
            for(int j = 0; j < n; j++){
                product *= nums[i + j];
                if(product > max){
                    max = product;
                }
            }
        }
        return max;
   }
}