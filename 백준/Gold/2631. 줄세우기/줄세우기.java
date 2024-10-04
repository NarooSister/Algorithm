import java.io.*;

/*
1. 입력
아이들의 수 n
1 ~ n 까지의 숫자가 한 줄에 하나씩

2. 출력
번호 순대로 줄을 세우는데 옮겨지는 아이들의 최소 수

3. 풀이
LIS(최장 증가 부분 수열) 문제
LIS를 구해 그 아이들을 제외한 다른 아이들을 옮기면 된다.
즉 3 7 5 2 6 1 4 에서 Lis인 3 5 6 인 아이들은 그대로 두고
나머지 아이만 옮기면 최소로 옮길 수 있다.

*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] child = new int[n];
        int [] dp = new int[n+1];
        for (int i = 0; i < n; i++) {
            child[i] = Integer.parseInt(br.readLine());
        }
        
        dp[0] = 1;
        int max = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;  // 다시 구하기 위해 초기화 해준다.
            for (int j = 0; j < i; j++) {   // 자기 앞까지의 숫자들을 모두 비교해서 자신을 구한다.
                if(child[i] > child[j]){    // 앞 수가 나보다 작으면 +1
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
        }
     
        System.out.println(n-max);
    }
}
