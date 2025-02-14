import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static boolean[][][] visited;
	static int K, W, H;
	static int[] mx = {-1, 1, 0, 0};
	static int[] my = {0, 0, -1, 1};
	static int[] hx = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] hy = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		visited = new boolean[K+1][H][W];
		
		for(int i = 0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0,0,0,0});
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			int[] node = q.poll();
			int x = node[0];
			int y = node[1];
			int move = node[2];
			int horse = node[3];
			
			if(x==H-1 && y==W-1) return move;
			
			for(int dir = 0; dir<4; dir++) {
				int nx = x + mx[dir];
				int ny = y + my[dir];
				
				if(!(nx>=0 && nx<H && ny>=0 && ny<W)) continue;
				if(map[nx][ny]==1) continue;
				if(visited[horse][nx][ny]) continue;
				
				q.add(new int[] {nx, ny, move+1, horse});
				visited[horse][nx][ny] = true;
				
			}
			if(K>horse) {
				for(int dir = 0; dir<8; dir++) {
					int nx = x + hx[dir];
					int ny = y + hy[dir];
					int nHorse = horse + 1;
					
					if(!(nx>=0 && nx<H && ny>=0 && ny<W)) continue;
					if(map[nx][ny]==1) continue;
					if(visited[nHorse][nx][ny]) continue;
					
					q.add(new int[] {nx, ny, move+1, nHorse});
					visited[nHorse][nx][ny] = true;
				}
			}
		}
		
		return -1;	
	}
}
