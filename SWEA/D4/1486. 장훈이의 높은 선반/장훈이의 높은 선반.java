import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	static int N, B;
	static int[] height;
	static boolean[] visited;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case<=T; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			height = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			
			visited = new boolean[N];
			min = Integer.MAX_VALUE;
			
			dfs(0, 0);
			
			sb.append("#").append(test_case).append(" ").append(min-B).append("\n");
			
		}
		System.out.print(sb);

	}
	private static void dfs(int idx, int sum) {
		if(sum>=B) {
			min = Math.min(min, sum);
			return;
		}
		for(int i = idx; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i, sum+height[i]);
				visited[i] = false;
			}
		}	
	}
}