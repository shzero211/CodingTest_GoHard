package baekjoon.teamNote.Dijkstra;

import java.util.ArrayList;
import java.util.Scanner;

public class Dijkstra {
    /*
    * 노드 클래스
    * */
    static class Node{
        int idx;
        int cost;
        Node(int idx,int cost){
            this.idx=idx;
            this.cost=cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //노드 개수
        int v=sc.nextInt();
        //간선 개수
        int e=sc.nextInt();
        //시작 지점
        int start=sc.nextInt();
        //전체 그래프
        ArrayList<ArrayList<Node>> arr=new ArrayList<>();
        //방문 여부
        boolean[] visited=new boolean[v+1];
        //각 노드 까지 가는 최소 값
        int[] dist=new int[v+1];
        //그래프 초기화
        for(int i=0;i<v+1;i++){
            arr.add(new ArrayList<>());
        }
        //입력 값으로 그래프 데이터 생성
        for(int i=0;i<e;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int cost=sc.nextInt();
            arr.get(a).add(new Node(b,cost));
        }
        //각 노드 최소 이동 값 초기화
        for(int i=0;i<v+1;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        //시작 노드 초기화
        dist[start]=0;

        for(int i=0;i<v;i++){
            int nodeValue=Integer.MAX_VALUE;
            int nodeIdx=0;
        }

    }
}
