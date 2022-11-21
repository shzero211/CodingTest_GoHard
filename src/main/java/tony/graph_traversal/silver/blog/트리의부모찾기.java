package tony.graph_traversal.silver.blog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//문제 풀이 정리
//핵심은 탐색을 추가로 진행하기전에 부모노드를 기록해놔야한다는것
public class 트리의부모찾기 {
    static ArrayList<ArrayList> arr=new ArrayList<>();
    static boolean[] visited;
    static int[] parents;//부모의 노드를 기록해 놓는 배열
    private static void solution() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        visited=new boolean[n+1];
        parents=new int[n+1];

        for(int i=0;i<=n;i++){
            arr.add(new ArrayList());
        }

        for(int i=0;i<n-1;i++){
            String[] node=br.readLine().split(" ");
            int a=Integer.parseInt(node[0]);
            int b=Integer.parseInt(node[1]);
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        Queue<Integer> queue=new LinkedList<>();
        queue.add(1);
        visited[1]=true;
        while(!queue.isEmpty()){
            int nowNode=queue.poll();
            ArrayList<Integer> list=arr.get(nowNode);
            for(int i=0;i<list.size();i++){
                int nextNode=list.get(i);
                if(!visited[nextNode]){
                    visited[nextNode]=true;
                    queue.add(nextNode);
                    parents[nextNode]=nowNode;
                }
            }
        }
        for(int parent:parents){
            if(parent!=0){
                System.out.println(parent+" ");
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
