import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int num;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int cnt;
	static List<Integer> res = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i<N; i++) {
			String tmp = br.readLine();
			for(int j = 0; j<N; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}
		num = 0;
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					cnt = 1;
					num++;
					bfs(i, j);
					res.add(cnt);
				}
			}
		}
		
		System.out.println(res.size());
		Collections.sort(res);
		for(int n : res) {
			System.out.println(n);
		}
	}
	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i, j});
		visited[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] node = q.poll();
			int x = node[0];
			int y = node[1];
			
			for(int dir = 0; dir<4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				if(!(nx>=0 && nx<N && ny>=0 && ny<N)) continue;
				if(visited[nx][ny] || map[nx][ny]==0) continue;
				
				q.add(new int[] {nx, ny});
				visited[nx][ny] = true;
				map[nx][ny] = num;
				cnt++;		
			}
		}	
	}
}