import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;

        int cnt = Integer.bitCount(n);
        answer = n;

        while(true){
            if(Integer.bitCount(++answer)==cnt) break;
        }

        return answer;
    }
}