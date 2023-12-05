class Solution {
    public int solution(int a, int b) {
String aA = Integer.toString(a);
String bB = Integer.toString(b);
 if(Integer.parseInt(aA+bB)>=Integer.parseInt(bB+aA)){
     return Integer.parseInt(aA+bB);
 } else{
     return Integer.parseInt(bB+aA);
 }
 }
}