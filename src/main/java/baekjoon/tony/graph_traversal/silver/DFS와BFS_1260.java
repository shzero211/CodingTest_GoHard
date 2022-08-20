package baekjoon.tony.graph_traversal.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//int arr 이중 배열로 둬서 연결을 저장하는 역활과 탐색에 용이
public class DFS와BFS_1260 {
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int v=Integer.parseInt(st.nextToken());
        arr=new int[n+1][n+1];
        visited=new boolean[n+1];
        for(int i=0;i<m;i++){
           st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            arr[a][b]=1;
            arr[b][a]=1;
        }
        dfs(v);
        visited=new boolean[n+1];
        System.out.println();
        bfs(v);
    }
    public static void dfs(int start){
        visited[start]=true;
        System.out.printf(start+" ");
        for(int i=1;i<arr.length;i++){
            if(arr[start][i]==1&&visited[i]==false){
                dfs(i);
            }
        }
    }
    public static void bfs(int start){
        Queue<Integer> q=new LinkedList<>();
        q.offer(start);
        visited[start]=true;

        while(!q.isEmpty()){
            int k=q.poll();
            System.out.printf(k+" ");
            for(int i=1;i<arr.length;i++){
                if(arr[k][i]==1&&visited[i]==false){
                    q.offer(i);
                    visited[i]=true;
                }
            }
        }
    }
}
