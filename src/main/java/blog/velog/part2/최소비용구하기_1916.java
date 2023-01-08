package blog.velog.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class 최소비용구하기_1916 {
    static int m;
    static int n;
    static ArrayList<ArrayList<Node>> arr;
    static int [] dist;
    static  boolean[] check;
    static class Node implements Comparable<Node>{
        int end;
        int weight;
        Node(int end,int weight){
            this.end=end;
            this.weight=weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight-o.weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n=Integer.parseInt(br.readLine());
        m=Integer.parseInt(br.readLine());

        arr=new ArrayList<>();
        dist=new int[n+1];
        check=new boolean[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        for(int i=0;i<=n;i++){
            arr.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int weight=Integer.parseInt(st.nextToken());
            arr.get(start).add(new Node(end,weight));
        }
        st=new StringTokenizer(br.readLine());
        int start=Integer.parseInt(st.nextToken());
        int end=Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start,end));

    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq=new PriorityQueue<>();
        check=new boolean[n+1];
        pq.offer(new Node(start,0));
        dist[start]=0;
        while(!pq.isEmpty()){
            Node curNode=pq.poll();
            int cur=curNode.end;
            if(!check[cur]){
                check[cur]=true;
                for(Node node:arr.get(cur)){
                    if(!check[node.end]&&dist[node.end]>dist[cur]+node.weight){
                        dist[node.end]=dist[cur]+node.weight;
                        pq.add(new Node(node.end,dist[node.end]));
                    }
                }
            }
        }
        return dist[end];
    }
}
