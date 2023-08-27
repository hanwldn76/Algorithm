import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        // 문자열의 길이
        int len = 0;

        while(!s.equals("1")) {
            answer[1] += s.length();

            s = s.replaceAll("0", "");
            len = s.length(); // 0 제거 후 길이

            answer[1] -= len;
            answer[0]++;

            s = Integer.toBinaryString(len);
        }

        return answer;
    }
}