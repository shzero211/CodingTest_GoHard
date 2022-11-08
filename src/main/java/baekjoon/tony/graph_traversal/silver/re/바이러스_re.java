package baekjoon.tony.graph_traversal.silver.re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//처음으로  이중 Array List로 풀어봄
//인덱스를 적게사용하니 읽기 쉬움
//이중배열 구현은 이게 훨씬좋은듯
public class 바이러스_re {
    public static void solution() throws IOException {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
       for(int i=0;i<n+1;i++){
           arr.add(new ArrayList<>());
       }
       for(int j=0;j<m;j++){
           String[] num=br.readLine().split(" ");
           int numL= Integer.parseInt(num[0]);
           int numR=Integer.parseInt(num[1]);
           arr.get(numL).add(numR);
           arr.get(numR).add(numL);
       }
        Queue<Integer> queue=new LinkedList<>();
        boolean[] visited=new boolean[n+1];
        int cnt=0;

       queue.add(1);
       visited[1]=true;
       while(!queue.isEmpty()){
           int p=queue.poll();
           for(int num:arr.get(p)){
               if(!visited[num]){
                   queue.add(num);
                   visited[num]=true;
                   cnt++;
               }
           }
       }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
