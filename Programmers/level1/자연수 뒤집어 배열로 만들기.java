import java.util.*;

class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        List list = new ArrayList();

        while(n>0) {
            list.add((int)(n%10));
            n /= 10;
        }
        answer = new int [list.size()];

        for(int i = 0; i<answer.length; i++) answer[i] = (int) list.get(i);
        return answer;
    }
}