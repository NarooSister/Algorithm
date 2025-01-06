import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] paper = new int[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                paper[i][j] = 0;
            }
        }

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            for (int j = a; j < a + 10; j++) {
                for (int k = b; k < b + 10; k++) {
                    paper[k][j] = 1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (paper[i][j] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
