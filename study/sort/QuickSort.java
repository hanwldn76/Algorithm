package sort;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr, int start, int end) {
        if(start >= end) {return;} //원소가 1개일 경우 종료

        int pivot = start;
        int i = start+1;
        int j = end;
        int temp;

        while(i <= j) { // 엇갈릴때까지 반
            while(i <= end && arr[i] <= arr[pivot]) {
                i++; //피벗보다 큰 데이터를 찾을 때까지 반복
            }
            while(j > start && arr[j] >= arr[pivot]) {
                j--; //피벗보다 작은 데이터를 찾을 때 까지 반복
            }

            if(i > j) { // 현재 엇갈린 상태면 pivot 값과 작은 값 교체
                temp = arr[pivot];
                arr[pivot] = arr[j];
                arr[j] = temp;
            }else { // 아니면 작은 값과 큰 값 교체
                temp = arr[i];
                arr[i]= arr[j];
                arr[j]=temp;
            }
        }

        // while문이 종료되고 나면 j값은 정렬된 값의 인덱스
        // 정렬 끝난 후 정렬이 이루어진 pivot값을 기준으로 왼쪽 정렬과 오른쪽 정렬이
        // 각각 정렬이 이루어 지도록 재귀함수를 이용한다.
        quickSort(arr, start, j-1); //분할이후 왼쪽에서 정렬수행
        quickSort(arr, j+1,end);
    }

    public static void main(String[] args){
        int [] array = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

        System.out.println("정렬 전");
        System.out.println(Arrays.toString(array));

        quickSort(array, 0, array.length-1);

        System.out.println("정렬 후");
        System.out.println(Arrays.toString(array));
    }
}