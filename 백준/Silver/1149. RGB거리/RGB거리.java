import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][3];
        int R, G, B;
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());

        }

        for (int i = 1; i < n; i++) {
            R = arr[i][0];
            G = arr[i][1];
            B = arr[i][2];
            
            arr[i][0] = R + Math.min(arr[i-1][1], arr[i-1][2]);
            arr[i][1] = G + Math.min(arr[i-1][0], arr[i-1][2]);
            arr[i][2] = B + Math.min(arr[i-1][0], arr[i-1][1]);
        }
        System.out.println(Math.min(Math.min(arr[n-1][0], arr[n-1][1]), arr[n-1][2]));
    }
}