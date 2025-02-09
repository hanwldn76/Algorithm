import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> s = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		int order = 1;
		boolean isCorrect = true;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp == order) {
				order++;
			}else {
				while(true) {
					if(!s.isEmpty()&& (s.peek()==order)) {
						s.pop();
						order++;
					}else {
						s.push(tmp);
						break;
					}
				}
			}
		}
		
		while(!s.isEmpty()) {
			if(s.pop()==order) order++;
			else isCorrect = false;
		}
		
		System.out.println(isCorrect && s.isEmpty() ? "Nice" : "Sad");
	}
}