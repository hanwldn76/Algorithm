import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[] selected;
	static List<int[]> chicken = new ArrayList<>();
	static List<int[]> home = new ArrayList<>();
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) chicken.add(new int[] {i, j});
				else if(map[i][j]==1) home.add(new int[] {i, j});
			}
		}
		selected = new boolean[chicken.size()];
		
		dfs(0, 0);
		
		System.out.println(min);
	}

	private static void dfs(int idx, int depth) {
		if(depth == M) {
			count();
			return;
		}
		for(int i = idx; i<chicken.size(); i++) {
			selected[i] = true;
			dfs(i+1, depth+1);
			selected[i] = false;
		}
		
	}

	private static void count() {
		int totalDistance = 0;
		
		for(int i = 0; i<home.size(); i++) {
			int minDistance = Integer.MAX_VALUE;
			int[] h = home.get(i);
			for(int j = 0; j<chicken.size(); j++) {
				if(!selected[j]) continue;
				
				int[] c = chicken.get(j);
				
				int distance = Math.abs(h[0]-c[0]) + Math.abs(h[1]-c[1]);
				minDistance = Math.min(minDistance, distance);
			}
			totalDistance += minDistance;
		}
		
		min = Math.min(totalDistance, min);
	}
}