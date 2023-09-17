package baekjoon.문제집.삼성SW_기출문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 구슬탈출2_13460 {
    static int min=Integer.MAX_VALUE;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};

    static char[][] map;
    static boolean[][][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        map =new char[n][m];
        visited=new boolean[n][m][n][m];

        int rx=0,ry=0;
        int bx=0,by=0;

        for(int i=0;i<n;i++){
            String str=br.readLine();
            for(int j=0;j<m;j++){
                char c=str.charAt(j);
                if(c=='R'){
                    rx=i;
                    ry=j;
                }
                if(c=='B'){
                    bx=i;
                    by=j;
                }
                map[i][j]=c;
            }
        }
        bfs(rx,ry,bx,by,0);
        System.out.println(min==Integer.MAX_VALUE?-1:min);
    }
    public static void bfs(int rx,int ry,int bx,int by,int cnt){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{rx,ry,bx,by,cnt});
        visited[rx][ry][bx][by]=true;

        while(!q.isEmpty()){

            int[] num=q.poll();
            int pCnt=num[4];

            for(int i=0;i<4;i++){
                int nrx=num[0];
                int nry=num[1];
                int nbx=num[2];
                int nby=num[3];

                //횟수가 10회를 넘는 경우
                if(pCnt>=10){
                    return;
                }

                while(map[nrx+dx[i]][nry+dy[i]]!='#'){
                    nrx+=dx[i];
                    nry+=dy[i];
                    if(map[nrx][nry]=='O') break;
                }

                while(map[nbx+dx[i]][nby+dy[i]]!='#'){
                    nbx+=dx[i];
                    nby+=dy[i];
                    if(map[nbx][nby]=='O') break;
                }

                //파란색이 들어간 경우(검색 더해야함)
                if(map[nbx][nby]=='O') continue;

                //빨간색이 들어간 경우(결과 보여줘야함)
                if(map[nrx][nry]=='O'){
                    min=Math.min(min,pCnt+1);
                    return;
                }
                //같은 위치 인 경우
                if(nrx==nbx&&nry==nby){
                    int red_move=Math.abs(nrx-num[0])+Math.abs(nry-num[1]);
                    int blue_move=Math.abs(nbx-num[2])+Math.abs(nby-num[3]);
                    if(red_move>=blue_move){
                        nrx-=dx[i];
                        nry-=dy[i];
                    }else{
                        nbx-=dx[i];
                        nby-=dy[i];
                    }
                }
                //다음 방문에 추가
                if(!visited[nrx][nry][nbx][nby]){
                    visited[nrx][nry][nbx][nby]=true;
                    q.add(new int[]{nrx,nry,nbx,nby,pCnt+1});
                }

            }
        }

    }
}
