import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            List<int[]> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }
            // 서류심사 성적 오름차순 정렬
            list.sort(Comparator.comparingInt(a -> a[0]));
            int result = 1;
            int minRank = list.get(0)[1];

            for (int j = 1; j < n; j++) {
                if(list.get(j)[1] < minRank){
                    result++;
                    minRank = list.get(j)[1];
                }
            }
            System.out.println(result);
        }
    }
}

