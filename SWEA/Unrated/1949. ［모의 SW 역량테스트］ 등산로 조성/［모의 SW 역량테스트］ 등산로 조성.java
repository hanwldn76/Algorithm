import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N, K;
	static int[][] map;
	static boolean[][] visited;
	static List<int[]> bong = new ArrayList<>();
	static List<Integer> trailLst = new ArrayList<>();
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int maxTrail;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case<=T; test_case++) {
			bong.clear();
			
			int max = 0;
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] > max) max = map[i][j];
				}
			}
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(map[i][j] == max) {
						bong.add(new int[] {i, j});
					}
				}
			}
			trailLst.clear();
			
			for(int i = 0; i<bong.size(); i++) {
				maxTrail = 0;
				
				int[] b = bong.get(i);
				int x = b[0];
				int y = b[1];
				
				if(visited[x][y] == false) {
					visited[x][y] = true;
					dfs(x, y, 1, map[x][y], K);
					visited[x][y] = false;
				}
				trailLst.add(maxTrail);
				trailLst.sort(null);
			}
			System.out.println("#"+test_case+" "+trailLst.get(trailLst.size()-1));
		}
	}
	
	private static void dfs(int x, int y, int trails, int height, int k) {
		maxTrail = Math.max(maxTrail, trails);
		
		for(int d = 0; d<4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(!(nx >= 0 && nx < N && ny >= 0 && ny <N) || visited[nx][ny]) continue;
			
			if(k==0) {
				if(height > map[nx][ny]) {
					visited[nx][ny] = true;
					dfs(nx, ny, trails+1, map[nx][ny], k);
					visited[nx][ny] = false;
				}
			}else {
				if(height > map[nx][ny]) {
					visited[nx][ny] = true;
					dfs(nx, ny, trails+1, map[nx][ny], k);
					visited[nx][ny] = false;
				}else if(height > map[nx][ny]-k) {
					visited[nx][ny] = true;
					dfs(nx, ny, trails+1, height-1, 0);
					visited[nx][ny] = false;
				}
			}
		}
	}
}
