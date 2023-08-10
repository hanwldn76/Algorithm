### 병합 정렬

>일단 반으로 나누고 나중에 합쳐서 정렬하는 것(합치는 순간에 정렬)

<br>

**시작** 

`7` `6` `5` `8` `3` `5` `9` `1`

**1**

`6 7` `5 8` `3 5` `1 9`

**2**

`5 6 7 8` `1 3 5 9`

**3**

`1 3 5 5 6 7 8 9`

-> 2의 배수만큼 합침

너비 n = 8

높이($\log_2 n$) $\log_2 8$ = 3

<br>

<img width="466" alt="image" src="https://github.com/hanwldn76/Algorithm/assets/138774991/752bb67e-2ea8-4a8f-abba-34ec64a56605">


i와 j를 비교해서 더 작은 걸 k의 위치에 옮김.

두 배열은 이미 정렬되었기 때문에 총 4번 데이터를 읽음.

<br>

**정렬 과정**

1. 주어진 리스트를 절반으로 분할하여 부분리스트로 나눔. (분할)

2. 해당 부분리스트의 길이가 1이 아니라면 1번 과정을 반복.

3. 인접한 부분리스트끼리 정렬하여 합침. (정복)

<br>

**코드**

```
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
```

<br>

<img width="158" alt="image" src="https://github.com/hanwldn76/Algorithm/assets/138774991/10fbd310-86a0-4f2a-ada2-da2203ccf7ff">

<br>

**시간 복잡도**

- 시간복잡도 O(NlogN)을 가진다는 점에서 퀵정렬 보완.
- 불필요 메모리 사용 최소화
  
