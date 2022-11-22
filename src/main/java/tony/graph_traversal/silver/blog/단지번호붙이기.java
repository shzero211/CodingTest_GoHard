package tony.graph_traversal.silver.blog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 단지번호붙이기 {
    static int[][] arr;
    static boolean[][] visited;

    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int n;
    static ArrayList<Integer> results=new ArrayList<>();
    private static void solution() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        arr=new int[n][n];
        visited=new boolean[n][n];

        for(int i=0;i<n;i++){
            String[] line=br.readLine().split("");
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(line[j]);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
             if(!visited[i][j]&&arr[i][j]==1){
                 int result=bfs(i,j);
                 results.add(result);
             }
            }
        }

        System.out.println(results.size());
        Collections.sort(results);
        for(int result:results){
            System.out.println(result);
        }
    }
    private static int bfs(int x,int y){
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y]=true;
        int cnt=1;
      while(!queue.isEmpty()){
          int[] ori=queue.poll();
          int ox=ori[0];
          int oy=ori[1];
          for(int i=0;i<4;i++){
              int px=ox+dx[i];
              int py=oy+dy[i];
              if(px<0||py<0||px>=n||py>=n){
                  continue;
              }
              if(!visited[px][py]&&arr[px][py]==1){
                  visited[px][py]=true;
                  queue.add(new int[]{px,py});
                  cnt++;
              }
          }
      }
      return cnt;
    }
    public static void main(String[] args) {
        try {
            solution();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
