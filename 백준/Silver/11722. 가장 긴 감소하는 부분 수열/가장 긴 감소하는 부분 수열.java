import java.io.*;
import java.util.*;

/*
1. 입력
수열 A의 크기 n
수열 A

2. 출력
A의 합이 가장 큰 증가하는 부분 수열의 합

3. 풀이
가장 긴 감소하는 부분 수열을 dp로 구한다.

*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int[n];
        int [] save = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = n-1; i >= 0; i--) {
            save[i] = 1;
            for (int j = n-1; j >= i; j--) {
                if(arr[i] > arr[j]){
                    save[i] = Math.max(save[i], save[j]+1);
                }
            }
            max = Math.max(max, save[i]);
        }
        System.out.println(max);
    }
}
