package baekjoon.barkingDog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 마로탐색_2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] numStr=br.readLine().split(" ");
        int a=Integer.parseInt(numStr[0]);
        int b=Integer.parseInt(numStr[1]);
        int[][] arr=new int[a][b];
        int[]dx={-1,0,1,0};
        int [] dy={0,-1,0,1};
        for(int i=0;i<a;i++){
           String[] lineNums=br.readLine().split("");
           for(int j=0;j<lineNums.length;j++){
               arr[i][j]=Integer.parseInt(lineNums[j]);
           }
        }

        Queue<int[]> queue=new LinkedList<>();
        boolean[][] visited=new boolean[a][b];

        queue.add(new int[]{0,0});
        visited[0][0]=true;
        while(!queue.isEmpty()){
            int[] num=queue.poll();
            for(int i=0;i<4;i++){
                int px=num[0]+dx[i];
                int py=num[1]+dy[i];
                if(px>=0&&py>=0&&px<a&&py<b){
                    if(!visited[px][py]&&arr[px][py]==1){
                        queue.add(new int[]{px,py});
                        arr[px][py]=arr[num[0]][num[1]]+1;
                        visited[px][py]=true;
                    }
                }
            }
        }
        System.out.println(arr[a-1][b-1]);
    }
}
