import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		dp = new int[N+1][N+1];
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=i; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for(int[] i: dp) {
//			System.out.println(Arrays.toString(i));
//		}
		
		for(int i = N-1; i>=1; i--) {
			for(int j = i; j>=1; j--) {
				dp[i][j] += Math.max(dp[i+1][j], dp[i+1][j+1]);
			}
		}
		
//		for(int[] i: dp) {
//			System.out.println(Arrays.toString(i));
//		}
		
		System.out.println(dp[1][1]);
	}
}
