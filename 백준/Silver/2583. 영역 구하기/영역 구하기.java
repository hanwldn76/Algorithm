import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int M, N, K;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int res = 0;
	static List<Integer> lst = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		visited = new boolean[M][N];
		
		for(int i = 0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int lx = Integer.parseInt(st.nextToken());
			int ly = Integer.parseInt(st.nextToken());
			int rx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());
			
			for(int r = ly; r<ry; r++) {
				for(int c = lx; c<rx; c++) {
					map[r][c] = 1;
				}
			}
		}
		
		int cnt = 0;
		
		
		for(int i = 0; i<M; i++) {
			for(int j = 0; j<N; j++) {
				if(map[i][j]==0 && !visited[i][j]) {
					bfs(i,j);
					cnt++;
					lst.add(res);
					
					res = 0;
				}
			}
		}
		System.out.println(cnt);
		lst.sort(null);
		for(int i: lst) {
			System.out.print(i+" ");
		}
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {i,j});
		visited[i][j] = true;
		res++;
		
		while(!q.isEmpty()) {
			int[] node = q.poll();
			int x = node[0];
			int y = node[1];
			
			for(int dir = 0; dir<4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				if(!(nx>=0 && nx<M && ny>=0 && ny<N)) continue;
				if(map[nx][ny]==1 || visited[nx][ny]) continue;
				
				q.add(new int[] {nx, ny});
				visited[nx][ny] = true;
				map[nx][ny] = 1;
				res++;
			}
		}	
	}
}