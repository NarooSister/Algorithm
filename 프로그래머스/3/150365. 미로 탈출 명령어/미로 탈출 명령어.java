import java.util.*;

class Solution {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static char[] directions = {'d', 'l', 'r', 'u'};

    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {        
        StringBuilder sb = new StringBuilder();
        
        // 거리가 k일 때 탈출할 수 없는 경우(거리 불가능)
        int dist = Math.abs(x-r) + Math.abs(y-c);
        if(dist > k || (k-dist) % 2 != 0){
            return "impossible";
        }

        int startX = x, startY = y;
        
        for(int i = 0; i < k; i++){
            boolean moved = false;
            
            for(int j = 0; j < 4; j++){
                int nx = startX + dx[j];
                int ny = startY + dy[j];
                
                if (nx >= 1 && nx <= n && ny >= 1 && ny <= m) {
                    int remainDist = Math.abs(nx - r) + Math.abs(ny - c);
                    
                    if(remainDist <= (k - i - 1)){
                        sb.append(directions[j]);
                        startX = nx;
                        startY = ny;
                        moved = true;
                        break;
                    }
                }
            }
            if(!moved){
                return "impossible";
            }
        }
        
        return sb.toString();
    }
}