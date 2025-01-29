import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int [][] arr = new int[1001][1001];
        int [] count = new int[n+1];

        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken()), h = Integer.parseInt(st.nextToken());
            for(int j = y; j<y+h; j++){
                for(int k = x; k<x+w; k++){
                    if(arr[j][k] != i){
                        arr[j][k] = i;
                    }
                }
            }
        }

        for(int i = 0; i < 1001; i++) {
            for(int j = 0; j < 1001; j++) {
                count[arr[i][j]]++;
            }
        }

        for(int i = 1; i<n+1; i++){
            System.out.println(count[i]);
        }

        br.close();
    }
}