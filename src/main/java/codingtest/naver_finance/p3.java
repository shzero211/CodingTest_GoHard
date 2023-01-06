package codingtest.naver_finance;

import java.util.Arrays;

public class p3 {
    static int n;
    static boolean[] visited;
    static double min=Integer.MAX_VALUE;
    public static int solution(int[][] games){
        n=games.length;
        visited=new boolean[n];
        dfs(0,0,games);
        System.out.println(min);
        return 0;
    }
    public static void dfs(int day,double sum,int[][] games){
        int visi=0;
        for(int i=0;i<n;i++){
            if(visited[i]){
                visi++;
            }
        }
        if(visi==n){
            min=Math.min(min,sum);
            return;
        }

        boolean flag=false;

        //할인날짜 중복있는지 먼저 계산
        for(int i=0;i<n;i++){
            if(games[i][1]==day){
                if(!visited[i]){
                    System.out.println("방문");
                    double price=games[i][0];
                    visited[i]=true;
                    price=price-(price*(games[i][2]*0.01));
                    dfs(day,sum+price,games);
                    visited[i]=false;
                }
            }
        }

        //할인날짜가 없는 경우
        for(int i=0;i<n;i++){
            if(!visited[i]){
                double price=games[i][0];
                visited[i]=true;
                dfs(day+1,sum+price,games);
                visited[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        solution(new int[][]{{100,0,50},{100,0,50},{100,0,50},{10000,3,50}});
    }
}
