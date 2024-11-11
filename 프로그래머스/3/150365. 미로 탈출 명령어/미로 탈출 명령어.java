import java.util.*;

class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {        
        StringBuilder sb = new StringBuilder();
        
        // 거리가 k일 때 탈출할 수 없는 경우(거리 불가능)
        int dist = Math.abs(x-r) + Math.abs(y-c);
        
        if(dist > k || (k-dist) % 2 != 0){
            return "impossible";
        }

        while(k > 0){
            // d : 아래로 이동 가능한 경우
            if(x < n && k -1 >= Math.abs(x+1-r)+Math.abs(y-c)){
                sb.append('d');
                x++;
            }
            // l : 왼쪽으로 이동 가능한 경우
            else if(y > 1 && k-1 >= Math.abs(x-r)+Math.abs(y-1-c)){
                sb.append('l');
                y--;
            }
            // r : 오른쪽으로 이동 가능한 경우
            else if(y < m && k-1 >= Math.abs(x-r)+Math.abs(y+1-c)){
                sb.append('r');
                y++;
            }
            // u : 위쪽으로 이동 가능한 경우
            else if(x > 1 && k-1 >= Math.abs(x-1-r)+Math.abs(y-c)){
                sb.append('u');
                x--;
            }
            // 마지막에 남은 이동 횟수를 감소
            k--;
        }
        
        
        return sb.toString();
    }
}