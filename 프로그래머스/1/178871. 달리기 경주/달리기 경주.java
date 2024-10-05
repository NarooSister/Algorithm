import java.util.HashMap;
import java.util.Map;

class Solution {
     public String[] solution(String[] players, String[] callings) {
       Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for(String calling : callings){
            int currentIdx = map.get(calling);
            if(currentIdx>0) {
                String frontPlayer = players[currentIdx - 1];

                players[currentIdx - 1] = calling;
                players[currentIdx] = frontPlayer;

                map.put(calling, currentIdx - 1);
                map.put(frontPlayer, currentIdx);
            }
        }
        return  players;
    }
}