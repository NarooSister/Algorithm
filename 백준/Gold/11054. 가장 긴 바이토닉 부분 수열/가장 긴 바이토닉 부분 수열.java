import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n + 1];
        int [] inDp = new int[n + 1];
        int [] deDp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //증가수열
        for (int i = 0; i < n; i++) {
            inDp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    inDp[i] = Math.max(inDp[i], inDp[j] + 1);
                }
            }
        }

        //감소수열
        for (int i = n - 1; i >= 0; i--) {
            deDp[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    deDp[i] = Math.max(deDp[i], deDp[j] + 1);
                }
            }
        }

        int max = 1;
        //바이토닉 수열 = 증가수열 + 감소수열 - 1
        for (int i = 0; i < n; i++) {
            if(inDp[i] + deDp[i] -1 > max) {
                max = inDp[i] + deDp[i] - 1;
            }
        }

        System.out.println(max);
    }
}