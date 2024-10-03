import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1. 입력
반의 학생 수 N
n행 5열의 이차원 배열

2. 출력
같은 반이었던 학생 수가 제일 많은 학생이 임시반장.
임시반장의 번호 출력

3. 풀이
학년마다 같은 반이었던 다른 학생의 수를 구한다.
주의할 점 : 한번이라도 같은 반이었던 학생을 구하는 것이다. 즉 중복 체크하지 말아야한다.
만약 a와 b가 1학년부터 5학년까지 같은반이라고 하더라도 +5가 아니라 +1이다.

*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][5];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] student = new int[n];
        boolean [][] check = new boolean[n][n];
        for (int x = 0; x < 5; x++) {
            for (int i = 0; i < n-1; i++) {
                for (int j = i+1; j < n; j++) {
                    if(!check[i][j]){
                        if(board[i][x] == board[j][x]){
                            student[i]++;
                            student[j]++;
                            check[i][j] = true;
                            check[j][i] = true;
                        }
                    }
                }
            }
        }
        int result = 1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if(student[i]>max){
                max = student[i];
                result = i+1;
            }
        }

        System.out.println(result);
    }
}