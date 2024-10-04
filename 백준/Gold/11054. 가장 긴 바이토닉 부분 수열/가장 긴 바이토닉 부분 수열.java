import java.io.*;
import java.util.StringTokenizer;

/*
1. 입력
수열의 크기 n
수열 A

2. 출력
가장 긴 바이토닉 수열의 길이

3. 풀이
가장 긴 바이토닉 부분 수열 구하기 :
증가 수열 (0->n으로 탐색) + 감소수열 (n->0으로 탐색) -1 (자기 자신이 두번 들어가므로 1 빼줌)

*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] inArr = new int[n];
        int[] deArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 증가 수열 구하기
        for (int i = 0; i < n; i++) {
            inArr[i] = 1;
            for (int j = 0; j <i ; j++) {
                if(arr[i] > arr[j]){
                    inArr[i] = Math.max(inArr[i], inArr[j] +1);
                }
            }
        }

        // 감소 수열 구하기
        for (int i = n-1; i >= 0; i--) {
            deArr[i] = 1;
            for (int j = n-1; j > i; j--) {
                if(arr[i] > arr[j]){
                    deArr[i] = Math.max(deArr[i], deArr[j] +1);
                }
            }
        }

        int max = 1;
        for (int i = 0; i < n; i++) {
            int sum = inArr[i] + deArr[i] -1;
            if(sum > max){
                max = sum;
            }
        }
        System.out.println(max);
    }
}
