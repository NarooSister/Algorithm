import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*  풀이 방법 : 중간수(홀수)를 기준으로 양쪽 날개 부분이 동일함
    1. 홀수의 경우 :
      Ex f(7):  중간이 1이면 양쪽에 3씩 남고, f(3)을 구함
                중간이 3이면 양쪽에 2씩 남고, f(2)를 구함
                증간이 5이면 양쪽에 1씩 남고, f(1)을 구함
                중간이 7이면 1 추가함.
                따라서 f(홀수 n) = 1+f(1)+f(2)+ ... + f((n-1)/2)

    2. 짝수의 경우 :
      Ex f(8): 중간이 없으면 양쪽에 4씩 남고, f(4)
               중간이 2 이면 양쪽에 3 남고, f(3)
               중간이 4 이면 양쪽에 2 남고, f(2)
               중간이 6 이면 양쪽에 1 남고, f(1)
               중간이 8 이면 1 추가.
               따라서 f(짝수 n) = f(n-1) + f(n/2)
 */



public class Main {
    static int[] dp = new int[1001];    // 메모이제이션을 위한 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < 1001; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= 1000; i++) {
            //짝수인 경우
            if (i % 2 == 0) {
                dp[i] = dp[i - 1] + dp[i / 2];
            } else {
                //홀수인 경우
                dp[i] = dp[i - 1];
            }
        }
        
        for (int i = 0; i < n; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }
    }
}