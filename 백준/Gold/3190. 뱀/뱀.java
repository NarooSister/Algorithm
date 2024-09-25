import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //방향 배열
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());    // 보드의 크기
        int k = Integer.parseInt(br.readLine());    // 사과의 개수
        StringTokenizer st;

        int [][] board = new int[n][n];     // 보드 배열
        // 사과가 있는 칸은 1로 표현
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
        }

        int l = Integer.parseInt(br.readLine());    // 방향 전환 횟수
        Map<Integer, Character> directionMap = new HashMap<>();

        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            directionMap.put(x, c.charAt(0));  // 방향 정보 저장
        }

        // 뱀의 초기 위치 설정
        Deque<int[]> snake = new ArrayDeque<>();
        snake.offer(new int[]{0,0});    // 뱀의 시작 위치
        int direction = 0;  // 최초 방향
        int time = 0;       // 시간
        int x = 0, y = 0;   // 뱀의 머리 위치

        // 게임 진행
        while(true){
            time++;

            x += dx[direction];
            y += dy[direction];

            // 게임 종료 상황
            if(x<0 || x>=n || y<0 || y>=n || isMine(snake, x, y)){
                break;
            }
            // 사과가 있다면 : 사과 먹고 꼬리 그대로
            if(board[x][y] == 1){
                board[x][y] = 0;
                snake.offerFirst(new int[]{x,y});
            } else {    // 사과가 없다면 : 꼬리 하나 쪽 제거
                snake.offerFirst(new int[]{x,y});
                snake.pollLast();
            }

            // 방향 전환 시간
            if(directionMap.containsKey(time)){
                char c = directionMap.get(time);
                if(c == 'L'){   // 왼쪽으로 90도 회전
                    direction = (direction + 3) % 4;
                } else if(c == 'D'){
                    direction = (direction + 1 ) % 4;
                }
            }
        }
        System.out.println(time);
    }

    // 자신의 몸과 충돌하는지 확인하는 함수
    static boolean isMine(Deque<int[]>snake, int x, int y){
        for(int[] body : snake){
            if(body[0] == x && body[1] == y){
                return true;
            }
        }
        return false;
    }
}
