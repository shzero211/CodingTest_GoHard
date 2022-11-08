package baekjoon.tony.graph_traversal.silver.re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DFS와BFS_RE {
   static List<ArrayList<Integer>> arr=new ArrayList<>();
   static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] p=br.readLine().split(" ");
        int point=Integer.parseInt(p[0]);
        int line=Integer.parseInt(p[1]);
        int start=Integer.parseInt(p[2]);

        for(int i=0;i<point+1;i++){
            arr.add(new ArrayList<>());
        }

        for(int i=0;i<line;i++){
            String num[]=br.readLine().split(" ");
            int numL=Integer.parseInt(num[0]);
            int numR=Integer.parseInt(num[1]);

            arr.get(numL).add(numR);
            arr.get(numR).add(numL);
        }

        visited=new boolean[point+1];
        dfs(start);
        System.out.println();
        visited=new boolean[point+1];
        bfs(start);
    }
    public static  void dfs(int idx){
        visited[idx]=true;
        System.out.printf(idx+" ");
        for(int num:arr.get(idx)){
            if(!visited[num]){
                dfs(num);
            }
        }
    }
    public static void bfs(int idx){
        System.out.printf(idx+" ");
        Queue<Integer> queue=new LinkedList<>();
        queue.add(idx);
        visited[idx]=true;
        while(!queue.isEmpty()){
            int num= queue.poll();
            for(int k:arr.get(num)){
                if(!visited[k]){
                    visited[k]=true;
                    System.out.printf(k+" ");
                }
            }
        }
    }
}
