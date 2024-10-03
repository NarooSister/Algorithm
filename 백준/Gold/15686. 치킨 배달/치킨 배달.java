import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1. 입력
N, M
N개의 줄에 도시의 정보

2. 출력
폐업시키지 않을 치킨집을 최대 M개 골랐을 때 도시의 치킨 거리의 최솟값 출력

3. 풀이
문제의 조건에 따라 분기를 나누면서 푼다.
1. 현재 칸이 아직 청소되지 않은 경우 -> 청소
2. 주변 칸 중 청소되지 않은 빈 칸이 있는 경우
3. 주변 칸 중 청소되지 않은 빈 칸이 없는 경우

*/
public class Main {
    static int[][] city;
    static List<int[]> chicken;
    static List<int[]> home;
    static boolean[] selected;
    static int n, m;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        city = new int[n][n];
        chicken = new ArrayList<>();
        home = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                } else if (city[i][j] == 1) {
                    home.add(new int[]{i, j});
                }
            }
        }
        selected = new boolean[chicken.size()];
        combination(0,0);
        System.out.println(result);
    }

    //도시의 치킨거리 구하기
    static int cityChickenDistance() {
        int totalDistance = 0;
        for (int[] h : home) {
            int distance = Integer.MAX_VALUE;
            for (int i = 0; i < chicken.size(); i++) {
                if (selected[i]) {
                    int[] nowChicken = chicken.get(i);
                    int currentDistance = Math.abs(h[0] - nowChicken[0]) + Math.abs(h[1] - nowChicken[1]);
                    distance = Math.min(distance, currentDistance);
                }
            }
            totalDistance += distance;
        }
        return totalDistance;
    }

    // 백트래킹 사용하여 m개의 치킨집을 선택하는 조합 구하기
    static void combination(int depth, int start) {
        if(depth == m){
            // m개를 선택했을 때 도시의 치킨거리 계산
            result = Math.min(result, cityChickenDistance());
            return;
        }
        // 백트래킹 : 치킨집을 고르고 조합을 구한다.
        for (int i = start; i < chicken.size() ; i++) {
            if(!selected[i]){
                selected[i] = true;
                combination(depth+1, i+1);
                selected[i] = false;
            }
        }
    }
}