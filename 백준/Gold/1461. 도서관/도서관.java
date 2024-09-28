import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int book = Integer.parseInt(st.nextToken());
            if(book>0) {
                plus.add(book);
            }else {
                minus.add(-book);
            }
        }
        
        Collections.sort(plus, Collections.reverseOrder()); // 내림차순
        Collections.sort(minus, Collections.reverseOrder());    // 내림차순

        int result = 0;
        // 한번에 두권씩 가져다둔다.
        for (int i = 0; i < plus.size(); i+= m) {
            // 두 권을 가져다 놓는 걸음 수 = 둘 중에 더 먼 책을 가져다 놓은 걸음 수
            // 따라서 2를 곱해주면 된다.
            result += plus.get(i)*2;    
        }
        for (int i = 0; i < minus.size(); i+= m) {
            result += minus.get(i)*2;
        }

        int maxDistance = 0;
        // 가장 먼 거리 구하기
        if(!plus.isEmpty()){
            maxDistance = plus.get(0);
        }
        if(!minus.isEmpty()){
            maxDistance = Math.max(maxDistance, minus.get(0));
        }
        result -=maxDistance;   // 마지막에 가장 먼 거리를 빼준다.
        
        System.out.println(result);
    }
}

