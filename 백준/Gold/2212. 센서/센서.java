import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
1. 입력
센서의 개수 n
최대 집중국 개수 k
센서의 좌표 정수

2. 출력
각 집중국의 수신 가능영역의 거리의 합의 최솟값

3. 풀이
<1 3> <6 6 7 9> 2+3 = 7
가장 간격이 큰 곳을 기준으로 나눈뒤 각각 집중국을 세운다.
k개의 집중국을 세워야 하므로 k-1개로 나눈다.
간격의 배열을 구해 큰 수부터 k-1개를 제거하고 나머지를 더하면 된다.

예제의 간격 배열은
2,3,0,1,2 이고 가장 큰 1개(k-1)를 지우면 2+0+1+2 = 5 이다.


*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] s = new int[n];
        int[] distance = new int[n-1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(s);

        for (int i = 0; i < n - 1; i++) {
            distance[i] = s[i+1]-s[i];
        }
        Arrays.sort(distance);

        int result = 0;
        for (int i = 0; i < n-k; i++) {
            result += distance[i];
        }

        System.out.println(result);
    }
}
