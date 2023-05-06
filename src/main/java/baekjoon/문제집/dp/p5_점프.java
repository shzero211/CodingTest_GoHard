package baekjoon.문제집.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;
//규칙이용한 점화식 찾기
public class p5_점프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[][] list=new int[n][n];
        long[][] dp=new long[n][n];

        for(int i=0;i<n;i++){
            String line=br.readLine();
            String[] strs=line.split(" ");
            for(int j=0;j<n;j++){
                list[i][j]=Integer.parseInt(strs[j]);
            }
        }

        //0,0에서 출발
        dp[0][0]=1;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(list[i][j]==0)continue;
                if(i+list[i][j]<n)
                    dp[i+list[i][j]][j]+=dp[i][j];
                if(j+list[i][j]<n)
                    dp[i][j+list[i][j]]+=dp[i][j];
            }
        }

        System.out.println(dp[n-1][n-1]);
    }
}
