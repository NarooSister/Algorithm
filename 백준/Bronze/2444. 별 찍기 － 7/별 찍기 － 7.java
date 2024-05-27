import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //n까지는 j번째 줄의 별 2j-1개 + 띄어쓰기 n-j개 양 쪽
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
        //n+1부터 2n-1 까지는 띄어쓰기 양쪽 j-n, 별 4n-2j-1
        for (int i = n + 1; i < 2 * n; i++) {
            for (int j = 0; j < i - n; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 4 * n - 2 * i - 1; j++) {
                System.out.print("*");
            }
            if (i != 2 * n - 1) {
                System.out.print("\n");
            }
        }
    }
}
