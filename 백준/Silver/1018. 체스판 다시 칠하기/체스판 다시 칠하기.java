import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;
    static int n, m;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = sc.next().toCharArray();
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= n-8; i++) {
            for (int j = 0; j <= m-8; j++) {
                min = Math.min(min, getMin(i,j));
            }
        }

        System.out.println(min);
    }

    public static int getMin(int x, int y){
        int count1 = 0;
        int count2 = 0;

        char[] board1 = {'W', 'B'};
        char[] board2 = {'B', 'W'};

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char ex1 = board1[(i+j)%2];
                char ex2 = board2[(i+j)%2];

                if(board[x+i][y+j] != ex1) count1++;
                if(board[x+i][y+j] != ex2) count2++;
            }
        }

        return Math.min(count1, count2);
    }
}
