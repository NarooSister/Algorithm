import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int n;
    static int[] queens;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        queens = new int[n];

        solve(0);
        System.out.println(count);
    }

    public static void solve(int row) {
        if (row == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(row, i)) {
                queens[row] = i;
                solve(row + 1);
            }
        }
    }

    public static boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col)
                return false;
            if (Math.abs(row - i) == Math.abs(col - queens[i]))
                return false;
        }
        return true;
    }
}
