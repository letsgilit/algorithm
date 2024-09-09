package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9012_Stack {
	public static String checkVPS(String inputdata) {
		String result = "YES";
		Stack<Character> stack = new Stack<>();
		for (char chr : inputdata.toCharArray()) {
			if(chr == '(') {
				stack.push(chr);
			}else {
				if (stack.empty()) {
					result="NO";
				}else {
					stack.pop();
				}
			}
		}
		if(!stack.empty()) {
			result = "NO";
		}
		return result;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
	
		for (int i = 0; i < n; i++) {
			System.out.println(checkVPS(br.readLine()));
		}
	}
}
