package baekjoon.tony.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호_silver_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            System.out.println(find(br.readLine()));
        }
    }
    public static String find(String str){
        Stack<Character> stack=new Stack<>();
        for(int j=0;j<str.length();j++){
            if(str.charAt(j)=='('){
                stack.add('(');
            }else if(stack.isEmpty()){
                return "NO";
            }else{
                stack.pop();
            }
        }

        if(stack.size()!=0){
            return "NO";
        }else{
            return "YES";
        }
    }
}
