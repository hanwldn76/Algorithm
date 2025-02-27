import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		dp = new int[N+2];
		
		dp[1] = 1;
		dp[2] = 3;
		
		for(int i = 3; i<=N; i++) {			
			dp[i] = (dp[i-2]*2 + dp[i-1])%10007 ;
		}
		
		System.out.println(dp[N]%10007);
	}
}