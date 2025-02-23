import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int N, M;
    static boolean[][] burger;
    static int ans;
    static boolean[] visited;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
         
        for(int test_case = 1; test_case<=T; test_case++) {
            st = new StringTokenizer(br.readLine());
             
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
             
            burger = new boolean[N+1][N+1];
             
            for(int i = 0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                 
                burger[a][b] = true;
                burger[b][a] = true;
            }
//            
//            for(boolean[] i : burger) {
//            	System.out.println(Arrays.toString(i));
//            }
            
            /*
             * 재료 3개, 안좋은 궁합 2개
             * [=, =, =, =]
			 * [=, false, true, false]
			 * [=, true, false, true]
			 * [=, false, true, false]
			 * 
			 * 헷갈리니까 0번째 인덱스는 생각하지 말기
			 * 지금 burger 배열에는 
			 * r번째 재료에 대해 c가 궁합이 맞으면 false
			 * 궁합이 맞지않으면 true로 저장되어 있음 
			 * 
			 * 즉 궁합이 맞지않은 재료가 선택되었다면 반복을 종료 시켜야함 
             */

            visited = new boolean[N+1];
            ans = 0;
            
            cook(1, 1);

            sb.append("#").append(test_case).append(" ");
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
	
	
	private static void cook(int cnt, int idx) {
		if(cnt == N+1) {
			ans++;
//			System.out.println(Arrays.toString(visited));
			
			return;
		}
		
		boolean state = true;
		// burger 배열이 true면 궁합이 맞지않거임 
		//
		// idx번째 재료를 선택해도 되는지 체크 
		// 이미 선택이되어있는 재료들과 비교를 할건데
		// 궁합이 맞지않는 재료가 선택되어 있다면 반복문을 종료 
		for(int i = 1; i<N+1; i++) {
			if(burger[idx][i] && visited[i]) {
				state = false;
				break;
			}
		}
		
		if(state) { 
			// 재료가 선택가능한지 체크했는데 문제가 없다면 재료를 선택함 
			visited[idx] = true;
			cook(cnt+1, idx+1);
			visited[idx] = false;
			
		}
		// 재료를 선택하지않고 다음 재료 확인하러감
		cook(cnt+1, idx+1);
	}

}
