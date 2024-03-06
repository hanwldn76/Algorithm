import java.util.*;

class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length()!=4&&s.length()!=6) return false;
        char[] c = s.toCharArray();
        Arrays.sort(c);
        answer = c[c.length-1]<'0'||c[c.length-1]>'9'?false:true;
        return answer;
    }
}