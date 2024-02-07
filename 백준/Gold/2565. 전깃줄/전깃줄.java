import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    //없애야 하는 전깃줄의 최소 갯수
    // = 전체 전깃줄 - 교차하지 않고 설치 가능한 전깃줄의 최대 개수
    // a,b의 수가 증가하는 수열 중 가장 긴 것을 골라내면 됨 (LIS)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [][] arr = new int[n][2];
        int [] dp = new int[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
           arr[i][0] = Integer.parseInt(st.nextToken());
           arr[i][1] = Integer.parseInt(st.nextToken());
        }
        //A를 기준으로 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int max = 1;

        //증가수열
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i][1] > arr[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(n - max);
    }
}