package blog.velog.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 괄호의값_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        char[]  carr =br.readLine().toCharArray();//계산을 위한 array
       Stack<Character> stack=new Stack<>();//짝을 이루었는지 파악하기위한 stack
       int answer=0;
       int temp=1;
        for(int i=0;i<carr.length;i++){
            if(carr[i]=='('){
                stack.add('(');
                temp*=2;
            }
            if(carr[i]=='['){
                stack.add('[');
                temp*=3;
            }
            if(carr[i]==')'){
                if(stack.isEmpty()||stack.peek()!='('){
                    answer=0;
                    break;
                }
                if(carr[i-1]=='('){
                    answer+=temp;
                }
                temp/=2;
                stack.pop();
            }
            if(carr[i]==']'){
                if(stack.isEmpty()||stack.peek()!='['){
                    answer=0;
                    break;
                }
                if(carr[i-1]=='['){
                    answer+=temp;
                }
                temp/=3;
                stack.pop();
            }
        }

        if(stack.isEmpty()){
            System.out.println(answer);
        }else{
            System.out.println(0);
        }
    }
}
