package blog.velog.part_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 전쟁_전투 {
    static int [] dx={0,0,-1,1};
    static int [] dy={-1,1,0,0};
    static boolean[][] visited;
    static int r;
    static int c;
    static char[][] arr;
    static int len=0;
    static int value=0;
    public static void solution() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        c=Integer.parseInt(st.nextToken());
        r=Integer.parseInt(st.nextToken());
        visited=new boolean[r][c];
        arr=new char[r][c];
        for(int i=0;i<r;i++){
           char[] chars=br.readLine().toCharArray();
            for(int j=0;j<c;j++){
                arr[i][j]=chars[j];
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(!visited[i][j]&&arr[i][j]=='W'){
                    visited[i][j]=true;
                    len++;
                    dfs(i,j,'W');
                    value=value+(len*len);
                    len=0;
                }
            }
        }

        System.out.printf(value+" ");
        value=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(!visited[i][j]&&arr[i][j]=='B'){
                    visited[i][j]=true;
                    len++;
                    dfs(i,j,'B');
                    value=value+(len*len);
                    len=0;
                }
            }
        }
        System.out.printf(value+"");
    }
    public static void dfs(int x,int y,char ch){
        for(int i=0;i<4;i++){
            int tx=x+dx[i];
            int ty=y+dy[i];
            if(tx<0||ty<0||tx>=r||ty>=c)continue;
            if(!visited[tx][ty]&&arr[tx][ty]==ch){
                visited[tx][ty]=true;
                dfs(tx,ty,ch);
                len++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}
