import java.io.*;
import java.util.*;

/*
1. 입력
책의 개수 N , 한번에 들 수 있는 책의 개수 M
n개의 책의 위치

2. 출력
책을 모두 가져다 놓는 최소 걸음 수 출력

3. 문제 접근법
양수와 음수 나눠서 저장
둘 다 내림차순으로 정렬하여 가장 먼 책부터 옮길 수 있도록 한다.
마지막엔 돌아올 필요가 없으므로 가장 먼 거리를 마지막에 가야한다.
결과에서 가장 먼 거리에서 돌아오는 걸음 수를 빼준다.

 */
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
        int maxDistance = 0;

        if(!plus.isEmpty()){
            maxDistance = plus.get(0);
        }
        if(!minus.isEmpty()){
            maxDistance = Math.max(maxDistance, minus.get(0));
        }

        for (int i = 0; i < plus.size(); i+= m) {
            result += plus.get(i)*2;
        }
        for (int i = 0; i < minus.size(); i+= m) {
            result += minus.get(i)*2;
        }
        result -=maxDistance;
        System.out.println(result);
    }
}

