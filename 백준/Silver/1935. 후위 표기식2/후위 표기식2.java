import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		String s = br.readLine();
		int[] numbers = new int[N];
		Stack<Double> stack = new Stack<Double>();
		
		for(int i = 0; i<N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
	
		for(int i = 0; i<s.length(); i++) {
			if(s.charAt(i)>='A' && s.charAt(i)<='Z') {
				stack.push((double) numbers[s.charAt(i)-65]);
			}else {
				double sum = 0.0;
				
				double b = stack.pop();
				double a = stack.pop();
				
				switch(s.charAt(i)) {
				case('+'):
					sum = a + b;
					break;
				case('-'):
					sum = a - b;
					break;
				case('*'):
					sum = a * b;
					break;
				case('/'):
					sum = a / b;
					break;
				}
				
				stack.push(sum);
			}
		}
		
		System.out.printf("%.2f",stack.peek());	
	}
}
