import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int[][] note;
	static int[][] sticker;
	static int R, C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		note = new int[N][M];
		
		for(int s = 0; s<K; s++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			sticker = new int[10][10];
			
			for(int r = 0; r<R; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c<C; c++) {
					sticker[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int d = 0; d<4; d++) {
				boolean isPaste = false;
			
				for(int r = 0; r<=N-R; r++) {
					for(int c = 0; c<=M-C; c++) {
						if(check(r, c)) {
							isPaste = true;
							break;
						}
					}
					if(isPaste) break;
				}
				if(isPaste) break;
				rotate();
			}
		}
		
		int cnt = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(note[i][j]==1) cnt++;
			}
		}
		System.out.println(cnt);
	}
	 
	static boolean check(int r, int c) {
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				if(note[i+r][j+c]==1 && sticker[i][j]==1) {
					return false;
				}
			}
		}
		
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				if(sticker[i][j]==1) {
					note[i+r][j+c] = 1;
				}
			}
		}
		
		return true;
	}
	
	static void rotate() {
		int[][] tmp = new int[10][10];
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				tmp[j][R-1-i] = sticker[i][j];
			}
		}
		
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				sticker[i][j] = tmp[i][j];
			}
		}
		int temp = R;
		R = C;
		C = temp;
	}
}
