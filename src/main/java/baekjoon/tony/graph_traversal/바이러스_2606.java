package baekjoon.tony.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 바이러스_2606 {
    static int[][] arr;
    static int[] check;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        arr=new int[n+1][n+1];
        check=new int[n+1];
        for(int i=0;i<m;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            arr[a][b]=1;
            arr[b][a]=1;
        }
        bfs(1);
    }
    private static void bfs(int num){
        Queue<Integer>q=new LinkedList<>();
        q.offer(num);
        check[num]=1;
        int cnt=0;
        while(!q.isEmpty()){
            int k=q.poll();
            for(int i=1;i<arr.length;i++){
                if(arr[k][i]==1&&check[i]!=1){
                    q.offer(i);
                    check[i]=1;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
