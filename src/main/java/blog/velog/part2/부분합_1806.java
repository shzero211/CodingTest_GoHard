package blog.velog.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int hap=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int[] arr=new int[n+1];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int start=0;
        int end=0;
        int sum=0;
        int len=Integer.MAX_VALUE;
        while(true){
            if(end>n||start>n) break;
            if(sum>=hap){
                //합길이 확인
                len=Math.min(len,end-start);
                sum-=arr[start++];
            }else{
                sum+=arr[end++];
            }
        }
        if(len==Integer.MAX_VALUE) System.out.println("0");
        else System.out.println(len);
    }
}
