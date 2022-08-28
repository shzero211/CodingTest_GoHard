package baekjoon.tony.graph_traversal.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//문제를 읽어보니 깊이에 대한 말은없고 주변에 연결된  컴퓨터의 개수를 찾는 문제라는것을
//보고 bfs로 풀어야 겠다고 생각했다.(넓게 완전탐색)
//문제풀다가 처음넣는 값의 visited 값을 안넣어줘서 개수가 1개 더많았었음
public class 바이러스_re {
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int m=Integer.parseInt(br.readLine());
        int n=Integer.parseInt(br.readLine());
        arr=new int[m+1][m+1];
        visited=new boolean[m+1];
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            arr[a][b]=1;
            arr[b][a]=1;
        }
        bfs(1);
    }
    public static void bfs(int num){
        Queue<Integer> q=new LinkedList<>();
        q.offer(num);
        visited[num]=true;
        int cnt=0;
        while(!q.isEmpty()){
            int out=q.poll();
            for(int i=1;i<arr.length;i++){
                if(arr[out][i]==1&&visited[i]==false){
                    visited[i]=true;
                    cnt++;
                    q.offer(i);
                }
            }
        }
        System.out.println(cnt);
    }
}
