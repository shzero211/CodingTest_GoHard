package baekjoon.tony.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 덱_silver_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        Deque<Integer> dq=new LinkedList<>();
        int n=Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String[] str=br.readLine().split(" ");
            switch (str[0]){
                case "push_back":
                    dq.addLast(Integer.parseInt(str[1]));
                    break;
                case "push_front":
                    dq.addFirst(Integer.parseInt(str[1]));
                    break;
                case "pop_front":
                    if(dq.size()==0){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(dq.pollFirst()).append("\n");
                    }
                    break;
                    case "pop_back":
                    if(dq.size()==0){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(dq.pollLast()).append("\n");
                    }
                    break;
                case "front":
                    if(dq.size()==0){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(dq.getFirst()).append("\n");
                    }
                    break;
                case "back":
                    if(dq.size()==0){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(dq.getLast()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(dq.size()).append("\n");
                    break;
                case "empty":
                    if(dq.size()==0){
                        sb.append(1).append("\n");
                    }else{
                        sb.append(0).append("\n");
                    }
                    break;

            }
        }
        System.out.println(sb.toString());
    }
}
