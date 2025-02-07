import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    static int[] dp;
    
    public long solution(int n) {
        long answer = 0;

		dp = new int[n+2];
		dp[1] = 1;
		dp[2] = 2;
        
        for(int i = 3; i<=n; i++) {
			dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
		}
        
        return dp[n];
    }
}