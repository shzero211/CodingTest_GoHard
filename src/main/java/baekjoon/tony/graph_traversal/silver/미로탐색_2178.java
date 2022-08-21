package baekjoon.tony.graph_traversal.silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색_2178 {
    static int [][] arr;
    static int n;
    static int m;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static boolean[][] visited;
     public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
      n=  Integer.parseInt(st.nextToken());
      m=Integer.parseInt(st.nextToken());
    arr=new int[n][m];
    visited=new boolean[n][m];
      for(int i=0;i<n;i++){
          String s=br.readLine();
          for(int j=0;j<m;j++){
              char c=s.charAt(j);
              arr[i][j] = c-'0';
          }
      }
        bfs(new int []{0,0});
         System.out.println(arr[n-1][m-1]);
    }
    public static void bfs(int[] a){
        Queue<int[]> q=new LinkedList<>();
        q.offer(a);
        visited[a[0]][a[1]]=true;
        while(!q.isEmpty()){
            int[] k=q.poll();
            for(int i=0;i<4;i++){
                int nextx=k[0]+dx[i];
                int nexty=k[1]+dy[i];
                if(nextx<0||nexty<0||nextx>=n||nexty>=m)
                    continue;
                if(arr[nextx][nexty]==0||visited[nextx][nexty]==true)
                    continue;
                arr[nextx][nexty]=arr[k[0]][k[1]]+1;
                visited[nextx][nexty]=true;
                q.offer(new int[]{nextx,nexty});
            }
        }
    }
}
