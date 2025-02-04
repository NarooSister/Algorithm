import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Integer> arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int gcd = gcd(n, m);
        System.out.println(gcd);
        System.out.println(Math.abs(n*m)/gcd);
    }

    static int gcd(int n, int m){
        if(m ==0){
            return n;
        }
        return gcd(m, n%m);
    }
}
