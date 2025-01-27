import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static ArrayList<Integer> list = new ArrayList<>();
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        f(0, 0);

        System.out.println(sb.toString());
        br.close();
    }

    static private void f(int cnt, int idx) throws IOException {
        if(cnt == m){
            for(int l : list){
                sb.append(l).append(" ");
            }
            sb.append("\n");
            return;
        }
        else{
            for(int i = idx; i<n; i++){
                list.add(arr[i]);
                f(cnt+1, i);
                list.remove(list.size()-1);
            }
        }
    }
}