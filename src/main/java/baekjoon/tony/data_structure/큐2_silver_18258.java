package baekjoon.tony.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 큐2_silver_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader( new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        Deque<Integer> q=new LinkedList<>();
        int n=Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            String str=st.nextToken();
            switch (str){
                case "push":
                    q.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    Integer num1=q.poll();
                    if(num1==null){
                        sb.append(-1).append('\n');
                    }else{
                        sb.append(num1).append('\n');
                    }
                    break;
                case "size":
                   sb.append(q.size()).append('\n');
                    break;
                case "empty":
                    if(q.isEmpty()){
                        sb.append(1).append('\n');
                    }else{
                        sb.append(0).append('\n');
                    }
                    break;
                case "front":
                   Integer num2=q.peek();
                    if(num2==null){
                        sb.append(-1).append('\n');
                    }else{
                        sb.append(num2).append('\n');
                    }
                    break;
                    case "back":
                        Integer num3=q.peekLast();
                        if(num3==null){
                            sb.append(-1).append('\n');
                        }else{
                            sb.append(num3).append('\n');
                        }
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
