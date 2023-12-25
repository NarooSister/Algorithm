import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        System.out.println(pib(n));
    }
    public static long pib(int n){
        if(n==0) return 0;
        else if(n==1) return 1;
        else return pib(n-2)+pib(n-1);
    }
}