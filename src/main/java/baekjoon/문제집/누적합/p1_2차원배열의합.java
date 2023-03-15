package baekjoon.문제집.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1_2차원배열의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[][] arr=new int[n+1][m+1];
        int[][] prefix=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<=m;j++){
                int num=Integer.parseInt(st.nextToken());
                arr[i][j]=num;
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                prefix[i][j]=prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1]+arr[i][j];
            }
        }

        int row=Integer.parseInt(br.readLine());
        for(int i=0;i<row;i++){
            st=new StringTokenizer(br.readLine());
            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());
            int result=prefix[x2][y2]-prefix[x2][y1-1]-prefix[x1-1][y2]+prefix[x1-1][y1-1];
            sb.append(result+"\n");
        }
        System.out.println(sb.toString());
    }
}
