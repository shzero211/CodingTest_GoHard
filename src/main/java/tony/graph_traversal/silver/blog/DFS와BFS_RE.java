package tony.graph_traversal.silver.blog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//문제 풀이과정
//1. 그래프를 자료구조로 만든다
//2. dfs 로 바로바로 방문후 출력한다
//3. bfs 로 queue 안에 방문할 주변 경로를 저장해서 방문한다.
public class DFS와BFS_RE {
    static ArrayList<ArrayList> arr=new ArrayList<>();
    static boolean[] visited;
    static int n;
    static int m;
    static int start;
    public static void solution() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] nums=br.readLine().split(" ");
        n=Integer.parseInt(nums[0]);//정점개수
        m=Integer.parseInt(nums[1]);//간선개수
        start=Integer.parseInt(nums[2]);//시작정점

        visited=new boolean[n+1];

        // 정점 개수 만큼 배열에 추가(0부터 시작하기때문에 1개더추가)
        for(int i=0;i<=n;i++){
            arr.add(new ArrayList());
        }
        // 각 정점의 간선 연관관계 추가
        for(int i=0;i<m;i++){
            String[] idx=br.readLine().split(" ");
            int a=Integer.parseInt(idx[0]);
            int b=Integer.parseInt(idx[1]);
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        //각 연관관계 오름차순으로 정렬
        for(ArrayList list:arr){
            Collections.sort(list);
        }

        dfs(start);
        System.out.println();
        visited=new boolean[n+1];
        bfs(start);
    }
    public static void dfs(int idx){
        visited[idx]=true;
        System.out.print(idx+" ");
        ArrayList<Integer> arrayList=arr.get(idx);
        for(int i=0;i<arrayList.size();i++){
            int nextIdx=arrayList.get(i);
            if(!visited[nextIdx]){
                dfs(nextIdx);
            }
        }
    }

    public static void bfs(int idx){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(idx);
        visited[idx]=true;
        System.out.print(idx+" ");

        while(!queue.isEmpty()){
            int nowIdx=queue.poll();
            ArrayList<Integer> connect=arr.get(nowIdx);//방문 순서를 저장하는 queue
            for(int i=0;i<connect.size();i++){
                int nextIdx=connect.get(i);
                if(!visited[nextIdx]){
                    visited[nextIdx]=true;
                    queue.add(nextIdx);

                    System.out.printf(nextIdx+" ");
                }
            }
        }
    }
    public static void main(String[] args) {
        try {
            solution();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
