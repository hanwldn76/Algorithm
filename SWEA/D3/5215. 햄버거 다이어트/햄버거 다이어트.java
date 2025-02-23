import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
 
public class Solution {
 
    static int N, L;
    static int[] score;
    static int[] kcal;
    static int max;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
         
        for(int test_case = 1; test_case<=T; test_case++) {
            st = new StringTokenizer(br.readLine());
             
             N = Integer.parseInt(st.nextToken());
             L = Integer.parseInt(st.nextToken());
              
             score = new int[N];
             kcal = new int[N];
              
             for(int i = 0; i<N; i++) {
                 st = new StringTokenizer(br.readLine());
                 score[i] = Integer.parseInt(st.nextToken());
                 kcal[i] = Integer.parseInt(st.nextToken());
             }
             max = 0;
 
//             dfs1(0, 0, 0); // 부분집합 방식 
             dfs2(0, 0, 0); // 조합 방식 
              
             System.out.println("#"+test_case+" "+max);
        }
    }
 
    // 부분집합 방식 (모든 경우 고려)
    private static void dfs1(int cnt, int kSum, int sSum) {
        if(kSum>L) return;
 
        if(cnt == N) {
            if(max<sSum) {
                max = sSum;
            }
            return;
        }
        dfs1(cnt+1, kSum+kcal[cnt], sSum+score[cnt]); // 현재 재료 포함
        dfs1(cnt+1, kSum, sSum); // 현재 재료 미포함
    }
    
    // 조합 방식 (현재 이후 재료만 선택 가능)
    private static void dfs2(int cnt, int kSum, int sSum) {
        if (kSum > L) return;

        max = Math.max(max, sSum);  // 최대 점수 갱신 (모든 조합이 유효하므로 바로 갱신)
        // 모든 가능한 조합에 대해서 최대값을 찾는거임 
        
        for (int i = cnt; i < N; i++) {
            dfs2(i + 1, kSum + kcal[i], sSum + score[i]); // 현재 재료 포함
        }
    }
}