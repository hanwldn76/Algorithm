import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean [][] arr = new boolean[100][100];
    static int count = 0;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            int x, y;
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            for(int j = y; j<y+10; j++){
                for(int k = x; k<x+10; k++){
                    if(arr[j-1][k-1] == false){
                       arr[j-1][k-1] = true;
                       count++;
                    }
                }
            }
        }

        System.out.println(count);

        br.close();
    }
}