import java.io.*;
import java.util.*;

/*
1. 입력
테스트케이스 T
... 각 T마다 3줄동안
체스판 한 변의 길이 l
현재 나이트가 있는 칸 좌표 (x, y)
나이트가 이동하려는 칸 (x1, y1)

2. 출력
각 T마다 최소 몇 번만에 이동할 수 있는지

3. 문제 접근법
최단거리를 구하는 문제기 때문에 BFS로 해결
queue에 넣을 때 new int[]{x,y,count}로 움직인 횟수까지 넣어준다.

 */
public class Main {
    static int [] dx = {2, 1, -1, -2, -2, -1, 1, 2 };
    static int [] dy = {1, 2, 2, 1, -1, -2, -2, -1 };
    static boolean[][] visited;
    static int l, resultX, resultY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            l = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            resultX = Integer.parseInt(st.nextToken());
            resultY = Integer.parseInt(st.nextToken());

            visited = new boolean[l][l];
            bw.write(bfs(startX, startY)+"\n");
        }
        bw.flush();
        bw.close();
    }
    static int bfs(int startX, int startY){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            int moveCount = now[2];
            if(nowX == resultX && nowY == resultY){
                return moveCount;
            }
            for (int i = 0; i < 8; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if( nextX<0 || nextY<0  || nextX>=l || nextY>=l) continue;
                if(visited[nextX][nextY]) continue;
                queue.add(new int[]{nextX, nextY, moveCount+1});
                visited[nextX][nextY] = true;
            }
        }
        return -1;
    }
}

