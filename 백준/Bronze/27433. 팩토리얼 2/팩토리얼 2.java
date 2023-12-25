import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        System.out.println(fact(n));
    }
    public static long fact(int n){
        if(n==0) return 1;
        else if(n==1) return 1;
        else return n*fact(n-1);
    }
}