package blog.velog.part_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {
    static int[][] nums;
    static int n;
    static int m;
    static int as;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        nums=new int[n][m];

        for(int i=0;i<n;i++){
            String str=br.readLine();
            String[] strs=str.split("");
            for(int j=0;j<m;j++){
                int k=Integer.parseInt(strs[j]);
                nums[i][j]=k;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                bfs(i,j);
            }
        }
        System.out.println(nums[n-1][m-1]);
    }

    private static void bfs(int x,int y){

        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()){
            int[] is=queue.poll();
            int xx=is[0];
            int yy= is[1];

            for(int i=0;i<4;i++){

                int tx=xx+dx[i];
                int ty=yy+dy[i];

                if(tx<0||ty<0||tx>=n||ty>=m) continue;

                if(nums[tx][ty]==1){
                    queue.add(new int[]{tx,ty});
                    nums[tx][ty]=nums[xx][yy]+1;
                    as=nums[tx][ty];
                }

            }
        }

    }

}
