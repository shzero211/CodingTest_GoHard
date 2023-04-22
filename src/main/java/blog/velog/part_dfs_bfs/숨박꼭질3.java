package blog.velog.part_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨박꼭질3 {

    static int n;
    static int m;
    static int min=Integer.MAX_VALUE;
    static int[] dp={-1,1};
    static int[] visited=new int[100001];
    private static class Node{

        private int position;
        private int time;

        public Node(int position,int time){
            this.position=position;
            this.time=time;
        }
        public int getPosition(){
            return position;
        }
        public int getTime(){
            return time;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        bfs();

    }
    public static void bfs(){
        Queue<Node> queue=new LinkedList<>();
        Node startNode=new Node(n,1);
        queue.add(startNode);
        while(!queue.isEmpty()){
            Node node=queue.poll();

            int nowP=node.getPosition();
            int nowT=node.getTime();

            //오른쪽 한칸
            if(nowP+1>=0&&nowP+1<=100000){
                if(visited[nowP+1]==0||visited[nowP+1]>nowT+1){
                    visited[nowP+1]=nowT+1;
                    queue.add(new Node(nowP+1,nowT+1));
                }
            }

            //오른쪽 한칸
            if(nowP-1>=0&&nowP-1<=100000){
                if(visited[nowP-1]==0||visited[nowP-1]>nowT+1){
                    visited[nowP-1]=nowT+1;
                    queue.add(new Node(nowP-1,nowT+1));
                }
            }

            //오른쪽 한칸
            if(nowP*2>=0&&nowP*2<=100000){
                if(visited[nowP*2]==0||visited[nowP*2]>nowT){
                    visited[nowP*2]=nowT;
                    queue.add(new Node(nowP*2,nowT));
                }
            }
        }
        System.out.println(visited[m]-1);
    }
}
