import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, L;
	static int[][] map;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		
		for(int r = 0; r<N; r++) {
			boolean[] installed = new boolean[N];
			if(checkUp1(r, installed) && checkDown1(r, installed)) {
				cnt++;
			}
		}
		
		for(int c = 0; c<N; c++) {
			boolean[] installed = new boolean[N];
			if(checkUp2(c, installed) && checkDown2(c, installed)) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	static boolean checkUp1(int r, boolean[] installed) {
	    for (int c = 1; c < N; c++) { 
	        int pc = c - 1;
	        
	        if (map[r][c] == map[r][pc]) continue; // 높이 변화 없으면 넘어감

	        if (map[r][c] - map[r][pc] == 1) { 
	            int startIdx = c - L;
	            
	            if (startIdx < 0) return false;
	            
	            for (int i = startIdx; i < c; i++) { // 경사로 설치할 구간 체크
	                if (map[r][i] != map[r][pc] || installed[i]) return false; // 높이 다르거나 이미 설치됨
	            }

	            for (int i = startIdx; i < c; i++) { // 경사로 설치 표시
	                installed[i] = true;
	            }
	        } else if (map[r][c] - map[r][pc] > 1) { 
	            return false;
	        }
	    }
	    return true;
	}

	
	static boolean checkDown1(int r, boolean[] installed) {
	    for (int c = 0; c < N-1; c++) { 
	        int nc = c + 1;
	        
	        if (map[r][c] == map[r][nc]) continue; // 높이 변화 없으면 넘어감

	        if (map[r][c] - map[r][nc] == 1) { 
	            int endIdx = c + L;
	            
	            if (endIdx >= N) return false;
	            
	            for (int i = nc; i <= endIdx; i++) { // 경사로 설치할 구간 체크
	                if (map[r][i] != map[r][nc] || installed[i]) return false; // 높이 다르거나 이미 설치됨
	            }

	            for (int i = nc; i <= endIdx; i++) { // 경사로 설치 표시
	                installed[i] = true;
	            }
	        } else if (map[r][c] - map[r][nc] > 1) { 
	            return false;
	        }
	    }
	    return true;
		
	}
	
	static boolean checkUp2(int c, boolean[] installed) {
	    for (int r = 1; r < N; r++) { 
	        int pr = r - 1;
	        
	        if (map[r][c] == map[pr][c]) continue; // 높이 변화 없으면 넘어감

	        if (map[r][c] - map[pr][c] == 1) { 
	            int startIdx = r - L;
	            
	            if (startIdx < 0) return false;
	            
	            for (int i = startIdx; i < r; i++) { // 경사로 설치할 구간 체크
	                if (map[i][c] != map[pr][c] || installed[i]) return false; // 높이 다르거나 이미 설치됨
	            }

	            for (int i = startIdx; i < r; i++) { // 경사로 설치 표시
	                installed[i] = true;
	            }
	        } else if (map[r][c] - map[pr][c] > 1) { 
	            return false;
	        }
	    }
	    return true;
	}

	
	static boolean checkDown2(int c, boolean[] installed) {
	    for (int r = 0; r < N-1; r++) { 
	        int nr = r + 1;
	        
	        if (map[r][c] == map[nr][c]) continue; // 높이 변화 없으면 넘어감

	        if (map[r][c] - map[nr][c] == 1) { 
	            int endIdx = r + L;
	            
	            if (endIdx >= N) return false;
	            
	            for (int i = nr; i <= endIdx; i++) { // 경사로 설치할 구간 체크
	                if (map[i][c] != map[nr][c] || installed[i]) return false; // 높이 다르거나 이미 설치됨
	            }

	            for (int i = nr; i <= endIdx; i++) { // 경사로 설치 표시
	                installed[i] = true;
	            }
	        } else if (map[r][c] - map[nr][c] > 1) { 
	            return false;
	        }
	    }
	    return true;
		
	}
}
