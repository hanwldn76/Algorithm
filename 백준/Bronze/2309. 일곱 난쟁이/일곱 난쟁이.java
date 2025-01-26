import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static ArrayList<Integer> list = new ArrayList<>();
    static int [] arr = new int[9];
    static boolean [] visited = new boolean[9];
    static int height = 0;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i<9; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        f(0);

        br.close();
        bw.close();
    }

    static void f(int cnt) throws IOException {
        if(cnt == 7){
            if(height == 100){
                for (int l : list) {
                    bw.write(l + "\n");
                }
                bw.flush();
                System.exit(0);
            }
        }else{
            for(int i = 0; i<9; i++){
                if(!visited[i]){
                    list.add(arr[i]);
                    height += arr[i];
                    visited[i] = true;
                    f(cnt+1);
                    list.remove(list.size()-1);
                    height -= arr[i];
                    visited[i] = false;
                }
            }
        }
    }
}