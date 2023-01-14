package blog.showmethecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 깨달음 {
    static  int n;
    static int[] arr;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n=Integer.parseInt(br.readLine());
        arr=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int sum=0;
        for(int len=1;len<=n;len++){
            for(int idx=0;idx<n;idx++){
                if(idx+len>n) break;
                for(int i=0;i<len;i++){
                   if(arr[idx+i]==1){
                       sum++;
                   }else{
                       sum--;
                   }
                }
                max=Math.max(max,Math.abs(sum));
                sum=0;
            }
        }
        System.out.println(max);
    }
}
