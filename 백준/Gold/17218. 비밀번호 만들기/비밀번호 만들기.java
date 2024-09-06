import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String A = br.readLine();
        String B = br.readLine();

        // LCS 사용
        // dp 배열에 저장하여 LCS(최장 공통 부분 수열)을 찾는다.
        // 인덱스를 저장해둔 뒤 찾아서 문자열로 출력한다.

        int lenA = A.length();
        int lenB = B.length();
        int [][] dp = new int[lenA+1][lenB+1];

        int max = 0; // LCS의 길이와 인덱스

        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB ; j++) {
                if(A.charAt(i-1)==B.charAt(j-1)){   //같은 문자를 만나면 이전 dp에 1 추가
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // 백트래킹하여 복원한다.
        // 오른쪽 아래 가장 끝인 dp[n][m]부터 복원
        int i = lenA;
        int j = lenB;
        while(i > 0 && j > 0){
            //문자가 같으면 결과를 추가하고 왼쪽 대각선 위로 한칸 이동한다.
            if(A.charAt(i-1) == B.charAt(j-1)){
                sb.append(A.charAt(i-1));
                i--;
                j--;
            }
            // 문자가 다른 경우
            // dp[i-1][j]와 같다면 i--로 가고
            // dp[i][j-1]과 같다면 j--로 간다
            else if(dp[i-1][j] == dp[i][j]){
                i--;
                //
            } else{
                j--;
            }
        }
        // 거꾸로 받았으므로 뒤집어준다.
        System.out.println(sb.reverse());
    }
}