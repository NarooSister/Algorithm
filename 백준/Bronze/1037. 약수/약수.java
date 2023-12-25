import java.util.Arrays;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){
     Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] Str = new int [n];
        for (int i = 0; i < n; i++) {
            Str [i] = sc.nextInt();
        }
        Arrays.sort(Str);
        System.out.println(Str[0]*Str[n-1]);
    }
}