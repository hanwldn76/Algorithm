### 힙 정렬

>힙을 이용해 데이터를 정렬하는 것

<br>

**정렬 과정**

1. 배열을 힙으로 만듦.
2. 만든 힙을 정렬.
>오름차순으로 정렬 => 최대 힙 이용
>
>내림차순으로 정렬 => 최소 힙 이용

<br>

<정렬하는 법>

- 최대힙 구성 후, 가장 큰 값인 root와 마지막 원소를 바꿔줌
- 그럼 가장 큰 값이 뒤로 갔기 때문에 정렬 완료됨.
- 그리고 다시 힙구조를 만들어 줌.
- 힙구조가 만들어졌으면 다시 root와 마지막 원소 바꿈.

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/19631f3f-cd19-4368-b72d-8a3d5362a332)


<br>

**코드**

```
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
```

<br>

<img width="176" alt="image" src="https://github.com/hanwldn76/Algorithm/assets/138774991/1123735f-5b46-420c-9347-523136ef985e">

<br>

<br>

**시간 복잡도**

- 힙 정렬은 병합 정렬과 다르게 추가적인 배열이 필요하지 않아 메모리 측면에서 효율적임.
- 항상 O(NlogN)을 보장함.
- 하지만 단순히 속도만 가지고 비교하면 퀵 정렬이 평균적으로 더 빠르기 때문에 힙 정렬은 일반적으로 많이 사용되지 않음.
