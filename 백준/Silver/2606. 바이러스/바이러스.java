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
	static List<Integer>[] map;
	static boolean[] visited;
	static int res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		map = new ArrayList[N+1];
		for(int i = 1; i<=N; i++) {
			map[i] = new ArrayList<>();
		}
		visited = new boolean[N+1];
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a].add(b);
			map[b].add(a);
		}
		
		res = 0;
		bfs();
		System.out.println(res);
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			
			for(int next : map[node]) {
				if(visited[next]) continue;
				
				q.add(next);
				visited[next] = true;
				res++;
			}
		}
	}
}
