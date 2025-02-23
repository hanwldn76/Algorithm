import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		// 0과 1이 몇번 리턴되는지
		// dp에 0과 1이 몇번 호출되었는지 저장
		dp = new int[41][2];
		
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		for(int i = 2; i<41; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-2][0];
			dp[i][1] = dp[i-1][1] + dp[i-2][1];
		}
		
		for(int test_case = 1; test_case<=T; test_case++) {
			int tmp = Integer.parseInt(br.readLine());
			
			
			sb.append(dp[tmp][0]).append(" ").append(dp[tmp][1]).append("\n");
		}
		
		System.out.print(sb);
	}
}