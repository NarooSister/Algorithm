import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int l = word.length();
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(l - i - 1) == word.charAt(i)) {
                count++;
            } 
        }if(count==l){
            System.out.println(1);
        }else {System.out.println(0);}
    }
}