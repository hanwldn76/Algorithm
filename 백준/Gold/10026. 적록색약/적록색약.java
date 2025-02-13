import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static char[][] map;
	static boolean[][] visited;
	static int cnt;
	static int N;
	static char[] colors = {'R', 'G', 'B'};
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		
		
		for(int i = 0; i<N; i++) {
			String tmp = br.readLine();
			for(int j = 0; j<N; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		
		cnt = 0;
		visited = new boolean[N][N];
		int bCnt = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(!visited[i][j] && map[i][j]=='B') {
					bfs('B', i, j);
					cnt++;
					bCnt++;
				}else if(!visited[i][j] && map[i][j]=='R') {
					bfs('R', i, j);
					cnt++;
				}else if(!visited[i][j] && map[i][j]=='G') {
					bfs('G', i, j);
					cnt++;
				}
			}
		}
		System.out.print(cnt+" ");
		
		cnt = 0;
		visited = new boolean[N][N];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(!visited[i][j] && (map[i][j]=='R'||map[i][j]=='G')) {
					bfs('X', i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt+bCnt);
		
	}
	private static void bfs(char color, int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i,j});
		visited[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] node = q.poll();
			int x = node[0];
			int y = node[1];
			
			for(int dir = 0; dir<4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				if(!(nx>=0 && nx<N && ny>=0 && ny<N)) continue;
				
				if(color=='X') {
					if(visited[nx][ny] || map[nx][ny] == 'B') continue;
				}else {
					if(visited[nx][ny] || map[nx][ny] != color) continue;
				}
				
				q.add(new int[] {nx,ny});
				visited[nx][ny] = true;
			}
		}	
	}
}
