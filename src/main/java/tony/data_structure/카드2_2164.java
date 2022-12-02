package tony.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 카드2_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(br.readLine());
        Queue<Integer> queue=new LinkedList<>();
        for(int i=1;i<=a;i++){
            queue.add(i);
        }
        while (queue.size()!=1){
            queue.poll();
            int num=queue.poll();
            queue.add(num);
        }
        System.out.println(queue.poll());
    }
}
