import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        double [] test = new double[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            test[i] = Integer.parseInt(st.nextToken());
        }

        //배열 정렬하여 최댓값 구하기
        Arrays.sort(test);
        double max = test[test.length -1];
        double sum =0;
        for (int i = 0; i < n; i++) {
            test[i] = test[i] / max * 100;
            sum+= test[i];
        }
        double result = sum/n;
        System.out.println(result);
    }
}