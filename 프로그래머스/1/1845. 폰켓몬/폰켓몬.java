import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        int max = nums.length/2 ;
        return Math.min(set.size(), max);
    }
}