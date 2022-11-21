package tony.tree;

import javax.management.Query;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 트리의부모찾기_silver_11725 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer>arr[]=new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            arr[i]=new ArrayList<Integer>();
        }
        boolean[] visited=new boolean[n+1];
        for(int i=0;i<n-1;i++){
            int l=sc.nextInt();
            int r=sc.nextInt();
           arr[l].add(r);
           arr[r].add(l);
        }
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        visited[1]=true;
        //부모를 저장하는 배열
        int[] answer=new int[n+1];
        while(!q.isEmpty()){
            int k=q.poll();
            //자식들을 방문하면서 부모삽입해주기
            for(int a:arr[k]){
                if(visited[a]==false){
                    visited[a]=true;
                    q.add(a);
                    answer[a]=k;
                }
            }
        }
        for(int i=2;i<=n;i++){
            System.out.println(answer[i]);
        }
    }
}
