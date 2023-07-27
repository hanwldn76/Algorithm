import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        String [] str = s.split("");
        Stack<String> st = new Stack<>();

        for(int i = 0; i<str.length; i++){
            if(!st.isEmpty() && st.peek().equals(str[i])){
                st.pop();
            }
            else{
                st.push(str[i]);
            }
        }

        answer = st.isEmpty()?1:0;

        return answer;
    }
}