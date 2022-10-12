package baekjoon.tony.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 후위표기식2_silver_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer>st=new Stack<>();
        int n=Integer.parseInt(br.readLine());
        Queue<Integer> q=new LinkedList<>();
        char[] chars= br.readLine().toCharArray();
        for(int i=0;i<n;i++){
            q.add(Integer.parseInt(br.readLine()));
        }
        int idx=0;
        while (idx<chars.length){
            if(chars[idx]>'A'&&chars[idx]<'Z'){
                st.add(q.poll());
            }
            else{
                        int n1=st.pop();
                        int n2=st.pop();
                        if(chars[idx]=='-'){
                            st.add(n2-n1);
                        }
                        if(chars[idx]=='+'){
                            st.add(n2+n1);
                        }
                        if(chars[idx]=='*'){
                            st.add(n2*n1);
                        }
                        if(chars[idx]=='/'){
                            st.add(n2/n1);
                        }
                    }
            idx++;
        }
        System.out.println(st.pop());
    }
}
