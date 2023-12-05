class Solution {
    public int solution(int a, int b) {
        String A = String.valueOf(a);
        String B = String.valueOf(b);

        return Math.max(Integer.parseInt(A+B), 2*a*b);
    }
}