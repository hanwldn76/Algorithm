import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int R, C, T;
	static int map[][];
	static List<int[]> dust = new ArrayList<>();
	// 공청기의 좌표 저장 
	static int X;
	
	// 시계방향 
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	// 반시계방향 
	static int[] cdx = {0,-1,0,1};
	static int[] cdy = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for(int i = 0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean tmp = false;
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				if(map[i][j]==-1) {
					X = i;
					tmp = true;
					break;
				}
			}
			if(tmp)break;
		}
		
		for(int time = 0; time<T; time++) {
			dustSpread();
			airClear(X+1, 1, 0, 0);
			airClearReverse(X, 1, 0, 0);
		}
		
		int cnt = 0;
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				if(map[i][j]!=-1) cnt += map[i][j];
			}
		}
		
		System.out.println(cnt);
		
	}
	
	static void dustSpread() {
		int tmp1[][] = new int[R][C];
		int tmp2[][] = new int[R][C];
		
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				if(map[i][j]!=-1 && map[i][j]!=0) {
					int dust = map[i][j];
					
					for(int dir = 0; dir<4; dir++) {
						int nx = i + dx[dir];
						int ny = j + dy[dir];
						
						if(!(nx>=0 && nx<R && ny>=0 && ny<C)) continue;
						if(map[nx][ny]==-1) continue;
						
						tmp1[nx][ny] += dust/5;
						tmp2[i][j] += dust/5;
					}
				}
			}
		}
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				if(map[i][j]==-1) continue;
				map[i][j] += tmp1[i][j];
				map[i][j] -= tmp2[i][j];
				if(map[i][j]<0) map[i][j] = 0;
			}
		}	
	}
	
	static void airClear(int i, int j, int dir, int pDust) {
		if(map[i][j] == -1) return;

		  int moveDust = map[i][j];
		  
		  map[i][j] = pDust;
		  int x = i+dx[dir];
		  int y = j+dy[dir];
		  if(x < 0 || y < 0 || x >= R || y >= C) {
		    dir++;
		    x = i+dx[dir];
		    y = j+dy[dir];
		    airClear(x, y, dir, moveDust);
		  }
		  else
		    airClear(x, y, dir, moveDust);
	}
	
	static void airClearReverse(int i, int j, int dir, int pDust) {
		if(map[i][j] == -1) return;

		  int moveDust = map[i][j];
		  
		  map[i][j] = pDust;
		  int x = i+cdx[dir];
		  int y = j+cdy[dir];
		  if(x < 0 || y < 0 || x >= R || y >= C) {
		    dir++;
		    x = i+cdx[dir];
		    y = j+cdy[dir];
		    airClearReverse(x, y, dir, moveDust);
		  }
		  else
			airClearReverse(x, y, dir, moveDust);
	}

}