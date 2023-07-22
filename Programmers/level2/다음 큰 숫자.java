import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;

        String s = Integer.toBinaryString(n);
        int cnt1 = 0;

        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)=='1') cnt1++;
        }

        answer = n;

        while(true){
            String tmp = Integer.toBinaryString(++answer);
            int cnt2 = 0;
            for(int i = 0; i<tmp.length(); i++){
                if(tmp.charAt(i)=='1') cnt2++;
            }
            if(cnt1 == cnt2) break;
        }

        return answer;
    }
}