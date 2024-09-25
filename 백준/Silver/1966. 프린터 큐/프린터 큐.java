import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // Deque에 문서의 인덱스와 중요도를 같이 저장한다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Deque<int[]> deque = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());

            // 문서의 인덱스와 중요도 저장
            for (int j = 0; j < n; j++) {
                deque.offer(new int[]{j, Integer.parseInt(st.nextToken())});
            }

            int count = 0;  // 인쇄 순서

            // 다 비울 때까지
            while (!deque.isEmpty()){
                int[] current = deque.poll();   // 첫번째 문서
                boolean isPrinted = true;   // 인쇄 되었는지
                
                // 현재 큐의 가장 앞에 있는 문서의 중요도 확인하고
                // 높은 문서가 하나라도 있다면 인쇄하지 않고 뒤에 재배치
                for (int[] document : deque){
                    if(document[1] > current[1]){
                        deque.offer(current);
                        isPrinted = false;
                        break;
                    }
                }
                
                // 현재 문서가 인쇄된 경우
                if(isPrinted){
                    count++;    // 현재 문서 인쇄 count;
                    if(current[0] == m){    // 궁금한 문서 m 일 경우 출력하고 종료
                        System.out.println(count);
                        break;
                    }
                }
            }
        }
    }
}
