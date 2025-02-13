import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int M, N, H;
	static int res;
	static int[][][] map;
	static boolean[][][] visited;
	static List<int[]> tomato = new ArrayList<>();
	static int[] dx = {-1, 1, 0, 0, 0, 0};
	static int[] dy = {0, 0, -1, 1, 0, 0};
	static int[] dz = {0, 0, 0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][N][M];
		visited = new boolean[H][N][M];
		
		for(int i = 0; i<H; i++) {
			for(int j = 0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k<M; k++) {
					int tmp = Integer.parseInt(st.nextToken());
					if(tmp==1) {
						tomato.add(new int[] {i, j, k});
					}
					map[i][j][k] = tmp;
				}
				
			}
		}
		
		if(tomato.size()==0) {
			System.out.println(-1);
			return;
		}

		res = -1;
		bfs();
		
		if(res!=0) {
			for(int i = 0; i<H; i++) {
				for(int j = 0; j<N; j++) {
					for(int k = 0; k<M; k++) {
						int tmp = map[i][j][k];
						if(tmp==0) {
							res = -1;
							break;
						}
					}
					if(res==-1) break;
				}
				if(res==-1) break;
			}
		}
		
		System.out.println(res);
		
	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		
		for(int[] t : tomato) {
			q.add(new int[] {t[0], t[1], t[2], 0});
			visited[t[0]][t[1]][t[2]] = true;
		}
		
		while(!q.isEmpty()) {
			int[] t = q.poll();
			int z = t[0];
			int x = t[1];
			int y = t[2];
			int day = t[3];
		
			for(int dir = 0; dir<6; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				int nz = z + dz[dir];
				
				if(!(nx>=0 && nx<N && ny>=0 && ny<M && nz>=0 && nz<H)) continue;
				if(visited[nz][nx][ny]) continue;
				if(map[nz][nx][ny]!=0) continue;
				
				q.add(new int[] {nz, nx, ny, day+1});
				visited[nz][nx][ny] = true;
				res = Math.max(day+1, res);
				map[nz][nx][ny] = map[z][x][y]+1;
			}
		}
		
		if(res==-1) res = 0;
	}

}
