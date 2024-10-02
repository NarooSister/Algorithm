import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1. 입력
문자열 1
문자열 2
문자열 3

2. 출력
첫번째, 두번째, 세 번째 문자열의 LCS 길이 출력

3. 풀이
3차원 배열 dp에 저장하며 LCS를 구한다.

*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        int lenA = a.length();
        int lenB = b.length();
        int lenC = c.length();
        int [][][]dp = new int[lenA+1][lenB+1][lenC+1];

        for (int i = 1; i <=lenA ; i++) {
            for (int j = 1; j <= lenB; j++) {
                for (int k = 1; k <= lenC; k++) {
                    // 만약 세 문자가 같다면 이전 dp에서 +1 해준다.
                    if(a.charAt(i-1)==b.charAt(j-1) && b.charAt(j-1)==c.charAt(k-1)){
                        dp[i][j][k] = dp[i-1][j-1][k-1] +1;
                    } else{
                        // 다르다면 각각의 인덱스에서 이전값 중에 최댓값을 가져온다.
                        dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
                    }
                }
            }
        }
        System.out.println(dp[lenA][lenB][lenC]);
    }
}