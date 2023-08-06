package sort;

import java.util.*;

public class SelectionSort {
    public static void main(String[] args){
        int min, index = 0, temp;
        int [] array = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

        System.out.println("정렬 전");
        System.out.println(Arrays.toString(array));

        for(int i = 0; i<array.length; i++){
            min = 9999;
            for(int j = i; j<array.length; j++){
                if(array[j] <= min){
                    min = array[j];
                    index = j;
                }
            }
            temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }

        System.out.println("정렬 후");
        System.out.println(Arrays.toString(array));
    }
}
