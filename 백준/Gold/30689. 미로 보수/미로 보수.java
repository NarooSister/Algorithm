import java.util.*;

public class Main {
    static int N, M;
    static char[][] directions;
    static int[][] costs;
    static boolean[][] visited; 
    static boolean[][] done;
    static int totalMinCost = 0;
    static Map<Character, int[]> directionMap = Map.of(
            'U', new int[]{-1, 0},
            'D', new int[]{1, 0},
            'L', new int[]{0, -1},
            'R', new int[]{0, 1}
    );

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        directions = new char[N][M];
        costs = new int[N][M];
        visited = new boolean[N][M];
        done = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            directions[i] = sc.next().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                costs[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!done[i][j]) {
                    dfs(i, j);
                }
            }
        }

        System.out.println(totalMinCost);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        int[] dir = directionMap.get(directions[x][y]);
        int nx = x + dir[0];
        int ny = y + dir[1];

        if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
            done[x][y] = true;
        } else if (!done[nx][ny]) {
            if (!visited[nx][ny]) {
                dfs(nx, ny);
            } else if (visited[nx][ny] && !done[nx][ny]) {
                int cx = nx, cy = ny;
                int minCost = Integer.MAX_VALUE;
                do {
                    minCost = Math.min(minCost, costs[cx][cy]);
                    int[] nextDir = directionMap.get(directions[cx][cy]);
                    cx += nextDir[0];
                    cy += nextDir[1];
                } while (cx != nx || cy != ny);
                totalMinCost += minCost;
            }

            done[x][y] = true;
        }

        visited[x][y] = false;
    }
}
