import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int F, S, G, U, D;
	static int[] map;
	static boolean[] visited;
	static List<Integer> lst = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[F+1];
		visited = new boolean[F+1];
		
		if(S==G) {
			System.out.println(0);
			return;
		}
		
		bfs();
		if(map[G]==0) {
			System.out.println("use the stairs");
		}else {
			System.out.println(map[G]);
		}
	}

	private static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(S);
		visited[S] = true;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			int nu = tmp + U;
			int nd = tmp - D;
			
			if(tmp == G) return;
			
			if(nu < 1 || nu > F) {}
			else if(!visited[nu]){
				q.add(nu);
				map[nu] = map[tmp]+1;
				visited[nu] = true;
			}
			
			if(nd < 1 || nd > F) {}
			else if(!visited[nd]){
				q.add(nd);
				map[nd] = map[tmp]+1;
				visited[nd] = true;
			}
			
		}
		
	}

}
