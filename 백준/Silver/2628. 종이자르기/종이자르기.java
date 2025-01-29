import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());

        // 가로 배열
        int [] wArr = new int[w+1];
        // 세로 배열
        int [] dArr = new int[d+1];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken()), t2 = Integer.parseInt(st.nextToken());

            if(t1 == 0){
                dArr[t2] = 1;
            }else{
                wArr[t2] = 1;
            }
        }

        int wMax = 1, dMax = 1;
        int tmp = 0;
        for(int i = 0; i<wArr.length; i++){
            if(wArr[i]==1 || i == wArr.length-1){
                wMax = Math.max(wMax, tmp);
                tmp = 0;
            }
            tmp++;
        }
        tmp = 0;
        for(int i = 0; i<dArr.length; i++){
            if(dArr[i]==1 || i == dArr.length-1){
                dMax = Math.max(dMax, tmp);
                tmp = 0;
            }
            tmp++;
        }

        System.out.println(wMax*dMax);

        br.close();
    }
}