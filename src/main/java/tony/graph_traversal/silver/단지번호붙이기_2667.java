package tony.graph_traversal.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 단지번호붙이기_2667 {
   static int [][] arr;
    static boolean [][] visited;
    static List<Integer> list=new ArrayList<>();
    static int m;
    static int cnt;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        m=Integer.parseInt(br.readLine());
        arr=new int[m][m];
        visited=new boolean[m][m];
        for(int i=0;i<m;i++){
            String s=br.readLine();
            for(int j=0;j<m;j++){
                char c=s.charAt(j);
                arr[i][j]=c-'0';
            }
        }
       for(int i=0;i<m;i++){
           for(int j=0;j<m;j++){
              if(visited[i][j]==false&&arr[i][j]==1){
                  cnt=0;
                  dfs(i,j);
                  list.add(cnt);
              }
           }
       }
        Collections.sort(list);
        System.out.println(list.size());
       for(int num:list){
           System.out.println(num);
       }
    }
    public static void dfs(int x,int y){
        visited[x][y]=true;
        cnt++;
        for(int i=0;i<4;i++){
            int nextx=x+dx[i];
            int nexty=y+dy[i];
            if(nextx>=0&&nexty>=0&&nextx<=m-1&&nexty<=m-1){
                if(visited[nextx][nexty]==false&&arr[nextx][nexty]==1){
                    visited[nextx][nexty]=true;
                    dfs(nextx,nexty);
                }
            }
        }
    }
}
