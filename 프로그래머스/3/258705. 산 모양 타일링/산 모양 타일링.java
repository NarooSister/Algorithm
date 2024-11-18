
class Solution {
    public int solution(int n, int[] tops) {
        int[] dp = new int[n];
        int[] nextDp = new int[n];
        
        dp[0] = 1;
        nextDp[0] = 2 + tops[0];
        
        for(int i= 1; i <n; i++){
            dp[i] = (dp[i-1] + nextDp[i-1]) % 10007;
            nextDp[i] = ((dp[i-1] * (1 + tops[i])) + nextDp[i-1]*(2 + tops[i])) %10007;
        }
        
        return (dp[n-1] + nextDp[n-1]) % 10007;
    }
}