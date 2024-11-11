import java.util.*;

class Solution {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static char[] directions = {'d', 'l', 'r', 'u'};
    static boolean found = false;
    String answer = "";
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {        
        // 거리가 k일 때 탈출할 수 없는 경우(거리 불가능)
        int dist = Math.abs(x-r) + Math.abs(y-c);
        if(dist > k || (k-dist) % 2 != 0){
            return "impossible";
        }
        
        dfs(n, m, x, y, r, c, k, "");
        
        return answer;
    }
    
    void dfs(int n, int m, int x, int y, int r, int c, int k, String path){
        if(found) return;
        
        if(path.length() == k){
            if(x == r && y == c){
                answer = path;
                found = true;
            }
            return;
        }
        
        // 네 방향 탐색
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 격자 조건 확인
            if(nx >= 1 && nx <= n && ny >= 1 && ny <= m){
                if(Math.abs(nx-r) + Math.abs(ny-c) <= k - path.length() -1){
                    dfs(n, m, nx, ny, r, c, k, path + directions[i]);
                }
            }
        }
    }
}