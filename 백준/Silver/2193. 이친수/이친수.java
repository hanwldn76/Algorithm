import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static long[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		dp = new long[N+2][2];
		
		dp[1][1] = 1;
		dp[2][0] = 1;
		dp[2][1] = 0;
			
		for(int i = 3; i<=N; i++) {
			dp[i][0] = dp[i-1][0]+dp[i-1][1];
			dp[i][1] = dp[i-1][0];
		}
		

		// [본인][나의상황] 
		// [3][0] => 내가 0일때 내앞에 올 수 있는 경우는 2가 0일때, 2가 1일때 
		// [3][1] => 내가 1일때 내앞에 올 수 있는 경우는 2가 0일때 
		// [4][0] => 내가 0일때 내앞에 올 수 있는 경우는 3이 0일때, 3이 1일때 
		// [4][1] => 내가 1일때 내앞에 올 수 있는 경우는 3이 0일때
		
		System.out.println(dp[N][0]+dp[N][1]);
		
	}

}
