import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static ArrayList<Integer> list = new ArrayList<>();
    static int n, m;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        f(0);

        br.close();
        bw.close();
    }
    
    static private void f(int cnt) throws IOException {
        if(cnt == m){
            for(int l : list){
                bw.write(l + " ");
            }
            bw.newLine();
            bw.flush();
            return;
        }
        else{
            for(int i = 0; i<n; i++){
                if(!visited[i]){
                    visited[i] = true;
                    list.add(arr[i]);
                    f(cnt+1);
                    visited[i] = false;
                    list.remove(list.size()-1);
                }
            }
        }
    }
}