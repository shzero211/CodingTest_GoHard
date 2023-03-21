package baekjoon.문제집.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1_게임 {
    static int max,n,m;
    static boolean cycle;
    static char[][] map;
    static int[][] dp;
    static boolean[][] visited;

    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        map=new char[n][m];
        dp=new int[n][m];
        visited=new boolean[n][m];

        for(int i=0;i<n;i++){
            char[] lineNums=br.readLine().toCharArray();
            for(int j=0;j<m;j++){
                map[i][j]=lineNums[j];
            }
        }
        max=0;
        visited[0][0]=true;
        dfs(0,0,0);
        if(cycle){
            System.out.println(-1);
        }else{
            System.out.println(max+1);
        }
    }
    public static void dfs(int x,int y,int cnt){
        int len=Character.getNumericValue(map[x][y]);

        dp[x][y]=cnt;//dp에 기록

        if(max<cnt){//최대 길이 갱신
            max=cnt;
        }

        for(int i =0;i<4;i++){
            int nextX=x+dx[i]*len;
            int nextY=y+dy[i]*len;



            if(nextX<0||nextY<0||nextX>=n||nextY>=m) continue;//범위 밖

            if(map[nextX][nextY]=='H') continue; // 구멍에 빠지면

            if(cnt+1<=dp[nextX][nextY]) continue;// 이미 이전에 더 긴 거리가 입력 되었더라면

            if(visited[nextX][nextY]==true) {//사이클 체크
                cycle=true;
                return;
            }

            visited[nextX][nextY]=true;
            dfs(nextX,nextY,cnt+1);
            visited[nextX][nextY]=false;

        }
    }
}
