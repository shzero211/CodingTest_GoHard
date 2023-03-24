package baekjoon.문제집.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p3_빙산 {
    static int [][] map;
    static int n,m;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    private static class Ice{
        int x;
        int y;
        public Ice(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new int[n][m];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int year=0;

        while(true){//빙산이 2조각 이상 이전까지 반복
            int iceSplit=iceFind();

            if(iceSplit==0){
                System.out.println(0);
                break;
            }

            //빙산 덩어리 확인
            if(iceSplit>=2){
                System.out.println(year);
                break;
            }

            //빙산 녹이기
            iceDry();

            //년도가 지남
            year++;
        }

    }
    public static void iceDry(){

        Queue<Ice> queue=new LinkedList<>();

        boolean[][] visited=new boolean[n][m];//이전에 빈곳인지 확인용 배열

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]!=0){
                    queue.add(new Ice(i,j));
                    visited[i][j]=true;//이전에 빈곳 아니였다고 표시
                }
            }
        }

        while(!queue.isEmpty()){
            Ice ice=queue.poll();
            int x=ice.x;
            int y=ice.y;
            int dryCnt=0;//주변에 0인 빙산개수
            for(int i=0;i<4;i++){
                int mx=x+dx[i];
                int my=y+dy[i];
                if (mx >= 0 && my >= 0 && mx <n && my <m) {
                    if(!visited[mx][my]&&map[mx][my]==0){
                        dryCnt++;
                        }
                }
            }
            if(map[x][y]-dryCnt<0){
                map[x][y]=0;
            }else{
                map[x][y]-=dryCnt;
            }
        }

    }

    private static int iceFind(){
        boolean[][] visited=new boolean[n][m];
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]&&map[i][j]!=0){
                    visited[i][j]=true;
                    dfs(i,j,visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void dfs(int x,int y,boolean[][] visited){
        for(int i=0;i<4;i++){
            int mx=x+dx[i];
            int my=y+dy[i];
            if (mx >= 0 && my >= 0 && mx <n && my <m) {
                if(!visited[mx][my]&&map[mx][my]!=0){
                    visited[mx][my]=true;
                    dfs(mx,my,visited);
                }
            }
        }
    }
}
