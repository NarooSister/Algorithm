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
        int money = Integer.parseInt(st.nextToken());
        Integer [] coins = new Integer[n];
        int count = 0;

        for (int i = 0; i <n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        //가장 가치가 큰 돈부터 선택
        Arrays.sort(coins, Comparator.reverseOrder());

        // 돈의 가치가 남은 돈보다 크다면 다음으로 작은 돈을 선택
        for (int i = 0; i < coins.length; i++) {
            count += money / coins[i];
            money %= coins[i];
        }

        // 합이 일치하면 동전 갯수의 최솟값 출력
        if(money ==0){
            System.out.println(count);
        }
    }
}