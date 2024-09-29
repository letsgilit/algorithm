package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q17413_ReverseString_Stack {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        Stack<Character> wordStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        for (char c : str.toCharArray()) {
            if(c == '<'){
                stack.push(c);
                while(!wordStack.isEmpty()){
                    sb.append(wordStack.pop());
                }
                sb.append(c);
            }else if(c == '>'){
                stack.pop();
                sb.append(c);
            }else if(stack.isEmpty()){
                if(c == ' '){
                    while(!wordStack.isEmpty()){
                        sb.append(wordStack.pop());
                    }
                    sb.append(c);
                }else{
                    wordStack.push(c);
                }
            }else {
                sb.append(c);
            }
        }
        while(!wordStack.isEmpty()){
            sb.append(wordStack.pop());
        }
        System.out.println(sb);

    }
}