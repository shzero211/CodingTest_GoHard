package barkingDog.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
//구현과정
//1.시작점이 정해져 있는것이아니기 때문에 2중 for 문으로 bfs 시작점 찾기
//2.일반적인 bfs 과정과 같지만 그림의 개수와 최대 면적을 구하는 문제이기때문에 전역변수를 이용해서 값으 추가및 저장
public class 그림_1926 {
    static boolean[][] visited;
    static int[][] arr;
    static int row;
    static int col;
    static Queue<Integer[]> queue;
    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};
    static int drawNum=0;
    static int maxDraw=0;

    private static  void bfs(){
        int drawArea=1;
    while(!queue.isEmpty()){
        Integer [] idx=queue.poll();
        int x=idx[0];
        int y=idx[1];

        for(int i=0;i<4;i++){
            int px=x+dx[i];
            int py=y+dy[i];
            if(px<0||py<0||px>=row||py>=col){
                continue;
            }
            if(!visited[px][py]&&arr[px][py]==1){

                visited[px][py]=true;
                queue.add(new Integer[]{px,py});
                drawArea++;
            }
        }
    }
    if(maxDraw<drawArea){
        maxDraw=drawArea;
    }
    drawNum++;
    }

    public static void solution() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] numStr=br.readLine().split(" ");
        row=Integer.parseInt(numStr[0]);
        col=Integer.parseInt(numStr[1]);

        arr=new int[row][col];
        visited=new boolean[row][col];
        queue=new LinkedList<>();

        for(int i=0;i<row;i++){
            String[] nums=br.readLine().split(" ");
            for(int j=0;j<col;j++){
               int num=Integer.parseInt( nums[j]);
                arr[i][j]=num;
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!visited[i][j]&&arr[i][j]==1){
                    visited[i][j]=true;
                    queue.add(new Integer[]{i,j});
                    bfs();
                }
            }
        }
        System.out.println(drawNum);
        System.out.println(maxDraw);
    }

    public static void main(String[] args) {
        try {
            solution();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
