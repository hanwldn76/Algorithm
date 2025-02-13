import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int res;
	static List<int[]> tomato = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					tomato.add(new int[] {i,j});
				}
			}
		}
		
		res = 0;
		
		BFS();
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j] == 0) {
					res = -1;
					break;
				}
			}
			if(res==-1) break;
		}
		
		System.out.println(res);
	}

	private static void BFS() {
		Queue<int[]> q = new LinkedList<>();
		// x, y, day
		for(int[] t : tomato) {
			q.add(new int[] {t[0], t[1], 0});
			visited[t[0]][t[1]] = true;
		}
		
		while(!q.isEmpty()) {
			int[] node = q.poll();
			int x = node[0];
			int y = node[1];
			int day = node[2];
			
			for(int dir = 0; dir<4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				if(!(nx>=0 && nx<N && ny>=0 && ny<M)) continue;
				if(visited[nx][ny] || map[nx][ny]==-1) continue;
				
				q.add(new int[] {nx, ny, day+1});
				visited[nx][ny] = true;
				map[nx][ny] = map[x][y]+1;
				res = Math.max(res, day+1);
			}
		}
	}
}