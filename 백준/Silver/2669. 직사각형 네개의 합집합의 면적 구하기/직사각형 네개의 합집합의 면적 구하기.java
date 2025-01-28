import java.io.*;
import java.util.*;
public class Main {
    static int [][] arr = new int [100][100];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cnt = 0;

        for(int i = 0; i<4; i++){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j = y1; j<y2; j++){
                for(int k = x1; k<x2; k++){
                    if(arr[j-1][k-1] == 0){
                        arr[j-1][k-1]++;
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);

        br.close();
    }
}