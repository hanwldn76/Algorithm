import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int[][] copyMap;
	static List<int[]> cctvs = new ArrayList<>();
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		copyMap = new int[N][M];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]!=0 && map[i][j]!=6) cctvs.add(new int[] {i,j});
			}
		}
		
		int checkCnt = 1;
		for(int i = 0; i<cctvs.size(); i++) {
			checkCnt *= 4;
		}
		
		int minCnt = Integer.MAX_VALUE;
		
		for(int c = 0; c<checkCnt; c++) {
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					copyMap[i][j] = map[i][j];
				}
			}
			
			int tmp = c;
			for(int i = 0; i<cctvs.size(); i++) {
				int dir = tmp % 4;
				tmp /= 4;
				
				int[] cctv = cctvs.get(i);
				int x = cctv[0];
				int y = cctv[1];
				
				if(copyMap[x][y]==1) {
					check(x, y, dir);
				}else if(copyMap[x][y]==2) {
					check(x, y, dir);
					check(x, y, dir+2);
				}else if(copyMap[x][y]==3) {
					check(x, y, dir);
					check(x, y, dir+1);
				}else if(copyMap[x][y]==4) {
					check(x, y, dir);
					check(x, y, dir+1);
					check(x, y, dir+2);
				}else if(copyMap[x][y]==5) {
					check(x, y, dir);
					check(x, y, dir+1);
					check(x, y, dir+2);
					check(x, y, dir+3);
				}
			}
			
			minCnt = Math.min(minCnt, count());
			
		}
		System.out.println(minCnt);
		
		
	}
	
	static void check(int x, int y, int dir) {
		dir %= 4;
		
		while(true) {
			x += dx[dir];
			y += dy[dir];
			
			if(!(x>=0 && x<N && y>=0 && y<M)) return;
			if(copyMap[x][y]==6) return;
			if(copyMap[x][y]!=0) continue;
			
			copyMap[x][y] = 7;
		}
	}
	
	static int count() {
		int cnt = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(copyMap[i][j]==0) cnt++;
			}
		}
		return cnt;
	}
}