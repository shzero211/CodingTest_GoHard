package baekjoon.문제집.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class N과M_1 {
    static int n;
    static int m;
    static boolean[] visited;
    static Stack list;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        String[] strN=str.split(" ");
        n=Integer.parseInt(strN[0]);
        m=Integer.parseInt(strN[1]);
        visited=new boolean[n+1];
        list=new Stack();
        dfs();
    }
    static private void dfs(){
        if(list.size()==m){
            list.stream().forEach(x-> System.out.printf(x+" "));
            System.out.println();
            return;
        }
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                visited[i]=true;
                list.add(i);
                dfs();
                list.pop();
                visited[i]=false;
            }
        }
    }
}
