import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuilder output = new StringBuilder();
        int count = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i - 1)){
                count++;
            }else{
                output.append(count).append(s.charAt(i - 1));
                count = 1;
            }
        }
        output.append(count).append(s.charAt(s.length() - 1));
        System.out.println(output);
    }
}