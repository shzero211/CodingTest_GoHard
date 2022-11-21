package tony.dp1.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치수2_2748 {
    static Long[] arr=new Long[91];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        arr[0]=0L;
        arr[1]=1L;
        if(n==0){
            System.out.println(0);
            return;
        }
        if(n==1){
            System.out.println(1);
            return;
        }
        int idx=1;
        while (idx!=n){
            arr[idx+1]=arr[idx-1]+arr[idx];
            idx++;
        }
        System.out.println(arr[n]);
    }
}
