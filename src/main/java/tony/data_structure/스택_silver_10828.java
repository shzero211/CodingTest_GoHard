package tony.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class 스택_silver_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<n;i++){
            String[] str=br.readLine().split(" ");
            switch (str[0]){
                case "push" :
                    int num=Integer.parseInt(str[1]);
                    s.push(num);
                    break;
                case "pop" :
                    if(s.size()!=0)
                        System.out.println(s.pop());
                    else
                        System.out.println(-1);
                    break;
                case "size" :
                    System.out.println(s.size());
                    break;
                case "empty" :
                    if(s.size()==0)
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;
                case "top" :
                    if(s.size()!=0)
                        System.out.println(s.peek());
                    else
                        System.out.println(-1);
                    break;
            }
        }


    }
}
