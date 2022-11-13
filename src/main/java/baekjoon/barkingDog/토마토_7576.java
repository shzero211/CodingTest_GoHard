package baekjoon.barkingDog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 토마토_7576 {
     public static void solution() throws IOException {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         int[] dx={-1,1,0,0};
         int[] dy={0,0,-1,1};
         String[] str=br.readLine().split(" ");
         int a=Integer.parseInt(str[0]);
         int b=Integer.parseInt(str[1]);
         int[][] arr=new int[b][a];
         Queue<int[]> queue=new LinkedList<>();
         boolean[][] visited=new boolean[b][a];

         for(int i=0;i<b;i++){
             String[] line=br.readLine().split(" ");
            for(int j=0;j<line.length;j++){
                arr[i][j]=Integer.parseInt(line[j]);
                if(arr[i][j]==1){
                    queue.add(new int[]{i,j});
                }
            }
         }

         int max=0;

         while(!queue.isEmpty()){
             int[] idx=queue.poll();
             int  x=idx[0];
             int  y=idx[1];
             for(int i=0;i<4;i++){
                 int px=x+dx[i];
                 int py=y+dy[i];
                 if(px>=0&&py>=0&&px<b&&py<a){
                     if(!visited[px][py]&&arr[px][py]==0){
                         queue.add(new int[]{px,py});
                         visited[px][py]=true;
                         arr[px][py]=arr[x][y]+1;
                        if(max<arr[px][py]){
                            max=arr[px][py];
                        }
                     }
                 }
             }
         }

         for(int i=0;i<visited.length;i++){
             for(int j=0;j<visited[i].length;j++){
                 if(arr[i][j]==0){
                     System.out.println(-1);
                     return;
                 }
             }
         }

        if(max==0){
            System.out.println(0);
        }else{
            System.out.println(max-1);
        }
     }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
