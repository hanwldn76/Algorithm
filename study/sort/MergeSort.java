package sort;

import java.util.Arrays;

public class MergeSort {
    static int[] tmp; // 정렬 배열을 임시로 저장할 배열
    // 반드시 전역 변수로 선언

    static void merge(int a[], int m, int middle, int n){
        int i = m;
        int j = middle + 1;
        int k = m;

        // 작은 순서대로 배열에 삽입
        while(i <= middle && j <= n){
            if(a[i] <= a[j]){
                tmp[k] = a[i];
                i++;
            } else{
                tmp[k] = a[j];
                j++;
            }
            k++;
        }

        // 남은 데이터도 삽입
        if(i > middle){
            for(int t = j; t<=n; t++){
                tmp[k] = a[t];
                k++;
            }
        } else{
            for(int t = i; t<=middle; t++){
                tmp[k] = a[t];
                k++;
            }
        }

        // 정렬된 배열을 삽입
        for(int t = m; t<=n; t++){
            a[t] = tmp[t];
        }
    }

    static void mergeSort(int a[], int m, int n){
        // 크기가 1보다 큰 경우
        if(m < n){
            int middle = (m + n) / 2;
            mergeSort(a, m, middle);
            mergeSort(a, middle + 1, n);
            merge(a, m, middle, n);
        }
    }

    static public void main(String []args){
        int [] array = {7, 6, 5, 8, 3, 5, 9, 1};
        tmp = new int[array.length];

        System.out.println("정렬 전");
        System.out.println(Arrays.toString(array));

        mergeSort(array, 0, array.length-1);

        System.out.println("정렬 후");
        System.out.println(Arrays.toString(array));
    }
}
