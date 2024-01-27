import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String [] s = String.valueOf(n).split("");
        Arrays.sort(s, Collections.reverseOrder());
        String temp = "";
        for(int i = 0; i<s.length; i++) temp += s[i];
        answer = Long.valueOf(temp);
        return answer;
    }
}