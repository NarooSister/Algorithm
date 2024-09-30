import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
1. 입력
10*10 배열

2. 출력
필요한 최소 소의 수

3. 문제 접근법
B, L, R 의 위치를 찾은 뒤
B에서 L로 가는 최단 경로를 찾는다.
최소 탐색이 필요하므로 BFS 사용

 */
public class Main {
    static char[][] farm = new char[10][10];
    static boolean[][] visited = new boolean[10][10];
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[] barn = new int[2];
    static int[] lake = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            String str = br.readLine();
            for (int j = 0; j < 10; j++) {
                farm[i][j] = str.charAt(j);
                if(farm[i][j] == 'B'){
                    barn[0] = i;
                    barn[1] = j;
                } else if (farm[i][j] == 'L'){
                    lake[0] = i;
                    lake[1] = j;
                }
            }
        }
        System.out.println(bfs());
    }

    static int bfs(){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{barn[0], barn[1], 0});
        visited[barn[0]][barn[1]] = true;

        while(!queue.isEmpty()){
            int [] current = queue.poll();
            // 현재 위치가 호수일 때 거리 반환하기
            if(current[0] == lake[0] && current[1] == lake[1]){
                return current[2] -1;   // 거리 구하기
            }
            // 네 방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if(nx<0 || ny<0 || nx>=10 || ny>=10) continue;  // 경계 설정
                if(visited[nx][ny] || farm[nx][ny] == 'R') continue;    // 방문했거나, 돌일 때

                queue.add(new int[]{nx, ny, current[2]+1});
                visited[nx][ny] = true;
            }
        }
        return -1;
    }
}

