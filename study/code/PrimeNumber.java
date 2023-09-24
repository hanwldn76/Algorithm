import java.util.*;

public class PrimeNumber {
    static boolean isPrimeNumber(int n){
        int end = (int) Math.sqrt(n);
        for(int i = 2; i<=end; i++){
            if(n % i == 0) return false;
        }
        return true;
    }

    static int number = 100000;
    static int [] a = new int [100001];

    static void primeNumberSieve(){
        for(int i = 2; i<=number; i++){
            a[i] = i;
        }
        for(int i = 2; i<=number; i++){
            if(a[i]==0) continue;
            for(int j = i + i; j<=number; j += i){
                a[j] = 0;
            }
        }

        int cnt = 0;
        for(int i = 2; i<=number; i++){
            if(a[i] != 0) {
                if(cnt%5==0) System.out.println();
                cnt++;
                System.out.print(a[i]+" ");
            }
        }
    }

    public static void main(String []args){
        System.out.println(isPrimeNumber(97));

        primeNumberSieve();
    }
}