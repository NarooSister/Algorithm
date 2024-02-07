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
        int [] time = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        //가장 적게 걸리는 시간부터 시작한다.
        Arrays.sort(time);

        int sum = 0;            //이전까지의 총 대기시간
        int eachSum = 0;        //개인별 총 대기시간


        for (int i = 0; i < n; i++) {
            // 이전까지의 대기시간과 현재 사람이 걸리는 시간을 더해준다.
            eachSum += sum + time[i];
            // 이전까지의 대기시간에 현재 걸리는 시간을 더해준다.
            sum += time[i];
        }
        System.out.println(eachSum);
    }
}