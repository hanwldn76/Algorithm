package sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args){
        int temp;
        int [] array = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

        System.out.println("정렬 전");
        System.out.println(Arrays.toString(array));

        for(int i = 0; i<array.length; i++){
            for(int j = 0; j<9-i; j++){
                if(array[j] >= array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        System.out.println("정렬 후");
        System.out.println(Arrays.toString(array));
    }
}
