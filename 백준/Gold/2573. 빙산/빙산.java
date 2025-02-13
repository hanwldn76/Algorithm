import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static List<int[]> ice;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int time;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 빙산은 동서남북 인접한 부분이 있으면 1년마다 그만큼 녹음
		// 빙산이 두덩어리 이상으로 분리되는 최초의 시간을 구해야함 
		// 빙산이 전부 다 녹을때까지 두 덩어리 이상으로 분리되지 않으면 프로그램은 0을 출력 
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		ice = new ArrayList<>();
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]!=0) ice.add(new int[] {i,j});
			}
		}
		
		time = 0;
		int res = 0;
		
		while(true) {
			int cnt = 0;
			execute();
//			System.out.println(Arrays.deepToString(map));
			
			time++;
			visited = new boolean[N][M];
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					if(map[i][j]!=0 && !visited[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}
//			System.out.println(cnt);
			
			if(cnt>=2) {
				res = time;
				break;
			}
			if(cnt==0) {
				res = 0;
				break;
			}
		}
		
		System.out.println(res);
		

	}
	
	//빙산이 쪼개진 갯수를 세는 함수 
	private static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
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
				if(visited[nx][ny]) continue;
				if(map[nx][ny]==0) continue;
				
				q.add(new int[] {nx, ny});
				visited[nx][ny] = true;			
			}
		}
	}

	private static void execute() {
		boolean[][] visited2 = new boolean[N][M];
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j]==0) continue;
				visited2[i][j] = true;
				
				for(int dir = 0; dir<4; dir++) {
					int nx = i + dx[dir];
					int ny = j + dy[dir];
					
					if(!(nx>=0 && nx<N && ny>=0 && ny<M)) continue;
					if(map[nx][ny]!=0) continue;
					if(visited2[nx][ny]) continue;
					
					map[i][j]--;
					if(map[i][j]<=0) break;
				}
			}
		}
	}
}
