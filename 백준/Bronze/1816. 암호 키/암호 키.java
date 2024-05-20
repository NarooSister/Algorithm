import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long[] s = new long[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            s[i] = Long.parseLong(st.nextToken());
            for (int j = 2; j < 1000001; j++) {
                if(s[i]%j ==0){
                    System.out.println("NO");
                    break;
                }
                if(j == 1000000){
                    System.out.println("YES");
                }
            }
        }

    }
}