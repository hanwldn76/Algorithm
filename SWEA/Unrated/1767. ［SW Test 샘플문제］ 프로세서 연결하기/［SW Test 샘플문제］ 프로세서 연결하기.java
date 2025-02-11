import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[][] map;
	static List<int[]> cores = new ArrayList<>();
	static int maxCores, minLines;
	// 상하좌우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case<=T; test_case++) {
			N = Integer.parseInt(br.readLine());
			
			cores.clear();
			map = new int[N][N];
			
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1 && !(i == 0 || i == N-1 || j == 0 || j == N-1)) {
						cores.add(new int[] {i, j});
					}
				}
			}
			
			maxCores = 0;
			minLines = Integer.MAX_VALUE;
			
			dfs(0, 0, 0);
			
			System.out.println("#"+test_case+" "+minLines);
		}
	}

	private static void dfs(int idx, int connectedCores, int lines) {
		// 종료조건
		if((cores.size() - idx + connectedCores)<maxCores) return;
		if(idx == cores.size()) {
			if(connectedCores > maxCores) {
				maxCores = connectedCores;
				minLines = lines;
			}else if(connectedCores == maxCores) {
				minLines = Math.min(minLines, lines);
			}
			return;
		}
		
		int x = cores.get(idx)[0];
		int y = cores.get(idx)[1];
		
		// 상하좌우로 전선을 설치할 수 있는지 확인
		for(int i = 0; i<4; i++) {
			int count = isConnectedCores(x, y, i);
			
			if(count > 0) {
				// 전선을 설치
				placedLines(x, y, i, 2);
				
				dfs(idx+1, connectedCores+1, lines+count);
				placedLines(x, y, i, 0);
			}
			
			dfs(idx+1, connectedCores, lines);
		}
	}
	
	private static int isConnectedCores(int x, int y, int dir) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		int count = 0;
		
		while(nx >= 0 && nx < N && ny >= 0 && ny < N) {
			if(map[nx][ny]!=0) {
				return 0;
			}
			count++;
			nx += dx[dir];
			ny += dy[dir];
		}
		
		return count;
	}
	
	private static void placedLines(int x, int y, int dir, int value) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		
		while(nx >= 0 && nx < N && ny >= 0 && ny < N) {
			map[nx][ny] = value;
			nx += dx[dir];
			ny += dy[dir];
		}
	}
}