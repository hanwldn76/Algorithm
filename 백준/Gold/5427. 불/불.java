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
	static int w, h;
	static char[][] map;
	static boolean[][] visited;
	static List<int[]> fires;
	static int sx, sy;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case<=T; test_case++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			map = new char[h][w];
			visited = new boolean[h][w];
			fires = new ArrayList<>();
			
			for(int i = 0; i<h; i++) {
				String tmp = br.readLine();
				for(int j = 0; j<w; j++) {
					map[i][j] = tmp.charAt(j);
					if(map[i][j]=='@') {
						sx = i;
						sy = j;
					}else if(map[i][j]=='*') {
						fires.add(new int[] {i,j});
					}
				}
			}
			
			int res = bfs();
			if(res>0) System.out.println(res);
			else System.out.println("IMPOSSIBLE");
		}

	}

	private static int bfs() {
		// 0: 불 1: 상근
		Queue<int[]> q = new ArrayDeque<>();
		
		for(int[] f : fires) {
			q.add(new int[] {f[0],f[1], 0, 0});
			visited[f[0]][f[1]] = true;
		}
		
		q.add(new int[] {sx,sy,1,1});
		visited[sx][sy] = true;
		
		
		while(!q.isEmpty()) {
			int[] node = q.poll();
			int x = node[0];
			int y = node[1];
			int time = node[2];
			int state = node[3];
			
			if(state==1 && (x==0 || x==h-1 || y==0 || y==w-1)) {
				return time;
			}
			
			for(int dir = 0; dir<4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				if(!(nx>=0 && nx<h && ny>=0 && ny<w)) continue;
				if(visited[nx][ny]) continue;
				if(map[nx][ny]!='.') continue;
				
				// 불일때 
				if(state==0) {
					q.add(new int[] {nx, ny, time+1, 0});
					visited[nx][ny] = true;
					map[nx][ny] = '*';
				}else { // 상근이일때 
					if(nx==0 || nx==h-1 || ny==0 || ny==w-1) {
						return time+1;
					}
					q.add(new int[] {nx, ny, time+1, 1});
					visited[nx][ny] = true;
					map[nx][ny] = '@';
				}
			}
		}
		
		return -1;
	}

}