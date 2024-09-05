import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 큰 별 네모에서 가운데 네모를 뺀다
// n=3이 될 때까지 재귀적으로 반복한다.

public class Main {
    static int n;
    static char [][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for (int i = 0; i < n ;i++) {
            Arrays.fill(arr[i], '*');
        }

        func(n, 0, 0);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void func(int n, int x, int y){
        if(n==1){
            return;
        }
        int size = n/3;
        // 가운데 빈칸 처리하기
        for (int i = x + size; i < x + (size*2) ; i++) {
            for (int j = y + size; j < y + (size*2) ; j++) {
                arr[i][j] = ' ';
            }
        }
        // 작은 9개의 네모 재귀적으로 호출
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i == 1 && j == 1) continue;
                func(size, x+i*size, y+ j*size);
            }
        }
    }
}