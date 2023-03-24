package baekjoon.문제집.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p4_촌수계산 {
    static int n,a,b,answer;
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;
    private static class Node{
        private int num;
        private int cnt;
        public Node(int num,int cnt){
            this.num=num;
            this.cnt=cnt;
        }

        public int getNum() {
            return num;
        }
        public int getCnt(){
            return cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        list=new ArrayList<>();
        n=Integer.parseInt(st.nextToken());
        visited=new boolean[n+1];

        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }

        st=new StringTokenizer(br.readLine());
        a=Integer.parseInt(st.nextToken());
        b=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        int m=Integer.parseInt(st.nextToken());

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int left=Integer.parseInt(st.nextToken());
            int right=Integer.parseInt(st.nextToken());
            list.get(left).add(right);
            list.get(right).add(left);
        }

        Queue<Node> queue=new LinkedList<>();
        queue.add(new Node(a,0));
        visited[a]=true;

        while(!queue.isEmpty()){
            Node beforeNode=queue.poll();
            int beforeNum=beforeNode.getNum();
            int beforeCnt=beforeNode.getCnt();

            if(beforeNum==b){
                answer=beforeCnt;
            }

            for(int i=0;i<list.get(beforeNum).size();i++){
                int afterNum=list.get(beforeNum).get(i);
                if(!visited[afterNum]){
                    queue.add(new Node(afterNum,beforeCnt+1));
                    visited[afterNum]=true;
                }
            }
        }
        if(answer==0){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }
    }
}
