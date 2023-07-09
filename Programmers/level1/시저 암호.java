import java.util.*;

class Solution {
    public String solution(String s, int n) {
        String answer = "";

        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == ' ') answer += s.charAt(i);
            else if(Character.isLowerCase(s.charAt(i)) && (int)'z' < (int)s.charAt(i) + n)
                answer += (char)((int)s.charAt(i) + n - 26);
            else if(Character.isUpperCase(s.charAt(i)) && (int)'Z' < (int)s.charAt(i) + n)
                answer += (char)((int)s.charAt(i) + n - 26);
            else answer += (char)((int)s.charAt(i) + n);
        }

        return answer;
    }
}