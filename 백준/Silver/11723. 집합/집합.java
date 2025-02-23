import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        
        int b = 0;
        for(int i = 0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	String s = st.nextToken();
        	
        	// all, empty는 문자열 토큰 하나만 들어오니까 이 두 경우에 대한 처리해주고
        	// 나머지 경우에 다음토큰을 가져오고 연산하도록 함 
        	
        	// all 일경우 b=~0해서 모든 비트를 다 켜줬는데 그러면 20비트 상위 비트들도 모두 1이 되버림
        	// 그래서 b = (1 << 21) - 1; 로 바꿔서 하위 20비트만 1로 설정 
        	if(s.equals("all")) {
        		b = (1 << 21) - 1;
        	}else if(s.equals("empty")){
        		b = 0;
        	}else {
        		int tmp = Integer.parseInt(st.nextToken());
        		// 중복되는 부분 위로 빼기...!
        		int bit = 1<<tmp;
            	
            	if(s.equals("add")) {
            		b = b | bit;
            	}else if(s.equals("check")) {
            		if((b & bit) != 0) sb.append(1).append("\n");
            		else sb.append(0).append("\n");
            	}else if(s.equals("remove")) {
            		tmp = ~bit;
            		b = b & tmp;
            	}else if(s.equals("toggle")) {
            		if((b & bit) != 0) {
                		b = b ^ bit;
            		}else {
            			b = b | bit;
            		}
            	}
        	}
        	
//        	System.out.println(Integer.toBinaryString(b));
        }
        
        System.out.print(sb);
	}
}