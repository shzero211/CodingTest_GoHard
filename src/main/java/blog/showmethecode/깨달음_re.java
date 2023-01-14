package blog.showmethecode;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 깨달음_re {
    static  int n;
    static int[] arr;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n=Integer.parseInt(br.readLine());
        arr=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int[] dp;
        for(int idx=0;idx<n;idx++){
         dp=new int[n];
            dp[idx]=1;
            int tmp=1;
            for(int i=idx+1;i<n;i++){
                if(arr[i]==arr[i-1]){
                    tmp++;
                }else{
                    tmp--;
                }
                dp[i]=Math.max(dp[i-1],tmp);
            }
            max=Math.max(max,dp[n-1]);
        }
        bw.write(max+"");
        bw.flush();
        bw.close();
}
}
