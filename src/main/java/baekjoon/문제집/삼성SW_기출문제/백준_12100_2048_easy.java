package baekjoon.문제집.삼성SW_기출문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_12100_2048_easy {
    static int [][] oriMap;
    static int [][] tempMap;
    static boolean[][] visited;
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static int n;
    static int max=0;
    static int[] moveStack=new int[5];
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        oriMap=new int[n][n];

        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                oriMap[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        dfs(5,0);
        System.out.println(max);
    }
    private static void dfs(int end,int cnt){
        for(int i=0;i<4;i++){
            if(end==cnt) {
                confirm();
            }else{
                moveStack[cnt]=i;
                dfs(end,cnt+1);
            }
        }
    }
    private static void confirm(){
        tempMap=new int[n][n];
        for(int i=0;i<n;i++){//map 초기화
            tempMap[i]=oriMap[i].clone();
        }
        for(int p=0;p<5;p++){//전체 스택 순회
            visited=new boolean[n][n];

            if(moveStack[p]==0){//우
                for(int j=n-1;j>=0;j--){
                    for(int i=0;i<n;i++){
                        move(i,j,moveStack[p]);
                    }
                }
            }

            if(moveStack[p]==1){//하
                for(int i=n-1;i>=0;i--){
                    for(int j=0;j<n;j++){
                        move(i,j,moveStack[p]);
                    }
                }
            }

            if(moveStack[p]==2){//좌
                for(int j=0;j<n;j++){
                    for(int i=0;i<n;i++){
                           move(i,j,moveStack[p]);
                    }
                }
            }

            if(moveStack[p]==3){//상
                 for(int i=0;i<n;i++){
                     for(int j=0;j<n;j++){
                         move(i,j,moveStack[p]);
                     }
                 }
            }

        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(tempMap[i][j]>max){
                    max= tempMap[i][j]  ;
                }
            }
        }
    }
    private static void move(int x,int y,int dir){
        if(tempMap[x][y]==0) return;
        while(true){
            int nx=x+dx[dir];
            int ny=y+dy[dir];
            if(nx<0||ny<0||nx>=n||ny>=n) return;
            if(visited[nx][ny]==true) return;
            if(tempMap[nx][ny]==tempMap[x][y]){//같으면
                visited[nx][ny]=true;
                tempMap[nx][ny]=tempMap[nx][ny]*2;
                tempMap[x][y]=0;
                return;
            }
            if(tempMap[nx][ny]!=0){//다르면
                return;
            }
            //0일때
            tempMap[nx][ny]=tempMap[x][y];
            tempMap[x][y]=0;
            x=nx;
            y=ny;
        }

    }
}
