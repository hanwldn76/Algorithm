import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int [][] arr = new int[5][5];
    static ArrayList<Integer> list = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<5; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<5; j++){
                list.add(Integer.parseInt(st.nextToken()));
            }
        }
        br.close();

        for(int k = 0; k<list.size(); k++){
            for(int i = 0; i<5; i++){
                for(int j = 0; j<5; j++){
                    if(arr[i][j] == list.get(k)){
                        arr[i][j] = 0;
                    }
                }
            }
            check_1();
            check_2();
            check_3();
            check_4();

            if(count >= 3){
                System.out.println(k+1);
                break;
            }
            count = 0;
        }
    }

    // 가로 췍
    private static void check_1(){
        int check;
        for(int i = 0; i<5; i++){
            check = 0;
            for(int j = 0; j<5; j++){
                check += arr[i][j];
            }
            if(check == 0) count += 1;
        }
    }
    // 세로 췍
    private static void check_2(){
        int check;
        for(int i = 0; i<5; i++){
            check = 0;
            for(int j = 0; j<5; j++){
                check += arr[j][i];
            }
            if(check == 0) count += 1;
        }
    }
    // 오른쪽 아래로 가는 대각선 췍
    private static void check_3(){
        int check = 0;
        for(int k = 0; k<5; k++){
            check += arr[k][k];
        }
        if(check == 0) count += 1;
    }
    // 왼쪽 아래로 가는 대각선 췍
    private static void check_4(){
        int check = 0;
        for(int k = 0; k<5; k++){
            check += arr[k][4-k];
        }
        if(check == 0) count += 1;
    }
}