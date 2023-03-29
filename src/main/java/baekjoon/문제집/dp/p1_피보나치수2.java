package baekjoon.문제집.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1_피보나치수2 {
    static long[] dp=new long[91];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        System.out.println(fibo(num));
    }
    private static long  fibo(int num){
        if(num==0)
            return 0;
        if(num==1)
            return 1;
        if(dp[num]!=0){
            return dp[num];
        }
        return dp[num]=fibo(num-1)+fibo(num-2);
    }
}
