import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int [] gArr = new int[7];
        int [] bArr = new int[7];

        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());

            if(s == 0){
                gArr[y]++;
            }else{
                bArr[y]++;
            }
        }
        
        int cnt = 0;

        for(int i = 1; i<7; i++){
            while(true){
                if(gArr[i] <= 0){
                    break;
                } else{
                    gArr[i] -= k;
                    cnt++;
                }
            }
            while(true){
                if(bArr[i] <= 0){
                    break;
                } else{
                    bArr[i] -= k;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

        br.close();
    }
}