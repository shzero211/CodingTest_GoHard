package baekjoon.문제집.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p5_스타트링크 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int F=Integer.parseInt(st.nextToken());
        int S=Integer.parseInt(st.nextToken());
        int G=Integer.parseInt(st.nextToken());
        int U=Integer.parseInt(st.nextToken());
        int D=Integer.parseInt(st.nextToken());

        int[] arr=new int[F+1];//이동 횟수 저장

        Queue<Integer> queue=new LinkedList<>();
        queue.add(S);
        arr[S]=1;
        int cnt=0;

        while(!queue.isEmpty()){
            int floor=queue.poll();
            if(floor==G){
                cnt=arr[floor]-1;
                break;
            }

            if(floor+U<=F&&arr[floor+U]==0){
                arr[floor+U]=arr[floor]+1;
                queue.add(floor+U);
            }

            if(floor-D>0&&arr[floor-D]==0){
                    arr[floor-D]=arr[floor]+1;
                    queue.add(floor-D);
            }
        }

      if(arr[G]==0){
          System.out.println("use the stairs");
      }else{
          System.out.println(cnt);
      }
    }
}
