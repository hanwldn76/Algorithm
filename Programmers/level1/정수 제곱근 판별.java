import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        long number = (long)Math.sqrt(n);
        answer = (long) (number*number==n?Math.pow(number+1, 2):-1);
        return answer;
    }
}