package tony.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 요세푸스_문제_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken())-1;
        Queue<Integer> arr=new LinkedList<>();
        for(int i=1;i<=a;i++){
            arr.add(i);
        }
        System.out.print("<");
        while(!arr.isEmpty()){
            for(int i=0;i<b;i++){
                int num=arr.poll();
                arr.add(num);
            }
            if(arr.size()==1){
                System.out.print(arr.poll());
            }else {
                System.out.print(arr.poll()+", ");
            }
        }
        System.out.println(">");
    }
}
