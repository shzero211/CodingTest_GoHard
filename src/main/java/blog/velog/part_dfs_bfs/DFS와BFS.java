package blog.velog.part_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class DFS와BFS {
    static int n;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list;
    public static void solution() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        visited=new boolean[n+1];
        int m=Integer.parseInt(st.nextToken());
        int start=Integer.parseInt(st.nextToken());
        list=new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<=n;i++){
            list.add(new ArrayList<Integer>());
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int v1=Integer.parseInt(st.nextToken());
            int v2=Integer.parseInt(st.nextToken());
            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }
        for(int i=0;i<=n;i++){
            Collections.sort(list.get(i));
        }
        visited[start]=true;
        dfs(start,1);
        System.out.println();
        visited=new boolean[n+1];
        bfs(start);
    }

    //dfs
    public static void dfs(int start,int len){
        if(len==n+1){
            return;
        }
        System.out.printf(start+" ");
        for(int i=0;i<list.get(start).size();i++){
            int idx=list.get(start).get(i);//리스트안 리스트의 속 인덱스값
            if(!visited[idx]){
                visited[idx]=true;
                dfs(idx,len+1);
            }
        }
    }

    public static void bfs(int start){
        Queue<Integer> q=new LinkedList<>();
        int len=1;
        q.add(start);
        visited[start]=true;
        while(!q.isEmpty()){
            int idx=q.poll();
            System.out.printf(idx+" ");
            for(int i=0;i<list.get(idx).size();i++){
                int next=list.get(idx).get(i);
                if(!visited[next]){
                    visited[next]=true;
                    q.add(next);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}
