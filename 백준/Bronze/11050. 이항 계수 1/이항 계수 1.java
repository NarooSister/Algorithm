import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(result(n, m));
    }

    public static int result(int n, int m) {
        return factorial(n) / (factorial(m) * factorial(n - m));
    }

    public static int factorial(int n) {
        if (n == 1 || n == 0) return 1;
        return n * factorial(n - 1);
    }
}


