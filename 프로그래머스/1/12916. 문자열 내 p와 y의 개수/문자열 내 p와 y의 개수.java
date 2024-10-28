class Solution {
    boolean solution(String s) {
        boolean answer = true;
        s = s.toLowerCase();
        int pCount = 0;
        int yCount = 0;
        for(int i =0; i < s.length(); i++){
            if(s.charAt(i)=='p') pCount++;
            if(s.charAt(i)=='y') yCount++;
        }
        
        return (pCount == yCount) ? true : false;
    }
}