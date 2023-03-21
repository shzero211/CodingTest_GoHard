package baekjoon.문제집.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2_토마토 {
    static int[] dx={-1,1,0,0,0,0};
    static int[] dy={0,0,-1,1,0,0};
    static int[] dz={0,0,0,0,-1,1};
    static int[][][] map;
    static int n,h,m;
    private static class Tomato{
        private int x;
        private int y;
        private int z;
        public Tomato(int z,int x,int y){
            this.x=x;
            this.y=y;
            this.z=z;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        h=Integer.parseInt(st.nextToken());
        map=new int[h][m][n];

        Queue<Tomato>queue=new LinkedList<>();

        int result=Integer.MIN_VALUE;
        for(int i=0;i<h;i++){
            for(int j=0;j<m;j++){
                st=new StringTokenizer(br.readLine());
                for(int k=0;k<n;k++){
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k]==1) queue.add(new Tomato(i,j,k));//익은 토마토 큐에 넣기
                }
            }
        }
        while(!queue.isEmpty()){
            Tomato t=queue.poll();
            int x= t.x;
            int y=t.y;
            int z=t.z;
            for(int i=0;i<6;i++){
                int mx=x+dx[i];
                int my=y+dy[i];
                int mz=z+dz[i];
                if(mx>=0&&my>=0&&mz>=0&&mx<m&&my<n&&mz<h){
                    if(map[mz][mx][my]==0){
                        queue.add(new Tomato(mz,mx,my));
                        map[mz][mx][my]=map[z][x][y]+1;//최소 날짜를 구하기 위한 입력
                    }
                }
            }
        }

        for(int i=0;i<h;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<n;k++){
                    if(map[i][j][k]==0) {
                        System.out.println(-1);
                        return;
                    }
                    result=Math.max(result,map[i][j][k]);
                }
            }
        }
        System.out.println(result-1);
    }
}
