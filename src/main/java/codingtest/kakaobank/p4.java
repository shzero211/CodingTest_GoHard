package codingtest.kakaobank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class p4 {

    static class Node {
        private int call;
        private int running;
        private int category;
        private int important;

        public Node(int call, int running, int category, int important) {
            this.call = call;
            this.running = running;
            this.category = category;
            this.important = important;
        }
    }

    public static boolean isAllvisited(boolean [] visited){
        for(int i=0;i< visited.length;i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }

    public static void solution(int[][] jobs){
        int nowTime=0;
        ArrayList<Node> arr=new ArrayList<>();

        for(int i=0;i<jobs.length;i++){
            Node node=new Node(jobs[i][0],jobs[i][1],jobs[i][2],jobs[i][3]);
            arr.add(node);
        }
        int beforeCategory=0;
       boolean[] visited=new boolean[arr.size()];
        Queue<Node> queue=new LinkedList<>();
        queue.add(arr.get(0));
        visited[0]=true;
        boolean start=true;
        while(true){
            Node nowNode=queue.poll();
            if(start){
                nowTime=arr.get(0).call+arr.get(0).running;
                start=false;
            }else{
                nowTime+= nowNode.running;
            }
            beforeCategory=nowNode.category;
            for(int i=0;i<arr.size();i++){
               if(arr.get(i).call<=nowTime&&!visited[i]){
                   queue.add(arr.get(i));
                   visited[i]=true;
               }
            }
        }
    }
    public static void main(String[] args) {
        solution(new int[][] {
                {1, 2, 1, 5}, {2, 1, 2, 100} , {3, 2, 1, 5} , {5, 2, 1, 5}
        });
    }
}
