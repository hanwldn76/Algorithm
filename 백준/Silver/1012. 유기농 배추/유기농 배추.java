import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int M, N, K;
	static int[][] map;
	static boolean[][] visited;
	static int count;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case<=T; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			count = 0;
			
			for(int i = 0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				
				map[x][y] = 1;
			}
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					if(map[i][j]==1 && !visited[i][j]) {
						bfs(i, j);
						count++;
					}
				}
			}
			
			System.out.println(count);
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
				
				if(!(nx>=0 && nx<N && ny>=0 && ny<M)) continue;
				if(visited[nx][ny] || map[nx][ny]==0) continue;
				
				q.add(new int[] {nx, ny});
				visited[nx][ny] = true;
				map[nx][ny] = 0;
			}
		}	
	}
}