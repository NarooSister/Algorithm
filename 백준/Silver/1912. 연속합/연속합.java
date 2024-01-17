import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int [] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            //이전의 합 vs 현재 합 중에 더 큰 값을 할당
            dp[i] = Math.max(dp[i-1] + arr[i],arr[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}