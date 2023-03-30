package baekjoon.문제집.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p4_계단오르기 {
    static int[] arr;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int len=Integer.parseInt(br.readLine());
        arr=new int[len+1];
        dp=new Integer[len+1];
        for(int i=1;i<=len;i++){
            int num=Integer.parseInt(br.readLine());
            arr[i]=num;
        }

        dp[0]=arr[0];
        dp[1]=arr[1];

        if(len>=2){
            dp[2]=arr[1]+arr[2];
        }
        System.out.println(up(len));
    }
    public static int up(int num){
        if(dp[num]==null){
            dp[num]=Math.max(up(num-2),up(num-3)+arr[num-1])+arr[num];
        }
        return dp[num];
    }
}
