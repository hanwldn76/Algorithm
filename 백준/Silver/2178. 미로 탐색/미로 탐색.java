import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static boolean[][] visited;
	static int N, M;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i<N; i++) {
			String[] tmp = br.readLine().split("");
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
		res = 1;
		
		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0});
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] node = q.poll();
			int x = node[0];
			int y = node[1];
			
			if(x == N-1 && y == M-1) return map[x][y];
			
			for(int dir = 0; dir<4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				if(!(nx>=0 && nx<N && ny>=0 && ny<M)) continue;
				if(visited[nx][ny] || map[nx][ny]==0) continue;
				
				q.add(new int[] {nx, ny});
				visited[nx][ny] = true;
				map[nx][ny] = map[x][y] + 1;
			}
		}
		return -1;
	}
}
