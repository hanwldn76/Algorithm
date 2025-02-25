import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * [아이디어]
 * 일단 배열에 시너지에 대한 정보를 입력 받음 (arr)
 * N/2개 를 조합으로 뽑아서 뽑은건 a음식의 맛, 뽑히지않은건 b음식의 맛으로 둘거임. 
 * 그래서 N/2개 뽑히면 a리스트와 b리스트를 생성해서 여기에 식재료에대한 인덱스 값을 저장함
 * 그리고 그 인덱스값을 가지고 음식맛의 합을 구하고 a음식과b음식 맛의 차이의 최소를 갱신해감
 * 
 */
public class Solution {
	static int N;
	static int[][] arr;
	static int min;
	static boolean[] visited;
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case<=T; test_case++) {
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N+1][N+1];
			
			for(int i = 1; i<N+1; i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j = 1; j<N+1; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visited = new boolean[N+1];
			min = Integer.MAX_VALUE;
			dfs(0, 1);
			
			sb.append("#").append(test_case).append(" ").append(min).append("\n");
        }
		
        System.out.print(sb);

	}
	private static void dfs(int cnt, int start) {		
		if(cnt==N/2) {
			List<Integer> a = new ArrayList<>();
			List<Integer> b = new ArrayList<>();
			
			for(int i = 1; i<N+1; i++) {
				if(visited[i]) a.add(i);
				else b.add(i);
			}
			sum(a, b);
			return;
		}
		
		for(int i = start; i<N+1; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(cnt+1, i+1);
				visited[i] = false;
			}
		}
	}
	
	private static void sum(List<Integer> a, List<Integer> b) {
		int aSum = 0, bSum = 0;

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < N / 2; j++) {
                if (i != j) { // 자기 자신과의 시너지는 계산하지 않음
                    aSum += arr[a.get(i)][a.get(j)];
                    bSum += arr[b.get(i)][b.get(j)];
                }
            }
        }

		int tmp = Math.abs(aSum - bSum);
//		System.out.println(aSum+" "+bSum);
		min = Math.min(min, tmp);
	}
}
