import java.util.*;

class Solution {
    public int solution(int[] number) {
        int answer = 0;

        for(int i = 0; i<number.length-1; i++) {
            for (int j = i + 1; j < number.length; j++) {
                int tmp = 0;
                tmp = number[i]+number[j];

                for(int k = j+1; k<number.length; k++){
                    if(tmp+number[k]==0) answer++;
                }
            }
        }

        return answer;
    }
}