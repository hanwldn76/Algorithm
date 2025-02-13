import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, max;
	static int[] map;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		max = Math.max(N, M);
		
		map = new int[max+2];
		visited = new boolean[max+2];
		
		int cnt = bfs();
		
		System.out.println(cnt);

	}
	private static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {N, 0});
		visited[N] = true;
		
		while(!q.isEmpty()) {
			int[] node = q.poll();
			int x = node[0];
			int time = node[1];
			
			if(x == M) return 0;
			
			for(int i = 0; i<3; i++) {
				int nx;
				if(i==0) {
					nx = x - 1;
				}else if(i==1) {
					nx = x + 1;
				}else {
					nx = x * 2;
				}
				
				if(nx<0 || nx>=max+2) continue;
				if(visited[nx]) continue;
				if(nx == M) return time+1;
				
				q.add(new int[] {nx, time+1});
				visited[nx] = true;
			}
		}
		
		return 0;
	}
}