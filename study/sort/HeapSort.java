package sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String []args){
        int [] heap = {7, 6, 5, 8, 3, 5, 9, 1, 6};

        System.out.println("정렬 전");
        System.out.println(Arrays.toString(heap));

        // 최대 힙 구성하는 과정
        for(int i = 1; i<heap.length; i++){
            int c = i; // c는 root의 자식
            do{
                int root = (c - 1)/2;
                if(heap[root]<heap[c]){
                    int temp = heap[root];
                    heap[root] = heap[c];
                    heap[c] = temp;
                }
                c = root;
            }while(c != 0);
        }

        // 크기를 줄여가며 반복적으로 힙을 구성
        for(int i = heap.length-1; i>=0; i--){
            int temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;

            int root = 0;
            int c = 1;

            do{
                c = 2 * root + 1;
                try{
                    // 자식 중에 더 큰 값을 찾기
                    if(heap[c] < heap[c+1] && c < i-1){
                        c++;
                    }
                    // 루트보다 자식이 더 크다면 교환
                    if(heap[root] < heap[c] && c < i){
                        temp = heap[root];
                        heap[root] = heap[c];
                        heap[c] = temp;
                    }
                } catch(Exception e){
                    e.printStackTrace();
                }
                root = c;
            } while(c < i);
        }

        System.out.println("정렬 후");
        System.out.println(Arrays.toString(heap));
    }
}
