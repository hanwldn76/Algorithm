import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j= 0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i<R; i++) {
			rotate();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	private static void rotate() {
		// 가장 큰 사각형부터 안으로 한번씩 돌리기
		// 배열의 바깥쪽 테두리부터 안쪽으로 한칸씩 들어가면서 회전함 
		// 즉 배열을 층 단위로 나누어서 각 층을 개별적으로 회전 
		for(int i = 0; i<Math.min(N,M)/2; i++) {
			// 각 사각형의 왼쪽 위의 값을 저장해둠
			// 다 돌리고나서 넣어줄거임 
			int tmp = arr[i][i];
			
			// left
			for(int j=i; j<M-i-1; j++) {
				arr[i][j] = arr[i][j+1];
			}
			// up
			for(int j=i; j<N-1-i; j++) {
				arr[j][M-i-1] = arr[j+1][M-i-1];
			}
			// right
			for(int j=M-i-1; j>i; j--) {
				arr[N-1-i][j] = arr[N-1-i][j-1];
			}
			// down
			for(int j=N-i-1; j>i; j--) {
				arr[j][i] = arr[j-1][i];
			}
			arr[i+1][i] = tmp;
		}
		
	}

}
