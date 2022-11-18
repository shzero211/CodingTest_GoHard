package barkingDog.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//풀이 과정
//1. 시작 지점과 도착지점이 정해져 있기때문에 한번의 bfs 과정만으로 답을 구할수있다고 생각
//2.dist 이중 배열을 이용해서 거리와 방문 표시 문제를 해결함
public class 미로탐색_2178 {
    static int row;
    static int col;
    static int[][] arr;
    static int[][] dist;
    static Queue<int[]>queue;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    private static void bfs(){
        while(!queue.isEmpty()){
            int[] idx=queue.poll();
            int x=idx[0];
            int y=idx[1];
            for(int i=0;i<4;i++){
                int px=x+dx[i];
                int py=y+dy[i];
                if(px<0||py<0||px>=row||py>=col){
                    continue;
                }
                if(dist[px][py]==-1&&arr[px][py]==1){
                    dist[px][py]=dist[x][y]+1;
                    queue.add(new int[]{px,py});
                }
            }
        }
    }
    public static void solution() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] nums=br.readLine().split(" ");
        row=Integer.parseInt(nums[0]);
        col=Integer.parseInt(nums[1]);
        arr=new int[row][col];
        dist=new int[row][col];//거리 저장 배열
        queue=new LinkedList<>();//탐색 순서를 저장하는 큐

        for(int i=0;i<row;i++){
            String[] strs=br.readLine().split("");
            for(int j=0;j<col;j++){
            int num=Integer.parseInt(strs[j]);
            arr[i][j]=num;
            dist[i][j]=-1;
            }
        }
        dist[0][0]=1;
        queue.add(new int[]{0,0});
        bfs();
        System.out.println(dist[row-1][col-1]);
    }
    public static void main(String[] args) {
        try {
            solution();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
