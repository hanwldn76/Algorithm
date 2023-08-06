package sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String []args){
        int temp, j;
        int [] array = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

        System.out.println("정렬 전");
        System.out.println(Arrays.toString(array));

        for(int i = 0; i<array.length-1; i++){
            j = i; // 현재 정렬할 원소 선택
            while(array[j] > array[j+1]){ // 왼오를 비교, 왼쪽이 더 크다면 반복
                temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
                j--; // 1씩 빼가면서 앞 원소와 비교
            }
        }

        System.out.println("정렬 후");
        System.out.println(Arrays.toString(array));
    }
}
