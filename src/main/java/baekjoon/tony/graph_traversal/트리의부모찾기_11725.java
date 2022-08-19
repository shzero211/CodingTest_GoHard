package baekjoon.tony.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리의부모찾기_11725 {
    static boolean[ ] visited;
    static int [] parent;
    static ArrayList<ArrayList<Integer>> arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
      arr=new ArrayList<>();
      visited=new boolean[n+1];
      parent=new int[n+1];
        for(int i=0;i<=n;i++){
            arr.add(new ArrayList());
        }

        for(int i=0;i<n-1;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }
        bfs(1);
    }
    public static void bfs(int start){
        Queue<Integer> q=new LinkedList<>();
        q.offer(start);
        visited[start]=true;
        while(!q.isEmpty()){
            int k=q.poll();
            for(int num:arr.get(k)){
               if(!visited[num]){
                   visited[num]=true;
                   q.add(num);
                   parent[num]=k;
                  }
             }
            }
        for(int i=2;i<parent.length;i++){
            System.out.println(parent[i]);
        }
    }
}
