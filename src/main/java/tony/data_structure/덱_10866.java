package tony.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 덱_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq=new LinkedList<>();
        int num=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<num;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            String command=st.nextToken();
            int input=0;
            if(st.hasMoreTokens()){
              input=Integer.parseInt(st.nextToken());
            }
            switch (command){
                case "push_front":
                    dq.addFirst(input);
                    break;
                case "push_back":
                    dq.addLast(input);
                    break;
                case "pop_front":
                    if(!dq.isEmpty()){
                        sb.append(dq.pollFirst());
                    }else{
                        sb.append("-1");
                    }
                    sb.append("\n");
                    break;
                case "pop_back":
                    if(!dq.isEmpty()){
                        sb.append(dq.pollLast());
                    }else{
                        sb.append("-1");
                    }
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(dq.size());
                    sb.append("\n");
                    break;
                case "empty":
                    if(!dq.isEmpty()){
                        sb.append(0);
                    }else{
                        sb.append(1);
                    }
                    sb.append("\n");
                    break;
                case "front":
                    if(!dq.isEmpty()){
                        sb.append(dq.peekFirst());
                    }else{
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;
                case "back":
                    if(!dq.isEmpty()){
                        sb.append(dq.peekLast());
                    }else{
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
