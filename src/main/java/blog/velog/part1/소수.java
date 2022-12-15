package blog.velog.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(br.readLine());
        int b=Integer.parseInt(br.readLine());
        int[] arr=new int[10001];
        for(int i=2;i<=10000;i++){
            arr[i]=i;
        }
        for(int i=2;i<=10000;i++){
            for(int j=i*2;j<=10000;j=j+i){
                arr[j]=0;
            }
        }
        int sum=0;
        int min=Integer.MAX_VALUE;
        for(int i=a;i<=b;i++){
            sum+=arr[i];
            if(arr[i]!=0){
                min=Math.min(min,i);
            }
        }
       if(min==Integer.MAX_VALUE){
           System.out.println(-1);
       }else{
           System.out.println(sum);
           System.out.println(min);

       }
    }
}
