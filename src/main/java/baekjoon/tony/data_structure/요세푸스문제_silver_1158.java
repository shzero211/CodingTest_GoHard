package baekjoon.tony.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스문제_silver_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;i++){
            q.add(i);
        }
        while (!q.isEmpty()){
            for(int i=0;i<k-1;i++){
                int num=q.poll();
                q.add(num);
            }
           if(q.size()!=1){
               sb.append(q.poll()).append(", ");
           }else{
               sb.append(q.poll());
           }
        }
        System.out.println("<"+sb.toString()+">");
    }
}
