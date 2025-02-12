import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] map;
	static boolean[] visited;
	static int N, M, V;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
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
		
		for (int i = 1; i <= N; i++) {
            Collections.sort(map[i]);
        }
		
		sb = new StringBuilder();
		visited = new boolean[N + 1];
        dfs(V);
        System.out.println(sb);
		
		sb = new StringBuilder();
		visited = new boolean[N + 1];
        bfs();
		System.out.println(sb);
	}
	
	private static void dfs(int node) {
		visited[node] = true;
		sb.append(node).append(" ");
		
		for(int next : map[node]) {
			if(!visited[next]) {
				visited[next] = true;
				dfs(next);
			}
		}
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(V);
		visited[V] = true;
		
		while (!q.isEmpty()) {
            int tmp = q.poll();
            sb.append(tmp).append(" ");

            for (int next : map[tmp]) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
	}
}