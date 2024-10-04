import java.io.*;
import java.util.*;

/*
1. 입력
작업 개수 N
... n 줄 동안
작업에 걸리는 시간, 선행 관계에 있는 작업들의 개수, 선행관계에 있는 작업들의 번호

2. 출력

3. 풀이
위상 정렬을 사용해 해결할 수 있다.
작업 간의 선행관계를 그래프로 표현한다.
선행 작업이 없는 작업들을 큐에 넣고 하나씩 꺼내서 처리하면서,
후속 작업들의 진입 차수(선행작업 개수)를 감소시킨다.
모든 작업이 끝나면, 각 작업이 완료되는 최소시간 배열에서 가장 큰 값을 가져온다.

*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] workTime = new int[n+1]; // 소요 시간
        int [] indegree = new int[n+1]; // 각 작업의 진입 차수 = 선행 작업의 개수
        List<Integer>[] graph = new ArrayList[n+1]; // 작업 선행관계 그래프
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            workTime[i] = Integer.parseInt(st.nextToken());
            int preWorkNum = Integer.parseInt(st.nextToken());
            for (int j = 0; j < preWorkNum; j++) {  // 선행 작업이 있는 경우에
                int preWork = Integer.parseInt(st.nextToken());
                graph[preWork].add(i);  // 선행작업에 현재 작업 추가
                indegree[i]++;  // 진입 차수 증가
            }
        }
        System.out.println(TSort(graph, indegree, workTime, n));
    }

    // 최소 시간을 반환하는 위상 정렬
    static int TSort(List<Integer>[] graph, int [] indegree, int [] workTime, int n){
        int[] result = new int[n+1];    // 각 작업에 걸리는 최소 시간
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n ; i++) {
            if(indegree[i] == 0){   // 선행 작업이 없는 경우 넣어줄 큐
                queue.offer(i);
                result[i] = workTime[i];    // 선행 작업이 없으면 해당 작업 시간으로 초기화
            }
        }

        while(!queue.isEmpty()){
            int current = queue.poll(); // 현재 작업
            for(int next : graph[current]){
                indegree[next]--;   // 차수를 줄이면서(선행 작업 개수를 줄이면서) 탐색한다.
                result[next] = Math.max(result[next], result[current] + workTime[next]);    // 완료 시간 최댓값으로 갱신
                if(indegree[next] == 0){  // 선행작업이 0개가 되면
                    queue.offer(next);  // 큐에 넣어 작업 시작
                }
            }
        }
        int maxTime = 0;    // 전체 작업을 완료하는데 걸리는 시간
        for (int i = 1; i <= n; i++) {
            maxTime = Math.max(maxTime, result[i]);
        }
        return maxTime;
    }
}
