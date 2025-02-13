import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int I;
	static int sx, sy;
	static int ex, ey;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case<=T; test_case++) {
			I = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());
			
			map = new int[I][I];
			visited = new boolean[I][I];
			int cnt = bfs();
			System.out.println(cnt);
		}

	}

	private static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {sx, sy, 0});
		visited[sx][sy] = true;
		
		while(!q.isEmpty()) {
			int[] node = q.poll();
			int x = node[0];
			int y = node[1];
			int move = node[2];
			
			if(x==ex && y==ey) return 0;
			
			for(int dir = 0; dir<8; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				if(!(nx>=0 && nx<I && ny>=0 && ny<I)) continue;
				if(visited[nx][ny]) continue;
				if(nx == ex && ny == ey) {
					return move+1;
				}
				
				q.add(new int[] {nx, ny, move+1});
				visited[nx][ny] = true;
			}
		}
		
		return 0;
	}

}
