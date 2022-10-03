package baekjoon.tony.tree;

import javax.management.Query;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 트리의부모찾기_silver_11725 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] arr=new int[n+1][n+1];
        boolean[] visited=new boolean[n+1];
        for(int i=0;i<n-1;i++){
            int l=sc.nextInt();
            int r=sc.nextInt();
            arr[l][r]=1;
            arr[r][l]=1;
        }
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        visited[1]=true;
        int[] answer=new int[n+1];
        while(!q.isEmpty()){
            int k=q.poll();
            for(int i=0;i<=n;i++){
                if(arr[k][i]==1&&visited[i]==false){
                    visited[i]=true;
                    q.add(i);
                    answer[i]=k;
                }
            }
        }
        for(int i=2;i<=n;i++){
            System.out.println(answer[i]);
        }
    }
}
