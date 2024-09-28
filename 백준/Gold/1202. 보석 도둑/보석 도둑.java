import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1. 입력
보석의 개수 N, 상덕이의 가방 개수 K
N 줄 동안 ... 각 보석의 정보 M, 가격 V
K 줄 동안 ... 가방에 담을 수 있는 최대 무게 C

2. 출력
훔칠 수 있는 보석 가격의 합의 최댓값

3. 문제 접근법
보석의 무게, 가격을 저장한 뒤 무게 순으로 정렬
가방도 무게 순으로 정렬
우선순위 큐를 이용하여 가격이 높은 보석을 우선으로 담기
각 가방에 가격이 높은 우선부터 넣기
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<int[]> gemInfo = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());  // 보석 무게
            int cost = Integer.parseInt(st.nextToken());    // 모석 가치
            gemInfo.add(new int[]{weight, cost});
        }
        int [] bagWeight = new int[k];
        for (int i = 0; i < k; i++) {
            bagWeight[i] = Integer.parseInt(br.readLine()); // 가방 무게
        }

        // 보석 무게 순으로 오름차순
        gemInfo.sort(Comparator.comparingInt(a -> a[0]));
        // 가방 무게 순으로 오름차순
        Arrays.sort(bagWeight);

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); // 가치가 큰 순부터 내림차순
        long result = 0; // 총 가치의 합
        int index = 0;  // 보석의 인덱스
        for(int a : bagWeight){
            while(index< n && gemInfo.get(index)[0] <= a){  // index로 가져온 보석 무게가 가방 무게보다 작을 동안에
                queue.offer(gemInfo.get(index)[1]); // 해당하는 보석가치를 우선순위큐에 추가
                index++;
            }
            if(!queue.isEmpty()){
                result += queue.poll(); // 가장 가치가 큰 보석을 가방에 넣기
            }
        }
        System.out.println(result);
    }
}

