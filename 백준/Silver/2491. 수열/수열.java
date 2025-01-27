import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int inc = 1, dec = 1;
        int max = 1;
        for(int i = 1; i<n; i++){
            if(arr[i] >= arr[i-1]){
                inc++;
            }else{
                inc = 1;
            }

            if(arr[i] <= arr[i-1]){
                dec++;
            }else {
                dec = 1;
            }

            max = Math.max(max, Math.max(inc, dec));
        }

        System.out.println(max);

        br.close();
    }
}