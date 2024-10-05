import java.util.*;
class Solution {
     public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i],0)+1);
        }
        for(String name : completion) {
            map.put(name, map.get(name) - 1);
            if (map.get(name) == 0) {
                map.remove(name);
            }
        }
        return map.keySet().iterator().next();
    }
}