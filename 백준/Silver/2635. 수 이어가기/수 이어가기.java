import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int tmp = 0;
        int cnt = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = n/2; i<=n; i++){
            int idx = 0;
            arr.add(n);
            arr.add(i);

            while(true){
                tmp = arr.get(idx) - arr.get(idx+1);
                if(tmp < 0){
                    break;
                }else{
                    arr.add(tmp);
                    idx++;
                }
            }

            if(cnt < arr.size()){
                answer.clear();
                cnt = arr.size();
                answer.addAll(arr);

            }
            arr.clear();
        }
        System.out.println(answer.size());
        for(int a : answer){
            System.out.print(a+" ");
        }

        br.close();
    }
}