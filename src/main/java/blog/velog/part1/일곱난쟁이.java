package blog.velog.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 일곱난쟁이 {
    static List<Integer> arr=new ArrayList<>();
    static List<Integer> temp=new ArrayList<>();
    static boolean[] visited=new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<9;i++){
            arr.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arr);
        find(0,0);
    }
    static void find(int hap,int len){
        if(hap>=100){
            if(hap==100&&len==7){
                for(int num:temp){
                    System.out.println(num);
                }
                System.exit(0);
            }
            return;
        }
        for(int i=0;i<arr.size();i++){
            if(!visited[i]){
                visited[i]=true;
                temp.add(arr.get(i));
                find(hap+arr.get(i),len+1);
                temp.remove(arr.get(i));
                visited[i]=false;
            }
        }
    }
}
