import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[]{0, 0};

        int len1 = s.length();
        String tmp = new String(s);

        while(len1 != 1) {
            // 제거할 0의 개수
            int len2 = 0;

            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == '0') {
                    len2++;
                    continue;
                }
            }

            // 0 제거 후 길이
            len1 = tmp.length() - len2;

            tmp = Integer.toBinaryString(len1);

            answer[0]++;
            answer[1] += len2;
        }

        return answer;
    }
}